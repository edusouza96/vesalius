<%-- 
    Document   : menu
    Created on : 29/01/2017, 15:02:19
    Author     : Edu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <h:head>
            <style>
                body {
                   margin:0;
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
            <script>
                window.onload = function(){
                    var urlRelatorio = window.location+"";
                    if(urlRelatorio.match(/relatorio/)){
                        var canvasPaciente = document.getElementById("GraficoPizzaPaciente").getContext("2d");
                        var graficoPaciente = new Chart(canvasPaciente).Pie(dataPaciente, optionsPaciente);
                        
                        var canvasConsulta = document.getElementById("GraficoPizzaConsulta").getContext("2d");
                        var graficoConsulta = new Chart(canvasConsulta).Pie(dataConsulta, optionsConsulta);
                        
                        var canvasProcedimento = document.getElementById("GraficoPizzaProcedimento").getContext("2d");
                        var graficoProcedimento = new Chart(canvasProcedimento).Pie(dataProcedimento, optionsProcedimento);
                        
                        var canvasFinanceiro = document.getElementById("GraficoBarraFinanceiro").getContext("2d");
                            var graficoFinanceiro = new Chart(canvasFinanceiro).Bar(dataFinanceiro, optionsFinanceiro);
                        
                    }
                    var permissao = '<%=request.getSession().getAttribute("permissao")%>';
                    if(permissao == 3){
                        document.getElementById('menuAgenda').style.display = '';
                        document.getElementById('menuPacienteView').style.display = '';
                        document.getElementById('menuPaciente').style.display = 'none';
                        document.getElementById('menuProcedimento').style.display = 'none';
                        document.getElementById('menuEstoque').style.display = 'none';
                        document.getElementById('menuFinanceiro').style.display = 'none';
                        document.getElementById('menuRelatorio').style.display = 'none';
                        document.getElementById('menuNotificacao').style.display = 'none';
                    }else if(permissao == 2){
                        document.getElementById('menuAgenda').style.display = '';
                        document.getElementById('menuPacienteView').style.display = 'none';
                        document.getElementById('menuPaciente').style.display = '';
                        document.getElementById('menuProcedimento').style.display = 'none';
                        document.getElementById('menuEstoque').style.display = '';
                        document.getElementById('menuFinanceiro').style.display = '';
                        document.getElementById('menuRelatorio').style.display = 'none';
                        document.getElementById('menuNotificacao').style.display = '';
                    }else if(permissao == 1){
                        document.getElementById('menuAgenda').style.display = '';
                        document.getElementById('menuPacienteView').style.display = 'none';
                        document.getElementById('menuPaciente').style.display = '';
                        document.getElementById('menuProcedimento').style.display = '';
                        document.getElementById('menuEstoque').style.display = '';
                        document.getElementById('menuFinanceiro').style.display = '';
                        document.getElementById('menuRelatorio').style.display = '';
                        document.getElementById('menuNotificacao').style.display = '';
                    }else{
                        document.getElementById('menuAgenda').style.display = 'none';
                        document.getElementById('menuPacienteView').style.display = 'none';
                        document.getElementById('menuPaciente').style.display = 'none';
                        document.getElementById('menuProcedimento').style.display = 'none';
                        document.getElementById('menuEstoque').style.display = 'none';
                        document.getElementById('menuFinanceiro').style.display = 'none';
                        document.getElementById('menuRelatorio').style.display = 'none';
                        document.getElementById('menuNotificacao').style.display = 'none';
                    }
                };
                function myFunction() {
                    var x = document.getElementById("myTopnav");
                    if (x.className === "topnav") {
                        x.className += " responsive";
                    } else {
                        x.className = "topnav";
                    }
                }
            </script>
    </head>
    <body>
        <ul class="topnav" id="myTopnav">
          <li id="menuAgenda"><a class="active" href="../agenda/">Agenda</a></li>
          <li id="menuPaciente"><a href="../paciente/lista">Pacientes</a></li>
          <li id="menuPacienteView"><a href="../paciente/visualizar">Meus Dados</a></li>
          <li id="menuProcedimento"><a href="../procedimento/lista">Procedimentos</a></li>
          <li id="menuEstoque"><a href="../estoque/lista">Estoque</a></li>
          <li id="menuFinanceiro"><a href="../financeiro/lista">Financeiro</a></li>
          <li id="menuRelatorio"><a href="../relatorio/">Relatórios</a></li>
          <li id="menuNotificacao"><a href="../agenda/notification"><span class="glyphicon glyphicon-bullhorn"></span></a></li>
          <li id="btnSair"><a href="../logout/"><span class="glyphicon glyphicon-off"></span></a></li>
          <li class="icon">
            <a href="javascript:void(0);" style="font-size:15px;" onclick="myFunction()"><span class="glyphicon glyphicon-menu-hamburger"></span></a>
          </li>
        </ul>
    </body>
</html>
