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
public class almacen {

    private int id = 0;
    private String codigo = new String();
    private String nombreCompleto = new String();
    private String descripcion = new String();
    private tipoAlmacen tpAlmacen = new tipoAlmacen();
    private double capacidad = 0.0;
    unidadMedida undMedida = new unidadMedida();
    private int secciones = 0;
    private int lados = 0;
    private int segmentos = 0;
    private int niveles = 0;
    private int idEstado = 0;

    public almacen() {
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

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
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

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public tipoAlmacen getTpAlmacen() {
        return tpAlmacen;
    }

    public void setTpAlmacen(tipoAlmacen tpAlmacen) {
        this.tpAlmacen = tpAlmacen;
    }

    public unidadMedida getUndMedida() {
        return undMedida;
    }

    public void setUndMedida(unidadMedida undMedida) {
        this.undMedida = undMedida;
    }

}
