/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.calidadNota;
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
public class calidadNotaDAOImpl implements catalogosInterface {

    private Connection _conn;

    public calidadNotaDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        calidadNota _calidadesNotaObj = (calidadNota) o;

        String _consulta = "INSERT INTO gpcControl.dbcalidadesNota "
                + "(idDocumentacion, "
                + "idCalidad, "
                + "porcentajeCalidad, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setInt(1, _calidadesNotaObj.getIdDocumentacion());
        st.setInt(2, _calidadesNotaObj.getIdCalidad());
        st.setDouble(3, _calidadesNotaObj.getPorcentajeCalidad());
        st.setInt(4, _calidadesNotaObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        calidadNota _calidadesNotaObj = (calidadNota) o;

        String _consulta = "UPDATE gpcControl.dbcalidadesNota "
                + "SET "
                + "idDocumentacion = ?, "
                + "idCalidad = ?, "
                + "porcentajeCalidad = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setInt(1, _calidadesNotaObj.getIdDocumentacion());
        st.setInt(2, _calidadesNotaObj.getIdCalidad());
        st.setDouble(3, _calidadesNotaObj.getPorcentajeCalidad());
        st.setInt(4, _calidadesNotaObj.getIdEstado());

        st.setInt(5, _calidadesNotaObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dbcalidadesNota SET idEstado = 3 WHERE id = ?;";

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

        calidadNota _calidadesNotaObj;

        List<calidadNota> _listacalidadNota = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbcalidadesNota.id AS 'id', "
                + "    dbcalidadesNota.idDocumentacion AS 'idDocumentacion', "
                + "    dbcalidadesNota.idCalidad AS 'idCalidad', "
                + "    dbcalidad.nombreCompleto AS 'nombreCalidad', "
                + "    dbcalidadesNota.porcentajeCalidad AS 'porcentajeCalidad', "
                + "    dbcalidadesNota.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbcalidadesNota "
                + "        LEFT JOIN "
                + "    dbcalidad ON dbcalidad.id = dbcalidadesNota.id "
                + "WHERE "
                + "    dbcalidadesNota.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesNotaObj = new calidadNota();

                _calidadesNotaObj.setId(rs.getInt(1));
                _calidadesNotaObj.setIdDocumentacion(rs.getInt(2));
                _calidadesNotaObj.setIdCalidad(rs.getInt(3));
                _calidadesNotaObj.setNombreCalidad(rs.getString(4));
                _calidadesNotaObj.setPorcentajeCalidad(rs.getDouble(5));
                _calidadesNotaObj.setIdEstado(rs.getInt(6));

                _listacalidadNota.add(_calidadesNotaObj);
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

        return _listacalidadNota;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        calidadNota _calidadesNotaObj;

        List<calidadNota> _listacalidadNota = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbcalidadesNota.id AS 'id', "
                + "    dbcalidadesNota.idDocumentacion AS 'idDocumentacion', "
                + "    dbcalidadesNota.idCalidad AS 'idCalidad', "
                + "    dbcalidad.nombreCompleto AS 'nombreCalidad', "
                + "    dbcalidadesNota.porcentajeCalidad AS 'porcentajeCalidad', "
                + "    dbcalidadesNota.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbcalidadesNota "
                + "        LEFT JOIN "
                + "    dbcalidad ON dbcalidad.id = dbcalidadesNota.id "
                + "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbcalidadesNota.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesNotaObj = new calidadNota();

                _calidadesNotaObj.setId(rs.getInt(1));
                _calidadesNotaObj.setIdDocumentacion(rs.getInt(2));
                _calidadesNotaObj.setIdCalidad(rs.getInt(3));
                _calidadesNotaObj.setNombreCalidad(rs.getString(4));
                _calidadesNotaObj.setPorcentajeCalidad(rs.getDouble(5));
                _calidadesNotaObj.setIdEstado(rs.getInt(6));

                _listacalidadNota.add(_calidadesNotaObj);
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

        return _listacalidadNota;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        calidadNota _calidadesNotaObj = new calidadNota();

        String _consulta = "SELECT  "
                + "    dbcalidadesNota.id AS 'id', "
                + "    dbcalidadesNota.idDocumentacion AS 'idDocumentacion', "
                + "    dbcalidadesNota.idCalidad AS 'idCalidad', "
                + "    dbcalidad.nombreCompleto AS 'nombreCalidad', "
                + "    dbcalidadesNota.porcentajeCalidad AS 'porcentajeCalidad', "
                + "    dbcalidadesNota.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbcalidadesNota "
                + "        LEFT JOIN "
                + "    dbcalidad ON dbcalidad.id = dbcalidadesNota.id "
                + "WHERE dbcalidadesNota.id = " + id + " AND dbcalidadesNota.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesNotaObj.setId(rs.getInt(1));
                _calidadesNotaObj.setIdDocumentacion(rs.getInt(2));
                _calidadesNotaObj.setIdCalidad(rs.getInt(3));
                _calidadesNotaObj.setNombreCalidad(rs.getString(4));
                _calidadesNotaObj.setPorcentajeCalidad(rs.getDouble(5));
                _calidadesNotaObj.setIdEstado(rs.getInt(6));

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

        return _calidadesNotaObj;
    }

}
