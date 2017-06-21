<!DOCTYPE html>
<html  lang="pt-br" Xmanifest="appcache.manifest">
    <head>
        <title>Vesalius</title>
        <meta charset='utf-8' />
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>

        <link rel="shortcut icon" href="../resources/img/icone.png"/>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link href="../resources/css/style.css" rel="stylesheet" type="text/css"/> 
        <link href="../resources/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/fullcalendar-3.2.0/fullcalendar.min.css" rel="stylesheet" type="text/css"/>
        <link href="../resources/fullcalendar-3.2.0/fullcalendar.print.min.css" rel="stylesheet" media="print" type="text/css"/>

        <script src="https://unpkg.com/vue"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/1.0.8/vue.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/vue-resource/0.1.16/vue-resource.min.js"></script>
        <script type="text/javascript" src="../resources/fullcalendar-3.2.0/lib/moment.min.js"></script>
        <script type="text/javascript" src="../resources/fullcalendar-3.2.0/lib/jquery.min.js"></script>
        <script type="text/javascript" src="../resources/fullcalendar-3.2.0/fullcalendar.min.js"></script>
        <script type="text/javascript" src="../resources/fullcalendar-3.2.0/locale-all.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <style>
            
            body {
                margin:0;
            }
            #app {
                max-width: 900px;
                margin: 0 auto;
            }
            ul.topnav {
                list-style-type: none;
                margin: 0 0 5% 0;
                padding: 0;
                overflow: hidden;
                background-color: #007fbf;
            }

            #btnSair{
                float: right;
            }
            ul.topnav li {float: left;}

            ul.topnav li a {
                display: inline-block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                transition: 0.3s;
                font-size: 17px;
            }

            ul.topnav li a:hover {background-color: #007fbf;}

            ul.topnav li.icon {display: none;}

            @media screen and (max-width:780px) {
                ul.topnav li:not(:first-child) {display: none;}
                ul.topnav li.icon {
                    float: right;
                    display: inline-block;
                }
            }

            @media screen and (max-width:780px) {
                ul.topnav.responsive {position: relative;}
                ul.topnav.responsive li.icon {
                    position: absolute;
                    right: 0;
                    top: 0;
                }
                ul.topnav.responsive li {
                    float: none;
                    display: inline;
                }
                ul.topnav.responsive li a {
                    display: block;
                    text-align: left;
                }
            }
        </style>
    </head>
    <body>
        <ul class="topnav" id="myTopnav">
            <li id="menuAgenda"><a class="active" href="../agenda/">Agenda</a></li>
            <li id="menuPacienteView"><a href="../paciente/visualizar">Meus Dados</a></li>
            <li id="btnSair"><a href="../logout/"><span class="glyphicon glyphicon-off"></span></a></li>
            <li class="icon">
                <a href="javascript:void(0);" style="font-size:15px;" onclick="myFunction()"><span class="glyphicon glyphicon-menu-hamburger"></span></a>
            </li>
        </ul>
        <div id="app" >  
            <calendar :events="events" :editable="true"></calendar>
        </div>
    </body>
</html>
<script>
    function myFunction() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }
    
    function dateBr2Us(data,hour){
        var d = new Date(data);
        if(hour == 0){
            return pad(d.getFullYear(),2)+"-"+pad((1+d.getMonth()),2)+"-"+pad(d.getDate(),2)+" "+pad(d.getHours(),2)+":"+pad(d.getMinutes(),2);
        }else{
            return pad(d.getFullYear(),2)+"-"+pad((1+d.getMonth()),2)+"-"+pad(d.getDate(),2)+" "+hour;
        }
    }
    
    function pad(n, width, z) {
        z = z || '0';
        n = n + '';
        return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
      }
      
    Vue.component('calendar', {
        template: '<div></div>',
        props: {
            events: {
                type: Array, 
                required: true
            },
    
            editable: {
                type: Boolean,
                required: false,
                default: false
            },
    
            droppable: {
                type: Boolean,
                required: false,
                default: false
            },
        },
  
        data: function(){
            return {
                cal: null
            };
        },
  
        ready: function(){
            var self = this;
            self.cal = $(self.$el);
    
            var args = {
                lang: 'de',
                header: {
                    left:   'prev,next today',
                    center: 'title',
                    right:  'month,agendaWeek,agendaDay'
                },
                locale: 'pt-br',
                height: "auto",
                allDaySlot: false,
                slotEventOverlap: false,
                timeFormat: 'HH:mm',

                events: self.events,
      
                dayClick: function(date){
                    self.$dispatch('day::clicked', date);
                    self.cal.fullCalendar('gotoDate', date.start);
                    self.cal.fullCalendar('changeView', 'agendaDay');
                },

                eventClick: function(event){
                    self.$dispatch('event::clicked', event);
                }
            };
    
            if (self.editable){
                args.editable = true;
                args.eventResize = function(event){
                    self.$dispatch('event::resized', event);
                };

                args.eventDrop = function(event){
                    self.$dispatch('event::dropped', event);
                };
            }
    
            if (self.droppable){
                args.droppable = true;
                args.eventReceive = function(event){
                    self.$dispatch('event::received', event);
                };
            }
    
            this.cal.fullCalendar(args);
        }
    });

    new Vue({
        el: '#app',
  
        data: {    
            events: []
        },
        
        created: function(){
            var title = "";
            var start = "";
            var end = "";
            var status = "";
            var procedimento = "";

            $.ajax({
                url: 'http://localhost:8080/TCC_Vesalius/webresources/agenda/consultasPorPaciente/31',
                async: false
            }).done(function(data) {
                var titleArray = [];
                var startArray = [];
                var endArray = [];
                var statusArray = [];
                var procedimentoArray = [];
                for(x in data){
                    titleArray.push(data[x].paciente.nomePaciente);
                    startArray.push(data[x].dataAgenda);
                    endArray.push(data[x].horaAgenda);
                    statusArray.push(data[x].statusAgenda);
                    procedimentoArray.push(data[x].servico);
                }
                title = titleArray;
                start = startArray;
                end = endArray;
                status = statusArray;
                procedimento = procedimentoArray;
            });
           
            for(n in title){
                if(status[n] == 0){
                    this.events.push( {procedimento: procedimento[n],title: title[n], start: dateBr2Us(start[n],0),  end: dateBr2Us(start[n],end[n]), color: '#ff0000'});
                }else{
                    this.events.push( {procedimento: procedimento[n],title: title[n], start: dateBr2Us(start[n],0),  end: dateBr2Us(start[n],end[n])});
                }
            }
        },
        events: {
            'day::clicked': function(date){
                console.log(date);
            }
        }
    });
            
</script>