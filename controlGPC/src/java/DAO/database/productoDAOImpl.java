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

        String _consulta = "INSERT INTO controlGPC.dbproducto " +
                "(codigo, " +
                "nombreCompleto, " +
                "descripcion, " +
                "idCategoriaProducto, " +
                "idEstado) " +
                "VALUES " +
                "(?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);
        
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

        String _consulta = "UPDATE controlGPC.dbproducto " +
                "SET " +
                "codigo = ?, " +
                "nombreCompleto = ?, " +
                "descripcion = ?, " +
                "idCategoriaProducto = ?, " +
                "idEstado = ? " +
                "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE controlGPC.dbproducto SET idEstado = 3 WHERE id = ?;";

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
                    "    dbproducto.codigo AS 'codigo', " +
                    "    dbproducto.nombreCompleto AS 'nombreCompleto', " +
                    "    dbproducto.descripcion AS 'descripcion', " +
                    "    dbproducto.idCategoriaProducto AS 'idCategoriaProducto', " +
                    "    dbcategoriaProducto.nombreCompleto AS 'nombreCategoriaProducto', " +
                    "    dbproducto.idEstado AS 'idEstado' " +
                    " FROM " +
                    "    controlGPC.dbproducto "+
                    " LEFT JOIN dbcategoriaProducto ON dbcategoriaProducto.id = dbproducto.idCategoriaProducto " +
                    " WHERE " +
                    "    dbproducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  " +
                    "    dbproducto.id AS 'id', " +
                    "    dbproducto.codigo AS 'codigo', " +
                    "    dbproducto.nombreCompleto AS 'nombreCompleto', " +
                    "    dbproducto.descripcion AS 'descripcion', " +
                    "    dbproducto.idCategoriaProducto AS 'idCategoriaProducto', " +
                    "    dbcategoriaProducto.nombreCompleto AS 'nombreCategoriaProducto', " +
                    "    dbproducto.idEstado AS 'idEstado' " +
                    " FROM " +
                    "    controlGPC.dbproducto "+
                    " LEFT JOIN dbcategoriaProducto ON dbcategoriaProducto.id = dbproducto.idCategoriaProducto " +
                    " WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbproducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  " +
                    "    dbproducto.id AS 'id', " +
                    "    dbproducto.codigo AS 'codigo', " +
                    "    dbproducto.nombreCompleto AS 'nombreCompleto', " +
                    "    dbproducto.descripcion AS 'descripcion', " +
                    "    dbproducto.idCategoriaProducto AS 'idCategoriaProducto', " +
                    "    dbcategoriaProducto.nombreCompleto AS 'nombreCategoriaProducto', " +
                    "    dbproducto.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    controlGPC.dbproducto "+
                    " LEFT JOIN dbcategoriaProducto ON dbcategoriaProducto.id = dbproducto.idCategoriaProducto " +
                    " WHERE dbproducto.id = " + id + " AND dbproducto.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
