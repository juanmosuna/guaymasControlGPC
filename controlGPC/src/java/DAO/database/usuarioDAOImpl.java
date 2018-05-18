/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import entity.perfilUsuario;
import entity.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan_m_osuna
 */
public class usuarioDAOImpl {

    private Connection conexion;

    public usuarioDAOImpl(Connection _conexion) {
        this.conexion = _conexion;
    }
    
    public boolean agregarRegistro(Object o) throws Exception {
        
        usuario _usuario = (usuario) o;
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("INSERT INTO controlGPC.dbusuario ")
                    .append("(nombreCompleto, ")
                    .append("idPerfilUsuario, ")
                    .append("idLocalidad, ")
                    .append("idDepartamento, ")
                    .append("idEmpresa, ")
                    .append("cuenta, ")
                    .append("contrasena, ")
                    .append("fotoUsuario, ")
                    .append("cuentaActiva, ")
                    .append("idEstado) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, aes_encrypt(?, 'gpc'), ?, ?, ?);");
                
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, _usuario.getNombreCompleto());
        st.setInt(2, _usuario.getPerfilUsuario().getId());
        st.setInt(3, _usuario.getIdLocalidad());
        st.setInt(4, _usuario.getIdDepartamento());
        st.setInt(5, _usuario.getIdEmpresa());
        st.setString(6, _usuario.getCuenta());
        st.setString(7, _usuario.getContrasena());
        st.setString(8, _usuario.getFotoUsuario());
        st.setBoolean(9, _usuario.isCuentaActiva());
        st.setInt(10, _usuario.getIdEstado());
        
        boolean resultado = st.execute();
        
        if (st != null){
            st.close();
        }
        
