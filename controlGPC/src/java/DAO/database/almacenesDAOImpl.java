/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entities.Almacenes;
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
public class almacenesDAOImpl implements catalogosInterface {

    private Connection _conn;

    public almacenesDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        Almacenes _almObj = (Almacenes) o;

        String _consulta = "INSERT INTO gpcControl.dbalmacen "
                + "(codigo, "
                + "nombreCompleto, "
                + "descripcion, "
                + "idtipoAlmacen, "
                + "capacidad, "
                + "idunidadMedida, "
                + "secciones, "
                + "lados, "
                + "segmentos, "
                + "niveles, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _almObj.getCodigo());
        st.setString(2, _almObj.getNombreCompleto());
        st.setString(3, _almObj.getDescripcion());
        st.setInt(4, _almObj.getIdtipoAlmacen());
        st.setDouble(5, _almObj.getCapacidad());
        st.setInt(6, _almObj.getIdunidadMedida());
        st.setInt(7, _almObj.getSecciones());
        st.setInt(8, _almObj.getLados());
        st.setInt(9, _almObj.getSegmentos());
        st.setInt(10, _almObj.getNiveles());
        st.setInt(11, _almObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        Almacenes _almObj = (Almacenes) o;

        String _consulta = "UPDATE gpcControl.dbalmacen "
                + "SET "
                + "codigo = ?, "
                + "nombreCompleto = ?, "
                + "descripcion = ?, "
                + "idtipoAlmacen = ?, "
                + "capacidad = ?, "
                + "idunidadMedida = ?, "
                + "secciones = ?, "
                + "lados = ?, "
                + "segmentos = ?, "
                + "niveles = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _almObj.getCodigo());
        st.setString(2, _almObj.getNombreCompleto());
        st.setString(3, _almObj.getDescripcion());
        st.setInt(4, _almObj.getIdtipoAlmacen());
        st.setDouble(5, _almObj.getCapacidad());
        st.setInt(6, _almObj.getIdunidadMedida());
        st.setInt(7, _almObj.getSecciones());
        st.setInt(8, _almObj.getLados());
        st.setInt(9, _almObj.getSegmentos());
        st.setInt(10, _almObj.getNiveles());
        st.setInt(11, _almObj.getIdEstado());

        st.setInt(12, _almObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dbalmacen SET idEstado = 3 WHERE id = ?;";

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

        Almacenes _almacenesObj;

        List<Almacenes> _listaAlmacenes = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbalmacen.id AS 'id', "
                + "    dbalmacen.codigo AS 'codigo', "
                + "    dbalmacen.nombreCompleto AS 'nombreCompleto', "
                + "    dbalmacen.descripcion AS 'descripcion', "
                + "    dbalmacen.idtipoAlmacen AS 'idtipoAlmacen', "
                + "    dbtipoAlmacen.nombreCompleto AS 'nombreTipoAlmacen', "
                + "    dbalmacen.capacidad AS 'capacidad', "
                + "    dbalmacen.idunidadMedida AS 'idunidadMedida', "
                + "    dbunidadMedida.nombreCompleto AS 'nombreUnidadMedida', "
                + "    dbalmacen.secciones AS 'secciones', "
                + "    dbalmacen.lados AS 'lados', "
                + "    dbalmacen.segmentos AS 'segmentos', "
                + "    dbalmacen.niveles AS 'niveles', "
                + "    dbalmacen.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbalmacen "
                + "        LEFT JOIN "
                + "    dbtipoAlmacen ON dbtipoAlmacen.id = dbalmacen.idtipoAlmacen "
                + "        LEFT JOIN "
                + "    dbunidadMedida ON dbunidadMedida.id = dbalmacen.idunidadMedida "
                + "WHERE "
                + "    dbalmacen.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _almacenesObj = new Almacenes();

                _almacenesObj.setId(rs.getInt(1));
                _almacenesObj.setCodigo(rs.getString(2));
                _almacenesObj.setNombreCompleto(rs.getString(3));
                _almacenesObj.setDescripcion(rs.getString(4));
                _almacenesObj.setIdtipoAlmacen(rs.getInt(5));
                _almacenesObj.setNombreTipoAlmacen(rs.getString(6));
                _almacenesObj.setCapacidad(rs.getDouble(7));
                _almacenesObj.setIdunidadMedida(rs.getInt(8));
                _almacenesObj.setNombreUnidadMedida(rs.getString(9));
                _almacenesObj.setSecciones(rs.getInt(10));
                _almacenesObj.setLados(rs.getInt(11));
                _almacenesObj.setSegmentos(rs.getInt(12));
                _almacenesObj.setNiveles(rs.getInt(13));
                _almacenesObj.setIdEstado(rs.getInt(14));

                _listaAlmacenes.add(_almacenesObj);
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

        return _listaAlmacenes;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        Almacenes _almacenesObj;

        List<Almacenes> _listaAlmacenes = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbalmacen.id AS 'id', "
                + "    dbalmacen.codigo AS 'codigo', "
                + "    dbalmacen.nombreCompleto AS 'nombreCompleto', "
                + "    dbalmacen.descripcion AS 'descripcion', "
                + "    dbalmacen.idtipoAlmacen AS 'idtipoAlmacen', "
                + "    dbtipoAlmacen.nombreCompleto AS 'nombreTipoAlmacen', "
                + "    dbalmacen.capacidad AS 'capacidad', "
                + "    dbalmacen.idunidadMedida AS 'idunidadMedida', "
                + "    dbunidadMedida.nombreCompleto AS 'nombreUnidadMedida', "
                + "    dbalmacen.secciones AS 'secciones', "
                + "    dbalmacen.lados AS 'lados', "
                + "    dbalmacen.segmentos AS 'segmentos', "
                + "    dbalmacen.niveles AS 'niveles', "
                + "    dbalmacen.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbalmacen "
                + "        LEFT JOIN "
                + "    dbtipoAlmacen ON dbtipoAlmacen.id = dbalmacen.idtipoAlmacen "
                + "        LEFT JOIN "
                + "    dbunidadMedida ON dbunidadMedida.id = dbalmacen.idunidadMedida "
                + "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbalmacen.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _almacenesObj = new Almacenes();

                _almacenesObj.setId(rs.getInt(1));
                _almacenesObj.setCodigo(rs.getString(2));
                _almacenesObj.setNombreCompleto(rs.getString(3));
                _almacenesObj.setDescripcion(rs.getString(4));
                _almacenesObj.setIdtipoAlmacen(rs.getInt(5));
                _almacenesObj.setNombreTipoAlmacen(rs.getString(6));
                _almacenesObj.setCapacidad(rs.getDouble(7));
                _almacenesObj.setIdunidadMedida(rs.getInt(8));
                _almacenesObj.setNombreUnidadMedida(rs.getString(9));
                _almacenesObj.setSecciones(rs.getInt(10));
                _almacenesObj.setLados(rs.getInt(11));
                _almacenesObj.setSegmentos(rs.getInt(12));
                _almacenesObj.setNiveles(rs.getInt(13));
                _almacenesObj.setIdEstado(rs.getInt(14));

                _listaAlmacenes.add(_almacenesObj);
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

        return _listaAlmacenes;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        Almacenes _almacenesObj = new Almacenes();

        String _consulta = "SELECT  "
                + "    dbalmacen.id AS 'id', "
                + "    dbalmacen.codigo AS 'codigo', "
                + "    dbalmacen.nombreCompleto AS 'nombreCompleto', "
                + "    dbalmacen.descripcion AS 'descripcion', "
                + "    dbalmacen.idtipoAlmacen AS 'idtipoAlmacen', "
                + "    dbtipoAlmacen.nombreCompleto AS 'nombreTipoAlmacen', "
                + "    dbalmacen.capacidad AS 'capacidad', "
                + "    dbalmacen.idunidadMedida AS 'idunidadMedida', "
                + "    dbunidadMedida.nombreCompleto AS 'nombreUnidadMedida', "
                + "    dbalmacen.secciones AS 'secciones', "
                + "    dbalmacen.lados AS 'lados', "
                + "    dbalmacen.segmentos AS 'segmentos', "
                + "    dbalmacen.niveles AS 'niveles', "
                + "    dbalmacen.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbalmacen "
                + "        LEFT JOIN "
                + "    dbtipoAlmacen ON dbtipoAlmacen.id = dbalmacen.idtipoAlmacen "
                + "        LEFT JOIN "
                + "    dbunidadMedida ON dbunidadMedida.id = dbalmacen.idunidadMedida "
                + "WHERE dbalmacen.id = " + id + " AND dbalmacen.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _almacenesObj.setId(rs.getInt(1));
                _almacenesObj.setCodigo(rs.getString(2));
                _almacenesObj.setNombreCompleto(rs.getString(3));
                _almacenesObj.setDescripcion(rs.getString(4));
                _almacenesObj.setIdtipoAlmacen(rs.getInt(5));
                _almacenesObj.setNombreTipoAlmacen(rs.getString(6));
                _almacenesObj.setCapacidad(rs.getDouble(7));
                _almacenesObj.setIdunidadMedida(rs.getInt(8));
                _almacenesObj.setNombreUnidadMedida(rs.getString(9));
                _almacenesObj.setSecciones(rs.getInt(10));
                _almacenesObj.setLados(rs.getInt(11));
                _almacenesObj.setSegmentos(rs.getInt(12));
                _almacenesObj.setNiveles(rs.getInt(13));
                _almacenesObj.setIdEstado(rs.getInt(14));

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

        return _almacenesObj;
    }

}
