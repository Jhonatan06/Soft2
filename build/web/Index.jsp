<%-- 
    Document   : Index
    Created on : Oct 3, 2016, 10:58:56 AM
    Author     : jsalv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap-3.3.7-dist/css/sidebar.css" rel="stylesheet" type="text/css"/>
        <title>InstaDash Inicio</title>
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
                        <a href="Producto.jsp"><h3>Productos</h3></a>
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
            
            <div class="jumbotron">
                <h1 class="text-center">Bienvenido</h1>
                <h2 class="text-center">Empieza a disfrutar de las herramientas que tenemos para ti</h2>
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