<%-- 
    Document   : redirect
    Created on : 02/02/2017, 23:06:17
    Author     : Edu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            window.onload = function(){
                sessionStorage.setItem('confirmation_ok', '${ok}');
            };
            
        </script>
        <meta http-equiv="REFRESH" content="0;url=${redirect}"/>
    </head>
</html>
