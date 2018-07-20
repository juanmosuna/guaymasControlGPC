<%-- 
    Document   : modificarAlmacen
    Created on : May 30, 2018, 10:51:43 PM
    Author     : juan_m_osuna
--%>

<%@page import="DAO.database.almacenDAOImpl"%>
<%@page import="entity.almacen"%>
<%@page import="DAO.database.unidadMedidaDAOImpl"%>
<%@page import="entity.unidadMedida"%>
<%@page import="database.baseDatos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.tipoAlmacen"%>
<%@page import="java.util.List"%>
<%@page import="DAO.database.tipoAlmacenDAOImpl"%>
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
            
            almacen _almacen = new almacen();
            
            try{
                
                almacenDAOImpl _almacenDAO = new almacenDAOImpl(_baseDatos.getConnection());
                
                _almacen = (almacen) _almacenDAO.consultarPorId(_id);
                
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
        <title>Modificar almacén</title>
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
                    <h1 class="card-title fontUbuntulight fontColor ">Modificar almacén</h1>
                    <i class="fas fa-pencil-alt fa-4x iconColor"></i>
                </div>
            </div>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="almacenTabla.jsp">Almacén</a> <span class="divider">/</span></li>
                <li class="active">Modificar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="almacenTabla.jsp" class="btn btn-light">Regresar</a>
                </li>
            </ul>
            <hr>
            <form id="formulario" action="/controlGPC/almacenServlet.do" method="post" class="">
                <div class="form-group">
                    <label class="control-label" class="control-label" for="nombreCompleto">Nombre completo:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" name="nombreCompleto" placeholder="Teclee el nombre completo del almacén ..." value="<%=_almacen.getNombreCompleto() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="codigo">Código del almacén:</label>
                    <input type="text" class="form-control is-invalid" id="codigo" name="codigo" placeholder="Teclee el código del almacén ..." value="<%=_almacen.getCodigo() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="descripcion">Descripción:</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Teclee una descripción acerca del almacén ..." value="<%=_almacen.getDescripcion() %>" >
                </div>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="tipoAlmacen">Tipo de almacén:</label>
                    <select class="custom-select mr-sm-2" id="tipoAlmacen" name="idtipoAlmacen">
                        <option value="0">Selecciona un tipo de almacén ...</option>
                        <% 
                                _baseDatos = new baseDatos();

                                List<tipoAlmacen> _tipoAlmacenDAO = new ArrayList<tipoAlmacen>();

                                try{

                                    tipoAlmacenDAOImpl _tipoAlmacenDAOImpl = new tipoAlmacenDAOImpl(_baseDatos.getConnection());

                                    _tipoAlmacenDAO = (List<tipoAlmacen>)_tipoAlmacenDAOImpl.consultarTodos();

                                }catch(Exception ex){

                                    ex.printStackTrace();

                                }finally{

                                    if (_baseDatos != null){
                                        _baseDatos.closeConnection();
                                    }

                                }

                                for(tipoAlmacen _tipoAlmacen : _tipoAlmacenDAO){
                                    out.print("<option value=\"" + _tipoAlmacen.getId() + "\" " + ( _tipoAlmacen.getId() == _almacen.getTpAlmacen().getId() ? "selected" : "") + ">" + _tipoAlmacen.getNombreCompleto() + "</option>");
                                }
                                
                        %>
                    </select>
                </div>
                <div class="form-group"> 
                    <label class="control-label" for="capacidad">Capacidad del almacén:</label>
                    <input type="number" class="form-control" id="capacidad" name="capacidad" placeholder="Teclee la capacidad del almacén ..." value="<%=_almacen.getCapacidad() %>" >
                </div>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="unidadMedida">Unidad de medida:</label>
                    <select class="custom-select mr-sm-2" id="unidadMedida" name="idunidadMedida">
                        <option value="0">Selecciona una unidad de medida ...</option>
                        <%
                            _baseDatos = new baseDatos();
                            
                            List<unidadMedida> _unidadMedidaDAO = new ArrayList<unidadMedida>();
                                
                            try{
                            
                                unidadMedidaDAOImpl _unidadMedidaDAOImpl = new unidadMedidaDAOImpl(_baseDatos.getConnection());
                                
                                _unidadMedidaDAO = (List<unidadMedida>)_unidadMedidaDAOImpl.consultarTodos();
                            
                            }catch(Exception ex){

                                ex.printStackTrace();

                            }finally{

                                if (_baseDatos != null){
                                    _baseDatos.closeConnection();
                                }

                            }
                        
                            for(unidadMedida _unidadMedida : _unidadMedidaDAO){
                                out.print("<option value=\""+_unidadMedida.getId()+"\" " + ( _unidadMedida.getId() == _almacen.getUndMedida().getId() ? "selected" : "") + ">"+_unidadMedida.getNombreCompleto()+"</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <label class="control-label" for="secciones">Secciones del almacén:</label>
                    <input type="number" class="form-control" id="secciones" name="secciones" placeholder="Teclee el número de secciones del almacén ..." value="<%=_almacen.getSecciones() %>" >
                </div>
                <div class="form-group">
                    <label class="control-label" for="lado">Lados por sección del almacén:</label>
                    <input type="number" class="form-control" id="lado" name="lados" placeholder="Teclee el número de lados por sección del almacén ..." value="<%=_almacen.getLados() %>" >
                </div>
                <div class="form-group">
                    <label class="control-label" for="segmentos">Segmentos por sección del almacén:</label>
                    <input type="number" class="form-control" id="segementos" name="segmentos" placeholder="Teclee el número de segmentos por sección del almacén ..." value="<%=_almacen.getSegmentos() %>" >
                </div>
                <div class="form-group">
                    <label class="control-label" for="niveles">Niveles por sección del almacén:</label>
                    <input type="number" class="form-control" id="niveles" name="niveles" placeholder="Teclee el número de niveles por sección del almacén ..." value="<%=_almacen.getNiveles() %>" >
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="button" class="btn btn-light" onclick="location.href='almacenTabla.jsp';" >Cancelar</button>
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
            
            String _mensajeAlerta = "danger, No se encontró el almacén ...";
            response.sendRedirect("/controlGPC/catalogos/almacen/almacenTabla.jsp?m=" + _mensajeAlerta);
        }
    }  
%>