<%-- 
    Document   : modificarPerfilUsuario
    Created on : May 30, 2018, 7:50:41 PM
    Author     : juan_m_osuna
--%>

<%@page import="entity.perfilUsuario"%>
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
        
        if (request.getParameter("id") != null){
            
            int _id = Integer.parseInt(String.valueOf(request.getParameter("id")));
            
            baseDatos _baseDatos = new baseDatos();
            
            perfilUsuario _perfilUsuario = new perfilUsuario();
            
            try{
                
                perfilUsuarioDAOImpl _perfilUsuarioDAO = new perfilUsuarioDAOImpl(_baseDatos.getConnection());
                
                _perfilUsuario = (perfilUsuario) _perfilUsuarioDAO.consultarPorId(_id);
                
            }catch(Exception ex){
                
                ex.printStackTrace();
                
            }finally{
                
                if (_baseDatos != null){
                    _baseDatos.closeConnection();
                }
                
            }
            
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar perfil de usuario</title>
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
                color: #3079ed;
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
            
            .paddin10{
                padding: 10px;
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
                    <h1 class="card-title fontUbuntulight fontColor ">Modificar perfil de usuario</h1>
                    <i class="fas fa-pencil-alt fa-4x iconColor"></i>
                </div>
            </div>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="perfilUsuarioTabla.jsp">Perfil de usuario</a> <span class="divider">/</span></li>
                <li class="active">Modificar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="perfilUsuarioTabla.jsp" class="btn btn-light">Regresar</a>
                </li>
            </ul>
            <hr>
            <form id="formulario" action="/controlGPC/perfilUsuarioServlet.do" method="post" class="">
                <div class="form-group">
                    <label class="control-label" for="nombreCompleto">Nombre:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" name="nombreCompleto" placeholder="Teclee el nombre del perfil del usuario ..." value="<%=_perfilUsuario.getNombreCompleto() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!   
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="descripcion">Descripción:</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Teclee una descripción acerca del perfil del usuario ..." value="<%=_perfilUsuario.getDescripcion() %>">
                </div>
                <fieldset class="form-group">
                    <div class="row">
                        <legend class="col-form-label col-sm-4 pt-0">Privilegios:</legend>
                        <div class="col-sm-10">
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" id="accesoPlataforma" name="accesoPlataforma" <%=(_perfilUsuario.isAccesoPlataforma() ? "checked" : "") %>>
                              <label class="control-label" class="form-check-label" for="accesoPlataforma">Acceso a la Plataforma</label>
                            </div>
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" id="gestionCatalogos" name="gestionCatalogos" <%=(_perfilUsuario.isGestionCatalogos() ? "checked" : "") %>>
                              <label class="control-label" class="form-check-label" for="gestionCatalogos">Gestión de catálogos configuración</label>
                            </div>
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" id="gestionUsuario" name="gestionUsuario" <%=(_perfilUsuario.isGestionUsuario() ? "checked" : "") %>>
                              <label class="control-label" class="form-check-label" for="gestionUsuario">Gestión de usuarios</label>
                            </div>
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" id="gestionDocumentos" name="gestionDocumentos" data-toggle="collapse" href="#collapseExample" role="button" <%=(_perfilUsuario.isGestionDocumentos() ? "checked" : "") %>>
                              <label class="control-label" class="form-check-label" for="gestionDocumentos">Gestión de documentos</label>
                            </div>
                            <div class="<%=(_perfilUsuario.isGestionDocumentos() ? "" : "collapse") %> col-sm-4" id="collapseExample">
                                <div class="card card-body backgroundLightgray">
                                  <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="agregarDocumento" name="agregarDocumento" <%=(_perfilUsuario.isAgregarDocumento() ? "checked" : "") %>>
                                        <label class="control-label" class="form-check-label" for="agregarDocumento">Agregar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="eliminarDocumento" name="eliminarDocumento" <%=(_perfilUsuario.isEliminarDocumento()? "checked" : "") %>>
                                        <label class="control-label" class="form-check-label" for="eliminarDocumento">Eliminar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox"id="modificarDocumento" name="modificarDocumento" <%=(_perfilUsuario.isModificarDocumento() ? "checked" : "") %>>
                                        <label class="control-label" class="form-check-label" for="modificarDocumento">Modificar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="buscarDocumento" name="buscarDocumento" <%=(_perfilUsuario.isBuscarDocumento() ? "checked" : "") %>>
                                        <label class="control-label" class="form-check-label" for="buscarDocumento">Buscar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="imprimirDocumento" name="imprimirDocumento" <%=(_perfilUsuario.isImprimirDocumento() ? "checked" : "") %>>
                                        <label class="control-label" class="form-check-label" for="imprimirDocumento">Imprimir documentos</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="button" class="btn btn-light" onclick="location.href='perfilUsuarioTabla.jsp';" >Cancelar</button>
                </div>
                <input type="hidden" id="op" name="id" value="<%=_id %>">
                <input type="hidden" id="op" name="op" value="2">
            </form>
        </div>
    </body>
</html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<%
        }else{
            
            String _mensajeAlerta = "danger, No se encontró el perfil de usuario ...";
            response.sendRedirect("/controlGPC/catalogos/perfilUsuario/perfilUsuarioTabla.jsp?m=" + _mensajeAlerta);
        }
    }  
%>