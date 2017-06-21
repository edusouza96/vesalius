<%-- 
    Document   : exibir
    Created on : 29/01/2017, 11:21:33
    Author     : Edu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br" Xmanifest="appcache.manifest">
    <head>
        <link rel="shortcut icon" href="<c:url value="../resources/img/icone.png"/>"/>
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>

        <script type="text/javascript" src="<c:url value="../resources/fullcalendar-3.2.0/lib/jquery.min.js"/>"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="theme-color" content="#007fbf">
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>
        <title>Lista</title>
        <script>
            $(document).ready(function() {
                var ok = sessionStorage.getItem('confirmation_ok');
                document.getElementById('ok').innerHTML = ok;
                sessionStorage.removeItem('confirmation_ok');
                
                var permissao = '<%=request.getSession().getAttribute("permissao")%>';
                if(permissao =='1'){
                    document.getElementById('btnAdicionar').style.display = 'block';
                }else{
                    document.getElementById('btnAdicionar').style.display = 'none';
                }
            });
        </script>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            <p id="ok">
                
            </p>
            <table class="table table-condensed table-striped table-bordered table-hover ">
                <thead>
                    <tr>
                        <th id="headTable" colspan="12" class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                            Financeiro                        
                            <a href="cadastro" id="btnAdicionar" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-plus">Adicionar<br>Despesas</span>
                            </a>
                            
                        </th>
                    </tr>
                    <tr>
                        <th class="col-xs-2 col-sm-2 col-lg-2 col-md-2"></th>
                        <th class="col-xs-5 col-sm-5 col-lg-5 col-md-5"></th>
                        <th class="col-xs-2 col-sm-2 col-lg-2 col-md-2"></th>
                        <th class="col-xs-3 col-sm-3 col-lg-3 col-md-3"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="financeiro">
                        <tr>
                            <c:if test="${financeiro.tipoFinanceiro == false}">
                                <td>
                                    <span class="glyphicon glyphicon-arrow-up" style="color:red"></span>
                                    ${financeiro.vencimentoFinanceiroStr}
                                </td>
                                <td>${financeiro.tituloFinanceiro}</td>
                                <td>R$ ${financeiro.valorFinanceiro}</td>
                                <td>
                                    <c:if test="${financeiro.statusFinanceiro == false}">
                                        <a href="pagar-${financeiro.idFinanceiro}" id="btnDetalhe" class="btn btn-warning btn-sm">
                                            Pagar
                                        </a>
                                    </c:if>
                                    <c:if test="${financeiro.statusFinanceiro == true}">
                                        <a href="detalhes-${financeiro.idFinanceiro}" id="btnDetalhe" class="btn btn-warning btn-sm">
                                            Detalhes
                                        </a>
                                    </c:if>
                                </td>
                            </c:if>
                                
                            <c:if test="${financeiro.tipoFinanceiro == true}">
                                <td>
                                    <span class="glyphicon glyphicon-arrow-down" style="color:green"></span>                                    
                                    ${financeiro.vencimentoFinanceiroStr}
                                </td>
                                <td>${financeiro.paciente.nomePaciente}</td>
                                <td>R$ ${financeiro.valorFinanceiro}</td>
                                <td>
                                    <c:if test="${financeiro.statusFinanceiro == false}">
                                        <a href="receber-${financeiro.idFinanceiro}" id="btnDetalhe" class="btn btn-warning btn-sm">
                                            Receber
                                        </a>
                                    </c:if>
                                    <c:if test="${financeiro.statusFinanceiro == true}">
                                        <a href="detalhe-${financeiro.idFinanceiro}" id="btnDetalhe" class="btn btn-warning btn-sm">
                                            Detalhes
                                        </a>
                                    </c:if>                                    
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
