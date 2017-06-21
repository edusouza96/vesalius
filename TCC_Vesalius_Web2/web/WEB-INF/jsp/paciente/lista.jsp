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
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <title>Lista</title>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            <table class="table table-condensed table-striped table-bordered table-hover ">
                <thead>
                    <tr>
                        <th id="headTable" colspan="3" class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                            Pacientes                        
                            <a href="cadastro" id="btnAdicionar" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-plus">Adicionar</span>
                            </a>
                            
                        </th>
                    </tr>
                    <tr>
                        <th class="col-xs-6 col-sm-6 col-lg-6 col-md-6">Nome</th>
                        <th class="col-xs-3 col-sm-3 col-lg-3 col-md-3">Telefone</th>
                        <th class="col-xs-3 col-sm-3 col-lg-3 col-md-3"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="paciente">
                        <tr>
                            <td>${paciente.nomePaciente}</td>
                            <td>${paciente.telefonePaciente}</td>
                            <td>
                               
                                <%
                                    int permissao = (Integer) request.getSession().getAttribute("permissao");
                                    if(permissao == 1){
                                %>
                                    <a href="../prontuario/paciente-${paciente.idPaciente}" class="btn btn-warning btn-sm">
                                        <span class="glyphicon glyphicon-eye-open"></span>
                                    </a>
                                <%
                                    }
                                %>
                                &emsp;
                                <a href="editar-${paciente.idPaciente}" class="btn btn-info btn-sm">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>
                                &emsp;
                                <a href="deletar-${paciente.idPaciente}" class="btn btn-danger btn-sm">
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
