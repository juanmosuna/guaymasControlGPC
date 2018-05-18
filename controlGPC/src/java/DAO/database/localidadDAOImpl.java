/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.localidad;
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
public class localidadDAOImpl implements catalogosInterface {

    private Connection _conn;

    public localidadDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        localidad _localidadesObj = (localidad) o;

        String _consulta = "INSERT INTO gpcControl.dblocalidad "
                + "(nombreCompleto, "
                + "descripcion, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _localidadesObj.getNombreCompleto());
        st.setString(2, _localidadesObj.getDescripcion());
        st.setInt(3, _localidadesObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        localidad _localidadesObj = (localidad) o;

        String _consulta = "UPDATE gpcControl.dblocalidad "
                + "SET "
                + "nombreCompleto = ?, "
                + "descripcion = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _localidadesObj.getNombreCompleto());
        st.setString(2, _localidadesObj.getDescripcion());
        st.setInt(3, _localidadesObj.getIdEstado());

        st.setInt(4, _localidadesObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dblocalidad SET idEstado = 3 WHERE id = ?;";

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

        localidad _localidadesObj;

        List<localidad> _listalocalidad = new ArrayList();

        String _consulta = "SELECT  "
                + "    dblocalidad.id AS 'id', "
                + "    dblocalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dblocalidad.descripcion AS 'descripcion', "
                + "    dblocalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dblocalidad "
                + "WHERE "
                + "    dblocalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _localidadesObj = new localidad();

                _localidadesObj.setId(rs.getInt(1));
                _localidadesObj.setNombreCompleto(rs.getString(2));
                _localidadesObj.setDescripcion(rs.getString(3));
                _localidadesObj.setIdEstado(rs.getInt(4));

                _listalocalidad.add(_localidadesObj);
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

        return _listalocalidad;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        localidad _localidadesObj;

        List<localidad> _listalocalidad = new ArrayList();

        String _consulta = "SELECT  "
                + "    dblocalidad.id AS 'id', "
                + "    dblocalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dblocalidad.descripcion AS 'descripcion', "
                + "    dblocalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dblocalidad "
                + "WHERE " + _campo + " LIKE '%" + _dato + "%' "
                + "    AND dblocalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _localidadesObj = new localidad();

                _localidadesObj.setId(rs.getInt(1));
                _localidadesObj.setNombreCompleto(rs.getString(2));
                _localidadesObj.setDescripcion(rs.getString(3));
                _localidadesObj.setIdEstado(rs.getInt(4));

                _listalocalidad.add(_localidadesObj);
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

        return _listalocalidad;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        localidad _localidadesObj = new localidad();

        String _consulta = "SELECT  "
                + "    dblocalidad.id AS 'id', "
                + "    dblocalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dblocalidad.descripcion AS 'descripcion', "
                + "    dblocalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dblocalidad "
                + "WHERE dblocalidad.id = " + id + " "
                + "    AND dblocalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _localidadesObj.setId(rs.getInt(1));
                _localidadesObj.setNombreCompleto(rs.getString(2));
                _localidadesObj.setDescripcion(rs.getString(3));
                _localidadesObj.setIdEstado(rs.getInt(4));

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

        return _localidadesObj;
    }

}
