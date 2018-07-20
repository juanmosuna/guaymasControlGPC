<%-- 
    Document   : modificarVehiculo
    Created on : May 30, 2018, 10:56:22 PM
    Author     : juan_m_osuna
--%>

<%@page import="DAO.database.vehiculoDAOImpl"%>
<%@page import="entity.vehiculo"%>
<%@page import="DAO.database.transportistaDAOImpl"%>
<%@page import="entity.transportista"%>
<%@page import="entity.tipoVehiculo"%>
<%@page import="DAO.database.tipoVehiculoDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
            
            vehiculo _vehiculo = new vehiculo();
            
            try{
                
                vehiculoDAOImpl _vehiculoDAO = new vehiculoDAOImpl(_baseDatos.getConnection());
                
                _vehiculo = (vehiculo) _vehiculoDAO.consultarPorId(_id);
                
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
        <title>Modificar vehículo</title>
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
                    <h1 class="card-title fontUbuntulight fontColor ">Modificar vehículo</h1>
                    <i class="fas fa-pencil-alt fa-4x iconColor"></i>
                </div>
            </div>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="vehiculoTabla.jsp">Vehiculo</a> <span class="divider">/</span></li>
                <li class="active">Modificar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="vehiculoTabla.jsp" class="btn btn-light">Regresar</a>
                </li>
            </ul>
            <hr>
            <form id="formulario" action="/controlGPC/vehiculoServlet.do" method="post" class="">
                <div class="form-group">
                    <label class="control-label" for="marca">Marca:</label>
                    <input type="text" class="form-control is-invalid" id="marca" name="marca" placeholder="Teclee una marca para éste vehículo ..." value="<%=_vehiculo.getMarca() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="modelo">Modelo:</label>
                    <input type="text" class="form-control is-invalid" id="modelo" name="modelo" placeholder="Teclee una modelo para éste vehículo ..." value="<%=_vehiculo.getModelo() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="idTipoVehiculo">Tipo de vehículo:</label>
                    <select class="custom-select mr-sm-2" id="idTipoVehiculo" name="idTipoVehiculo">
                        <option value="0">Selecciona un tipo de vehículo ...</option>
                        <%
                            _baseDatos = new baseDatos();
                            
                            List<tipoVehiculo> _tipoVehiculoDAO = new ArrayList<tipoVehiculo>();
                                
                            try{
                            
                                tipoVehiculoDAOImpl _tipoVehiculoDAOImpl = new tipoVehiculoDAOImpl(_baseDatos.getConnection());
                                
                                _tipoVehiculoDAO = (List<tipoVehiculo>)_tipoVehiculoDAOImpl.consultarTodos();
                            
                            }catch(Exception ex){

                                ex.printStackTrace();

                            }finally{

                                if (_baseDatos != null){
                                    _baseDatos.closeConnection();
                                }

                            }
                        
                            for(tipoVehiculo _tipoVehiculo : _tipoVehiculoDAO){
                                out.print("<option value=\""+_tipoVehiculo.getId()+"\" " + ( _tipoVehiculo.getId() == _vehiculo.getTipoVehiculo().getId() ? "selected"  : "" ) + ">"+_tipoVehiculo.getNombreCompleto()+"</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label" for="numeroSerie">Número de serie:</label>
                    <input type="text" class="form-control is-invalid" id="numeroSerie" name="numeroSerie" placeholder="Teclee un número de serie para éste vehículo ..." value="<%=_vehiculo.getNumeroSerie() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="placas">Número de placas:</label>
                    <input type="text" class="form-control is-invalid" id="placas" name="placas" placeholder="Teclee un número de placas para éste vehículo ..." value="<%=_vehiculo.getPlacas() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="numeroEconomico">Número de económico:</label>
                    <input type="text" class="form-control is-invalid" id="numeroEconomico" name="numeroEconomico" placeholder="Teclee un número económico para éste vehículo ..." value="<%=_vehiculo.getNumeroEconomico() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="tarjetaCirculacion">Tarjeta de circulación:</label>
                    <input type="text" class="form-control is-invalid" id="tarjetaCirculacion" name="tarjetaCirculacion" placeholder="Teclee el número de tarjeta de circulación del vehículo ..." value="<%=_vehiculo.getTarjetaCirculacion() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="polizaSeguro">Número de póliza de seguro:</label>
                    <input type="text" class="form-control is-invalid" id="polizaSeguro" name="polizaSeguro" placeholder="Teclee el número de póliza de seguro del vehículo ..." value="<%=_vehiculo.getPolizaSeguro() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="fechaPoliza">Fecha de la póliza de seguro:</label>
                    <input type="date" class="form-control is-invalid" id="fechaPoliza" name="fechaPoliza" placeholder="Teclee la fecha de la póliza de seguro del vehículo ..." value="<%=_vehiculo.getFechaPoliza() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="nombrePropietario">Nombre del propietario:</label>
                    <input type="text" class="form-control is-invalid" id="nombrePropietario" name="nombrePropietario" placeholder="Teclee el nombre completo del propietario del vehículo ..." value="<%=_vehiculo.getNombrePropietario() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="idTransportista">Ligar al transportista:</label>
                    <select class="custom-select mr-sm-2" id="idTransportista" name="idTransportista">
                        <option value="0">Selecciona un transportista ...</option>
                        <%
                            _baseDatos = new baseDatos();
                            
                            List<transportista> _transportistaDAO = new ArrayList<transportista>();
                                
                            try{
                            
                                transportistaDAOImpl _transportistaDAOImpl = new transportistaDAOImpl(_baseDatos.getConnection());
                                
                                _transportistaDAO = (List<transportista>)_transportistaDAOImpl.consultarTodos();
                            
                            }catch(Exception ex){

                                ex.printStackTrace();

                            }finally{

                                if (_baseDatos != null){
                                    _baseDatos.closeConnection();
                                }

                            }
                        
                            for(transportista _transportista : _transportistaDAO){
                                out.print("<option value=\""+_transportista.getId()+"\" " + ( _transportista.getId() == _vehiculo.getTransportista().getId() ? "selected"  : "" ) + ">"+_transportista.getNombreCompleto()+"</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="button" class="btn btn-light" onclick="location.href='vehiculoTabla.jsp';" >Cancelar</button>
                </div>
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
            
            String _mensajeAlerta = "danger, No se encontró el vehículo ...";
            response.sendRedirect("/controlGPC/catalogos/vehiculo/vehiculoTabla.jsp?m=" + _mensajeAlerta);
        }
    }  
%>