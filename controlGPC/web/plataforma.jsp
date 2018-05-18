<%-- 
    Document   : plataforma.jsp
    Created on : May 15, 2018, 7:40:04 PM
    Author     : juan_m_osuna
--%>

<%@page import="entity.usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") == null){
        response.sendRedirect("index.jsp");
    }else{
        
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
    
    
        usuario _usuario = (usuario) session.getAttribute("usuario");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ControlGPC v1.8</title>
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/plataforma.css" rel="stylesheet" type="text/css"/>
        <link href="css/menuPrincipal.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="paginaCompleta">
            <div class="cabeceraPagina">ControlGPC</div>
            <div class="cuerpoPagina">
                <div class="area"></div>
                <nav class="main-menu">
                    <ul>
                        <li>
                            <a href="#">
                                <i class="fa fa-home fa-2x"></i>
                                <span class="nav-text">
                                    Inicio
                                </span>
                            </a>

                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-dashcube fa-2x"></i>
                                <span class="nav-text">
                                    Almacén
                                </span>
                            </a>

                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-wrench fa-2x"></i>
                                <span class="nav-text">
                                    Configuración
                                </span>
                            </a>

                        </li>
                    </ul>
                    <ul class="logout">
                        <li>
                           <a href="logout.do">
                                 <i class="fa fa-power-off fa-2x"></i>
                                <span class="nav-text">
                                    Logout
                                </span>
                            </a>
                        </li>  
                    </ul>
                </nav>
            </div>
        </div>
    </body>
</html>
<%
    }  
%>