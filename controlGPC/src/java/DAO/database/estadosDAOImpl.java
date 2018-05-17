/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entities.Estados;
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
public class estadosDAOImpl implements catalogosInterface {

    private Connection _conn;

    public estadosDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        Estados _estadosObj = (Estados) o;

        String _consulta = "INSERT INTO gpcControl.dbestado "
                + "(nombreCompleto, "
                + "descripcion) "
                + "VALUES "
                + "(?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _estadosObj.getNombreCompleto());
        st.setString(2, _estadosObj.getDescripcion());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        Estados _estadosObj = (Estados) o;

        String _consulta = "UPDATE gpcControl.dbestado "
                + "SET "
                + "nombreCompleto = ?, "
                + "descripcion = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _estadosObj.getNombreCompleto());
        st.setString(2, _estadosObj.getDescripcion());

        st.setInt(3, _estadosObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "DELETE FROM gpcControl.dbestado WHERE ?;";

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

        Estados _estadosObj;

        List<Estados> _listaEstados = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbestado.id AS 'id', "
                + "    dbestado.nombreCompleto AS 'nombreCompleto', "
                + "    dbestado.descripcion AS 'descripcion' "
                + "FROM "
                + "    gpcControl.dbestado;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _estadosObj = new Estados();

                _estadosObj.setId(rs.getInt(1));
                _estadosObj.setNombreCompleto(rs.getString(2));
                _estadosObj.setDescripcion(rs.getString(3));

                _listaEstados.add(_estadosObj);
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

        return _listaEstados;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        Estados _estadosObj;

        List<Estados> _listaEstados = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbestado.id AS 'id', "
                + "    dbestado.nombreCompleto AS 'nombreCompleto', "
                + "    dbestado.descripcion AS 'descripcion' "
                + "FROM "
                + "    gpcControl.dbestado WHERE " + _campo + " LIKE '%" + _dato + "%';";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _estadosObj = new Estados();

                _estadosObj.setId(rs.getInt(1));
                _estadosObj.setNombreCompleto(rs.getString(2));
                _estadosObj.setDescripcion(rs.getString(3));

                _listaEstados.add(_estadosObj);
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

        return _listaEstados;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        Estados _estadosObj = new Estados();

        String _consulta = "SELECT  "
                + "    dbestado.id AS 'id', "
                + "    dbestado.nombreCompleto AS 'nombreCompleto', "
                + "    dbestado.descripcion AS 'descripcion' "
                + "FROM "
                + "    gpcControl.dbestado WHERE dbestado.id = " + id + ";";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _estadosObj.setId(rs.getInt(1));
                _estadosObj.setNombreCompleto(rs.getString(2));
                _estadosObj.setDescripcion(rs.getString(3));

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

        return _estadosObj;
    }

}
