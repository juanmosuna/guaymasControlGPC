/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.grupoCalidad;
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
public class grupoCalidadDAOImpl implements catalogosInterface {

    private Connection _conn;

    public grupoCalidadDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        grupoCalidad _grupoCalidadesObj = (grupoCalidad) o;

        String _consulta = "INSERT INTO gpcControl.dbgrupoCalidad "
                + "(nombreCompleto, "
                + "descripcion, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _grupoCalidadesObj.getNombreCompleto());
        st.setString(2, _grupoCalidadesObj.getDescripcion());
        st.setInt(3, _grupoCalidadesObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        grupoCalidad _grupoCalidadesObj = (grupoCalidad) o;

        String _consulta = "UPDATE gpcControl.dbgrupoCalidad "
                + "SET "
                + "nombreCompleto = ?, "
                + "descripcion = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _grupoCalidadesObj.getNombreCompleto());
        st.setString(2, _grupoCalidadesObj.getDescripcion());
        st.setInt(3, _grupoCalidadesObj.getIdEstado());

        st.setInt(4, _grupoCalidadesObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dbgrupoCalidad SET idEstado = 3 WHERE id = ?;";

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

        grupoCalidad _gupoCalidadesObj;

        List<grupoCalidad> _listagrupoCalidad = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbgrupoCalidad.id AS 'id', "
                + "    dbgrupoCalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dbgrupoCalidad.descripcion AS 'descripcion', "
                + "    dbgrupoCalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbgrupoCalidad "
                + "WHERE "
                + "    dbgrupoCalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _gupoCalidadesObj = new grupoCalidad();

                _gupoCalidadesObj.setId(rs.getInt(1));
                _gupoCalidadesObj.setNombreCompleto(rs.getString(2));
                _gupoCalidadesObj.setDescripcion(rs.getString(3));
                _gupoCalidadesObj.setIdEstado(rs.getInt(4));

                _listagrupoCalidad.add(_gupoCalidadesObj);
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

        return _listagrupoCalidad;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        grupoCalidad _gupoCalidadesObj;

        List<grupoCalidad> _listagrupoCalidad = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbgrupoCalidad.id AS 'id', "
                + "    dbgrupoCalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dbgrupoCalidad.descripcion AS 'descripcion', "
                + "    dbgrupoCalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbgrupoCalidad "
                + "WHERE " + _campo + " LIKE '%" + _dato + "%' "
                + "    dbgrupoCalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _gupoCalidadesObj = new grupoCalidad();

                _gupoCalidadesObj.setId(rs.getInt(1));
                _gupoCalidadesObj.setNombreCompleto(rs.getString(2));
                _gupoCalidadesObj.setDescripcion(rs.getString(3));
                _gupoCalidadesObj.setIdEstado(rs.getInt(4));

                _listagrupoCalidad.add(_gupoCalidadesObj);
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

        return _listagrupoCalidad;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        grupoCalidad _gupoCalidadesObj = new grupoCalidad();

        String _consulta = "SELECT  "
                + "    dbgrupoCalidad.id AS 'id', "
                + "    dbgrupoCalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dbgrupoCalidad.descripcion AS 'descripcion', "
                + "    dbgrupoCalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbgrupoCalidad "
                + "WHERE dbgrupoCalidad.id = " + id + " dbgrupoCalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _gupoCalidadesObj.setId(rs.getInt(1));
                _gupoCalidadesObj.setNombreCompleto(rs.getString(2));
                _gupoCalidadesObj.setDescripcion(rs.getString(3));
                _gupoCalidadesObj.setIdEstado(rs.getInt(4));

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

        return _gupoCalidadesObj;
    }

}
