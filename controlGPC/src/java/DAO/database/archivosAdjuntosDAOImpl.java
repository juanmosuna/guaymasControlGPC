/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.archivosAdjuntos;
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
public class archivosAdjuntosDAOImpl implements catalogosInterface {

    private Connection _conn;

    public archivosAdjuntosDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        archivosAdjuntos _archivosObj = (archivosAdjuntos) o;
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbarchivosAdjuntos ")
                .append("(idDocumento, ")
                .append("nombreArchivo, ")
                .append("tipoArchivo, ")
                .append("archivo, ")
                .append("idUsuario, ")
                .append("fechaHora, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setInt(1, _archivosObj.getDocumentacion().getId());
        st.setString(2, _archivosObj.getNombreArchivo());
        st.setString(3, _archivosObj.getTipoArchivo());
        st.setString(4, javax.xml.bind.DatatypeConverter.printBase64Binary(_archivosObj.getArchivo()));
        st.setInt(5, _archivosObj.getUsuario().getId());
        st.setString(6, _archivosObj.getFechaHora());
        st.setInt(7, _archivosObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        archivosAdjuntos _archivosObj = (archivosAdjuntos) o;
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbarchivosAdjuntos ")
                .append("SET ")
                .append("idDocumento = ?, ")
                .append("nombreArchivo = ?, ")
                .append("tipoArchivo = ?, ")
                .append("archivo = ?, ")
                .append("idUsuario = ?, ")
                .append("fechaHora = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setInt(1, _archivosObj.getDocumentacion().getId());
        st.setString(2, _archivosObj.getNombreArchivo());
        st.setString(3, _archivosObj.getTipoArchivo());
        st.setString(4, javax.xml.bind.DatatypeConverter.printBase64Binary(_archivosObj.getArchivo()));
        st.setInt(5, _archivosObj.getUsuario().getId());
        st.setString(6, _archivosObj.getFechaHora());
        st.setInt(7, _archivosObj.getIdEstado());

        st.setInt(8, _archivosObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbarchivosAdjuntos SET idEstado = 3 WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setInt(1, id);

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public Object consultarTodos() throws Exception {

        archivosAdjuntos _archivosObj;

        List<archivosAdjuntos> _listaArchivos = new ArrayList();

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT  ")
                .append( "    dbarchivosAdjuntos.id AS 'id', ")
                .append( "    dbarchivosAdjuntos.idDocumento AS 'idDocumento', ")
                .append( "    dbarchivosAdjuntos.nombreArchivo AS 'nombreArchivo', ")
                .append( "    dbarchivosAdjuntos.tipoArchivo AS 'tipoArchivo', ")
                .append( "    dbarchivosAdjuntos.archivo AS 'archivo', ")
                .append( "    dbarchivosAdjuntos.idUsuario AS 'idUsuario', ")
                .append( "    dbusuario.nombreCompleto AS 'nombreUsuario', ")
                .append( "    dbarchivosAdjuntos.fechaHora AS 'fechaHora', ")
                .append( "    dbarchivosAdjuntos.idEstado AS 'idEstado' ")
                .append( "FROM ")
                .append( "    controlGPC.dbarchivosAdjuntos ")
                .append( "        LEFT JOIN ")
                .append( "    dbusuario ON dbusuario.id = dbarchivosAdjuntos.idUsuario ")
                .append( "WHERE ")
                .append( "    dbarchivosAdjuntos.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _archivosObj = new archivosAdjuntos();

                _archivosObj.setId(rs.getInt(1));

                documentacion _documentacion = new documentacion();

                _documentacion.setId(rs.getInt(2));
                _archivosObj.setDocumentacion(_documentacion);

                _archivosObj.setNombreArchivo(rs.getString(3));
                _archivosObj.setTipoArchivo(rs.getString(4));
                _archivosObj.setArchivo(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(5)));

                usuario _usuario = new usuario();

                _usuario.setId(rs.getInt(6));
                _usuario.setNombreCompleto(rs.getString(7));

                _archivosObj.setUsuario(_usuario);

                _archivosObj.setFechaHora(rs.getString(8));
                _archivosObj.setIdEstado(rs.getInt(9));

                _listaArchivos.add(_archivosObj);
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

        return _listaArchivos;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        archivosAdjuntos _archivosObj;

        List<archivosAdjuntos> _listaArchivos = new ArrayList();
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbarchivosAdjuntos.id AS 'id', ")
                .append("    dbarchivosAdjuntos.idDocumento AS 'idDocumento', ")
                .append("    dbarchivosAdjuntos.nombreArchivo AS 'nombreArchivo', ")
                .append("    dbarchivosAdjuntos.tipoArchivo AS 'tipoArchivo', ")
                .append("    dbarchivosAdjuntos.archivo AS 'archivo', ")
                .append("    dbarchivosAdjuntos.idUsuario AS 'idUsuario', ")
                .append("    dbusuario.nombreCompleto AS 'nombreUsuario', ")
                .append("    dbarchivosAdjuntos.fechaHora AS 'fechaHora', ")
                .append("    dbarchivosAdjuntos.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbarchivosAdjuntos ")
                .append("        LEFT JOIN ")
                .append("    dbusuario ON dbusuario.id = dbarchivosAdjuntos.idUsuario ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbarchivosAdjuntos.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _archivosObj = new archivosAdjuntos();

                _archivosObj.setId(rs.getInt(1));

                documentacion _documentacion = new documentacion();

                _documentacion.setId(rs.getInt(2));
                _archivosObj.setDocumentacion(_documentacion);

                _archivosObj.setNombreArchivo(rs.getString(3));
                _archivosObj.setTipoArchivo(rs.getString(4));
                _archivosObj.setArchivo(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(5)));

                usuario _usuario = new usuario();

                _usuario.setId(rs.getInt(6));
                _usuario.setNombreCompleto(rs.getString(7));

                _archivosObj.setUsuario(_usuario);

                _archivosObj.setFechaHora(rs.getString(8));
                _archivosObj.setIdEstado(rs.getInt(9));

                _listaArchivos.add(_archivosObj);
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

        return _listaArchivos;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        archivosAdjuntos _archivosObj = new archivosAdjuntos();

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT  ")
                .append("    dbarchivosAdjuntos.id AS 'id', ")
                .append("    dbarchivosAdjuntos.idDocumento AS 'idDocumento', ")
                .append("    dbarchivosAdjuntos.nombreArchivo AS 'nombreArchivo', ")
                .append("    dbarchivosAdjuntos.tipoArchivo AS 'tipoArchivo', ")
                .append("    dbarchivosAdjuntos.archivo AS 'archivo', ")
                .append("    dbarchivosAdjuntos.idUsuario AS 'idUsuario', ")
                .append("    dbusuario.nombreCompleto AS 'nombreUsuario', ")
                .append("    dbarchivosAdjuntos.fechaHora AS 'fechaHora', ")
                .append("    dbarchivosAdjuntos.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbarchivosAdjuntos ")
                .append("        LEFT JOIN ")
                .append("    dbusuario ON dbusuario.id = dbarchivosAdjuntos.idUsuario ")
                .append("WHERE dbarchivosAdjuntos.id = ")
                .append(id)
                .append(" AND dbarchivosAdjuntos.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _archivosObj.setId(rs.getInt(1));

                documentacion _documentacion = new documentacion();

                _documentacion.setId(rs.getInt(2));
                _archivosObj.setDocumentacion(_documentacion);

                _archivosObj.setNombreArchivo(rs.getString(3));
                _archivosObj.setTipoArchivo(rs.getString(4));
                _archivosObj.setArchivo(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(5)));

                usuario _usuario = new usuario();

                _usuario.setId(rs.getInt(6));
                _usuario.setNombreCompleto(rs.getString(7));

                _archivosObj.setUsuario(_usuario);

                _archivosObj.setFechaHora(rs.getString(8));
                _archivosObj.setIdEstado(rs.getInt(9));

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

        return _archivosObj;
    }

}
