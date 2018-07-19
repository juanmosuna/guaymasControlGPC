/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.tipoVehiculo;
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
public class tipoVehiculoDAOImpl implements catalogosInterface{

    private Connection _conn;

    public tipoVehiculoDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        tipoVehiculo _tpVehiculoObj = (tipoVehiculo) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbtipoVehiculo ")
                .append("(nombreCompleto, ")
                .append("descripcion, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _tpVehiculoObj.getNombreCompleto());
        st.setString(2, _tpVehiculoObj.getDescripcion());
        st.setInt(3, _tpVehiculoObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        tipoVehiculo _tpVehiculoObj = (tipoVehiculo) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbtipoVehiculo ")
                .append("SET ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _tpVehiculoObj.getNombreCompleto());
        st.setString(2, _tpVehiculoObj.getDescripcion());
        st.setInt(3, _tpVehiculoObj.getIdEstado());

        st.setInt(4, _tpVehiculoObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbtipoVehiculo SET idEstado = 3 WHERE id = ?;");

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

        tipoVehiculo _tpVehiculoObj;

        List<tipoVehiculo> _listatpVehiculo = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtipoVehiculo.id AS 'id', ")
                .append("    dbtipoVehiculo.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtipoVehiculo.descripcion AS 'descripcion', ")
                .append("    dbtipoVehiculo.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtipoVehiculo ")
                .append("WHERE ")
                .append("    dbtipoVehiculo.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpVehiculoObj = new tipoVehiculo();

                _tpVehiculoObj.setId(rs.getInt(1));
                _tpVehiculoObj.setNombreCompleto(rs.getString(2));
                _tpVehiculoObj.setDescripcion(rs.getString(3));
                _tpVehiculoObj.setIdEstado(rs.getInt(4));

                _listatpVehiculo.add(_tpVehiculoObj);
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

        return _listatpVehiculo;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        tipoVehiculo _tpVehiculoObj;

        List<tipoVehiculo> _listatpVehiculo = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtipoVehiculo.id AS 'id', ")
                .append("    dbtipoVehiculo.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtipoVehiculo.descripcion AS 'descripcion', ")
                .append("    dbtipoVehiculo.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtipoVehiculo ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbtipoVehiculo.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpVehiculoObj = new tipoVehiculo();

                _tpVehiculoObj.setId(rs.getInt(1));
                _tpVehiculoObj.setNombreCompleto(rs.getString(2));
                _tpVehiculoObj.setDescripcion(rs.getString(3));
                _tpVehiculoObj.setIdEstado(rs.getInt(4));

                _listatpVehiculo.add(_tpVehiculoObj);
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

        return _listatpVehiculo;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        tipoVehiculo _tpVehiculoObj = new tipoVehiculo();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtipoVehiculo.id AS 'id', ")
                .append("    dbtipoVehiculo.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtipoVehiculo.descripcion AS 'descripcion', ")
                .append("    dbtipoVehiculo.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtipoVehiculo ")
                .append("WHERE dbtipoVehiculo.id = ")
                .append(id)
                .append(" AND dbtipoVehiculo.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpVehiculoObj.setId(rs.getInt(1));
                _tpVehiculoObj.setNombreCompleto(rs.getString(2));
                _tpVehiculoObj.setDescripcion(rs.getString(3));
                _tpVehiculoObj.setIdEstado(rs.getInt(4));

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

        return _tpVehiculoObj;
    }
    
}
