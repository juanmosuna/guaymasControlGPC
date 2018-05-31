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

        String _consulta = "INSERT INTO controlGPC.dbarchivosAdjuntos "
                + "(idDocumento, "
                + "nombreArchivo, "
                + "tipoArchivo, "
                + "archivo, "
                + "idUsuario, "
                + "fechaHora, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE controlGPC.dbarchivosAdjuntos "
                + "SET "
                + "idDocumento = ?, "
                + "nombreArchivo = ?, "
                + "tipoArchivo = ?, "
                + "archivo = ?, "
                + "idUsuario = ?, "
                + "fechaHora = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE controlGPC.dbarchivosAdjuntos SET idEstado = 3 WHERE id = ?;";

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

        archivosAdjuntos _archivosObj;

        List<archivosAdjuntos> _listaArchivos = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbarchivosAdjuntos.id AS 'id', "
                + "    dbarchivosAdjuntos.idDocumento AS 'idDocumento', "
                + "    dbarchivosAdjuntos.nombreArchivo AS 'nombreArchivo', "
                + "    dbarchivosAdjuntos.tipoArchivo AS 'tipoArchivo', "
                + "    dbarchivosAdjuntos.archivo AS 'archivo', "
                + "    dbarchivosAdjuntos.idUsuario AS 'idUsuario', "
                + "    dbusuario.nombreCompleto AS 'nombreUsuario', "
                + "    dbarchivosAdjuntos.fechaHora AS 'fechaHora', "
                + "    dbarchivosAdjuntos.idEstado AS 'idEstado' "
                + "FROM "
                + "    controlGPC.dbarchivosAdjuntos "
                + "        LEFT JOIN "
                + "    dbusuario ON dbusuario.id = dbarchivosAdjuntos.idUsuario "
                + "WHERE "
                + "    dbarchivosAdjuntos.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  "
                + "    dbarchivosAdjuntos.id AS 'id', "
                + "    dbarchivosAdjuntos.idDocumento AS 'idDocumento', "
                + "    dbarchivosAdjuntos.nombreArchivo AS 'nombreArchivo', "
                + "    dbarchivosAdjuntos.tipoArchivo AS 'tipoArchivo', "
                + "    dbarchivosAdjuntos.archivo AS 'archivo', "
                + "    dbarchivosAdjuntos.idUsuario AS 'idUsuario', "
                + "    dbusuario.nombreCompleto AS 'nombreUsuario', "
                + "    dbarchivosAdjuntos.fechaHora AS 'fechaHora', "
                + "    dbarchivosAdjuntos.idEstado AS 'idEstado' "
                + "FROM "
                + "    controlGPC.dbarchivosAdjuntos "
                + "        LEFT JOIN "
                + "    dbusuario ON dbusuario.id = dbarchivosAdjuntos.idUsuario "
                + "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbarchivosAdjuntos.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  "
                + "    dbarchivosAdjuntos.id AS 'id', "
                + "    dbarchivosAdjuntos.idDocumento AS 'idDocumento', "
                + "    dbarchivosAdjuntos.nombreArchivo AS 'nombreArchivo', "
                + "    dbarchivosAdjuntos.tipoArchivo AS 'tipoArchivo', "
                + "    dbarchivosAdjuntos.archivo AS 'archivo', "
                + "    dbarchivosAdjuntos.idUsuario AS 'idUsuario', "
                + "    dbusuario.nombreCompleto AS 'nombreUsuario', "
                + "    dbarchivosAdjuntos.fechaHora AS 'fechaHora', "
                + "    dbarchivosAdjuntos.idEstado AS 'idEstado' "
                + "FROM "
                + "    controlGPC.dbarchivosAdjuntos "
                + "        LEFT JOIN "
                + "    dbusuario ON dbusuario.id = dbarchivosAdjuntos.idUsuario "
                + "WHERE dbarchivosAdjuntos.id = " + id + " AND dbarchivosAdjuntos.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
