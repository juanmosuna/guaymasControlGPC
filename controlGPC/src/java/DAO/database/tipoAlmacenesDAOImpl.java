/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entities.TipoAlmacenes;
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
public class tipoAlmacenesDAOImpl implements catalogosInterface {
    
    private Connection _conn;

    public tipoAlmacenesDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        TipoAlmacenes _tpAlmacenesObj = (TipoAlmacenes) o;

        String _consulta = "INSERT INTO gpcControl.dbtipoAlmacen " +
                    "(nombreCompleto, " +
                    "descripcion, " +
                    "idEstado) " +
                    "VALUES " +
                    "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        TipoAlmacenes _tpAlmacenesObj = (TipoAlmacenes) o;

        String _consulta = "UPDATE gpcControl.dbtipoAlmacen " +
                "SET " +
                "nombreCompleto = ?, " +
                "descripcion = ?, " +
                "idEstado = ? " +
                "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE gpcControl.dbtipoAlmacen SET idEstado = 3 WHERE id = ?;";

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

        TipoAlmacenes _tpAlmacenesObj;

        List<TipoAlmacenes> _listatpAlmacenes = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbtipoAlmacen.id AS 'id', " +
                "    dbtipoAlmacen.nombreCompleto AS 'nombreCompleto', " +
                "    dbtipoAlmacen.descripcion AS 'descripcion', " +
                "    dbtipoAlmacen.idEstado AS 'idEstado' " +
                "FROM " +
                "    gpcControl.dbtipoAlmacen " +
                "WHERE " +
                "    dbtipoAlmacen.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpAlmacenesObj = new TipoAlmacenes();

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

        TipoAlmacenes _tpAlmacenesObj;

        List<TipoAlmacenes> _listatpAlmacenes = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbtipoAlmacen.id AS 'id', " +
                "    dbtipoAlmacen.nombreCompleto AS 'nombreCompleto', " +
                "    dbtipoAlmacen.descripcion AS 'descripcion', " +
                "    dbtipoAlmacen.idEstado AS 'idEstado' " +
                "FROM " +
                "    gpcControl.dbtipoAlmacen " +
                "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbtipoAlmacen.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _tpAlmacenesObj = new TipoAlmacenes();

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

        TipoAlmacenes _tpAlmacenesObj = new TipoAlmacenes();

        String _consulta = "SELECT  " +
                "    dbtipoAlmacen.id AS 'id', " +
                "    dbtipoAlmacen.nombreCompleto AS 'nombreCompleto', " +
                "    dbtipoAlmacen.descripcion AS 'descripcion', " +
                "    dbtipoAlmacen.idEstado AS 'idEstado' " +
                "FROM " +
                "    gpcControl.dbtipoAlmacen " +
                "WHERE dbtipoAlmacen.id = " + id + " AND dbtipoAlmacen.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
