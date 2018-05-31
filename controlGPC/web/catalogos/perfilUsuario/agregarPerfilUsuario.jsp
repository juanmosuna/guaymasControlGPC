<%-- 
    Document   : agregarPerfilUsuario
    Created on : May 30, 2018, 7:50:41 PM
    Author     : juan_m_osuna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar perfil de usuario</title>
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
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="fontUbuntulight fontColor">Agregar perfil de usuario</h1>
            <hr>
            <form action="" method="post" class="">
                <div class="form-group">
                    <label for="nombreCompleto">Nombre:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" placeholder="Teclee el nombre del perfil del usuario ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!   
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción:</label>
                    <input type="text" class="form-control" id="descripcion" placeholder="Teclee una descripción acerca del perfil del usuario ...">
                </div>
                <fieldset class="form-group">
                    <div class="row">
                        <legend class="col-form-label col-sm-4 pt-0">Privilegios:</legend>
                        <div class="col-sm-10">
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" name="ingresoPlataforma" id="ingresoPlataforma">
                              <label class="form-check-label" for="ingresoPlataforma">Acceso a la Plataforma</label>
                            </div>
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" name="gestionCatalogos" id="gestionCatalogos">
                              <label class="form-check-label" for="gestionCatalogos">Gestión de catálogos configuración</label>
                            </div>
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" name="gestionUsuario" id="gestionUsuario">
                              <label class="form-check-label" for="gestionUsuario">Gestión de usuarios</label>
                            </div>
                            <div class="form-check">
                              <input class="form-check-input" type="checkbox" name="gestionDocumentos" id="gestionDocumentos"  data-toggle="collapse" href="#collapseExample" role="button">
                              <label class="form-check-label" for="gestionDocumentos">Gestión de documentos</label>
                            </div>
                            <div class="collapse col-sm-4" id="collapseExample">
                                <div class="card card-body backgroundLightgray">
                                  <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="agregarDocumento" id="agregarDocumento" value="agregarDocumento">
                                        <label class="form-check-label" for="agregarDocumento">Agregar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="eliminarDocumento" id="eliminarDocumento" value="eliminarDocumento">
                                        <label class="form-check-label" for="eliminarDocumento">Eliminar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="modificarDocumento" id="modificarDocumento" value="modificarDocumento">
                                        <label class="form-check-label" for="modificarDocumento">Modificar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="buscarDocumento" id="buscarDocumento" value="buscarDocumento">
                                        <label class="form-check-label" for="buscarDocumento">Buscar documentos</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="Imprimir documentos" id="imprimirDocumento" value="imprimirDocumento">
                                        <label class="form-check-label" for="imprimirDocumento">Imprimir documentos</label>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </fieldset>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="submit" class="btn btn-light">Cancelar</button>
                </div>
            </form>
        </div>
    </body>
</html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>