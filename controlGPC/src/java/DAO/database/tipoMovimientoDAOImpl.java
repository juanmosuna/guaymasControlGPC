/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
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
public class tipoMovimientoDAOImpl implements catalogosInterface {
    
    private Connection _conn;

    public tipoMovimientoDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        tipoMovimiento _tpMovimientoObj = (tipoMovimiento) o;

        String _consulta = "INSERT INTO controlGPC.dbtipoMovimiento " +
                "(nombreCompleto, " +
                "descripcion, " +
                "idEstado) " +
                "VALUES " +
                "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _tpMovimientoObj.getNombreCompleto());
        st.setString(2, _tpMovimientoObj.getDescripcion());
        st.setInt(3, _tpMovimientoObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        tipoMovimiento _tpMovimientoObj = (tipoMovimiento) o;

        String _consulta = "UPDATE controlGPC.dbtipoMovimiento " +
                "SET " +
                "nombreCompleto = ?, " +
                "descripcion = ?, " +
                "idEstado = ? " +
                "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _tpMovimientoObj.getNombreCompleto());
        st.setString(2, _tpMovimientoObj.getDescripcion());
        st.setInt(3, _tpMovimientoObj.getIdEstado());
        
        st.setInt(4, _tpMovimientoObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE controlGPC.dbtipoMovimiento SET idEstado = 3 WHERE id = ?;";

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

        tipoMovimiento _tpMovimientoObj;

        List<tipoMovimiento> _listatpMovimientos = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbtipoMovimiento.id AS 'id', " +
                "    dbtipoMovimiento.nombreCompleto AS 'nombreCompleto', " +
                "    dbtipoMovimiento.descripcion AS 'descripcion', " +
                "    dbtipoMovimiento.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbtipoMovimiento " +
                "WHERE " +
                "    dbtipoMovimiento.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpMovimientoObj = new tipoMovimiento();

                _tpMovimientoObj.setId(rs.getInt(1));
                _tpMovimientoObj.setNombreCompleto(rs.getString(2));
                _tpMovimientoObj.setDescripcion(rs.getString(3));
                _tpMovimientoObj.setIdEstado(rs.getInt(4));

                _listatpMovimientos.add(_tpMovimientoObj);
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

        return _listatpMovimientos;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        tipoMovimiento _tpMovimientoObj;

        List<tipoMovimiento> _listatpMovimientos = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbtipoMovimiento.id AS 'id', " +
                "    dbtipoMovimiento.nombreCompleto AS 'nombreCompleto', " +
                "    dbtipoMovimiento.descripcion AS 'descripcion', " +
                "    dbtipoMovimiento.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbtipoMovimiento " +
                "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbtipoMovimiento.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpMovimientoObj = new tipoMovimiento();

                _tpMovimientoObj.setId(rs.getInt(1));
                _tpMovimientoObj.setNombreCompleto(rs.getString(2));
                _tpMovimientoObj.setDescripcion(rs.getString(3));
                _tpMovimientoObj.setIdEstado(rs.getInt(4));

                _listatpMovimientos.add(_tpMovimientoObj);
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

        return _listatpMovimientos;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        tipoMovimiento _tpMovimientoObj = new tipoMovimiento();

        String _consulta = "SELECT  " +
                "    dbtipoMovimiento.id AS 'id', " +
                "    dbtipoMovimiento.nombreCompleto AS 'nombreCompleto', " +
                "    dbtipoMovimiento.descripcion AS 'descripcion', " +
                "    dbtipoMovimiento.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbtipoMovimiento " +
                "WHERE dbtipoMovimiento.id = " + id + " AND dbtipoMovimiento.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpMovimientoObj.setId(rs.getInt(1));
                _tpMovimientoObj.setNombreCompleto(rs.getString(2));
                _tpMovimientoObj.setDescripcion(rs.getString(3));
                _tpMovimientoObj.setIdEstado(rs.getInt(4));

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

        return _tpMovimientoObj;
    }
    
}
