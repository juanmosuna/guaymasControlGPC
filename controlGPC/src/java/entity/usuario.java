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
public class usuario {

    private int id = 0;
    private String nombreCompleto = new String();
    private String sexo = new String();
    private perfilUsuario perfilUsuario = new perfilUsuario();
    private localidad localidad = new localidad();
    private departamento departamento = new departamento();
    private empresa empresa = new empresa();
    private String cuenta = new String();
    private String contrasena = new String();
    private byte[] fotoUsuario = null;
    private boolean cuentaActiva = false;
    private int idEstado = 0;
    private String estado = new String();
    
    public usuario() {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public perfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(perfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(localidad localidad) {
        this.localidad = localidad;
    }

    public departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(departamento departamento) {
        this.departamento = departamento;
    }

    public empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(empresa empresa) {
        this.empresa = empresa;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public byte[] getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(byte[] fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public boolean isCuentaActiva() {
        return cuentaActiva;
    }

    public void setCuentaActiva(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
