<%-- 
    Document   : index
    Created on : 28/02/2017, 22:04:58
    Author     : Edu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br" Xmanifest="appcache.manifest">
<head>
    <title>Vesalius</title>
    <link rel="shortcut icon" href="<c:url value="../resources/img/icone.png"/>"/>
    <meta name="theme-color" content="#007fbf"/>
    <meta name="mobile-web-app-capable" content="yes"/>
    <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>
        
    <meta charset='utf-8' />
    <link href="<c:url value="../resources/manifest.json"/>" rel="manifest" />
    <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="../resources/fullcalendar-3.2.0/fullcalendar.min.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="../resources/fullcalendar-3.2.0/fullcalendar.print.min.css"/>" rel="stylesheet" media="print" type="text/css"/>
    <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/lib/moment.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/lib/jquery.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/fullcalendar.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/locale-all.js"/>"></script>
    <link href="<c:url value="../resources/css/jquery-ui.css"/>" rel="stylesheet" type="text/css"/>  
    <script type="text/javascript" src="<c:url value="../resources/js/jquery-ui.js"/>"></script>
    <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>    

    <script>
        $(document).ready(function() {
            var arrayConsultas = new Array(${lista});
            var arrayConsultas2 = new Array();
            for (i=0;i<arrayConsultas.length; i++){
                arrayConsultas2.push(JSON.stringify(arrayConsultas[i]));
            }
            localStorage.setItem('consultas',arrayConsultas2.join('|'));
            
            $('#calendar').fullCalendar({
                    header: {
                            left: 'prev,next today',
                            center: 'title',
                            right: 'month,agendaWeek,agendaDay,listWeek'
                    },
                    defaultDate: '${dataAtual}',
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

                        $( "#dialog" ).dialog( "open" );
                        var dateString = start.toISOString();
                        var dateFimString = end.toISOString();
                        $("#dataAgenda").val(dateString.substring(0,10));
                        $("#horaAgenda").val(dateString.substring(11,16));
                        $("#horaFimAgenda").val(dateFimString.substring(11,16));
                    },
                    editable: true,
                    eventLimit: true, // allow "more" link when too many events
                    events: [
                        ${lista}
                    ],
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
                            $("#idAgenda").val(parseInt(event.id));
                            $("#nomePaciente").val(event.title);
                            var dateString = event.start.toISOString();
                            $("#dataAgenda").val(dateString.substring(0,10));
                            $("#horaAgenda").val(dateString.substring(11,16));
                            $("#servico").val(event.procedimento);                            
                            return false;
                        }
                    }
            });
            var ok = sessionStorage.getItem('confirmation_ok');
            document.getElementById('ok').innerHTML = ok;
            sessionStorage.removeItem('confirmation_ok');

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
    <jsp:include page="../inc/menu.jsp"/>
    <p id="ok"></p>
    <div id='calendar'></div>

    <div id="dialog" title="Solicitação de Consulta">
        <form method="POST" action="">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                    <div class="form-group">
                        <label for="nomePaciente">Paciente</label>
                        <input type="text" name="nomePaciente" value="${nomePaciente}" id="nomePaciente" class="form-control" autocomplete="off" readonly="readonly"/>
                        <input type="hidden" name="idAgenda" value="0" id="idAgenda" class="form-control"/>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                    <div class="form-group">
                        <label for="dataConsultaAgenda">Data</label>
                        <input type="date" name="dataConsultaAgenda" id="dataAgenda" class="form-control" required/>
                    </div>
                </div>
            </div>
                    
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                    <div class="form-group">
                        <label for="horaAgenda">Hora</label>
                        <input type="text" name="horaAgenda" id="horaAgenda" class="form-control" required/>
                        <input type="hidden" name="horaFimAgenda" id="horaFimAgenda" class="form-control"/>
                    </div>
                </div>
            </div>
                    
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                    <div class="form-group">
                        <label for="servico">Procedimento</label>
                        <select name="servico" id="servico" class="form-control" require>
                            <c:forEach items="${listaProcedimento}" var="procedimento">
                                <option value="${procedimento.idProcedimento}">${procedimento.nomeProcedimento}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <input type="submit" value="Salvar" id="submit" class="btn btn-primary"/>
                        
                        </div>
                    </div>
                </div>
                
            </div>
        </form>
    </div>
</body>
</html>