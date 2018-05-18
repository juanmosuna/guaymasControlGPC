/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author elara
 */
public class documentacion {

    private int id = 0;
    private int idAlmacen = 0;
    private String nombreAlamcen = new String();
    private int idTipoDocumento = 0;
    private String nombreTipoDocumento = new String();
    private int folio = 0;
    private int secciones = 0;
    private int lados = 0;
    private int segmentos = 0;
    private String lote = new String();
    private String fechaHoraDocumentacion = new String();
    private int cantidad = 0;
    private int idunidadMedida = 0;
    private String nombreUnidadMedida = new String();
    private int idProducto = 0;
    private String nombreProducto = new String();
    private double pesoPromedio = 0.0;
    private int idgrupoCalidad = 0;
    private String nombreGrupoCalidad = new String();
    private int idUsuario = 0;
    private String nombreUsuario = new String();
    private int idEstado = 0;
    private String fechaHoraEstado = new String();
    private String comentarios = new String();

    public documentacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public String getNombreAlamcen() {
        return nombreAlamcen;
    }

    public void setNombreAlamcen(String nombreAlamcen) {
        this.nombreAlamcen = nombreAlamcen;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombreTipoDocumento() {
        return nombreTipoDocumento;
    }

    public void setNombreTipoDocumento(String nombreTipoDocumento) {
        this.nombreTipoDocumento = nombreTipoDocumento;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getSecciones() {
        return secciones;
    }

    public void setSecciones(int secciones) {
        this.secciones = secciones;
    }

    public int getLados() {
        return lados;
    }

    public void setLados(int lados) {
        this.lados = lados;
    }

    public int getSegmentos() {
        return segmentos;
    }

    public void setSegmentos(int segmentos) {
        this.segmentos = segmentos;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFechaHoraDocumentacion() {
        return fechaHoraDocumentacion;
    }

    public void setFechaHoraDocumentacion(String fechaHoraDocumentacion) {
        this.fechaHoraDocumentacion = fechaHoraDocumentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdunidadMedida() {
        return idunidadMedida;
    }

    public void setIdunidadMedida(int idunidadMedida) {
        this.idunidadMedida = idunidadMedida;
    }

    public String getNombreUnidadMedida() {
        return nombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        this.nombreUnidadMedida = nombreUnidadMedida;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    public int getIdgrupoCalidad() {
        return idgrupoCalidad;
    }

    public void setIdgrupoCalidad(int idgrupoCalidad) {
        this.idgrupoCalidad = idgrupoCalidad;
    }

    public String getNombreGrupoCalidad() {
        return nombreGrupoCalidad;
    }

    public void setNombreGrupoCalidad(String nombreGrupoCalidad) {
        this.nombreGrupoCalidad = nombreGrupoCalidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getFechaHoraEstado() {
        return fechaHoraEstado;
    }

    public void setFechaHoraEstado(String fechaHoraEstado) {
        this.fechaHoraEstado = fechaHoraEstado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
