<%-- 
    Document   : Index
    Created on : Oct 3, 2016, 10:58:56 AM
    Author     : jsalv
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap-3.3.7-dist/css/sidebar.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap-3.3.7-dist/css/Clientes.css" rel="stylesheet" type="text/css"/>
        <title>Clientes</title>
    </head>
    <body background="img/ios_7_galaxy-wallpaper-1920x1080.jpg">       
        <div id="wrapper">
            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        <a href="Index.jsp"><h1>InstaDash</h1></a>
                    </li>
                    <li>                        
                        <img class="img-responsive" src="img/12792366_1175147119165188_8417811475972890227_o.jpg" alt=""/>
                        <h2 style='color: #fff'>Juanita Alimaña</h2>
                    </li>
                    <li>
                        <a href="s02-Cliente"><h3>Clientes</h3></a>
                    </li>
                    <li>
                        <a href="s04-Producto"><h3>Productos</h3></a>
                    </li>
                    <li>
                        <a href="#"><h3>Dashboard</h3></a>
                    </li>
                    <li>
                        <a href="#"><h3>GridView</h3></a>
                    </li>                                      
                </ul>
            </div>

            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-1">
                            <br>
                            <a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></a>
                        </div>                       
                    </div>                    
                </div>
            </div>
            <br>
            <div class="jumbotron">
                <div class="container-fluid">
                    <div class="panel panel-primary">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <h2>Resumen de Productos</h2>
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <span style="color:black">Cliente</span>
                                    <span class="caret" style="color:black;font-weight:bold"> </span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="#">Topy Top</a></li>
                                    <li><a href="#">Luz del Sur</a></li>
                                    <li><a href="#">Cineplanet</a></li>
                                    <li><a href="#">Bembos</a></li>                                  
                                </ul>
                            </div>
                        </div>

                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Producto</th>
                                    <th>Zona</th>
                                    <th>Ingreso (S/.M)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="producto" items="${producto}">
                                    <tr>
                                        <td><a href="s04-Producto">${producto.producto}</td>
                                        <td>${producto.zona}</td>
                                        <td>${producto.ingreso}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel panel-primary">
                                <!-- Default panel contents -->
                                <div class="panel-heading"><h3>Volumen Promedio</h3></div>                    
                                <img class="img-responsive" src="img/barchart.png" alt=""/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="panel panel-primary">
                                <!-- Default panel contents -->
                                <div class="panel-heading"><h3>Distribucion IxS</h3></div>                    
                                <img class="img-responsive" src="img/pie chart.png" alt=""/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="bootstrap-3.3.7-dist/js/jquery.js" type="text/javascript"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    <script>
        $("#menu-toggle").click(function (e) {
            e.preventDefault();
            $("#wrapper").toggleClass("toggled");
        });
    </script>
</body>
</html>
