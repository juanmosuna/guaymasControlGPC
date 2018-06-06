<%-- 
    Document   : agregarVehiculo
    Created on : May 30, 2018, 10:56:22 PM
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
        <title>Agregar vehículo</title>
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
            <h1 class="fontUbuntulight fontColor">Agregar vehículo</h1>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="vehiculoTabla.jsp">Vehiculo</a> <span class="divider">/</span></li>
                <li class="active">Agregar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="vehiculoTabla.jsp">Regresar</a>
                </li>
            </ul>
            <hr>
            <form action="" method="post" class="">
                <div class="form-group">
                    <label for="marca">Marca:</label>
                    <input type="text" class="form-control is-invalid" id="marca" name="marca" placeholder="Teclee una marca para éste vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="modelo">Modelo:</label>
                    <input type="text" class="form-control is-invalid" id="modelo" name="modelo" placeholder="Teclee una modelo para éste vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="mr-sm-2" for="idTipoVehiculo">Tipo de vehículo:</label>
                    <select class="custom-select mr-sm-2" id="idTipoVehiculo" name="idTipoVehiculo">
                        <option value="0" selected>Selecciona un tipo de vehículo ...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="numeroSerie">Número de serie:</label>
                    <input type="text" class="form-control is-invalid" id="numeroSerie" name="numeroSerie" placeholder="Teclee un número de serie para éste vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="placas">Número de placas:</label>
                    <input type="text" class="form-control is-invalid" id="placas" name="placas" placeholder="Teclee un número de placas para éste vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="numeroEconomico">Número de económico:</label>
                    <input type="text" class="form-control is-invalid" id="numeroEconomico" name="numeroEconomico" placeholder="Teclee un número económico para éste vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="tarjetaCirculacion">Tarjeta de circulación:</label>
                    <input type="text" class="form-control is-invalid" id="tarjetaCirculacion" name="tarjetaCirculacion" placeholder="Teclee el número de tarjeta de circulación del vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="polizaSeguro">Número de póliza de seguro:</label>
                    <input type="text" class="form-control is-invalid" id="polizaSeguro" name="polizaSeguro" placeholder="Teclee el número de póliza de seguro del vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="fechaPoliza">Fecha de la póliza de seguro:</label>
                    <input type="date" class="form-control is-invalid" id="fechaPoliza" name="fechaPoliza" placeholder="Teclee la fecha de la póliza de seguro del vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="nombrePropietario">Nombre del propietario:</label>
                    <input type="text" class="form-control is-invalid" id="nombrePropietario" name="nombrePropietario" placeholder="Teclee el nombre completo del propietario del vehículo ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="mr-sm-2" for="idTransportista">Ligar al transportista:</label>
                    <select class="custom-select mr-sm-2" id="idTransportista" name="idTransportista">
                        <option value="0" selected>Selecciona un transportista ...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
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
<%
    }  
%>