/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.empresa;
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
public class empresaDAOImpl implements catalogosInterface {

    private Connection _conn;

    public empresaDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        empresa _empresasObj = (empresa) o;

        String _consulta = "INSERT INTO gpcControl.dbempresa "
                + "(nombreCompleto, "
                + "descripcion, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _empresasObj.getNombreCompleto());
        st.setString(2, _empresasObj.getDescripcion());
        st.setInt(3, _empresasObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        empresa _empresasObj = (empresa) o;

        String _consulta = "UPDATE gpcControl.dbempresa "
                + "SET "
                + "nombreCompleto = ?, "
                + "descripcion = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _empresasObj.getNombreCompleto());
        st.setString(2, _empresasObj.getDescripcion());
        st.setInt(3, _empresasObj.getIdEstado());

        st.setInt(4, _empresasObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE gpcControl.dbempresa SET idEstado = 3 WHERE id = ?;";

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

        empresa _empresasObj;

        List<empresa> _listaempresa = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbempresa.id AS 'id', "
                + "    dbempresa.nombreCompleto AS 'nombreCompleto', "
                + "    dbempresa.descripcion AS 'descripcion', "
                + "    dbempresa.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbempresa WHERE dbempresa.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _empresasObj = new empresa();

                _empresasObj.setId(rs.getInt(1));
                _empresasObj.setNombreCompleto(rs.getString(2));
                _empresasObj.setDescripcion(rs.getString(3));
                _empresasObj.setIdEstado(rs.getInt(4));

                _listaempresa.add(_empresasObj);
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

        return _listaempresa;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        empresa _empresasObj;

        List<empresa> _listaempresa = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbempresa.id AS 'id', "
                + "    dbempresa.nombreCompleto AS 'nombreCompleto', "
                + "    dbempresa.descripcion AS 'descripcion', "
                + "    dbempresa.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbempresa WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbempresa.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _empresasObj = new empresa();

                _empresasObj.setId(rs.getInt(1));
                _empresasObj.setNombreCompleto(rs.getString(2));
                _empresasObj.setDescripcion(rs.getString(3));
                _empresasObj.setIdEstado(rs.getInt(4));

                _listaempresa.add(_empresasObj);
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

        return _listaempresa;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        empresa _empresasObj = new empresa();

        String _consulta = "SELECT  "
                + "    dbempresa.id AS 'id', "
                + "    dbempresa.nombreCompleto AS 'nombreCompleto', "
                + "    dbempresa.descripcion AS 'descripcion', "
                + "    dbempresa.idEstado AS 'idEstado' "
                + "FROM "
                + "    gpcControl.dbempresa WHERE dbempresa.id = " + id + " AND dbempresa.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _empresasObj.setId(rs.getInt(1));
                _empresasObj.setNombreCompleto(rs.getString(2));
                _empresasObj.setDescripcion(rs.getString(3));
                _empresasObj.setIdEstado(rs.getInt(4));

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

        return _empresasObj;
    }

}
