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
        <link href="<c:url value="../resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="../resources/css/styleLogin.css"/>" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>                
        <div class="container">
            <form class="form-signin" method="POST" action="auth">
              <h2 class="form-signin-heading">Login</h2>
              
              <label for="userLogin" class="sr-only">Usuario</label>
              <input type="text" name="userLogin" id="userLogin" class="form-control" placeholder="Usuario" required autofocus>
              
              <label for="passwordLogin" class="sr-only">Senha</label>
              <input type="password" name="passwordLogin" id="passwordLogin" class="form-control" placeholder="Senha" required>
              
              <input class="btn btn-lg btn-primary btn-block" type="submit" value="Entrar">
            </form>
        </div>
    </body>
</html>