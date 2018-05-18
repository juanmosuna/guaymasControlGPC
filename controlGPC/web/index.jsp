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
        <link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%
            String _mensaje = (session.getAttribute("mensajeError") != null ? String.valueOf(session.getAttribute("mensajeError")) : new String() );
            
            if (!_mensaje.isEmpty()){
        %>
        <div class="alerta">
            <div class="iconoAlerta"><i class="fa fa-warning fa-3x"></i></div>
            <div class="mensajeAlerta"><%=_mensaje %></div>
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
                            <span><i class="fa fa-user"></i></span>
                            <input id="nombreUsuario" type="text" name="nombreUsuario" value="" placeholder="usuario" title="Capture su nombre de usuario ..." autofocus required/>
                        </div>
                        <div class="contenedorCampo">
                            <span><i class="fa fa-key   "></i></span>
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
