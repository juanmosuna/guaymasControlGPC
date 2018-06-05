/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.almacen;
import entity.tipoAlmacen;
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
public class almacenDAOImpl implements catalogosInterface {

    private Connection _conn;

    public almacenDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        almacen _almObj = (almacen) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbalmacen ")
                .append("(codigo, ")
                .append("nombreCompleto, ")
                .append("descripcion, ")
                .append("idtipoAlmacen, ")
                .append("capacidad, ")
                .append("idunidadMedida, ")
                .append("secciones, ")
                .append("lados, ")
                .append("segmentos, ")
                .append("niveles, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _almObj.getCodigo());
        st.setString(2, _almObj.getNombreCompleto());
        st.setString(3, _almObj.getDescripcion());
        st.setInt(4, _almObj.getTpAlmacen().getId());
        st.setDouble(5, _almObj.getCapacidad());
        st.setInt(6, _almObj.getUndMedida().getId());
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

        almacen _almObj = (almacen) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbalmacen ")
                .append("SET ")
                .append("codigo = ?, ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idtipoAlmacen = ?, ")
                .append("capacidad = ?, ")
                .append("idunidadMedida = ?, ")
                .append("secciones = ?, ")
                .append("lados = ?, ")
                .append("segmentos = ?, ")
                .append("niveles = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _almObj.getCodigo());
        st.setString(2, _almObj.getNombreCompleto());
        st.setString(3, _almObj.getDescripcion());
        st.setInt(4, _almObj.getTpAlmacen().getId());
        st.setDouble(5, _almObj.getCapacidad());
        st.setInt(6, _almObj.getUndMedida().getId());
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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbalmacen SET idEstado = 3 WHERE id = ?;");

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

        almacen _almacenesObj;

        List<almacen> _listaalmacen = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbalmacen.id AS 'id', ")
                .append("    dbalmacen.codigo AS 'codigo', ")
                .append("    dbalmacen.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbalmacen.descripcion AS 'descripcion', ")
                .append("    dbalmacen.idtipoAlmacen AS 'idtipoAlmacen', ")
                .append("    dbtipoAlmacen.nombreCompleto AS 'nombreTipoAlmacen', ")
                .append("    dbalmacen.capacidad AS 'capacidad', ")
                .append("    dbalmacen.idunidadMedida AS 'idunidadMedida', ")
                .append("    dbunidadMedida.nombreCompleto AS 'nombreUnidadMedida', ")
                .append("    dbalmacen.secciones AS 'secciones', ")
                .append("    dbalmacen.lados AS 'lados', ")
                .append("    dbalmacen.segmentos AS 'segmentos', ")
                .append("    dbalmacen.niveles AS 'niveles', ")
                .append("    dbalmacen.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbalmacen ")
                .append("        LEFT JOIN ")
                .append("    dbtipoAlmacen ON dbtipoAlmacen.id = dbalmacen.idtipoAlmacen ")
                .append("        LEFT JOIN ")
                .append("    dbunidadMedida ON dbunidadMedida.id = dbalmacen.idunidadMedida ")
                .append("WHERE ")
                .append("    dbalmacen.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _almacenesObj = new almacen();

                _almacenesObj.setId(rs.getInt(1));
                _almacenesObj.setCodigo(rs.getString(2));
                _almacenesObj.setNombreCompleto(rs.getString(3));
                _almacenesObj.setDescripcion(rs.getString(4));

                tipoAlmacen _tpAlmacen = new tipoAlmacen();
                _tpAlmacen.setId(rs.getInt(5));
                _tpAlmacen.setNombreCompleto(rs.getString(6));
                _almacenesObj.setTpAlmacen(_tpAlmacen);

                _almacenesObj.setCapacidad(rs.getDouble(7));

                unidadMedida _undMedida = new unidadMedida();
                _undMedida.setId(rs.getInt(8));
                _undMedida.setNombreCompleto(rs.getString(9));

                _almacenesObj.setUndMedida(_undMedida);

                _almacenesObj.setSecciones(rs.getInt(10));
                _almacenesObj.setLados(rs.getInt(11));
                _almacenesObj.setSegmentos(rs.getInt(12));
                _almacenesObj.setNiveles(rs.getInt(13));
                _almacenesObj.setIdEstado(rs.getInt(14));

                _listaalmacen.add(_almacenesObj);
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

        return _listaalmacen;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        almacen _almacenesObj;

        List<almacen> _listaAlmacen = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbalmacen.id AS 'id', ")
                .append("    dbalmacen.codigo AS 'codigo', ")
                .append("    dbalmacen.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbalmacen.descripcion AS 'descripcion', ")
                .append("    dbalmacen.idtipoAlmacen AS 'idtipoAlmacen', ")
                .append("    dbtipoAlmacen.nombreCompleto AS 'nombreTipoAlmacen', ")
                .append("    dbalmacen.capacidad AS 'capacidad', ")
                .append("    dbalmacen.idunidadMedida AS 'idunidadMedida', ")
                .append("    dbunidadMedida.nombreCompleto AS 'nombreUnidadMedida', ")
                .append("    dbalmacen.secciones AS 'secciones', ")
                .append("    dbalmacen.lados AS 'lados', ")
                .append("    dbalmacen.segmentos AS 'segmentos', ")
                .append("    dbalmacen.niveles AS 'niveles', ")
                .append("    dbalmacen.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbalmacen ")
                .append("        LEFT JOIN ")
                .append("    dbtipoAlmacen ON dbtipoAlmacen.id = dbalmacen.idtipoAlmacen ")
                .append("        LEFT JOIN ")
                .append("    dbunidadMedida ON dbunidadMedida.id = dbalmacen.idunidadMedida ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbalmacen.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _almacenesObj = new almacen();

                _almacenesObj.setId(rs.getInt(1));
                _almacenesObj.setCodigo(rs.getString(2));
                _almacenesObj.setNombreCompleto(rs.getString(3));
                _almacenesObj.setDescripcion(rs.getString(4));

                tipoAlmacen _tpAlmacen = new tipoAlmacen();
                _tpAlmacen.setId(rs.getInt(5));
                _tpAlmacen.setNombreCompleto(rs.getString(6));
                _almacenesObj.setTpAlmacen(_tpAlmacen);

                _almacenesObj.setCapacidad(rs.getDouble(7));

                unidadMedida _undMedida = new unidadMedida();
                _undMedida.setId(rs.getInt(8));
                _undMedida.setNombreCompleto(rs.getString(9));

                _almacenesObj.setUndMedida(_undMedida);

                _almacenesObj.setSecciones(rs.getInt(10));
                _almacenesObj.setLados(rs.getInt(11));
                _almacenesObj.setSegmentos(rs.getInt(12));
                _almacenesObj.setNiveles(rs.getInt(13));
                _almacenesObj.setIdEstado(rs.getInt(14));

                _listaAlmacen.add(_almacenesObj);
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

        return _listaAlmacen;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        almacen _almacenesObj = new almacen();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbalmacen.id AS 'id', ")
                .append("    dbalmacen.codigo AS 'codigo', ")
                .append("    dbalmacen.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbalmacen.descripcion AS 'descripcion', ")
                .append("    dbalmacen.idtipoAlmacen AS 'idtipoAlmacen', ")
                .append("    dbtipoAlmacen.nombreCompleto AS 'nombreTipoAlmacen', ")
                .append("    dbalmacen.capacidad AS 'capacidad', ")
                .append("    dbalmacen.idunidadMedida AS 'idunidadMedida', ")
                .append("    dbunidadMedida.nombreCompleto AS 'nombreUnidadMedida', ")
                .append("    dbalmacen.secciones AS 'secciones', ")
                .append("    dbalmacen.lados AS 'lados', ")
                .append("    dbalmacen.segmentos AS 'segmentos', ")
                .append("    dbalmacen.niveles AS 'niveles', ")
                .append("    dbalmacen.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbalmacen ")
                .append("        LEFT JOIN ")
                .append("    dbtipoAlmacen ON dbtipoAlmacen.id = dbalmacen.idtipoAlmacen ")
                .append("        LEFT JOIN ")
                .append("    dbunidadMedida ON dbunidadMedida.id = dbalmacen.idunidadMedida ")
                .append("WHERE dbalmacen.id = ")
                .append(id)
                .append(" AND dbalmacen.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _almacenesObj.setId(rs.getInt(1));
                _almacenesObj.setCodigo(rs.getString(2));
                _almacenesObj.setNombreCompleto(rs.getString(3));
                _almacenesObj.setDescripcion(rs.getString(4));

                tipoAlmacen _tpAlmacen = new tipoAlmacen();
                _tpAlmacen.setId(rs.getInt(5));
                _tpAlmacen.setNombreCompleto(rs.getString(6));
                _almacenesObj.setTpAlmacen(_tpAlmacen);

                _almacenesObj.setCapacidad(rs.getDouble(7));

                unidadMedida _undMedida = new unidadMedida();
                _undMedida.setId(rs.getInt(8));
                _undMedida.setNombreCompleto(rs.getString(9));

                _almacenesObj.setUndMedida(_undMedida);

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
