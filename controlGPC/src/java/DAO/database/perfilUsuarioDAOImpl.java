/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.perfilUsuario;
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
public class perfilUsuarioDAOImpl implements catalogosInterface{

    private Connection conexion;

    public perfilUsuarioDAOImpl(Connection _conexion) {
        this.conexion = _conexion;
    }
    
    @Override
    public boolean agregarRegistro(Object o) throws Exception {
        
        perfilUsuario _perfilUsuario = (perfilUsuario) o;
        
        StringBuilder _consulta = new StringBuilder();
                
        _consulta.append("INSERT INTO controlGPC.dbperfilUsuario ")
                    .append("(nombreCompleto, ")
                    .append("descripcion, ")
                    .append("accesoPlataforma, ")
                    .append("gestionCatalogos, ")
                    .append("gestionUsuario, ")
                    .append("gestionDocumentos, ")
                    .append("agregarDocumento, ")
                    .append("eliminarDocumento, ")
                    .append("modificarDocumento, ")
                    .append("buscarDocumento, ")
                    .append("imprimirDocumento, ")
                    .append("idEstado) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
                
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, _perfilUsuario.getNombreCompleto());
        st.setString(2, _perfilUsuario.getDescripcion());
        st.setBoolean(3, _perfilUsuario.isAccesoPlataforma());
        st.setBoolean(4, _perfilUsuario.isGestionCatalogos());
        st.setBoolean(5, _perfilUsuario.isGestionUsuario());
        st.setBoolean(6, _perfilUsuario.isGestionDocumentos());
        st.setBoolean(7, _perfilUsuario.isAgregarDocumento());
        st.setBoolean(8, _perfilUsuario.isEliminarDocumento());
        st.setBoolean(9, _perfilUsuario.isModificarDocumento());
        st.setBoolean(10, _perfilUsuario.isBuscarDocumento());
        st.setBoolean(11, _perfilUsuario.isImprimirDocumento());
        st.setInt(12, _perfilUsuario.getIdEstado());
        
        boolean resultado = st.execute();
        
        if (st != null){
            st.close();
        }
        
        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int _indice) throws Exception {
        
        String _consulta = "DELETE FROM controlGPC.dbperfilUsuario WHERE id = ?;";
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta);
        
        st.setInt(1, _indice);
        
        boolean resultado = st.execute();
        
        if (st != null){
            st.close();
        }
        
        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {
        
        perfilUsuario _perfilUsuario = (perfilUsuario) o;
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("UPDATE controlGPC.dbperfilUsuario ")
                    .append("SET ")
                        .append("nombreCompleto = ?, ")
                        .append("descripcion = ?, ")
                        .append("accesoPlataforma = ?, ")
                        .append("gestionCatalogos = ?, ")
                        .append("gestionUsuario = ?, ")
                        .append("gestionDocumentos = ?, ")
                        .append("agregarDocumento = ?, ")
                        .append("eliminarDocumento = ?, ")
                        .append("modificarDocumento = ?, ")
                        .append("buscarDocumento = ?, ")
                        .append("imprimirDocumento = ?, ")
                        .append("idEstado = ? ")
                    .append("WHERE id = ?;");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, _perfilUsuario.getNombreCompleto());
        st.setString(2, _perfilUsuario.getDescripcion());
        st.setBoolean(3, _perfilUsuario.isAccesoPlataforma());
        st.setBoolean(4, _perfilUsuario.isGestionCatalogos());
        st.setBoolean(5, _perfilUsuario.isGestionUsuario());
        st.setBoolean(6, _perfilUsuario.isGestionDocumentos());
        st.setBoolean(7, _perfilUsuario.isAgregarDocumento());
        st.setBoolean(8, _perfilUsuario.isEliminarDocumento());
        st.setBoolean(9, _perfilUsuario.isModificarDocumento());
        st.setBoolean(10, _perfilUsuario.isBuscarDocumento());
        st.setBoolean(11, _perfilUsuario.isImprimirDocumento());
        st.setInt(12, _perfilUsuario.getIdEstado());
        st.setInt(13, _perfilUsuario.getId());
        
        boolean resultado = st.execute();
        
        if (st != null){
            st.close();
        }
        
