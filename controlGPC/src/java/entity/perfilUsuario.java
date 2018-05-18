/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author juan_m_osuna
 */
public class perfilUsuario {

    private int id = 0;
    private String nombreCompleto = new String();
    private String descripcion = new String();
    private boolean ingresoPlataforma = false;
    private boolean agregarDocumento = false;
    private boolean eliminarDocumento = false;
    private boolean modificarDocumento = false;
    private boolean buscarDocumento = false;
    private boolean imprimirDocumento = false;
    private int idEstado = 0;
    
    public perfilUsuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isIngresoPlataforma() {
        return ingresoPlataforma;
    }

    public void setIngresoPlataforma(boolean ingresoPlataforma) {
        this.ingresoPlataforma = ingresoPlataforma;
    }

    public boolean isAgregarDocumento() {
        return agregarDocumento;
    }

    public void setAgregarDocumento(boolean agregarDocumento) {
        this.agregarDocumento = agregarDocumento;
    }

    public boolean isEliminarDocumento() {
        return eliminarDocumento;
    }

    public void setEliminarDocumento(boolean eliminarDocumento) {
        this.eliminarDocumento = eliminarDocumento;
    }

    public boolean isModificarDocumento() {
        return modificarDocumento;
    }

    public void setModificarDocumento(boolean modificarDocumento) {
        this.modificarDocumento = modificarDocumento;
    }

    public boolean isBuscarDocumento() {
        return buscarDocumento;
    }

    public void setBuscarDocumento(boolean buscarDocumento) {
        this.buscarDocumento = buscarDocumento;
    }

    public boolean isImprimirDocumento() {
        return imprimirDocumento;
    }

    public void setImprimirDocumento(boolean imprimirDocumento) {
        this.imprimirDocumento = imprimirDocumento;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    
    
}