        return resultado;
    }

    public boolean eliminarRegistro(int _indice) throws Exception {
        
        String _consulta = "UPDATE controlGPC.dbusuario SET idEstado = 3 WHERE id = ?;";
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta);
        
        st.setInt(1, _indice);
        
        boolean resultado = st.execute();
        
        if (st != null){
            st.close();
        }
        
        return resultado;
    }

    public boolean modificarRegistro(Object o) throws Exception {
        
        usuario _usuario = (usuario) o;
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("UPDATE controlGPC.dbusuario ")
                .append("SET ")
                    .append("nombreCompleto = ?, ")
                    .append("idPerfilUsuario = ?, ")
                    .append("idLocalidad = ?, ")
                    .append("idDepartamento = ?, ")
                    .append("idEmpresa = ?, ")
                    .append("cuenta = ?, ")
                    .append("contrasena = aes_encrypt(?, 'gpc'), ")
                    .append("fotoUsuario = ?, ")
                    .append("cuentaActiva = ?, ")
                    .append("idEstado = ? ")
                .append("WHERE id = ?;");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, _usuario.getNombreCompleto());
        st.setInt(2, _usuario.getPerfilUsuario().getId());
        st.setInt(3, _usuario.getIdLocalidad());
        st.setInt(4, _usuario.getIdDepartamento());
        st.setInt(5, _usuario.getIdEmpresa());
        st.setString(6, _usuario.getCuenta());
        st.setString(7, _usuario.getContrasena());
        st.setString(8, _usuario.getFotoUsuario());
        st.setBoolean(9, _usuario.isCuentaActiva());
        st.setInt(10, _usuario.getIdEstado());
        st.setInt(11, _usuario.getId());
        
        boolean resultado = st.execute();
        
        if (st != null){
            st.close();
        }
        
        return resultado;
    }

    public Object consultarPorId(int _indice) throws Exception {
        
        Object o = new Object();
        usuario _usuario;
                
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT dbusuario.id, ")
                    .append("dbusuario.nombreCompleto, ")
                    .append("dbusuario.idPerfilUsuario, ")
                    .append("dbusuario.idLocalidad, ")
                    .append("dbusuario.idDepartamento, ")
                    .append("dbusuario.idEmpresa, ")
                    .append("dbusuario.cuenta, ")
                    .append("aes_decrypt(dbusuario.contrasena, 'gpc'), ")
                    .append("dbusuario.fotoUsuario, ")
                    .append("dbusuario.cuentaActiva, ")
                    .append("dbusuario.idEstado ")
                .append("FROM controlGPC.dbusuario ")
                .append("WHERE id = ?;");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setInt(1, _indice);
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            if(rs.next()){
                
                _usuario = new usuario();
            
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                
                perfilUsuario _perfilUsuario = new perfilUsuario();
                _perfilUsuario.setId(rs.getInt(3));
                
                _usuario.setPerfilUsuario(_perfilUsuario);
                _usuario.setIdLocalidad(rs.getInt(4));
                _usuario.setIdDepartamento(rs.getInt(5));
                _usuario.setIdEmpresa(rs.getInt(6));
                _usuario.setCuenta(rs.getString(7));
                _usuario.setContrasena(rs.getString(8));
                _usuario.setFotoUsuario(rs.getString(9));
                _usuario.setCuentaActiva(rs.getBoolean(10));
                _usuario.setIdEstado(rs.getInt(11));
                
                o = (Object)_usuario;
                
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            
            if (rs != null){
                rs.close();
            }
            if (st != null){
                st.close();
            }
            
        }
        
        return o;
    }

    public Object consultarPor(String _campo, String _dato) throws Exception {
        
        usuario _usuario;
        List<usuario> _listaUsuarios = new ArrayList<usuario>();
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT dbusuario.id, ")
                    .append("dbusuario.nombreCompleto, ")
                    .append("dbusuario.idPerfilUsuario, ")
                    .append("dbusuario.idLocalidad, ")
                    .append("dbusuario.idDepartamento, ")
                    .append("dbusuario.idEmpresa, ")
                    .append("dbusuario.cuenta, ")
                    .append("aes_decrypt(dbusuario.contrasena, 'gpc'), ")
                    .append("dbusuario.fotoUsuario, ")
                    .append("dbusuario.cuentaActiva, ")
                    .append("dbusuario.idEstado ")
                    .append("FROM controlGPC.dbusuario ")
                .append("WHERE " + _campo + " LIKE ?;");
                
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, "%"+_dato+"%");
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            while(rs.next()){
                
                _usuario = new usuario();
            
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                
                perfilUsuario _perfilUsuario = new perfilUsuario();
                _perfilUsuario.setId(rs.getInt(3));
                
                _usuario.setPerfilUsuario(_perfilUsuario);
                _usuario.setIdLocalidad(rs.getInt(4));
                _usuario.setIdDepartamento(rs.getInt(5));
                _usuario.setIdEmpresa(rs.getInt(6));
                _usuario.setCuenta(rs.getString(7));
                _usuario.setContrasena(rs.getString(8));
                _usuario.setFotoUsuario(rs.getString(9));
                _usuario.setCuentaActiva(rs.getBoolean(10));
                _usuario.setIdEstado(rs.getInt(11));
            
                _listaUsuarios.add(_usuario);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            
            if (rs != null){
                rs.close();
            }
            if (st != null){
                st.close();
            }
            
        }
        
        return (Object)_listaUsuarios;
    }

    public Object consultarTodos() throws Exception {
        
        usuario _usuario;
        List<usuario> _listaUsuarios = new ArrayList<usuario>();
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT dbusuario.id, ")
                    .append("dbusuario.nombreCompleto, ")
                    .append("dbusuario.idPerfilUsuario, ")
                    .append("dbusuario.idLocalidad, ")
                    .append("dbusuario.idDepartamento, ")
                    .append("dbusuario.idEmpresa, ")
                    .append("dbusuario.cuenta, ")
                    .append("aes_decrypt(dbusuario.contrasena, 'gpc'), ")
                    .append("dbusuario.fotoUsuario, ")
                    .append("dbusuario.cuentaActiva, ")
                    .append("dbusuario.idEstado ")
                .append("FROM controlGPC.dbusuario; ");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            while(rs.next()){
                
                _usuario = new usuario();
            
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                
                perfilUsuario _perfilUsuario = new perfilUsuario();
                _perfilUsuario.setId(rs.getInt(3));
                
                _usuario.setPerfilUsuario(_perfilUsuario);
                _usuario.setIdLocalidad(rs.getInt(4));
                _usuario.setIdDepartamento(rs.getInt(5));
                _usuario.setIdEmpresa(rs.getInt(6));
                _usuario.setCuenta(rs.getString(7));
                _usuario.setContrasena(rs.getString(8));
                _usuario.setFotoUsuario(rs.getString(9));
                _usuario.setCuentaActiva(rs.getBoolean(10));
                _usuario.setIdEstado(rs.getInt(11));
            
                _listaUsuarios.add(_usuario);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            
            if (rs != null){
                rs.close();
            }
            if (st != null){
                st.close();
            }
            
        }
        
        return (Object)_listaUsuarios;
    }
    
    public Object login (String _username, String _password) throws Exception {
        
        usuario _usuario = new usuario();
        List<usuario> _listaUsuarios = new ArrayList<usuario>();
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT ")
                    .append("u.id, ")
                    .append("u.nombreCompleto, ")
                    .append("u.idPerfilUsuario, ")
                    .append("u.idLocalidad, ")
                    .append("u.idDepartamento, ")
                    .append("u.idEmpresa, ")
                    .append("u.cuenta, ")
                    .append("aes_decrypt(u.contrasena, 'gpc'), ")
                    .append("u.fotoUsuario, ")
                    .append("u.cuentaActiva, ")
                    .append("u.idEstado, ")
                    .append("pu.nombreCompleto, ")
                    .append("pu.descripcion, ")
                    .append("pu.ingresoPlataforma, ")
                    .append("pu.agregarDocumento, ")
                    .append("pu.eliminarDocumento, ")
                    .append("pu.modificarDocumento, ")
                    .append("pu.buscarDocumento, ")
                    .append("pu.imprimirDocumento, ")
                    .append("pu.idEstado ")
                .append("FROM controlGPC.dbusuario u ")
                    .append("LEFT JOIN controlGPC.dbperfilUsuario pu ON pu.id = u.idPerfilUsuario ")
                .append("WHERE u.cuenta LIKE ? AND aes_decrypt(u.contrasena, 'gpc') LIKE ?;");
                    
                
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, _username);
        st.setString(2, _password);
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            if(rs.next()){
                
                _usuario = new usuario();
                perfilUsuario _perfilUsuario = new perfilUsuario();
                
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                
                _perfilUsuario.setId(rs.getInt(3));
                
                _usuario.setIdLocalidad(rs.getInt(4));
                _usuario.setIdDepartamento(rs.getInt(5));
                _usuario.setIdEmpresa(rs.getInt(6));
                _usuario.setCuenta(rs.getString(7));
                _usuario.setContrasena(rs.getString(8));
                _usuario.setFotoUsuario(rs.getString(9));
                _usuario.setCuentaActiva(rs.getBoolean(10));
                _usuario.setIdEstado(rs.getInt(11));
                
                _perfilUsuario.setNombreCompleto(rs.getString(12));
                _perfilUsuario.setDescripcion(rs.getString(13));
                _perfilUsuario.setIngresoPlataforma(rs.getBoolean(14));
                _perfilUsuario.setAgregarDocumento(rs.getBoolean(15));
                _perfilUsuario.setEliminarDocumento(rs.getBoolean(16));
                _perfilUsuario.setModificarDocumento(rs.getBoolean(17));
                _perfilUsuario.setBuscarDocumento(rs.getBoolean(18));
                _perfilUsuario.setImprimirDocumento(rs.getBoolean(19));
                _perfilUsuario.setIdEstado(rs.getInt(20));
                
                _usuario.setPerfilUsuario(_perfilUsuario);

            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            
            if (rs != null){
                rs.close();
            }
            if (st != null){
                st.close();
            }
            
        }
        
        return (Object) _usuario;
    }
    
}
