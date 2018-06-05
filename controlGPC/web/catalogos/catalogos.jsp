<%-- 
    Document   : catalogos
    Created on : Jun 4, 2018, 8:05:30 PM
    Author     : juan_m_osuna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogos Control GPC</title>
        <link href="../css/fontawesome-all.min.css" rel="stylesheet" type="text/css"/>
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
             
            h6{
                font-size: 0.9em;
            }
            
            .card:hover{
                cursor: pointer;
                border-color: #3079ed;
                background-color: #f5f5f5;
                
            }
            
            .card:hover>i{
                color: #3079ed;
            }
            
            .card:hover>div{
                color: #3079ed;
            }
           
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="fontUbuntulight fontColor">Catálogos generales</h1>
            <hr>
            <div class="card-deck">
                <div class="card text-center pt-3 pt-3 mb-4 col-2" onclick="location.href='almacen/almacenTabla.jsp';">
                    <i class="card-img-top fas fa-warehouse fa-2x"></i>
                    <div class="card-body">
                        <h6 class="card-title mb-0">Almacenes</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='calidad/calidadTabla.jsp';">
                    <i class="fas fa-clipboard-check fa-2x"></i>
                    <div class="card-body">
                       <h6 class="card-title mb-0">Calidades</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='categoriaProducto/categoriaProductoTabla.jsp';">
                    <i class="fas fa-boxes fa-2x"></i>
                    <div class="card-body">
                       <h6 class="card-title mb-0 mb-0">Categorías de producto</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='chofer/choferTabla.jsp';">
                    <i class="fas fa-user fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Choferes</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='cliente/clienteTabla.jsp';">
                    <i class="fas fa-user-tie fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Clientes</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='contactoCliente/contactoClienteTabla.jsp';">
                    <i class="fas fa-address-book fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Contactos del clientes</h6>
                    </div>
                </div>
            </div>  
            <div class="card-deck">
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='departamento/departamentoTabla.jsp';">
                    <i class="fab fa-laravel fa-2x"></i>
                    <div class="card-body">
                        <h6 class="card-title mb-0">Departamentos</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='empresa/empresaTabla.jsp';">
                    <i class="fas fa-building fa-2x"></i>
                    <div class="card-body">
                       <h6 class="card-title mb-0">Empresas</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='estado/estadoTabla.jsp';">
                    <i class="fas fa-thermometer-three-quarters fa-2x"></i>
                    <div class="card-body">
                       <h6 class="card-title mb-0">Estados</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='grupoCalidad/grupoCalidadTabla.jsp';">
                    <i class="fas fa-clipboard-check fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Grupo de calidades</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='localidad/localidadTabla.jsp';">
                    <i class="fas fa-globe fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Localidades</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='perfilUsuario/perfilUsuarioTabla.jsp';">
                    <i class="fas fa-users-cog fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Perfil de usuarios</h6>
                    </div>
                </div>
            </div>
            <div class="card-deck">
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='producto/productoTabla.jsp';">
                    <i class="fas fa-box fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Productos</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='tipoAlmacen/tipoAlmacenTabla.jsp';">
                    <i class="card-img-top fas fa-industry fa-2x"></i>
                    <div class="card-body">
                        <h6 class="card-title mb-0">Tipo de almacenes</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='tipoDocumento/tipoDocumentoTabla.jsp';">
                    <i class="far fa-copy fa-2x"></i>
                    <div class="card-body">
                       <h6 class="card-title mb-0">Tipo de documentos</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='tipoMovimiento/tipoMovimientoTabla.jsp';">
                    <i class="fas fa-exchange-alt fa-2x"></i>
                    <div class="card-body">
                       <h6 class="card-title mb-0">Tipo de movimientos</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='transportista/transportistaTabla.jsp';">
                    <i class="fas fa-truck-moving fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Transportistas</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 col-2" onclick="location.href='unidadMedida/unidadMedidaTabla.jsp';">
                    <i class="fas fa-ruler fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Unidades de medidas</h6>
                    </div>
                </div>
            </div>
            <div class="card-deck">
                <div class="card text-center pt-3 mb-4 mr-sm-2 col-2" style="width: 160px;" onclick="location.href='usuario/usuarioTabla.jsp';">
                    <i class="fas fa-users fa-2x"></i>
                    <div class="card-body">
                      <h6 class="card-title mb-0">Usuarios</h6>
                    </div>
                </div>
                <div class="card text-center pt-3 mb-4 mr-sm-2 col-2" style="width: 160px;" onclick="location.href='vehiculo/vehiculoTabla.jsp';">
                    <i class="fas fa-truck fa-2x"></i>
                    <div class="card-body">
                        <h6 class="card-title mb-0">Vehículos</h6>
                    </div>
                </div>
            </div>  
        </div>
    </body>
</html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>