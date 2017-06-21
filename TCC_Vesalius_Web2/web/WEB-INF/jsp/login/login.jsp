<%-- 
    Document   : login
    Created on : 16/04/2017, 22:12:29
    Author     : Edu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="o" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"  pageEncoding="Iso-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="<c:url value="../resources/img/icone.png"/>"/>
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/styleLogin.css"/>" rel="stylesheet" type="text/css"/>
        <title>Login</title>
        <meta name="mobile-web-app-capable" content="yes"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    </head>
    <body>                
        <div class="container">
            <form class="form-signin" method="POST" action="auth">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <h2 class="form-signin-heading">Login</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <label for="userLogin" class="sr-only">Usuario</label>
                            <input type="text" name="userLogin" id="userLogin" class="form-control" placeholder="Usuario" required autofocus>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <label for="passwordLogin" class="sr-only">Senha</label>
                            <input type="password" name="passwordLogin" id="passwordLogin" class="form-control" placeholder="Senha" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">
                        <div class="form-group">
                            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Entrar">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>