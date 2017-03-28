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

    <script>
      function autoCompletePaciente() {
        $("#nomePaciente").autocomplete({
            source: ${nomePacientes}
        });
      }

      function excluirConsulta(){
        if(confirm("Deseja Realmente Excluir Esta Consulta?")){
            var id = $("#idAgenda").val();
            var oReq = new XMLHttpRequest();
            oReq.onload = function(){
                alert("Consulta Excluida!");
                location.reload();
            };
            oReq.open("get", "deletar-"+id, true);
            oReq.send();
        }
      }
    </script>
    <script>

            $(document).ready(function() {

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
                                $("#servico").val(1);                            
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
    <jsp:include page="../inc/menu.jsp"/>
    <p id="ok">${ok}</p>
    <div id='calendar'></div>

    <div id="dialog" title="Marcar Consulta">
        <form method="POST" action="">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                    <div class="form-group">
                        <label for="nomePaciente">Paciente</label>
                        <input type="text" onKeyPress="autoCompletePaciente();" name="nomePaciente" id="nomePaciente" class="form-control" autocomplete="off" required/>
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
                        
                            <input type="button" onClick="excluirConsulta()" value="Excluir" id="submit" class="btn btn-danger"/>
                        </div>
                    </div>
                </div>
                
            </div>
        </form>
    </div>
</body>
</html>