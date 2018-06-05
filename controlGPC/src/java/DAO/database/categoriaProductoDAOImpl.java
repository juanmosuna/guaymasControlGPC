/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.categoriaProducto;
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
public class categoriaProductoDAOImpl implements catalogosInterface {

    private Connection _conn;

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        categoriaProducto _ctgProductoObj = (categoriaProducto) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbcategoriaProducto ")
                .append("(nombreCompleto, ")
                .append("descripcion, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _ctgProductoObj.getNombreCompleto());
        st.setString(2, _ctgProductoObj.getDescripcion());
        st.setInt(3, _ctgProductoObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        categoriaProducto _ctgProductoObj = (categoriaProducto) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbcategoriaProducto ")
                .append("SET ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _ctgProductoObj.getNombreCompleto());
        st.setString(2, _ctgProductoObj.getDescripcion());
        st.setInt(3, _ctgProductoObj.getIdEstado());

        st.setInt(4, _ctgProductoObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbcategoriaProducto SET idEstado = 3 WHERE id = ?;");

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

        categoriaProducto _ctgProductoObj;

        List<categoriaProducto> _listaCtgProducto = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbcategoriaProducto.id AS 'id', ")
                .append("    dbcategoriaProducto.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcategoriaProducto.descripcion AS 'descripcion', ")
                .append("    dbcategoriaProducto.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcategoriaProducto ")
                .append("WHERE ")
                .append("    dbcategoriaProducto.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _ctgProductoObj = new categoriaProducto();

                _ctgProductoObj.setId(rs.getInt(1));
                _ctgProductoObj.setNombreCompleto(rs.getString(2));
                _ctgProductoObj.setDescripcion(rs.getString(3));
                _ctgProductoObj.setIdEstado(rs.getInt(4));

                _listaCtgProducto.add(_ctgProductoObj);
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

        return _listaCtgProducto;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        categoriaProducto _ctgProductoObj;

        List<categoriaProducto> _listaCtgProducto = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbcategoriaProducto.id AS 'id', ")
                .append("    dbcategoriaProducto.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcategoriaProducto.descripcion AS 'descripcion', ")
                .append("    dbcategoriaProducto.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcategoriaProducto ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbcategoriaProducto.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _ctgProductoObj = new categoriaProducto();

                _ctgProductoObj.setId(rs.getInt(1));
                _ctgProductoObj.setNombreCompleto(rs.getString(2));
                _ctgProductoObj.setDescripcion(rs.getString(3));
                _ctgProductoObj.setIdEstado(rs.getInt(4));

                _listaCtgProducto.add(_ctgProductoObj);
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

        return _listaCtgProducto;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        categoriaProducto _ctgProductoObj = new categoriaProducto();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbcategoriaProducto.id AS 'id', ")
                .append("    dbcategoriaProducto.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcategoriaProducto.descripcion AS 'descripcion', ")
                .append("    dbcategoriaProducto.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcategoriaProducto ")
                .append("WHERE dbcategoriaProducto.id = ")
                .append(id)
                .append(" AND dbcategoriaProducto.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _ctgProductoObj.setId(rs.getInt(1));
                _ctgProductoObj.setNombreCompleto(rs.getString(2));
                _ctgProductoObj.setDescripcion(rs.getString(3));
                _ctgProductoObj.setIdEstado(rs.getInt(4));

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

        return _ctgProductoObj;
    }

}
