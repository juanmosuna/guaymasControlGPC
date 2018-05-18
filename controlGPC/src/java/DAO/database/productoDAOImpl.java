/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
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

        String _consulta = "INSERT INTO gpcControl.dbproducto " +
                "(nombreCompleto, " +
                "descripcion, " +
                "idEstado) " +
                "VALUES " +
                "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _productosObj.getNombreCompleto());
        st.setString(2, _productosObj.getDescripcion());
        st.setInt(3, _productosObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        producto _productosObj = (producto) o;

        String _consulta = "UPDATE gpcControl.dbproducto " +
                "SET " +
                "nombreCompleto = ?, " +
                "descripcion = ?, " +
                "idEstado = ? " +
                "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _productosObj.getNombreCompleto());
        st.setString(2, _productosObj.getDescripcion());
        st.setInt(3, _productosObj.getIdEstado());
        
        st.setInt(4, _productosObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dbproducto SET idEstado = 3 WHERE id = ?;";

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

        producto _productosObj;

        List<producto> _listaproducto = new ArrayList();

        String _consulta = "SELECT  " +
                    "    dbproducto.id AS 'id', " +
                    "    dbproducto.nombreCompleto AS 'nombreCompleto', " +
                    "    dbproducto.descripcion AS 'descripcion', " +
                    "    dbproducto.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    gpcControl.dbproducto " +
                    "WHERE " +
                    "    dbproducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _productosObj = new producto();

                _productosObj.setId(rs.getInt(1));
                _productosObj.setNombreCompleto(rs.getString(2));
                _productosObj.setDescripcion(rs.getString(3));
                _productosObj.setIdEstado(rs.getInt(4));

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

        String _consulta = "SELECT  " +
                    "    dbproducto.id AS 'id', " +
                    "    dbproducto.nombreCompleto AS 'nombreCompleto', " +
                    "    dbproducto.descripcion AS 'descripcion', " +
                    "    dbproducto.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    gpcControl.dbproducto " +
                    "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbproducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _productosObj = new producto();

                _productosObj.setId(rs.getInt(1));
                _productosObj.setNombreCompleto(rs.getString(2));
                _productosObj.setDescripcion(rs.getString(3));
                _productosObj.setIdEstado(rs.getInt(4));

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

        String _consulta = "SELECT  " +
                    "    dbproducto.id AS 'id', " +
                    "    dbproducto.nombreCompleto AS 'nombreCompleto', " +
                    "    dbproducto.descripcion AS 'descripcion', " +
                    "    dbproducto.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    gpcControl.dbproducto " +
                    "WHERE dbproducto.id = " + id + " AND dbproducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _productosObj = new producto();

                _productosObj.setId(rs.getInt(1));
                _productosObj.setNombreCompleto(rs.getString(2));
                _productosObj.setDescripcion(rs.getString(3));
                _productosObj.setIdEstado(rs.getInt(4));

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
