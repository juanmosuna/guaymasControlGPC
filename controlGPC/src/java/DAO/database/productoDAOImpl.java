/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.categoriaProducto;
import entity.producto;
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
public class productoDAOImpl implements catalogosInterface {

    private Connection _conn;

    public productoDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        producto _productosObj = (producto) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbproducto ")
                .append("(codigo, ")
                .append("nombreCompleto, ")
                .append("descripcion, ")
                .append("idCategoriaProducto, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _productosObj.getCodigo());
        st.setString(2, _productosObj.getNombreCompleto());
        st.setString(3, _productosObj.getDescripcion());
        st.setInt(4, _productosObj.getCtgProducto().getId());
        st.setInt(5, _productosObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        producto _productosObj = (producto) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbproducto ")
                .append("SET ")
                .append("codigo = ?, ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idCategoriaProducto = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _productosObj.getCodigo());
        st.setString(2, _productosObj.getNombreCompleto());
        st.setString(3, _productosObj.getDescripcion());
        st.setInt(4, _productosObj.getCtgProducto().getId());
        st.setInt(5, _productosObj.getIdEstado());

        st.setInt(6, _productosObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbproducto SET idEstado = 3 WHERE id = ?;");

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

        producto _productosObj;

        List<producto> _listaproducto = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbproducto.id AS 'id', ")
                .append("    dbproducto.codigo AS 'codigo', ")
                .append("    dbproducto.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbproducto.descripcion AS 'descripcion', ")
                .append("    dbproducto.idCategoriaProducto AS 'idCategoriaProducto', ")
                .append("    dbcategoriaProducto.nombreCompleto AS 'nombreCategoriaProducto', ")
                .append("    dbproducto.idEstado AS 'idEstado' ")
                .append(" FROM ")
                .append("    controlGPC.dbproducto ")
                .append(" LEFT JOIN dbcategoriaProducto ON dbcategoriaProducto.id = dbproducto.idCategoriaProducto ")
                .append(" WHERE ")
                .append("    dbproducto.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _productosObj = new producto();

                _productosObj.setId(rs.getInt(1));
                _productosObj.setCodigo(rs.getString(2));
                _productosObj.setNombreCompleto(rs.getString(3));
                _productosObj.setDescripcion(rs.getString(4));

                categoriaProducto _ctgProducto = new categoriaProducto();
                _ctgProducto.setId(rs.getInt(5));
                _ctgProducto.setNombreCompleto(rs.getString(6));

                _productosObj.setCtgProducto(_ctgProducto);

                _productosObj.setIdEstado(rs.getInt(7));

                _listaproducto.add(_productosObj);
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

        return _listaproducto;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        producto _productosObj;

        List<producto> _listaproducto = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbproducto.id AS 'id', ")
                .append("    dbproducto.codigo AS 'codigo', ")
                .append("    dbproducto.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbproducto.descripcion AS 'descripcion', ")
                .append("    dbproducto.idCategoriaProducto AS 'idCategoriaProducto', ")
                .append("    dbcategoriaProducto.nombreCompleto AS 'nombreCategoriaProducto', ")
                .append("    dbproducto.idEstado AS 'idEstado' ")
                .append(" FROM ")
                .append("    controlGPC.dbproducto ")
                .append(" LEFT JOIN dbcategoriaProducto ON dbcategoriaProducto.id = dbproducto.idCategoriaProducto ")
                .append(" WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbproducto.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _productosObj = new producto();

                _productosObj.setId(rs.getInt(1));
                _productosObj.setCodigo(rs.getString(2));
                _productosObj.setNombreCompleto(rs.getString(3));
                _productosObj.setDescripcion(rs.getString(4));

                categoriaProducto _ctgProducto = new categoriaProducto();
                _ctgProducto.setId(rs.getInt(5));
                _ctgProducto.setNombreCompleto(rs.getString(6));

                _productosObj.setCtgProducto(_ctgProducto);

                _productosObj.setIdEstado(rs.getInt(7));

                _listaproducto.add(_productosObj);
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

        return _listaproducto;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        producto _productosObj = new producto();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbproducto.id AS 'id', ")
                .append("    dbproducto.codigo AS 'codigo', ")
                .append("    dbproducto.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbproducto.descripcion AS 'descripcion', ")
                .append("    dbproducto.idCategoriaProducto AS 'idCategoriaProducto', ")
                .append("    dbcategoriaProducto.nombreCompleto AS 'nombreCategoriaProducto', ")
                .append("    dbproducto.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbproducto ")
                .append(" LEFT JOIN dbcategoriaProducto ON dbcategoriaProducto.id = dbproducto.idCategoriaProducto ")
                .append(" WHERE dbproducto.id = ")
                .append(id)
                .append(" AND dbproducto.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _productosObj = new producto();

                _productosObj.setId(rs.getInt(1));
                _productosObj.setCodigo(rs.getString(2));
                _productosObj.setNombreCompleto(rs.getString(3));
                _productosObj.setDescripcion(rs.getString(4));

                categoriaProducto _ctgProducto = new categoriaProducto();
                _ctgProducto.setId(rs.getInt(5));
                _ctgProducto.setNombreCompleto(rs.getString(6));

                _productosObj.setCtgProducto(_ctgProducto);

                _productosObj.setIdEstado(rs.getInt(7));

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

        return _productosObj;
    }

}
