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
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <form method="POST" action="dentista">
                <div class="row">
                    <div class="col-xs-4 col-sm-4 col-lg-4 col-md-4">
                        <div class="form-group">
                            <a href="dentista" class="btn btn-danger btn-sm">Dentista</a>
                            <a href="secretaria" class="btn btn-danger btn-sm">Secretaria</a>
                            <a href="paciente" class="btn btn-danger btn-sm">paciente</a>
                            
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

