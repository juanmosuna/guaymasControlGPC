<%-- 
    Document   : agregarUsuario
    Created on : May 30, 2018, 7:50:41 PM
    Author     : juan_m_osuna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar usuario</title>
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
            <h1 class="fontUbuntulight fontColor">Agregar usuario</h1>
            <hr>
            <form action="" method="post" class="">
                <div class="form-group">
                    <label for="nombreCompleto">Nombre completo:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" placeholder="Teclee el nombre completo del usuario ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <fieldset class="form-group">
                    <div class="row">
                      <legend class="col-form-label col-sm-4 pt-0">Sexo:</legend>
                      <div class="col-sm-10">
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="sexo" id="sexo1" value="Hombre" checked>
                          <label class="form-check-label" for="sexo1">Hombre</label>
                        </div>
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" type="radio" name="sexo" id="sexo2" value="Mujer">
                          <label class="form-check-label" for="sexo2">Mujer</label>
                        </div>
                      </div>
                    </div>
                </fieldset>
                <div class="form-group">
                    <label class="mr-sm-2" for="perfilUsuario">Perfil de Usuario:</label>
                    <select class="custom-select mr-sm-2" id="perfilUsuario">
                        <option value="0" selected>Selecciona un perfil de usuario ...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="mr-sm-2" for="departamento">Departamento:</label>
                    <select class="custom-select mr-sm-2" id="departamento">
                        <option value="0" selected>Selecciona un departamento...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="mr-sm-2" for="empresa">Empresa:</label>
                    <select class="custom-select mr-sm-2" id="empresa">
                        <option value="0" selected>Selecciona una empresa ...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="cuenta">Datos de la cuenta del usuario:</label>
                    <div class="container backgroundLightgray borderLightgray paddin10">
                        <div class="form-group">
                            <label for="cuenta">Cuenta de usuario:</label>
                            <input type="email" class="form-control is-invalid" id="cuenta" placeholder="Teclee la cuenta de correo del usuario ..." required>
                            <div class="invalid-feedback">
                             Campo obligatorio!   
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contrasena">Contraseña:</label>
                            <input type="password" class="form-control is-invalid" id="contrasena"  aria-describedby="passwordHelpInline" placeholder="Teclee una contraseña para el usuario ..." required>
                            <div id="passwordHelpInline" class="form-text text-muted">
                                Campo alfanumérico entre 8 a 20 caracteres!   
                            </div>
                            <div class="invalid-feedback">
                             Campo obligatorio!   
                            </div>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label>Foto del usuario:</label>
                        <div class="form-group">
                            <div class="custom-file">
                                <input type="file" class="custom-file-input" id="fotoUsuario">
                                <label class="custom-file-label" for="fotoUsuario">Selecciona una imagen</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="habilitarCuenta">
                    <label class="form-check-label" for="habilitarCuenta">Habilitar cuenta</label>
                </div>
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
