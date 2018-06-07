<%-- 
    Document   : perfilUsuarioTabla
    Created on : Jun 4, 2018, 9:59:27 PM
    Author     : juan_m_osuna
--%>

<%@page import="entity.perfilUsuario"%>
<%@page import="java.util.List"%>
<%@page import="DAO.database.perfilUsuarioDAOImpl"%>
<%@page import="database.baseDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuario") == null){
        response.sendRedirect("/controlGPC/logout.do");
    }else{
        
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setDateHeader("Expires", 0);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de perfiles de usuarios</title>
        <link href="../../css/fontawesome-all.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <style>
            
            @font-face{
                font-family: ubuntuLight;
                src: url(../..//fonts/Ubuntu-L.ttf);
            }
            
            .fontUbuntulight{
                font-family: ubuntuLight;
                
            }
            
            .fontColor{
                color: #999999;
            }
            
            .iconColor{
                color: #ddd;
            }
            
            .backgroundLightgray{
                background-color: #f8f8f8;
            }
            
            .borderLightgray{
                border: 1px solid #ced4da;
                border-radius: 5px;
            }
            
            .divider{
                padding: 2px;
                color: #777;
            }
            
            .active{
                color: #777;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="card-group">
                <div class="card-body d-flex justify-content-between">
                    <h1 class="card-title fontUbuntulight fontColor ">Perfil de usuarios</h1>
                    <i class="fas fa-users-cog fa-4x iconColor"></i>
                </div>
            </div>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li class="active">Perfil de usuarios</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="agregarPerfilUsuario.jsp" class="btn btn-primary">+ Agregar</a>
                </li>
            </ul>
            <hr>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Nombre completo</th>
                                    <th scope="col">Descripción</th>
                                    <th scope="col">Editar</th>
                                    <th scope="col">Eliminar</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    baseDatos _baseDatos = new baseDatos();
                                    perfilUsuarioDAOImpl _perfilUsuarioDAOImpl = new perfilUsuarioDAOImpl(_baseDatos.getConnection());

                                    List<perfilUsuario> _perfilUsuarioDAO = (List<perfilUsuario>)_perfilUsuarioDAOImpl.consultarTodos();

                                    for(perfilUsuario _perfilUsuario : _perfilUsuarioDAO){
                                %>
                                <tr>
                                    <th scope="row"><%=_perfilUsuario.getId() %></th>
                                    <td><%=_perfilUsuario.getNombreCompleto()%></td>
                                    <td><%=_perfilUsuario.getDescripcion()%></td>
                                    <td><a href=""><button type="button" class="btn btn-warning text-white btn-sm my-0">Editar</button></td>
                                    <td><a href=""><button type="button" class="btn btn-danger text-white btn-sm my-0">Eliminar</button></td>
                                </tr>
                                <%
                                    }
                                    try{

                                    }catch(Exception ex){
                                        ex.printStackTrace();
                                    }finally{
                                        _baseDatos.closeConnection();
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<%
    }  
%>