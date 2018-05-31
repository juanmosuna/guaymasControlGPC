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

        String _consulta = "INSERT INTO controlGPC.dbcategoriaProducto " +
                "(nombreCompleto, " +
                "descripcion, " +
                "idEstado) " +
                "VALUES " +
                "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE controlGPC.dbcategoriaProducto " +
                "SET " +
                "nombreCompleto = ?, " +
                "descripcion = ?, " +
                "idEstado = ? " +
                "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE controlGPC.dbcategoriaProducto SET idEstado = 3 WHERE id = ?;";

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

        categoriaProducto _ctgProductoObj;

        List<categoriaProducto> _listaCtgProducto = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbcategoriaProducto.id AS 'id', " +
                "    dbcategoriaProducto.nombreCompleto AS 'nombreCompleto', " +
                "    dbcategoriaProducto.descripcion AS 'descripcion', " +
                "    dbcategoriaProducto.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcategoriaProducto " +
                "WHERE " +
                "    dbcategoriaProducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  " +
                "    dbcategoriaProducto.id AS 'id', " +
                "    dbcategoriaProducto.nombreCompleto AS 'nombreCompleto', " +
                "    dbcategoriaProducto.descripcion AS 'descripcion', " +
                "    dbcategoriaProducto.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcategoriaProducto " +
                "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbcategoriaProducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  " +
                "    dbcategoriaProducto.id AS 'id', " +
                "    dbcategoriaProducto.nombreCompleto AS 'nombreCompleto', " +
                "    dbcategoriaProducto.descripcion AS 'descripcion', " +
                "    dbcategoriaProducto.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcategoriaProducto " +
                "WHERE dbcategoriaProducto.id = " + id + " AND dbcategoriaProducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
