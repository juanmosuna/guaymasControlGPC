/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.departamento;
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
public class departamentoDAOImpl implements catalogosInterface {

    private Connection _conn;

    public departamentoDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        departamento _dptosObj = (departamento) o;
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbdepartamento " )
                .append("(nombreCompleto, " )
                .append("descripcion, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _dptosObj.getNombreCompleto());
        st.setString(2, _dptosObj.getDescripcion());
        st.setInt(3, _dptosObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        departamento _dptosObj = (departamento) o;
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbdepartamento ")
                .append("SET ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _dptosObj.getNombreCompleto());
        st.setString(2, _dptosObj.getDescripcion());
        st.setInt(3, _dptosObj.getIdEstado());

        st.setInt(4, _dptosObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("UPDATE controlGPC.dbdepartamento SET idEstado = 3 WHERE id = ?;");

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

        departamento _dptoObj;

        List<departamento> _listadepartamento = new ArrayList();

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT  ")
                .append("    dbdepartamento.id AS 'id', ")
                .append("    dbdepartamento.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbdepartamento.descripcion AS 'descripcion', ")
                .append("    dbdepartamento.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbdepartamento WHERE dbdepartamento.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _dptoObj = new departamento();

                _dptoObj.setId(rs.getInt(1));
                _dptoObj.setNombreCompleto(rs.getString(2));
                _dptoObj.setDescripcion(rs.getString(3));
                _dptoObj.setIdEstado(rs.getInt(4));

                _listadepartamento.add(_dptoObj);
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

        return _listadepartamento;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        departamento _dptoObj;

        List<departamento> _listadepartamento = new ArrayList();
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbdepartamento.id AS 'id', ")
                .append("    dbdepartamento.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbdepartamento.descripcion AS 'descripcion', ")
                .append("    dbdepartamento.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbdepartamento WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbdepartamento.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _dptoObj = new departamento();

                _dptoObj.setId(rs.getInt(1));
                _dptoObj.setNombreCompleto(rs.getString(2));
                _dptoObj.setDescripcion(rs.getString(3));
                _dptoObj.setIdEstado(rs.getInt(4));

                _listadepartamento.add(_dptoObj);
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

        return _listadepartamento;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        departamento _dptoObj = new departamento();
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbdepartamento.id AS 'id', ")
                .append("    dbdepartamento.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbdepartamento.descripcion AS 'descripcion', ")
                .append("    dbdepartamento.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbdepartamento WHERE dbdepartamento.id = ")
                .append(id)
                .append(" AND dbdepartamento.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _dptoObj.setId(rs.getInt(1));
                _dptoObj.setNombreCompleto(rs.getString(2));
                _dptoObj.setDescripcion(rs.getString(3));
                _dptoObj.setIdEstado(rs.getInt(4));

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

        return _dptoObj;
    }

}
