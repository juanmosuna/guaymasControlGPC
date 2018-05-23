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
public class bitacora {

    private int id = 0;
    private String tabla = new String();
    private tipoMovimiento _tpMovimiento = new tipoMovimiento();
    private String comentario = new String();
    private usuario _usuario = new usuario();
    private String fechaHora = new String();
    private int idEstado = 0;

    public bitacora() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public tipoMovimiento getTpMovimiento() {
        return _tpMovimiento;
    }

    public void setTpMovimiento(tipoMovimiento _tpMovimiento) {
        this._tpMovimiento = _tpMovimiento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(usuario _usuario) {
        this._usuario = _usuario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

}
