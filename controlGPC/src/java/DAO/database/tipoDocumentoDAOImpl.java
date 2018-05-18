/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.tipoDocumento;
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

        String _consulta = "INSERT INTO gpcControl.dbtipoDocumento " +
                "(nombreCompleto, " +
                "descripcion, " +
                "idEstado) " +
                "VALUES " +
                "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _tpDocumentosObj.getNombreCompleto());
        st.setString(2, _tpDocumentosObj.getDescripcion());
        st.setInt(3, _tpDocumentosObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        tipoDocumento _tpDocumentosObj = (tipoDocumento) o;

        String _consulta = "UPDATE gpcControl.dbtipoDocumento " +
            "SET " +
            "nombreCompleto = ?, " +
            "descripcion = ?, " +
            "idEstado = ? " +
            "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _tpDocumentosObj.getNombreCompleto());
        st.setString(2, _tpDocumentosObj.getDescripcion());
        st.setInt(3, _tpDocumentosObj.getIdEstado());
        
        st.setInt(4, _tpDocumentosObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dbtipoDocumento SET idEstado = 3 WHERE id = ?;";

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

        String _consulta = "SELECT  " +
                    "    dbtipoDocumento.id AS 'id', " +
                    "    dbtipoDocumento.nombreCompleto AS 'nombreCompleto', " +
                    "    dbtipoDocumento.descripcion AS 'descripcion', " +
                    "    dbtipoDocumento.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    gpcControl.dbtipoDocumento " +
                    "WHERE " +
                    "    dbtipoDocumento.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpDocumentosObj = new tipoDocumento();

                _tpDocumentosObj.setId(rs.getInt(1));
                _tpDocumentosObj.setNombreCompleto(rs.getString(2));
                _tpDocumentosObj.setDescripcion(rs.getString(3));
                _tpDocumentosObj.setIdEstado(rs.getInt(4));

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

        String _consulta = "SELECT  " +
                    "    dbtipoDocumento.id AS 'id', " +
                    "    dbtipoDocumento.nombreCompleto AS 'nombreCompleto', " +
                    "    dbtipoDocumento.descripcion AS 'descripcion', " +
                    "    dbtipoDocumento.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    gpcControl.dbtipoDocumento " +
                    "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbtipoDocumento.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpDocumentosObj = new tipoDocumento();

                _tpDocumentosObj.setId(rs.getInt(1));
                _tpDocumentosObj.setNombreCompleto(rs.getString(2));
                _tpDocumentosObj.setDescripcion(rs.getString(3));
                _tpDocumentosObj.setIdEstado(rs.getInt(4));

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

        String _consulta = "SELECT  " +
                    "    dbtipoDocumento.id AS 'id', " +
                    "    dbtipoDocumento.nombreCompleto AS 'nombreCompleto', " +
                    "    dbtipoDocumento.descripcion AS 'descripcion', " +
                    "    dbtipoDocumento.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    gpcControl.dbtipoDocumento " +
                    "WHERE dbtipoDocumento.id = " + id + " AND dbtipoDocumento.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpDocumentosObj.setId(rs.getInt(1));
                _tpDocumentosObj.setNombreCompleto(rs.getString(2));
                _tpDocumentosObj.setDescripcion(rs.getString(3));
                _tpDocumentosObj.setIdEstado(rs.getInt(4));

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