        return resultado;
    }

    @Override
    public Object consultarPorId(int _indice) throws Exception {
        
        Object o = new Object();
        perfilUsuario _perfilUsuario;
                
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT dbperfilUsuario.id, ")
                        .append("dbperfilUsuario.nombreCompleto, ")
                        .append("dbperfilUsuario.descripcion, ")
                        .append("dbperfilUsuario.accesoPlataforma, ")
                        .append("dbperfilUsuario.gestionCatalogos, ")
                        .append("dbperfilUsuario.gestionUsuario, ")
                        .append("dbperfilUsuario.gestionDocumentos, ")
                        .append("dbperfilUsuario.agregarDocumento, ")
                        .append("dbperfilUsuario.eliminarDocumento, ")
                        .append("dbperfilUsuario.modificarDocumento, ")
                        .append("dbperfilUsuario.buscarDocumento, ")
                        .append("dbperfilUsuario.imprimirDocumento, ")
                        .append("dbperfilUsuario.idEstado ")
                    .append("FROM controlGPC.dbperfilUsuario ")
                    .append("WHERE dbperfilUsuario.id = ?;");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setInt(1, _indice);
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            if(rs.next()){
                
                _perfilUsuario = new perfilUsuario();
            
                _perfilUsuario.setId(rs.getInt(1));
                _perfilUsuario.setNombreCompleto(rs.getString(2));
                _perfilUsuario.setDescripcion(rs.getString(3));
                _perfilUsuario.setAccesoPlataforma(rs.getBoolean(4));
                _perfilUsuario.setGestionCatalogos(rs.getBoolean(5));
                _perfilUsuario.setGestionUsuario(rs.getBoolean(6));
                _perfilUsuario.setGestionDocumentos(rs.getBoolean(7));
                _perfilUsuario.setAgregarDocumento(rs.getBoolean(8));
                _perfilUsuario.setEliminarDocumento(rs.getBoolean(9));
                _perfilUsuario.setModificarDocumento(rs.getBoolean(10));
                _perfilUsuario.setBuscarDocumento(rs.getBoolean(11));
                _perfilUsuario.setImprimirDocumento(rs.getBoolean(12));
                _perfilUsuario.setIdEstado(rs.getInt(13));
                
                o = (Object)_perfilUsuario;
                
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

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {
        
        perfilUsuario _perfilUsuario;
        List<perfilUsuario> _listaPerfilUsuarios = new ArrayList<perfilUsuario>();
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT dbperfilUsuario.id, ")
                        .append("dbperfilUsuario.nombreCompleto, ")
                        .append("dbperfilUsuario.descripcion, ")
                        .append("dbperfilUsuario.accesoPlataforma, ")
                        .append("dbperfilUsuario.gestionCatalogos, ")
                        .append("dbperfilUsuario.gestionUsuario, ")
                        .append("dbperfilUsuario.gestionDocumentos, ")
                        .append("dbperfilUsuario.agregarDocumento, ")
                        .append("dbperfilUsuario.eliminarDocumento, ")
                        .append("dbperfilUsuario.modificarDocumento, ")
                        .append("dbperfilUsuario.buscarDocumento, ")
                        .append("dbperfilUsuario.imprimirDocumento, ")
                        .append("dbperfilUsuario.idEstado ")
                    .append("FROM controlGPC.dbperfilUsuario ")
                    .append("WHERE " + _campo + " LIKE ?;");
                
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        st.setString(1, "%"+_dato+"%");
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            while(rs.next()){
                
                _perfilUsuario = new perfilUsuario();
            
                _perfilUsuario.setId(rs.getInt(1));
                _perfilUsuario.setNombreCompleto(rs.getString(2));
                _perfilUsuario.setDescripcion(rs.getString(3));
                _perfilUsuario.setAccesoPlataforma(rs.getBoolean(4));
                _perfilUsuario.setGestionCatalogos(rs.getBoolean(5));
                _perfilUsuario.setGestionUsuario(rs.getBoolean(6));
                _perfilUsuario.setGestionDocumentos(rs.getBoolean(7));
                _perfilUsuario.setAgregarDocumento(rs.getBoolean(8));
                _perfilUsuario.setEliminarDocumento(rs.getBoolean(9));
                _perfilUsuario.setModificarDocumento(rs.getBoolean(10));
                _perfilUsuario.setBuscarDocumento(rs.getBoolean(11));
                _perfilUsuario.setImprimirDocumento(rs.getBoolean(12));
                _perfilUsuario.setIdEstado(rs.getInt(13));
            
                _listaPerfilUsuarios.add(_perfilUsuario);
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
        
        return (Object)_listaPerfilUsuarios;
    }

    @Override
    public Object consultarTodos() throws Exception {
        
        perfilUsuario _perfilUsuario;
        List<perfilUsuario> _listaPerfilUsuarios = new ArrayList<perfilUsuario>();
        
        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT dbperfilUsuario.id, ")
                        .append("dbperfilUsuario.nombreCompleto, ")
                        .append("dbperfilUsuario.descripcion, ")
                        .append("dbperfilUsuario.accesoPlataforma, ")
                        .append("dbperfilUsuario.gestionCatalogos, ")
                        .append("dbperfilUsuario.gestionUsuario, ")
                        .append("dbperfilUsuario.gestionDocumentos, ")
                        .append("dbperfilUsuario.agregarDocumento, ")
                        .append("dbperfilUsuario.eliminarDocumento, ")
                        .append("dbperfilUsuario.modificarDocumento, ")
                        .append("dbperfilUsuario.buscarDocumento, ")
                        .append("dbperfilUsuario.imprimirDocumento, ")
                        .append("dbperfilUsuario.idEstado ")
                    .append("FROM controlGPC.dbperfilUsuario;");
        
        PreparedStatement st = this.conexion.prepareStatement(_consulta.toString());
        
        ResultSet rs = st.executeQuery();
        
        try{
            
            while(rs.next()){
                
                _perfilUsuario = new perfilUsuario();
            
                _perfilUsuario.setId(rs.getInt(1));
                _perfilUsuario.setNombreCompleto(rs.getString(2));
                _perfilUsuario.setDescripcion(rs.getString(3));
                _perfilUsuario.setAccesoPlataforma(rs.getBoolean(4));
                _perfilUsuario.setGestionCatalogos(rs.getBoolean(5));
                _perfilUsuario.setGestionUsuario(rs.getBoolean(6));
                _perfilUsuario.setGestionDocumentos(rs.getBoolean(7));
                _perfilUsuario.setAgregarDocumento(rs.getBoolean(8));
                _perfilUsuario.setEliminarDocumento(rs.getBoolean(9));
                _perfilUsuario.setModificarDocumento(rs.getBoolean(10));
                _perfilUsuario.setBuscarDocumento(rs.getBoolean(11));
                _perfilUsuario.setImprimirDocumento(rs.getBoolean(12));
                _perfilUsuario.setIdEstado(rs.getInt(13));
            
                _listaPerfilUsuarios.add(_perfilUsuario);
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
        
        return (Object)_listaPerfilUsuarios;
    }
    
}
