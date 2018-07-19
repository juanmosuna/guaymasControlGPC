/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.tipoDocumento;
import entity.tipoMovimiento;
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
public class tipoDocumentoDAOImpl implements catalogosInterface {

    private Connection _conn;

    public tipoDocumentoDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        tipoDocumento _tpDocumentosObj = (tipoDocumento) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbtipoDocumento ")
                .append("(nombreCompleto, ")
                .append("descripcion, ")
                .append("idTipoMovimiento, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _tpDocumentosObj.getNombreCompleto());
        st.setString(2, _tpDocumentosObj.getDescripcion());
        st.setInt(3, _tpDocumentosObj.getTipoMovimiento().getId());
        st.setInt(4, _tpDocumentosObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        tipoDocumento _tpDocumentosObj = (tipoDocumento) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbtipoDocumento ")
                .append("SET ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idTipoMovimiento = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _tpDocumentosObj.getNombreCompleto());
        st.setString(2, _tpDocumentosObj.getDescripcion());
        st.setInt(3, _tpDocumentosObj.getTipoMovimiento().getId());
        st.setInt(4, _tpDocumentosObj.getIdEstado());

        st.setInt(5, _tpDocumentosObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE controlGPC.dbtipoDocumento SET idEstado = 3 WHERE id = ?;";

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

        tipoDocumento _tpDocumentosObj;

        List<tipoDocumento> _listatpDocumentos = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT ")
                    .append("td.id AS 'id', ")
                    .append("td.nombreCompleto AS 'nombreCompleto', ")
                    .append("td.descripcion AS 'descripcion', ")
                    .append("td.idTipoMovimiento AS 'idTipoMovimiento', ")
                    .append("tm.nombreCompleto AS 'nombreTipoMovimiento', ")
                    .append("td.idEstado AS 'idEstado' ")
                .append("FROM dbtipoDocumento td ")
                    .append("LEFT JOIN dbtipoMovimiento tm ON tm.id = td.idTipoMovimiento ")
                .append("WHERE td.idEstado != 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpDocumentosObj = new tipoDocumento();

                _tpDocumentosObj.setId(rs.getInt(1));
                _tpDocumentosObj.setNombreCompleto(rs.getString(2));
                _tpDocumentosObj.setDescripcion(rs.getString(3));
                
                tipoMovimiento _tpMovimiento = new tipoMovimiento();
                _tpMovimiento.setId(rs.getInt(4));
                _tpMovimiento.setNombreCompleto(rs.getString(5));
                _tpDocumentosObj.setTipoMovimiento(_tpMovimiento);
                
                _tpDocumentosObj.setIdEstado(rs.getInt(6));

                _listatpDocumentos.add(_tpDocumentosObj);
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

        return _listatpDocumentos;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        tipoDocumento _tpDocumentosObj;

        List<tipoDocumento> _listatpDocumentos = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT ")
                    .append("td.id AS 'id', ")
                    .append("td.nombreCompleto AS 'nombreCompleto', ")
                    .append("td.descripcion AS 'descripcion', ")
                    .append("td.idTipoMovimiento AS 'idTipoMovimiento', ")
                    .append("tm.nombreCompleto AS 'nombreTipoMovimiento', ")
                    .append("td.idEstado AS 'idEstado' ")
                .append("FROM dbtipoDocumento td ")
                    .append("LEFT JOIN dbtipoMovimiento tm ON tm.id = td.idTipoMovimiento ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND td.idEstado != 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpDocumentosObj = new tipoDocumento();

                _tpDocumentosObj.setId(rs.getInt(1));
                _tpDocumentosObj.setNombreCompleto(rs.getString(2));
                _tpDocumentosObj.setDescripcion(rs.getString(3));
                
                tipoMovimiento _tpMovimiento = new tipoMovimiento();
                _tpMovimiento.setId(rs.getInt(4));
                _tpMovimiento.setNombreCompleto(rs.getString(5));
                _tpDocumentosObj.setTipoMovimiento(_tpMovimiento);
                
                _tpDocumentosObj.setIdEstado(rs.getInt(6));

                _listatpDocumentos.add(_tpDocumentosObj);
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

        return _listatpDocumentos;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        tipoDocumento _tpDocumentosObj = new tipoDocumento();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtipoDocumento.id AS 'id', ")
                .append("    dbtipoDocumento.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtipoDocumento.descripcion AS 'descripcion', ")
                .append("    dbtipoDocumento.idTipoMovimiento AS 'idTipoMovimiento', ")
                .append("    dbtipoMovimento.nombreCompleto AS 'nombreTipoMovimiento', ")
                .append("    dbtipoDocumento.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtipoDocumento ")
                .append(" LEFT JOIN dbtipoMovimento ON dbtipoMovimiento.id = dbtipoDocumento.idTipoMovimiento ")
                .append("WHERE ")
                .append("dbtipoDocumento.id = ")
                .append(id)
                .append(" AND dbtipoDocumento.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpDocumentosObj.setId(rs.getInt(1));
                _tpDocumentosObj.setNombreCompleto(rs.getString(2));
                _tpDocumentosObj.setDescripcion(rs.getString(3));
                
                tipoMovimiento _tpMovimiento = new tipoMovimiento();
                _tpMovimiento.setId(rs.getInt(4));
                _tpMovimiento.setNombreCompleto(rs.getString(5));
                _tpDocumentosObj.setTipoMovimiento(_tpMovimiento);
                
                _tpDocumentosObj.setIdEstado(rs.getInt(6));

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

        return _tpDocumentosObj;
    }

}
