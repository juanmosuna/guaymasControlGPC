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
public class calidadNota {

    private int id = 0;
    private int idDocumentacion = 0;
    private int idCalidad = 0;
    private String nombreCalidad = new String();
    private double porcentajeCalidad = 0.0;
    private int idEstado = 0;

    public calidadNota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDocumentacion() {
        return idDocumentacion;
    }

    public void setIdDocumentacion(int idDocumentacion) {
        this.idDocumentacion = idDocumentacion;
    }

    public int getIdCalidad() {
        return idCalidad;
    }

    public void setIdCalidad(int idCalidad) {
        this.idCalidad = idCalidad;
    }

    public String getNombreCalidad() {
        return nombreCalidad;
    }

    public void setNombreCalidad(String nombreCalidad) {
        this.nombreCalidad = nombreCalidad;
    }

    public double getPorcentajeCalidad() {
        return porcentajeCalidad;
    }

    public void setPorcentajeCalidad(double porcentajeCalidad) {
        this.porcentajeCalidad = porcentajeCalidad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

}
