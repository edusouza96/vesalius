<%-- 
    Document   : cadastro
    Created on : 26/01/2017, 00:10:36
    Author     : Edu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <title>Cadastro</title>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            
            <form action="cadastro" method="POST">
                <p id="ok">${ok}</p>
                <div class="row">
                    <div class="col-xs-4 col-sm-4 col-lg-4 col-md-4">
                        <div class="form-group">
                            <label for="nomeProcedimento">Nome</label>
                            <input type="text" name="nomeProcedimento" id="nomeProcedimento" value="${procedimento.nomeProcedimento}" class="form-control" required/>
                            <input type="hidden" name="idProcedimento" id="idProcedimento" value="${procedimento.idProcedimento}"/>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-2 col-sm-2 col-lg-2 col-md-2">
                        <div class="form-group">
                            <label for="valorProcedimento">Valor</label>
                            <input type="text" name="valorProcedimento" id="valorProcedimento" value="${procedimento.valorProcedimento}" class="form-control"/>
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
