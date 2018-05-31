/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.comentarios;
import entity.documentacion;
import entity.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elara
 */
public class comentariosDAOImpl implements catalogosInterface {
    
    private Connection _conn;

    public comentariosDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        comentarios _comentsObj = (comentarios) o;

        String _consulta = "INSERT INTO controlGPC.dbcomentarios " +
                "(idDocumento, " +
                "comentario, " +
                "idUsuario, " +
                "fechaHora, " +
                "idEstado) " +
                "VALUES " +
                "(?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setInt(1, _comentsObj.getDocumentacion().getId());
        st.setString(2, _comentsObj.getComentario());
        st.setInt(3, _comentsObj.getUsuario().getId());
        st.setString(4, _comentsObj.getFechaHora());
        st.setInt(5, _comentsObj.getIdEstado());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        comentarios _comentsObj = (comentarios) o;

        String _consulta = "UPDATE controlGPC.dbcomentarios " +
                "SET " +
                "idDocumento = ?, " +
                "comentario = ?, " +
                "idUsuario = ?, " +
                "fechaHora = ?, " +
                "idEstado = ? " +
                "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setInt(1, _comentsObj.getDocumentacion().getId());
        st.setString(2, _comentsObj.getComentario());
        st.setInt(3, _comentsObj.getUsuario().getId());
        st.setString(4, _comentsObj.getFechaHora());
        st.setInt(5, _comentsObj.getIdEstado());
        
        st.setInt(6, _comentsObj.getId());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE controlGPC.dbcomentarios SET idEstado = 3 WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);
        
        st.setInt(1, id);
        
        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public Object consultarTodos() throws Exception {

        comentarios _commentsObj;

        List<comentarios> _listaComentarios = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbcomentarios.id AS 'id', " +
                "    dbcomentarios.idDocumento AS 'idDocumento', " +
                "    dbcomentarios.comentario AS 'comentario', " +
                "    dbcomentarios.idUsuario AS 'idUsuario', " +
                "    dbusuario.nombreCompleto AS 'nombreUsuario', " +
                "    dbcomentarios.fechaHora AS 'fechaHora', " +
                "    dbcomentarios.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcomentarios " +
                "        LEFT JOIN " +
                "    dbusuario ON dbusuario.id = dbcomentarios.idUsuario " +
                "WHERE " +
                "    dbcomentarios.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _commentsObj = new comentarios();

                _commentsObj.setId(rs.getInt(1));
                
                documentacion _documentacion = new documentacion();
                
                _documentacion.setId(rs.getInt(2));
                _commentsObj.setDocumentacion(_documentacion);
                
                _commentsObj.setComentario(rs.getString(3));
                
                usuario _usuario = new usuario();
                
                _usuario.setId(rs.getInt(4));
                _usuario.setNombreCompleto(rs.getString(5));
                
                _commentsObj.setUsuario(_usuario);
                
                _commentsObj.setFechaHora(rs.getString(6));
                _commentsObj.setIdEstado(rs.getInt(7));

                _listaComentarios.add(_commentsObj);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }

        }

        return _listaComentarios;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        comentarios _commentsObj;

        List<comentarios> _listaComentarios = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbcomentarios.id AS 'id', " +
                "    dbcomentarios.idDocumento AS 'idDocumento', " +
                "    dbcomentarios.comentario AS 'comentario', " +
                "    dbcomentarios.idUsuario AS 'idUsuario', " +
                "    dbusuario.nombreCompleto AS 'nombreUsuario', " +
                "    dbcomentarios.fechaHora AS 'fechaHora', " +
                "    dbcomentarios.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcomentarios " +
                "        LEFT JOIN " +
                "    dbusuario ON dbusuario.id = dbcomentarios.idUsuario " +
                "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbcomentarios.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _commentsObj = new comentarios();

                _commentsObj.setId(rs.getInt(1));
                
                documentacion _documentacion = new documentacion();
                
                _documentacion.setId(rs.getInt(2));
                _commentsObj.setDocumentacion(_documentacion);
                
                _commentsObj.setComentario(rs.getString(3));
                
                usuario _usuario = new usuario();
                
                _usuario.setId(rs.getInt(4));
                _usuario.setNombreCompleto(rs.getString(5));
                
                _commentsObj.setUsuario(_usuario);
                
                _commentsObj.setFechaHora(rs.getString(6));
                _commentsObj.setIdEstado(rs.getInt(7));

                _listaComentarios.add(_commentsObj);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }

        }

        return _listaComentarios;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        comentarios _commentsObj = new comentarios();

        String _consulta = "SELECT  " +
                "    dbcomentarios.id AS 'id', " +
                "    dbcomentarios.idDocumento AS 'idDocumento', " +
                "    dbcomentarios.comentario AS 'comentario', " +
                "    dbcomentarios.idUsuario AS 'idUsuario', " +
                "    dbusuario.nombreCompleto AS 'nombreUsuario', " +
                "    dbcomentarios.fechaHora AS 'fechaHora', " +
                "    dbcomentarios.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcomentarios " +
                "        LEFT JOIN " +
                "    dbusuario ON dbusuario.id = dbcomentarios.idUsuario " +
                "WHERE dbcomentarios.id = " + id + " AND dbcomentarios.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _commentsObj.setId(rs.getInt(1));
                
                documentacion _documentacion = new documentacion();
                
                _documentacion.setId(rs.getInt(2));
                _commentsObj.setDocumentacion(_documentacion);
                
                _commentsObj.setComentario(rs.getString(3));
                
                usuario _usuario = new usuario();
                
                _usuario.setId(rs.getInt(4));
                _usuario.setNombreCompleto(rs.getString(5));
                
                _commentsObj.setUsuario(_usuario);
                
                _commentsObj.setFechaHora(rs.getString(6));
                _commentsObj.setIdEstado(rs.getInt(7));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }

        }

        return _commentsObj;
    }
    
}
