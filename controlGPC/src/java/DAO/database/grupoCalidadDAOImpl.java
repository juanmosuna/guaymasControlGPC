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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "INSERT INTO controlGPC.dbgrupoCalidad ")
                .append( "(nombreCompleto, ")
                .append( "descripcion, ")
                .append( "idEstado) ")
                .append( "VALUES ")
                .append( "(?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "UPDATE controlGPC.dbgrupoCalidad ")
                .append( "SET ")
                .append( "nombreCompleto = ?, ")
                .append( "descripcion = ?, ")
                .append( "idEstado = ? ")
                .append( "WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "UPDATE controlGPC.dbgrupoCalidad SET idEstado = 3 WHERE id = ?;");

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

        grupoCalidad _gupoCalidadesObj;

        List<grupoCalidad> _listagrupoCalidad = new ArrayList();
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "SELECT  ")
                    .append("dbgrupoCalidad.id AS 'id', ")
                    .append("dbgrupoCalidad.nombreCompleto AS 'nombreCompleto', ")
                    .append("dbgrupoCalidad.descripcion AS 'descripcion', ")
                    .append("dbgrupoCalidad.idEstado AS 'idEstado' ")
                    .append("FROM controlGPC.dbgrupoCalidad ")
                .append("WHERE dbgrupoCalidad.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "SELECT  ")
                    .append("dbgrupoCalidad.id AS 'id', ")
                    .append("dbgrupoCalidad.nombreCompleto AS 'nombreCompleto', ")
                    .append("dbgrupoCalidad.descripcion AS 'descripcion', ")
                    .append("dbgrupoCalidad.idEstado AS 'idEstado' ")
                .append("FROM controlGPC.dbgrupoCalidad ")
                .append("WHERE ").append(_campo).append(" LIKE '%").append(_dato).append("%' ")
                .append( "  AND dbgrupoCalidad.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append( "SELECT  ")
                .append( "dbgrupoCalidad.id AS 'id', ")
                .append( "dbgrupoCalidad.nombreCompleto AS 'nombreCompleto', ")
                .append( "dbgrupoCalidad.descripcion AS 'descripcion', ")
                .append( "dbgrupoCalidad.idEstado AS 'idEstado' ")
                .append( "FROM controlGPC.dbgrupoCalidad ")
                .append("WHERE dbgrupoCalidad.id = ").append(id)
                .append(" AND dbgrupoCalidad.idEstado != 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
