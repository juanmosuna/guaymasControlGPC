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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbestado ")
                .append("(nombreCompleto, ")
                .append("descripcion) ")
                .append("VALUES ")
                .append("(?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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

        StringBuilder _consulta = new StringBuilder();
        
         _consulta.append("UPDATE controlGPC.dbestado ")
                .append("SET ")
                .append( "nombreCompleto = ?, ")
                .append( "descripcion = ? ")
                .append( "WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "DELETE FROM controlGPC.dbestado WHERE ?;");

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

        estado _estadosObj;

        List<estado> _listaestado = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "SELECT  ")
                .append( "    dbestado.id AS 'id', ")
                .append( "    dbestado.nombreCompleto AS 'nombreCompleto', ")
                .append( "    dbestado.descripcion AS 'descripcion' ")
                .append( "FROM ")
                .append( "    controlGPC.dbestado;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "SELECT  ")
                .append( "    dbestado.id AS 'id', ")
                .append( "    dbestado.nombreCompleto AS 'nombreCompleto', ")
                .append( "    dbestado.descripcion AS 'descripcion' ")
                .append( "FROM ")
                .append("    controlGPC.dbestado WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%';");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "SELECT  ")
                .append( "    dbestado.id AS 'id', ")
                .append( "    dbestado.nombreCompleto AS 'nombreCompleto', ")
                .append( "    dbestado.descripcion AS 'descripcion' ")
                .append( "FROM ")
                .append("    controlGPC.dbestado WHERE dbestado.id = ")
                .append(id)
                .append(";");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
