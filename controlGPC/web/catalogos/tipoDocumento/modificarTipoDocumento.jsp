<%-- 
    Document   : modificarTipoDocumento
    Created on : May 30, 2018, 10:55:40 PM
    Author     : juan_m_osuna
--%>

<%@page import="DAO.database.tipoDocumentoDAOImpl"%>
<%@page import="entity.tipoDocumento"%>
<%@page import="database.baseDatos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.database.tipoMovimientoDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="entity.tipoMovimiento"%>
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
            
            tipoDocumento _tipoDocumento = new tipoDocumento();
            
            try{
                
                tipoDocumentoDAOImpl _tipoDocumentoDAO = new tipoDocumentoDAOImpl(_baseDatos.getConnection());
                
                _tipoDocumento = (tipoDocumento) _tipoDocumentoDAO.consultarPorId(_id);
                
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
        <title>Modificar tipo de documento</title>
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
                    <h1 class="card-title fontUbuntulight fontColor ">Modificar tipo de documento</h1>
                    <i class="fas fa-pencil-alt fa-4x iconColor"></i>
                </div>
            </div>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="tipoDocumentoTabla.jsp">Tipo de documento</a> <span class="divider">/</span></li>
                <li class="active">Modificar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="tipoDocumentoTabla.jsp" class="btn btn-light">Regresar</a>
                </li>
            </ul>
            <hr>
            <form id="formulario" action="/controlGPC/tipoDocumentoServlet.do" method="post" class="">
                <div class="form-group">
                    <label class="control-label" for="nombreCompleto">Nombre completo:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" name="nombreCompleto" placeholder="Teclee el nombre completo del tipo de documento ..." value="<%=_tipoDocumento.getNombreCompleto() %>" required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="descripcion">Descripción:</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Teclee una descripción acerca del tipo de documento ..." value="<%=_tipoDocumento.getDescripcion() %>" required>
                </div>
                <div class="form-group">
                    <label class="control-label" class="mr-sm-2" for="idTipoMovimiento">Tipo de movimiento del documento:</label>
                    <select class="custom-select mr-sm-2" id="idTipoMovimiento" name="idTipoMovimiento">
                        <option value="0" selected>Selecciona un tipo de movimiento para el documento ...</option>
                        <%
                            _baseDatos = new baseDatos();
                            
                            List<tipoMovimiento> _tipoMovimientoDAO = new ArrayList<tipoMovimiento>();
                                
                            try{
                            
                                tipoMovimientoDAOImpl _tipoMovimientoDAOImpl = new tipoMovimientoDAOImpl(_baseDatos.getConnection());
                                
                                _tipoMovimientoDAO = (List<tipoMovimiento>)_tipoMovimientoDAOImpl.consultarTodos();
                            
                            }catch(Exception ex){

                                ex.printStackTrace();

                            }finally{

                                if (_baseDatos != null){
                                    _baseDatos.closeConnection();
                                }

                            }
                        
                            for(tipoMovimiento _tipoMovimiento : _tipoMovimientoDAO){
                                out.print("<option value=\""+_tipoMovimiento.getId()+"\" " + ( _tipoMovimiento.getId() == _tipoDocumento.getTipoMovimiento().getId() ? "selected"  : "" ) + ">"+_tipoMovimiento.getNombreCompleto()+"</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <button type="button" class="btn btn-light" onclick="location.href='tipoDocumentoTabla.jsp';" >Cancelar</button>
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
            
            String _mensajeAlerta = "danger, No se encontró el tipo de documento ...";
            response.sendRedirect("/controlGPC/catalogos/tipoDocumento/tipoDocumentoTabla.jsp?m=" + _mensajeAlerta);
        }
    }  
%>