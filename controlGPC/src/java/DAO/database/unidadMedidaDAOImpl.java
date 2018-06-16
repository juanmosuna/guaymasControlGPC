/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.unidadMedida;
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
public class unidadMedidaDAOImpl implements catalogosInterface {

    private Connection _conn;

    public unidadMedidaDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        unidadMedida _unidadMedidaObj = (unidadMedida) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbunidadMedida ")
                .append("(nombreCompleto, ")
                .append("codigo, ")
                .append("descripcion, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _unidadMedidaObj.getNombreCompleto());
        st.setString(2, _unidadMedidaObj.getCodigo());
        st.setString(3, _unidadMedidaObj.getDescripcion());
        st.setInt(4, _unidadMedidaObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        unidadMedida _unidadMedidaObj = (unidadMedida) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbunidadMedida ")
                .append("SET ")
                .append("nombreCompleto = ?, ")
                .append("codigo = ?, ")
                .append("descripcion = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _unidadMedidaObj.getNombreCompleto());
        st.setString(2, _unidadMedidaObj.getCodigo());
        st.setString(3, _unidadMedidaObj.getDescripcion());
        st.setInt(4, _unidadMedidaObj.getIdEstado());

        st.setInt(4, _unidadMedidaObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbunidadMedida SET idEstado = 3 WHERE id = ?;");

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

        unidadMedida _unidadMedidaObj;

        List<unidadMedida> _listaUnidadMedida = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbunidadMedida.id AS 'id', ")
                .append("    dbunidadMedida.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbunidadMedida.codigo AS 'codigo', ")
                .append("    dbunidadMedida.descripcion AS 'descripcion', ")
                .append("    dbunidadMedida.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbunidadMedida ")
                .append("WHERE ")
                .append("    dbunidadMedida.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _unidadMedidaObj = new unidadMedida();

                _unidadMedidaObj.setId(rs.getInt(1));
                _unidadMedidaObj.setNombreCompleto(rs.getString(2));
                _unidadMedidaObj.setCodigo(rs.getString(3));
                _unidadMedidaObj.setDescripcion(rs.getString(4));
                _unidadMedidaObj.setIdEstado(rs.getInt(5));

                _listaUnidadMedida.add(_unidadMedidaObj);
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

        return _listaUnidadMedida;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        unidadMedida _unidadMedidaObj;

        List<unidadMedida> _listaUnidadMedida = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbunidadMedida.id AS 'id', ")
                .append("    dbunidadMedida.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbunidadMedida.codigo AS 'codigo', ")
                .append("    dbunidadMedida.descripcion AS 'descripcion', ")
                .append("    dbunidadMedida.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbunidadMedida ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbunidadMedida.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _unidadMedidaObj = new unidadMedida();

                _unidadMedidaObj.setId(rs.getInt(1));
                _unidadMedidaObj.setNombreCompleto(rs.getString(2));
                _unidadMedidaObj.setCodigo(rs.getString(3));
                _unidadMedidaObj.setDescripcion(rs.getString(4));
                _unidadMedidaObj.setIdEstado(rs.getInt(5));

                _listaUnidadMedida.add(_unidadMedidaObj);
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

        return _listaUnidadMedida;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        unidadMedida _unidadMedidaObj = new unidadMedida();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbunidadMedida.id AS 'id', ")
                .append("    dbunidadMedida.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbunidadMedida.codigo AS 'codigo', ")
                .append("    dbunidadMedida.descripcion AS 'descripcion', ")
                .append("    dbunidadMedida.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbunidadMedida ")
                .append("WHERE dbunidadMedida.id = ")
                .append(id)
                .append(" AND dbunidadMedida.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _unidadMedidaObj.setId(rs.getInt(1));
                _unidadMedidaObj.setNombreCompleto(rs.getString(2));
                _unidadMedidaObj.setCodigo(rs.getString(3));
                _unidadMedidaObj.setDescripcion(rs.getString(4));
                _unidadMedidaObj.setIdEstado(rs.getInt(5));

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

        return _unidadMedidaObj;
    }

}
