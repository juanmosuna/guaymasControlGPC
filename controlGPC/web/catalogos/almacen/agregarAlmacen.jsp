<%-- 
    Document   : agregarAlmacen
    Created on : May 30, 2018, 10:51:43 PM
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
        <title>Agregar almacén</title>
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
            <h1 class="fontUbuntulight fontColor">Agregar almacén</h1>
            <ul class="breadcrumb">
                <li><a href="../catalogos.jsp">Catálogos</a> <span class="divider">/</span></li>
                <li><a href="almacenTabla.jsp">Almacén</a> <span class="divider">/</span></li>
                <li class="active">Agregar</li>
            </ul>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="almacenTabla.jsp">Regresar</a>
                </li>
            </ul>
            <hr>
            <form action="" method="post" class="">
                <div class="form-group">
                    <label for="nombreCompleto">Nombre completo:</label>
                    <input type="text" class="form-control is-invalid" id="nombreCompleto" name="nombreCompleto" placeholder="Teclee el nombre completo del almacén ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="codigo">Código del almacén:</label>
                    <input type="text" class="form-control is-invalid" id="codigo" name="codigo" placeholder="Teclee el código del almacén ..." required>
                    <div class="invalid-feedback">
                     Campo obligatorio!    
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción:</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="Teclee una descripción acerca del almacén ..." >
                </div>
                <div class="form-group">
                    <label class="mr-sm-2" for="tipoAlmacen">Tipo de almacén:</label>
                    <select class="custom-select mr-sm-2" id="tipoAlmacen" name="idtipoAlmacen">
                        <option value="0" selected>Selecciona un tipo de almacén ...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="capacidad">Capacidad del almacén:</label>
                    <input type="number" class="form-control" id="capacidad" name="capacidad" placeholder="Teclee la capacidad del almacén ..." >
                </div>
                <div class="form-group">
                    <label class="mr-sm-2" for="unidadMedida">Unidad de medida:</label>
                    <select class="custom-select mr-sm-2" id="unidadMedida" name="idunidadMedida">
                        <option value="0" selected>Selecciona una unidad de medida ...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="secciones">Secciones del almacén:</label>
                    <input type="number" class="form-control" id="secciones" name="secciones" placeholder="Teclee el número de secciones del almacén ..." >
                </div>
                <div class="form-group">
                    <label for="lado">Lados por sección del almacén:</label>
                    <input type="number" class="form-control" id="lado" name="lados" placeholder="Teclee el número de lados por sección del almacén ..." >
                </div>
                <div class="form-group">
                    <label for="segmentos">Segmentos por sección del almacén:</label>
                    <input type="number" class="form-control" id="segementos" name="segmentos" placeholder="Teclee el número de segmentos por sección del almacén ..." >
                </div>
                <div class="form-group">
                    <label for="niveles">Niveles por sección del almacén:</label>
                    <input type="number" class="form-control" id="niveles" name="niveles" placeholder="Teclee el número de niveles por sección del almacén ..." >
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