<%-- 
    Document   : cadastro
    Created on : 26/01/2017, 00:10:36
    Author     : Edu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"  pageEncoding="Iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="<c:url value="../resources/img/icone.png"/>"/>
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="<c:url value="../resources/js/jquery.js"/>"></script>
        <script type="text/javascript">
           $(document).ready(function(){
               document.getElementById('idPaciente').value = window.sessionStorage.getItem('idPaciente');
           });   
        </script>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <title>Cadastro</title>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            
            <form action="cadastro" method="POST">
                <input type="hidden" name="idPaciente" id="idPaciente" value="${prontuario.idPaciente}" class="form-control"/>
                <p id="ok">${ok}</p>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-12">
                        <div class="form-group">
                            <label for="idProcedimento">Procedimento</label>
                            <select name="idProcedimento" id="idProcedimento" class="form-control" require>
                                <c:forEach items="${listaProcedimento}" var="procedimento">
                                    <option value="${procedimento.idProcedimento}">${procedimento.nomeProcedimento}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-3 col-md-12">
                        <div class="form-group">
                            <label for="denteProntuario">Dente</label>
                            <input type="text" name="denteProntuario" id="denteProntuario" value="${prontuario.denteProntuario}" class="form-control"/>
                        </div>
                    </div>
                        
                    <div class="col-xs-12 col-sm-12 col-lg-4 col-md-12">
                        <div class="form-group">
                            <label for="tempoProntuario">Tempo</label>
                            <input type="text" name="tempoProntuario" id="tempoProntuario" value="${prontuario.tempoProntuario}" class="form-control"/>
                        </div>
                    </div>
                </div>
                
                <div class="row">                        
                    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-12">
                        <div class="form-group">
                            <label for="descricaoProntuario">Descri��o</label>
                            <textarea name="descricaoProntuario" id="descricaoProntuario" class="form-control">${prontuario.descricaoProntuario}</textarea>
                        </div>
                    </div>
                
                </div>

                     
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <input type="submit" value="Salvar" id="submit" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
            </form>
                
        </div>
    </body>
</html>
