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
public class calidad {

    private int id = 0;
    private String codigo = new String();
    private String nombreCompleto = new String();
    private String descripcion = new String();
    private grupoCalidad grpCalidad = new grupoCalidad();
    
    private int idEstado = 0;

    public calidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public grupoCalidad getGrpCalidad() {
        return grpCalidad;
    }

    public void setGrpCalidad(grupoCalidad grpCalidad) {
        this.grpCalidad = grpCalidad;
    }

}
