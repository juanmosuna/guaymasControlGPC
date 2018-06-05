/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.estado;
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
public class estadoDAOImpl implements catalogosInterface {

    private Connection _conn;

    public estadoDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        estado _estadosObj = (estado) o;

        String _consulta = "INSERT INTO controlGPC.dbestado "
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

        estado _estadosObj = (estado) o;

        String _consulta = "UPDATE controlGPC.dbestado "
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

        String _consulta = "DELETE FROM controlGPC.dbestado WHERE ?;";

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

        estado _estadosObj;

        List<estado> _listaestado = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbestado.id AS 'id', "
                + "    dbestado.nombreCompleto AS 'nombreCompleto', "
                + "    dbestado.descripcion AS 'descripcion' "
                + "FROM "
                + "    controlGPC.dbestado;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _estadosObj = new estado();

                _estadosObj.setId(rs.getInt(1));
                _estadosObj.setNombreCompleto(rs.getString(2));
                _estadosObj.setDescripcion(rs.getString(3));

                _listaestado.add(_estadosObj);
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

        return _listaestado;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        estado _estadosObj;

        List<estado> _listaestado = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbestado.id AS 'id', "
                + "    dbestado.nombreCompleto AS 'nombreCompleto', "
                + "    dbestado.descripcion AS 'descripcion' "
                + "FROM "
                + "    controlGPC.dbestado WHERE " + _campo + " LIKE '%" + _dato + "%';";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _estadosObj = new estado();

                _estadosObj.setId(rs.getInt(1));
                _estadosObj.setNombreCompleto(rs.getString(2));
                _estadosObj.setDescripcion(rs.getString(3));

                _listaestado.add(_estadosObj);
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

        return _listaestado;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        estado _estadosObj = new estado();

        String _consulta = "SELECT  "
                + "    dbestado.id AS 'id', "
                + "    dbestado.nombreCompleto AS 'nombreCompleto', "
                + "    dbestado.descripcion AS 'descripcion' "
                + "FROM "
                + "    controlGPC.dbestado WHERE dbestado.id = " + id + ";";

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
