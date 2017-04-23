<%-- 
    Document   : exibir
    Created on : 29/01/2017, 11:21:33
    Author     : Edu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" Xmanifest="appcache.manifest">
    <head>
        <link rel="shortcut icon" href="<c:url value="../resources/img/favicon.ico"/>"/>
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="theme-color" content="#007fbf">
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>
        <script type="text/javascript" src="<c:url value="../resources/js/jquery.js"/>"></script>
        <script type="text/javascript">
           $(document).ready(function(){
                window.sessionStorage.setItem('idPaciente', ${id});
           });   
        </script>
        <title>Lista</title>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <input type="hidden" name="idPaciente" id="idPaciente" value="${idPaciente}"/>
        <div class="container">
            <table class="table table-condensed table-striped table-bordered table-hover ">
                <thead>
                    <tr>
                        <th id="headTable" colspan="6" class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                            Prontuarios                        
                            <a href="cadastro" id="btnAdicionar" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-plus">Adicionar</span>
                            </a>
                            
                        </th>
                    </tr>
                    <tr>
                        <th class="col-xs-2 col-sm-2 col-lg-2 col-md-2">Data</th>
                        <th class="col-xs-2 col-sm-2 col-lg-2 col-md-2">Dente</th>
                        <th class="col-xs-2 col-sm-2 col-lg-2 col-md-2">Procedimento</th>
                        <th class="col-xs-2 col-sm-2 col-lg-2 col-md-2">Tratamento Realizado</th>
                        <th class="col-xs-2 col-sm-2 col-lg-2 col-md-2">Tempo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="prontuario">
                        <tr>
                            <td>${prontuario.dataProntuarioStr}</td>
                            <td>${prontuario.denteProntuario}</td>
                            <td>${prontuario.procedimento.nomeProcedimento}</td>
                            <td>${prontuario.descricaoProntuario}</td>
                            <td>${prontuario.tempoProntuario}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
