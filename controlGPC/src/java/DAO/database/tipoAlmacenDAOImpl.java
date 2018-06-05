/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.tipoAlmacen;
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
public class tipoAlmacenDAOImpl implements catalogosInterface {

    private Connection _conn;

    public tipoAlmacenDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        tipoAlmacen _tpAlmacenesObj = (tipoAlmacen) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbtipoAlmacen ")
                .append("(nombreCompleto, ")
                .append("descripcion, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _tpAlmacenesObj.getNombreCompleto());
        st.setString(2, _tpAlmacenesObj.getDescripcion());
        st.setInt(3, _tpAlmacenesObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        tipoAlmacen _tpAlmacenesObj = (tipoAlmacen) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbtipoAlmacen ")
                .append("SET ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _tpAlmacenesObj.getNombreCompleto());
        st.setString(2, _tpAlmacenesObj.getDescripcion());
        st.setInt(3, _tpAlmacenesObj.getIdEstado());

        st.setInt(4, _tpAlmacenesObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbtipoAlmacen SET idEstado = 3 WHERE id = ?;");

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

        tipoAlmacen _tpAlmacenesObj;

        List<tipoAlmacen> _listatpAlmacenes = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtipoAlmacen.id AS 'id', ")
                .append("    dbtipoAlmacen.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtipoAlmacen.descripcion AS 'descripcion', ")
                .append("    dbtipoAlmacen.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtipoAlmacen ")
                .append("WHERE ")
                .append("    dbtipoAlmacen.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpAlmacenesObj = new tipoAlmacen();

                _tpAlmacenesObj.setId(rs.getInt(1));
                _tpAlmacenesObj.setNombreCompleto(rs.getString(2));
                _tpAlmacenesObj.setDescripcion(rs.getString(3));
                _tpAlmacenesObj.setIdEstado(rs.getInt(4));

                _listatpAlmacenes.add(_tpAlmacenesObj);
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

        return _listatpAlmacenes;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        tipoAlmacen _tpAlmacenesObj;

        List<tipoAlmacen> _listatpAlmacenes = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtipoAlmacen.id AS 'id', ")
                .append("    dbtipoAlmacen.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtipoAlmacen.descripcion AS 'descripcion', ")
                .append("    dbtipoAlmacen.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtipoAlmacen ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbtipoAlmacen.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpAlmacenesObj = new tipoAlmacen();

                _tpAlmacenesObj.setId(rs.getInt(1));
                _tpAlmacenesObj.setNombreCompleto(rs.getString(2));
                _tpAlmacenesObj.setDescripcion(rs.getString(3));
                _tpAlmacenesObj.setIdEstado(rs.getInt(4));

                _listatpAlmacenes.add(_tpAlmacenesObj);
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

        return _listatpAlmacenes;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        tipoAlmacen _tpAlmacenesObj = new tipoAlmacen();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtipoAlmacen.id AS 'id', ")
                .append("    dbtipoAlmacen.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtipoAlmacen.descripcion AS 'descripcion', ")
                .append("    dbtipoAlmacen.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtipoAlmacen ")
                .append("WHERE dbtipoAlmacen.id = ")
                .append(id)
                .append(" AND dbtipoAlmacen.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpAlmacenesObj.setId(rs.getInt(1));
                _tpAlmacenesObj.setNombreCompleto(rs.getString(2));
                _tpAlmacenesObj.setDescripcion(rs.getString(3));
                _tpAlmacenesObj.setIdEstado(rs.getInt(4));

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

        return _tpAlmacenesObj;
    }

}
