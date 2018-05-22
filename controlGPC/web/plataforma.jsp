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
        <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/plataforma.css" rel="stylesheet" type="text/css"/>
        <link href="css/menuPrincipal.css" rel="stylesheet" type="text/css"/>
        <link href="css/cabeceraPagina.css" rel="stylesheet" type="text/css"/>
        <link href="css/formUsuario.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <div id="userform" class="formUsuario">
            <div class="formUsuario_cabecera"></div>
            <div class="formUsuario_cuerpo">
                <div class="formUsuario_cuerpoIzquierdo">
                    <img src="<%=(_usuario.getSexo().toLowerCase().equals("hombre") ? "images/boy.png" : "images/girl.png" ) %>" width="96" height="96" alt=""/>
                </div>
                <div class="formUsuario_cuerpoDerecho">
                    <div class="formUsuario_usuario"><%=_usuario.getNombreCompleto() %></div>
                    <div class="formUsuario_perfil"><%=_usuario.getPerfilUsuario().getNombreCompleto() %></div>
                    <div class="formUsuario_cuenta"><%=_usuario.getCuenta() %></div>
                    <div class="formUsuario_botonEditar"><a href=""><i class="fa fa-pencil-alt">&nbsp;&nbsp;Editar</i></a></div>
                </div>
            </div>
            <div class="formUsuario_pie">
                <a href="logout.do"><i class="fas fa-power-off" >&nbsp;&nbsp;Salir</i></a>
            </div>
        </div>
        <div class="paginaCompleta">
            <div class="cabeceraPagina">
                <div class="contenedorCabecera">
                    <div class="titulo">
                        <div class="subtitulo1">Control</div> 
                        <div class="subtitulo2">GPC</div>
                        <div class="subtitulo3">v1.8</div>
                    </div>
                    <div class="usuario">
                        <label class="switch">
                            <div class="botonUsuario">
                                <div class="nombreUsuario"><%=_usuario.getNombreCompleto() %></div>
                                <div>
                                    <input type="checkbox" onclick="toggle_visibility('userform');">
                                    <i class="fa fa-chevron-down"></i>
                                </div>
                            </div>
                        </label>
                    </div>
                </div>
            </div>
            <div class="cuerpoPagina">
                <div class="contenedorMenu">
                    <div class="area"></div>
                    <nav class="main-menu">
                        <ul>
                            <li>
                                <a href="#">
                                    <i class="fas fa-home"></i>
                                    <span class="nav-text">
                                        Inicio
                                    </span>
                                </a>

                            </li>
                            <li>
                                <a href="#">
                                    <i class="fas fa-warehouse"></i>
                                    <span class="nav-text">
                                        Almacén
                                    </span>
                                </a>

                            </li>
                            <li>
                                <a href="#">
                                    <i class="fas fa-calendar-alt"></i>
                                    <span class="nav-text">
                                        Agenda
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fas fa-file"></i>
                                    <span class="nav-text">
                                        Reportes
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fas fa-wrench"></i>
                                    <span class="nav-text">
                                        Configuración
                                    </span>
                                </a>
                            </li>
                        </ul>
                        <ul class="logout">
                            
                            <li>
                               <a href="logout.do">
                                     <i class="fas fa-power-off"></i>
                                    <span class="nav-text">
                                        Salir del sistema
                                    </span>
                                </a>
                            </li>  
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <script type="text/javascript">

            function toggle_visibility(id) {
                var e = document.getElementById(id);
                if(e.style.display === 'block'){
                    e.style.display = 'none';
                }else{
                    e.style.display = 'block';
                }
            }

        </script>
    </body>
</html>
<%
    }  
%>