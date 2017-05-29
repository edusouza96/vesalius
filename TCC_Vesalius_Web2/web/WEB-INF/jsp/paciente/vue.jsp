<%-- 
    Document   : vue
    Created on : 17/05/2017, 06:55:09
    Author     : Edu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html  lang="pt-br" Xmanifest="appcache.manifest">
    <head>
        <script src="https://unpkg.com/vue"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/vue-resource/0.9.3/vue-resource.min.js"></script>
        
        <title>Vesalius</title>
        <link rel="shortcut icon" href="<c:url value="../resources/img/favicon.ico"/>"/>
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>

        <meta charset='utf-8' />
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/fullcalendar-3.2.0/fullcalendar.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/fullcalendar-3.2.0/fullcalendar.print.min.css"/>" rel="stylesheet" media="print" type="text/css"/>
        <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/lib/moment.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/lib/jquery.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/fullcalendar.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/locale-all.js"/>"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>    

    <script>
        $(document).ready(function() {
            $('#calendar').fullCalendar({
                    header: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'month,agendaWeek,agendaDay,listWeek'
                    },
                    defaultDate: '2017-05-21',
                    locale: 'pt-br',
                    navLinks: true, // can click day/week names to navigate views

                    selectable: true,
                    selectHelper: true,
                    select: function (start,end){
                        $( "#dialog" ).dialog({
                            autoOpen: false,
                            show: {
                              effect: "clip",
                              duration: 500
                            },
                            hide: {
                              effect: "clip",
                              duration: 500
                            }
                        });
                    },
                    editable: true,
                    eventLimit: true, // allow "more" link when too many events
                    events:[{id: '1' ,
                            procedimento: '1' ,
                            title: 'Eduardo da Silva Souza' ,
                            start: '2017-01-19 16:00' ,
                            end: '2017-01-19 16:30' }],
                    eventClick: function(event) {
                        if (event.title) {
                            $( "#dialog" ).dialog({
                                autoOpen: true,
                                show: {
                                  effect: "clip",
                                  duration: 500
                                },
                                hide: {
                                  effect: "clip",
                                  duration: 500
                                }
                            });

                            return false;
                        }
                    }
            });

        });
        
    </script>
    <style>

            body {
                margin: 40px 10px;
                padding: 0;
                font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
                font-size: 14px;
            }

            #calendar {
                max-width: 900px;
                margin: 0 auto;
            }

            .fc-day-number{
                color: #000;
            }
            #dialog{
                overflow: hidden;
                display: none;
            }

    </style>
    </head>
    <body>
        <div id='calendar'></div>
        <div id="beerApp">
            {{dataConsultas}}
        </div>
<!--        <div id='app1'>
            <div v-html='titulo'></div>
            <p v-text='message'></p>
            <img :src="imagem" width="15%" height="15%">
            <label>Texto</label> <input type='text' v-model='textocampo'>
            <button v-on:click="atualiza">Atualizar</button>
            <button @click="atualiza2">Atualizar 2</button>
            {{texto}}
            <p v-for="txt in textos" v-text="txt"></p>
        </div>

        <div id='app'>
            <lista-tarefas></lista-tarefas>
        </div>-->
    </body>
</html>
<script>
    var beerApp = new Vue({
    el:'#beerApp',

    data:{
        cervejarias: [],
        dataConsultas: [],
        dataConsultasJson: ''
   },

    created:function ()
    {
    this.$http.get('http://localhost:8080/TCC_Vesalius/webresources/agenda/consultasPorPaciente/31').then((response) => {
        this.cervejarias = response.json();
        for(x in this.cervejarias){
            this.dataConsultas.push(this.cervejarias[x].dataAgenda);
        }
        this.dataConsultasJson = JSON.stringify(this.dataConsultas);
        console.log(this.dataConsultasJson);
      }, (error) => {
         consoel.log(error)
      });
    
    }
});
//    var app1 = new Vue({
//            el: '#app1',
//            data: {
//                message: 'Hello Vue!',
//                imagem:'Lighthouse.jpg',
//                titulo:'<h1>teste</h1>',
//                textocampo:'',
//                texto:'',
//                textos:[]
//            },
//            methods:{
//                atualiza(){
//                    this.texto = this.textocampo;
//                },
//                atualiza2(){
//                    this.textos.push(this.textocampo);
//                    this.textocampo = '';
//                }
//            }
//        });
//
//    Vue.component('lista-tarefas',{
//        template:'<div><tarefa v-for="tarefa in tarefas">{{tarefa.nome}}</tarefa></div>',
//        data(){
//            return{
//                tarefas:[
//                    {nome:"corrigir prova", importancia:"Urgente"},
//                    {nome:"Realizar trabalho", importancia:"Adiavel"},
//                    {nome:"publicar notas", importancia:"Urgente"},
//                    {nome:"finalizar codigo", importancia:"Importante"},
//                    {nome:"aplicar exercicio", importancia:"Adiavel"},                    
//                ]
//            }
//        }
//    });
//    Vue.component('tarefa',{
//        template:'<li><slot></slot></li>'
//    });
//    new Vue({
//        el:'#app'
//    });
</script>