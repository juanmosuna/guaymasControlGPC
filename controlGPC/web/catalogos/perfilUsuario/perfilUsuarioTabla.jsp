<%-- 
    Document   : perfilUsuarioTabla
    Created on : Jun 4, 2018, 9:59:27 PM
    Author     : juan_m_osuna
--%>

<%@page import="java.util.ArrayList"%>
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
        
        boolean _mostrarAlerta = false;
        String[] _mensajeAlerta = new String[2];
        
        if (request.getParameter("m") != null){
            
            _mensajeAlerta = String.valueOf(request.getParameter("m")).split(",");
            _mostrarAlerta = true;
            
        }
    
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
            
            .text-danger:hover{
                color: tomato; 
            }
            
            .text-primary:hover{
               color: tomato; 
            }
            
            .alert {
                top: 20px;
                right: 20px;
                
                position:absolute;
                z-index: 1;
                
            }
            
        </style>
    </head>
    <body>
        <%
            if (_mostrarAlerta){
        %>
        <div class="alert alert-<%=_mensajeAlerta[0] %> alert-dismissible fade show" role="alert">
            <%=_mensajeAlerta[1] %>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <%
            }
        %>
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
                    <a href="../catalogos.jsp" class="btn btn-light">Regresar</a>
                </li>
            </ul>
            <hr>
            <div class="container">
                <table id="table" class="table table-bordered table-hover">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Nombre completo</th>
                            <th scope="col">Descripción</th>
                            <th scope="col">Plataforma</th>
                            <th scope="col">Configuración</th>
                            <th scope="col">Usuarios</th>
                            <th scope="col">Documentos</th>
                            <th scope="col"><i class="fa fa-pencil-alt"></i></th>
                            <th scope="col"><i class="fa fa-trash-alt"></i></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            baseDatos _baseDatos = new baseDatos();
                            
                            List<perfilUsuario> _perfilUsuarioDAO = new ArrayList<perfilUsuario>();
                                
                            try{
                            
                                perfilUsuarioDAOImpl _perfilUsuarioDAOImpl = new perfilUsuarioDAOImpl(_baseDatos.getConnection());
                                
                                _perfilUsuarioDAO = (List<perfilUsuario>)_perfilUsuarioDAOImpl.consultarTodos();
                            
                            }catch(Exception ex){

                                ex.printStackTrace();

                            }finally{

                                if (_baseDatos != null){
                                    _baseDatos.closeConnection();
                                }

                            }
                        
                            for(perfilUsuario _perfilUsuario : _perfilUsuarioDAO){
                        %>
                        <tr>
                            <td width="40" scope="row"><%=_perfilUsuario.getId() %></td>
                            <td><%=_perfilUsuario.getNombreCompleto() %></td>
                            <td><%=_perfilUsuario.getDescripcion() %></td>
                            <td width="100" align="CENTER"><%=( _perfilUsuario.isAccesoPlataforma() ? "SI" : "NO" ) %></td>
                            <td width="100" align="CENTER"><%=( _perfilUsuario.isGestionCatalogos() ? "SI" : "NO" ) %></td>
                            <td width="100" align="CENTER"><%=( _perfilUsuario.isGestionUsuario() ? "SI" : "NO" ) %></td>
                            <td width="100" align="CENTER"><%=( _perfilUsuario.isGestionDocumentos() ? "SI" : "NO" ) %></td>
                            <td width="10"><a href="modificarPerfilUsuario.jsp?id=<%=_perfilUsuario.getId() %>"><i class="fa fa-pencil-alt text-primary"></i></a></td>
                            <td width="10"><a href="/controlGPC/perfilUsuarioServlet.do?op=3&id=<%=_perfilUsuario.getId() %>"><i class="fa fa-trash-alt  text-danger"></i></a></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
        // show the alert
        setTimeout(function() {
            $(".alert").alert('close');
        }, 3000);
    });
</script>
<%
    }  
%>
