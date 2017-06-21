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
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <title>Adicionar Despesas</title>
    </head>
    <body>
        <jsp:include page="../inc/menu.jsp"/>
        <div class="container">
            
            <p id="ok">${ok}</p>
            <form action="cadastro" method="POST">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-7 col-md-12">
                        <div class="form-group">
                            <label for="tituloFinanceiro">Titulo</label>
                            <input type="text" name="tituloFinanceiro" id="tituloFinanceiro" value="${financeiro.tituloFinanceiro}" class="form-control" required/>
                            <input type="hidden" name="idFinanceiro" id="idFinanceiro" value="${financeiro.idFinanceiro}"/>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-5 col-md-10">
                        <div class="form-group">
                            <label for="valorFinanceiro">Valor</label>
                            <input type="text" name="valorFinanceiro" id="valorFinanceiro" value="${financeiro.valorFinanceiro}" class="form-control" required/>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-5 col-md-10">
                        <div class="form-group">
                            <label for="vencimentoFinanceiro">Vencimento</label>
                            <input type="date" name="vencimentoFinanceiroStr" id="vencimentoFinanceiroStr" value="${financeiro.vencimentoFinanceiroStr}" class="form-control" required/>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <a href="javascript:history.back()" id="btnVoltar" class="btn btn-primary btn-sm">Voltar</a>
                            <input type="submit" value="Salvar" id="submit" class="btn btn-primary btn-sm"/>
                        </div>
                    </div>
                </div>
            </form>
                
        </div>
    </body>
</html>
