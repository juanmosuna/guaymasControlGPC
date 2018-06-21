<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>controlGPC v1.8</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <style>
            
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
            String _mensaje = (session.getAttribute("m") != null ? String.valueOf(session.getAttribute("m")) : new String() );

            boolean _mostrarAlerta = false;
            String[] _mensajeAlerta = new String[2];

            if (_mensaje != null && !_mensaje.isEmpty()){

                _mensajeAlerta = _mensaje.split(",");
                _mostrarAlerta = true;

            }
            
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
        <div class="paginaCompleta">
            <div class="contenedorFormulario">
                <div class="tituloFormulario">
                    <label style="font-size: 1.2em;color: gray;">control</label>
                    <label style="font-size: 1.4em;color: tomato;">GPC</label>
                    <label style="font-size: 0.7em;color: black;">&nbsp;v1.8</label></div>
                <form action="login.do" method="POST" autocomplete="off">
                    <div class="agupadorCampos">
                        <div class="contenedorCampo">
                            <span><i class="fas fa-user"></i></span>
                            <input id="nombreUsuario" type="text" name="nombreUsuario" value="" placeholder="usuario" title="Capture su nombre de usuario ..." autofocus required/>
                        </div>
                        <div class="contenedorCampo">
                            <span><i class="fas fa-key   "></i></span>
                            <input id="contrasena" type="password" name="contrasena" value="" placeholder="contraseña" title="Capture su contraseña ..."  required/>
                        </div>
                    </div>
                    <div class="contenedorCheckbox">
                        <input id="checkGuardarContrasena" type="checkbox" name="checkGuardarContrasena" title="Seleccione para guardar contraseña ..." />
                        <label for="checkGuardarContrasena" style="font-family: ubuntuLight;font-size: 1em;color: gray;">&nbsp;Guarda contraseña</label>
                    </div>
                    <div class="contenedorBoton">
                        <input id="botonIngresar" type="submit" name="botonIngresar" value="Ingresar" title="Seleccione para ingresar ..." />
                    </div>
                </form>
                <div class="pieFormulario">Copyrights &COPY; 2018</div>
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
