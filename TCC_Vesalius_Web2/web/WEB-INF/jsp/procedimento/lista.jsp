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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="theme-color" content="#007fbf">
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>
        <title>Lista</title>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            <table class="table table-condensed table-striped table-bordered table-hover ">
                <thead>
                    <tr>
                        <th id="headTable" colspan="3" class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                            Procedimentos                        
                            <a href="cadastro" id="btnAdicionar" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-plus">Adicionar</span>
                            </a>
                            
                        </th>
                    </tr>
                    <tr>
                        <th class="col-xs-6 col-sm-6 col-lg-6 col-md-6">Nome</th>
                        <th class="col-xs-3 col-sm-3 col-lg-3 col-md-3">Valor</th>
                        <th class="col-xs-3 col-sm-3 col-lg-3 col-md-3"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="procedimento">
                        <tr>
                            <td>${procedimento.nomeProcedimento}</td>
                            <td>${procedimento.valorProcedimento}</td>
                            <td>
                                <a href="editar-${procedimento.idProcedimento}" class="btn btn-info btn-sm">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                                &emsp;
                                <a href="deletar-${procedimento.idProcedimento}" class="btn btn-danger btn-sm">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
