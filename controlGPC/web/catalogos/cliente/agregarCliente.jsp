<%-- 
    Document   : agregarCliente
    Created on : May 30, 2018, 10:53:31 PM
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
        <title>Agregar cliente</title>
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
            <h1 class="fontUbuntulight fontColor">Agregar cliente</h1>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="clienteTabla.jsp">Cliente</a> <span class="divider">/</span></li>
                <li class="active">Agregar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="clienteTabla.jsp">Regresar</a>
                </li>
            </ul>
            <hr>
            <form id="formulario" action="clienteServlet.do" method="post" class="">
                <div class="form-group">
                    <label class="control-label" for="nombreCompleto">Nombre completo:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" name="nombreCompleto" placeholder="Teclee el nombre completo del cliente ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="descripcion">Descripción:</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Teclee una descripción acerca del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="domicilio">Domicilio:</label>
                    <input type="text" class="form-control" id="domicilio" name="domicilio" placeholder="Teclee el domicilio del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="codigoPostal">Código postal:</label>
                    <input type="text" class="form-control" id="codigoPostal" name="codigoPostal" placeholder="Teclee el código postal del domicilio del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="localidad">Localidad:</label>
                    <input type="text" class="form-control" id="localidad" name="localidad" placeholder="Teclee la localidad del domicilio del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="ciudad">Ciudad:</label>
                    <input type="text" class="form-control" id="ciudad" name="ciudad" placeholder="Teclee la ciudad del domicilio del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="estado">Estado:</label>
                    <input type="text" class="form-control" id="estado" name="estado" placeholder="Teclee el estado del domicilio del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="pais">País:</label>
                    <input type="text" class="form-control" id="pais" name="pais" placeholder="Teclee el país del domicilio del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="telefono">Teléfono:</label>
                    <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Teclee el número telefónico del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="mobile">Celular:</label>
                    <input type="tel" class="form-control" id="mobile" name="mobile" placeholder="Teclee el número de celular del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="fax">Fax:</label>
                    <input type="tel" class="form-control" id="fax" name="fax" placeholder="Teclee el número de fax del cliente ..." >
                </div>
                <div class="form-group">
                    <label class="control-label" for="correoElectronico">Correo electrónico:</label>
                    <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" placeholder="Teclee la cuenta de correo electrónico del cliente ..." required>
                </div>
                <div class="form-group">
                    <label class="control-label" for="paginaWeb">Página web:</label>
                    <input type="url" class="form-control" id="paginaWeb" name="paginaWeb" placeholder="Teclee la página web del cliente ..." required>
                </div>
                <div class="form-group">
                    <label class="control-label">Foto del cliente:</label>
                    <div class="form-group">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="fotoCliente" name="fotoCliente">
                            <label class="control-label" class="custom-file-label" for="fotoCliente">Selecciona una imagen</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="button" class="btn btn-light" onclick="location.href='clienteTabla.jsp';" >Cancelar</button>
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