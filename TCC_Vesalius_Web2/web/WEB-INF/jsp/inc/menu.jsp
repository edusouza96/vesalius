<%-- 
    Document   : menu
    Created on : 29/01/2017, 15:02:19
    Author     : Edu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <h:head>
            <style>
                body {
                   margin:0;
                }
                ul.topnav {
                  list-style-type: none;
                  margin: 0 0 5% 0;
                  padding: 0;
                  overflow: hidden;
                  background-color: #007fbf;
                }

                ul.topnav li {float: left;}

                ul.topnav li a {
                  display: inline-block;
                  color: #f2f2f2;
                  text-align: center;
                  padding: 14px 16px;
                  text-decoration: none;
                  transition: 0.3s;
                  font-size: 17px;
                }

                ul.topnav li a:hover {background-color: #007fbf;}

                ul.topnav li.icon {display: none;}

                @media screen and (max-width:680px) {
                  ul.topnav li:not(:first-child) {display: none;}
                  ul.topnav li.icon {
                    float: right;
                    display: inline-block;
                  }
                }

                @media screen and (max-width:680px) {
                  ul.topnav.responsive {position: relative;}
                  ul.topnav.responsive li.icon {
                    position: absolute;
                    right: 0;
                    top: 0;
                  }
                  ul.topnav.responsive li {
                    float: none;
                    display: inline;
                  }
                  ul.topnav.responsive li a {
                    display: block;
                    text-align: left;
                  }
                }
            </style>
            <script>
                function myFunction() {
                    var x = document.getElementById("myTopnav");
                    if (x.className === "topnav") {
                        x.className += " responsive";
                    } else {
                        x.className = "topnav";
                    }
                }
            </script>
    </head>
    <body>
        <ul class="topnav" id="myTopnav">
          <li><a class="active" href="../agenda/">Agenda</a></li>
          <li><a href="../paciente/lista">Pacientes</a></li>
          <li><a href="../procedimento/lista">Procedimentos</a></li>
          <li class="icon">
            <a href="javascript:void(0);" style="font-size:15px;" onclick="myFunction()"><span class="glyphicon glyphicon-menu-hamburger"></span></a>
          </li>
        </ul>
    </body>
</html>
