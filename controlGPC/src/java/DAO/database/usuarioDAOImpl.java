/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import entity.departamento;
import entity.empresa;
import entity.estado;
import entity.localidad;
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
                    .append("sexo, ")
                    .append("idPerfilUsuario, ")
                    .append("idLocalidad, ")
                    .append("idDepartamento, ")
                    .append("idEmpresa, ")
                    .append("cuenta, ")
                    .append("contrasena, ")
                    .append("fotoUsuario, ")
                    .append("cuentaActiva, ")
                    .append("idEstado) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?, aes_encrypt(?, 'gpc'), ?, ?, 1);");
                
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, _usuario.getNombreCompleto());
        st.setString(2, _usuario.getSexo());
        st.setInt(3, _usuario.getPerfilUsuario().getId());
        st.setInt(4, _usuario.getLocalidad().getId());
        st.setInt(5, _usuario.getDepartamento().getId());
        st.setInt(6, _usuario.getIdEstado());
        st.setString(7, _usuario.getCuenta());
        st.setString(8, _usuario.getContrasena());
        st.setString(9, javax.xml.bind.DatatypeConverter.printBase64Binary(_usuario.getFotoUsuario()));
        st.setBoolean(10, _usuario.isCuentaActiva());
        
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
                    .append("sexo = ?, ")
                    .append("idPerfilUsuario = ?, ")
                    .append("idLocalidad = ?, ")
                    .append("idDepartamento = ?, ")
                    .append("idEmpresa = ?, ")
                    .append("cuenta = ?, ")
                    .append("contrasena = aes_encrypt(?, 'gpc'), ")
                    .append("fotoUsuario = ?, ")
                    .append("cuentaActiva = ?, ")
                    .append("idEstado = 2 ")
                .append("WHERE id = ?;");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, _usuario.getNombreCompleto());
        st.setString(2, _usuario.getSexo());
        st.setInt(3, _usuario.getPerfilUsuario().getId());
        st.setInt(4, _usuario.getLocalidad().getId());
        st.setInt(5, _usuario.getDepartamento().getId());
        st.setInt(6, _usuario.getEmpresa().getId());
        st.setString(7, _usuario.getCuenta());
        st.setString(8, _usuario.getContrasena());
        st.setString(9, javax.xml.bind.DatatypeConverter.printBase64Binary(_usuario.getFotoUsuario()));
        st.setBoolean(10, _usuario.isCuentaActiva());
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
        
        _consulta.append("SELECT ")
                    .append("u.id AS 'id', ")
                    .append("u.nombreCompleto AS 'nombreCompleto', ")
                    .append("u.sexo AS 'sexo', ")
                    .append("u.idPerfilUsuario AS 'idPerfilUsuario', ")
                    .append("pu.nombreCompleto AS 'perfilUsuario', ")
                    .append("u.idLocalidad AS 'idLocalidad', ")
                    .append("l.nombreCompleto AS 'localidad', ")
                    .append("u.idDepartamento AS 'idDepartamento', ")
                    .append("d.nombreCompleto AS 'departamento', ")
                    .append("u.idEmpresa AS 'idEmpresa', ")
                    .append("em.nombreCompleto AS 'empresa', ")
                    .append("u.cuenta AS 'cuenta', ")
                    .append("aes_decrypt(u.contrasena, 'gpc'), ")
                    .append("u.fotoUsuario AS 'fotoUsuario', ")
                    .append("u.cuentaActiva AS 'cuentaActiva', ")
                    .append("u.idEstado AS 'idEstado', ")
                    .append("es.nombreCompleto AS 'estado' ")
                .append("FROM controlGPC.dbusuario u ")
                        .append("INNER JOIN controlGPC.dbperfilUsuario pu ON pu.id = u.idPerfilUsuario ")
                        .append("INNER JOIN controlGPC.dblocalidad l ON l.id = u.idLocalidad ")
                        .append("INNER JOIN controlGPC.dbdepartamento d ON d.id = u.idDepartamento ")
                        .append("INNER JOIN controlGPC.dbempresa em ON em.id = u.idEmpresa ")
                        .append("INNER JOIN controlGPC.dbestado es ON es.id = u.idEstado ")
                .append("WHERE u.id = ?;");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setInt(1, _indice);
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            if(rs.next()){
                
                _usuario = new usuario();
            
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                _usuario.setSexo(rs.getString(3));
                
                perfilUsuario _perfilUsuario = new perfilUsuario();
                _perfilUsuario.setId(rs.getInt(4));
                _perfilUsuario.setNombreCompleto(rs.getString(5));
                _usuario.setPerfilUsuario(_perfilUsuario);
                
                localidad _localidad = new localidad();
                _localidad.setId(rs.getInt(6));
                _localidad.setNombreCompleto(rs.getString(7));
                _usuario.setLocalidad(_localidad);
                
                departamento _departamento = new departamento();
                _departamento.setId(rs.getInt(8));
                _departamento.setNombreCompleto(rs.getString(9));
                _usuario.setDepartamento(_departamento);
                
                empresa _empresa = new empresa();
                _empresa.setId(rs.getInt(10));
                _empresa.setNombreCompleto(rs.getString(11));
                _usuario.setEmpresa(_empresa);
                
                _usuario.setCuenta(rs.getString(12));
                _usuario.setContrasena(rs.getString(13));
                _usuario.setFotoUsuario(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));
                _usuario.setCuentaActiva(rs.getBoolean(15));
                _usuario.setIdEstado(rs.getInt(16));
                _usuario.setEstado(rs.getString(17));
                
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
        
        _consulta.append("SELECT ")
                    .append("u.id AS 'id', ")
                    .append("u.nombreCompleto AS 'nombreCompleto', ")
                    .append("u.sexo AS 'sexo', ")
                    .append("u.idPerfilUsuario AS 'idPerfilUsuario', ")
                    .append("pu.nombreCompleto AS 'perfilUsuario', ")
                    .append("u.idLocalidad AS 'idLocalidad', ")
                    .append("l.nombreCompleto AS 'localidad', ")
                    .append("u.idDepartamento AS 'idDepartamento', ")
                    .append("d.nombreCompleto AS 'departamento', ")
                    .append("u.idEmpresa AS 'idEmpresa', ")
                    .append("em.nombreCompleto AS 'empresa', ")
                    .append("u.cuenta AS 'cuenta', ")
                    .append("aes_decrypt(u.contrasena, 'gpc'), ")
                    .append("u.fotoUsuario AS 'fotoUsuario', ")
                    .append("u.cuentaActiva AS 'cuentaActiva', ")
                    .append("u.idEstado AS 'idEstado', ")
                    .append("es.nombreCompleto AS 'estado' ")
                .append("FROM ")
                    .append("controlGPC.dbusuario u ")
                        .append("INNER JOIN controlGPC.dbperfilUsuario pu ON pu.id = u.idPerfilUsuario ")
                        .append("INNER JOIN controlGPC.dblocalidad l ON l.id = u.idLocalidad ")
                        .append("INNER JOIN controlGPC.dbdepartamento d ON d.id = u.idDepartamento ")
                        .append("INNER JOIN controlGPC.dbempresa em ON em.id = u.idEmpresa ")
                        .append("INNER JOIN controlGPC.dbestado es ON es.id = u.idEstado ")
                .append("WHERE " + _campo + " LIKE ?;");
                
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, "%"+_dato+"%");
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            while(rs.next()){
                
                _usuario = new usuario();
            
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                _usuario.setSexo(rs.getString(3));
                
                perfilUsuario _perfilUsuario = new perfilUsuario();
                _perfilUsuario.setId(rs.getInt(4));
                _perfilUsuario.setNombreCompleto(rs.getString(5));
                _usuario.setPerfilUsuario(_perfilUsuario);
                
                localidad _localidad = new localidad();
                _localidad.setId(rs.getInt(6));
                _localidad.setNombreCompleto(rs.getString(7));
                _usuario.setLocalidad(_localidad);
                
                departamento _departamento = new departamento();
                _departamento.setId(rs.getInt(8));
                _departamento.setNombreCompleto(rs.getString(9));
                _usuario.setDepartamento(_departamento);
                
                empresa _empresa = new empresa();
                _empresa.setId(rs.getInt(10));
                _empresa.setNombreCompleto(rs.getString(11));
                _usuario.setEmpresa(_empresa);
                
                _usuario.setCuenta(rs.getString(12));
                _usuario.setContrasena(rs.getString(13));
                _usuario.setFotoUsuario(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));
                _usuario.setCuentaActiva(rs.getBoolean(15));
                _usuario.setIdEstado(rs.getInt(16));
                _usuario.setEstado(rs.getString(17));
            
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
        
        _consulta.append("SELECT ")
                    .append("u.id AS 'id', ")
                    .append("u.nombreCompleto AS 'nombreCompleto', ")
                    .append("u.sexo AS 'sexo', ")
                    .append("u.idPerfilUsuario AS 'idPerfilUsuario', ")
                    .append("pu.nombreCompleto AS 'perfilUsuario', ")
                    .append("u.idLocalidad AS 'idLocalidad', ")
                    .append("l.nombreCompleto AS 'localidad', ")
                    .append("u.idDepartamento AS 'idDepartamento', ")
                    .append("d.nombreCompleto AS 'departamento', ")
                    .append("u.idEmpresa AS 'idEmpresa', ")
                    .append("em.nombreCompleto AS 'empresa', ")
                    .append("u.cuenta AS 'cuenta', ")
                    .append("aes_decrypt(u.contrasena, 'gpc'), ")
                    .append("u.fotoUsuario AS 'fotoUsuario', ")
                    .append("u.cuentaActiva AS 'cuentaActiva', ")
                    .append("u.idEstado AS 'idEstado', ")
                    .append("es.nombreCompleto AS 'estado' ")
                .append("FROM ")
                    .append("controlGPC.dbusuario u ")
                        .append("INNER JOIN controlGPC.dbperfilUsuario pu ON pu.id = u.idPerfilUsuario ")
                        .append("INNER JOIN controlGPC.dblocalidad l ON l.id = u.idLocalidad ")
                        .append("INNER JOIN controlGPC.dbdepartamento d ON d.id = u.idDepartamento ")
                        .append("INNER JOIN controlGPC.dbempresa em ON em.id = u.idEmpresa ")
                        .append("INNER JOIN controlGPC.dbestado es ON es.id = u.idEstado; ");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            while(rs.next()){
                
                _usuario = new usuario();
            
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                _usuario.setSexo(rs.getString(3));
                
                perfilUsuario _perfilUsuario = new perfilUsuario();
                _perfilUsuario.setId(rs.getInt(4));
                _perfilUsuario.setNombreCompleto(rs.getString(5));
                _usuario.setPerfilUsuario(_perfilUsuario);
                
                localidad _localidad = new localidad();
                _localidad.setId(rs.getInt(6));
                _localidad.setNombreCompleto(rs.getString(7));
                _usuario.setLocalidad(_localidad);
                
                departamento _departamento = new departamento();
                _departamento.setId(rs.getInt(8));
                _departamento.setNombreCompleto(rs.getString(9));
                _usuario.setDepartamento(_departamento);
                
                empresa _empresa = new empresa();
                _empresa.setId(rs.getInt(10));
                _empresa.setNombreCompleto(rs.getString(11));
                _usuario.setEmpresa(_empresa);
                
                _usuario.setCuenta(rs.getString(12));
                _usuario.setContrasena(rs.getString(13));
                _usuario.setFotoUsuario(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));
                _usuario.setCuentaActiva(rs.getBoolean(15));
                _usuario.setIdEstado(rs.getInt(16));
                _usuario.setEstado(rs.getString(17));
            
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
                    .append("u.sexo, ")
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
                    .append("pu.accesoPlataforma, ")
                    .append("pu.gestionCatalogos, ")
                    .append("pu.gestionUsuario, ")
                    .append("pu.gestionDocumentos, ")
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
                
                _usuario.setId(rs.getInt(1));
                _usuario.setNombreCompleto(rs.getString(2));
                _usuario.setSexo(rs.getString(3));
                
                perfilUsuario _perfilUsuario = new perfilUsuario();
                _perfilUsuario.setId(rs.getInt(4));
                
                localidad _localidad = new localidad();
                _localidad.setId(rs.getInt(5));
                _usuario.setLocalidad(_localidad);
                
                departamento _departamento = new departamento();
                _departamento.setId(rs.getInt(6));
                _usuario.setDepartamento(_departamento);
                
                empresa _empresa = new empresa();
                _empresa.setId(rs.getInt(7));
                _usuario.setEmpresa(_empresa);
                
                _usuario.setCuenta(rs.getString(8));
                _usuario.setContrasena(rs.getString(9));
                _usuario.setFotoUsuario(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(10)));
                _usuario.setCuentaActiva(rs.getBoolean(11));
                _usuario.setId(rs.getInt(12));
                
                _perfilUsuario.setNombreCompleto(rs.getString(13));
                _perfilUsuario.setDescripcion(rs.getString(14));
                _perfilUsuario.setAccesoPlataforma(rs.getBoolean(15));
                _perfilUsuario.setGestionCatalogos(rs.getBoolean(16));
                _perfilUsuario.setGestionUsuario(rs.getBoolean(17));
                _perfilUsuario.setGestionDocumentos(rs.getBoolean(18));
                _perfilUsuario.setAgregarDocumento(rs.getBoolean(19));
                _perfilUsuario.setEliminarDocumento(rs.getBoolean(20));
                _perfilUsuario.setModificarDocumento(rs.getBoolean(21));
                _perfilUsuario.setBuscarDocumento(rs.getBoolean(22));
                _perfilUsuario.setImprimirDocumento(rs.getBoolean(23));
                _perfilUsuario.setIdEstado(rs.getInt(24));
                
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
