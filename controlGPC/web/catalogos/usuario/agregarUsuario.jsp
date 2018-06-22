<%-- 
    Document   : agregarUsuario
    Created on : May 30, 2018, 7:50:41 PM
    Author     : juan_m_osuna
--%>

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
        <title>Agregar usuario</title>
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
                    <h1 class="card-title fontUbuntulight fontColor ">Agregar usuario</h1>
                    <i class="fa fa-plus fa-4x iconColor"></i>
                </div>
            </div>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="usuarioTabla.jsp">Usuario</a> <span class="divider">/</span></li>
                <li class="active">Agregar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="usuarioTabla.jsp" class="btn btn-light">Regresar</a>
                </li>
            </ul>
            <hr>
            <form id="formulario" action="vehiculoServlet.do" method="post" class="">
                <div class="form-group">
                    <label class="control-label" for="nombreCompleto">Nombre completo:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" name="nombreCompleto" placeholder="Teclee el nombre completo del usuario ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                      <legend class="col-form-label col-sm-4 pt-0">Sexo:</legend>
                      <div class="col-sm-10">
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" id="sexo1" name="sexo" value="Hombre" checked>
                          <label class="control-label" class="form-check-label" for="sexo1">Hombre</label>
                        </div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" id="sexo2" name="sexo" value="Mujer">
                          <label class="control-label" class="form-check-label" for="sexo2">Mujer</label>
                        </div>
                      </div>
                    </div>
                </fieldset>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="idDepartamento">Departamento:</label>
                    <select class="custom-select mr-sm-2" id="idDepartamento" name="idDepartamento">
                        <option value="0" selected>Selecciona un departamento...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="idEmpresa">Empresa:</label>
                    <select class="custom-select mr-sm-2" id="idEmpresa" name="idEmpresa">
                        <option value="0" selected>Selecciona una empresa ...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="idLocalidad">Localidad:</label>
                    <select class="custom-select mr-sm-2" id="idLocalidad" name="idLocalidad">
                        <option value="0" selected>Selecciona un localidad...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label" for="cuenta">Datos de la cuenta del usuario:</label>
                    <div class="container backgroundLightgray borderLightgray paddin10">
                        <div class="form-group">
                            <label class="control-label" class="mr-sm-2" for="idPerfilUsuario">Perfil de Usuario:</label>
                            <select class="custom-select mr-sm-2" id="idPerfilUsuario" name="idPerfilUsuario">
                                <option value="0" selected>Selecciona un perfil de usuario ...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="cuenta">Cuenta de usuario:</label>
                            <input type="email" class="form-control is-invalid" id="cuenta" name="cuenta" placeholder="Teclee la cuenta de correo del usuario ..." required>
                            <div class="invalid-feedback">
                             Campo obligatorio!   
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="contrasena">Contraseña:</label>
                            <input type="password" class="form-control is-invalid" id="contrasena" name="contrasena" aria-describedby="passwordHelpInline" placeholder="Teclee una contraseña para el usuario ..." required>
                            <div id="passwordHelpInline" class="form-text text-muted">
                                Campo alfanumérico entre 8 a 20 caracteres!   
                            </div>
                            <div class="invalid-feedback">
                             Campo obligatorio!   
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label class="control-label">Foto del usuario:</label>
                        <div class="form-group">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="fotoUsuario" name="fotoUsuario">
                                <label class="control-label" class="custom-file-label" for="fotoUsuario">Selecciona una imagen</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="cuentaActiva" name="cuentaActiva">
                    <label class="control-label" class="form-check-label" for="cuentaActiva">Habilitar cuenta</label>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="button" class="btn btn-light" onclick="location.href='usuarioTabla.jsp';" >Cancelar</button>
                </div>
            </form>
        </div>
    </body>
</html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<%
    }  
%>