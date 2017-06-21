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
        <link rel="shortcut icon" href="<c:url value="../resources/img/icone.png"/>"/>
        <meta name="theme-color" content="#0000ff"/>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=0.7, maximum-scale=0.7"/>

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
                    <div class="col-xs-12 col-sm-10 col-lg-7 col-md-10">
                        <div class="form-group">
                            <label for="itemEstoque">Item</label>
                            <input type="text" name="itemEstoque" id="itemEstoque" value="${estoque.itemEstoque}" class="form-control" required/>
                            <input type="hidden" name="idEstoque" id="idEstoque" value="${estoque.idEstoque}"/>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-12 col-sm-8 col-lg-4 col-md-8">
                        <div class="form-group">
                            <label for="quantidadeItemEstoque">Quantidade Atual</label>
                            <input type="text" name="quantidadeItemEstoque" id="quantidadeItemEstoque" value="${estoque.quantidadeItemEstoque}" class="form-control"/>
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
