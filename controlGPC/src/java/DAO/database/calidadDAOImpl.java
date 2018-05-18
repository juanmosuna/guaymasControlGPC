/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.calidad;
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
public class calidadDAOImpl implements catalogosInterface {

    private Connection _conn;

    public calidadDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        calidad _calidadesObj = (calidad) o;

        String _consulta = "INSERT INTO gpcControl.dbcalidad "
                + "(codigo, "
                + "nombreCompleto, "
                + "descripcion, "
                + "idgrupoCalidad, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _calidadesObj.getCodigo());
        st.setString(2, _calidadesObj.getNombreCompleto());
        st.setString(3, _calidadesObj.getDescripcion());
        st.setInt(4, _calidadesObj.getIdgrupoCalidad());
        st.setInt(5, _calidadesObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        calidad _calidadesObj = (calidad) o;

        String _consulta = "UPDATE gpcControl.dbcalidad "
                + "SET "
                + "codigo = ?, "
                + "nombreCompleto = ?, "
                + "descripcion = ?, "
                + "idgrupoCalidad = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _calidadesObj.getCodigo());
        st.setString(2, _calidadesObj.getNombreCompleto());
        st.setString(3, _calidadesObj.getDescripcion());
        st.setInt(4, _calidadesObj.getIdgrupoCalidad());
        st.setInt(5, _calidadesObj.getIdEstado());

        st.setInt(6, _calidadesObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dbcalidad SET idEstado = 3 WHERE id = ?;";

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

        calidad _calidadesObj;

        List<calidad> _listacalidad = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbcalidad.id AS 'id', "
                + "    dbcalidad.codigo AS 'codigo', "
                + "    dbcalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dbcalidad.descripcion AS 'descripcion', "
                + "    dbcalidad.idgrupoCalidad AS 'idgrupoCalidad', "
                + "    dbgrupoCalidad.nombreCompleto AS 'nombreGrupoCalidad', "
                + "    dbcalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbcalidad "
                + "        LEFT JOIN "
                + "    dbgrupoCalidad ON dbgrupoCalidad.id = dbcalidad.idgrupoCalidad "
                + "WHERE "
                + "    dbcalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesObj = new calidad();

                _calidadesObj.setId(rs.getInt(1));
                _calidadesObj.setCodigo(rs.getString(2));
                _calidadesObj.setNombreCompleto(rs.getString(3));
                _calidadesObj.setDescripcion(rs.getString(4));
                _calidadesObj.setIdgrupoCalidad(rs.getInt(5));
                _calidadesObj.setNombreGrupoCalidad(rs.getString(6));
                _calidadesObj.setIdEstado(rs.getInt(7));

                _listacalidad.add(_calidadesObj);
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

        return _listacalidad;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        calidad _calidadesObj;

        List<calidad> _listacalidad = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbcalidad.id AS 'id', "
                + "    dbcalidad.codigo AS 'codigo', "
                + "    dbcalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dbcalidad.descripcion AS 'descripcion', "
                + "    dbcalidad.idgrupoCalidad AS 'idgrupoCalidad', "
                + "    dbgrupoCalidad.nombreCompleto AS 'nombreGrupoCalidad', "
                + "    dbcalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbcalidad "
                + "        LEFT JOIN "
                + "    dbgrupoCalidad ON dbgrupoCalidad.id = dbcalidad.idgrupoCalidad "
                + "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbcalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesObj = new calidad();

                _calidadesObj.setId(rs.getInt(1));
                _calidadesObj.setCodigo(rs.getString(2));
                _calidadesObj.setNombreCompleto(rs.getString(3));
                _calidadesObj.setDescripcion(rs.getString(4));
                _calidadesObj.setIdgrupoCalidad(rs.getInt(5));
                _calidadesObj.setNombreGrupoCalidad(rs.getString(6));
                _calidadesObj.setIdEstado(rs.getInt(7));

                _listacalidad.add(_calidadesObj);
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

        return _listacalidad;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        calidad _calidadesObj = new calidad();

        String _consulta = "SELECT  "
                + "    dbcalidad.id AS 'id', "
                + "    dbcalidad.codigo AS 'codigo', "
                + "    dbcalidad.nombreCompleto AS 'nombreCompleto', "
                + "    dbcalidad.descripcion AS 'descripcion', "
                + "    dbcalidad.idgrupoCalidad AS 'idgrupoCalidad', "
                + "    dbgrupoCalidad.nombreCompleto AS 'nombreGrupoCalidad', "
                + "    dbcalidad.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbcalidad "
                + "        LEFT JOIN "
                + "    dbgrupoCalidad ON dbgrupoCalidad.id = dbcalidad.idgrupoCalidad "
                + "WHERE dbcalidad.id = " + id + " AND dbcalidad.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesObj.setId(rs.getInt(1));
                _calidadesObj.setCodigo(rs.getString(2));
                _calidadesObj.setNombreCompleto(rs.getString(3));
                _calidadesObj.setDescripcion(rs.getString(4));
                _calidadesObj.setIdgrupoCalidad(rs.getInt(5));
                _calidadesObj.setNombreGrupoCalidad(rs.getString(6));
                _calidadesObj.setIdEstado(rs.getInt(7));

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

        return _calidadesObj;
    }

}
