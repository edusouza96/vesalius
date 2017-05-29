<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="<c:url value="../resources/img/favicon.ico"/>"/>
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <title>Relatório</title>
        <script src="../resources/js/Chart.min.js"></script>
        <style type="text/css">
            .box {
                margin: 0px auto;
                width: 70%;
            }

            .box-chart {
                width: 100%;
                margin: 0 auto;
                padding: 10px;
            }
            
           
        </style>  
    </head>

    <body>    
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            
            <div id="box-paciente" class="box">
                <b>Pacientes novos Por Mês</b>
                <div class="box-chart">
                    <canvas id="GraficoPizzaPaciente" style="width:100%;"></canvas>
                    <script type="text/javascript">

                        var optionsPaciente = {
                            responsive:true
                        };

                        var dataPaciente = [ ${listaPacientes}];
                        
                    </script>           
                </div>
            </div>
                        
                        
            <div id="box-procedimento" class="box">
                <b>Procedimentos Realizados no Mês</b>
                <div class="box-chart">
                    <canvas id="GraficoPizzaProcedimento" style="width:100%;"></canvas>
                    <script type="text/javascript">

                        var optionsProcedimento = {
                            responsive:true
                        };

                        var dataProcedimento = [ ${listaProcedimentos}];

                    </script>           
                </div>
            </div>
                        
                        
            <div id="box-consulta" class="box">
                <b>Consultas Por Mês</b>
                <div class="box-chart">
                    <canvas id="GraficoPizzaConsulta" style="width:100%;"></canvas>
                    <script type="text/javascript">

                        var optionsConsulta = {
                            responsive:true
                        };

                        var dataConsulta = [ ${listaConsultas}];

                    </script>           
                </div>
            </div>
                        
            
            <div id="box-financeiro" class="box">
                <b>Balanço do ano</b>
                <div class="box-chart">
                    <canvas id="GraficoBarraFinanceiro" style="width:100%;"></canvas>
                    <script type="text/javascript">

                        var optionsFinanceiro = {
                            responsive:true
                        };

                        var dataFinanceiro = {
                            labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
                            datasets:[ ${listaFinanceiro}]
                        };
                    </script>           
                </div>
            </div>
                        
        </div>
    </body>

</html>