/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.calidad;
import entity.grupoCalidad;
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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbcalidad ")
                .append("(codigo, ")
                .append("nombreCompleto, ")
                .append("descripcion, ")
                .append("idgrupoCalidad, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _calidadesObj.getCodigo());
        st.setString(2, _calidadesObj.getNombreCompleto());
        st.setString(3, _calidadesObj.getDescripcion());
        st.setInt(4, _calidadesObj.getGrpCalidad().getId());
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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbcalidad ")
                .append("SET ")
                .append("codigo = ?, ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("idgrupoCalidad = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _calidadesObj.getCodigo());
        st.setString(2, _calidadesObj.getNombreCompleto());
        st.setString(3, _calidadesObj.getDescripcion());
        st.setInt(4, _calidadesObj.getGrpCalidad().getId());
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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbcalidad SET idEstado = 3 WHERE id = ?;");

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

        calidad _calidadesObj;

        List<calidad> _listacalidad = new ArrayList();

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT  ")
                .append("    dbcalidad.id AS 'id', ")
                .append("    dbcalidad.codigo AS 'codigo', ")
                .append("    dbcalidad.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcalidad.descripcion AS 'descripcion', ")
                .append("    dbcalidad.idgrupoCalidad AS 'idgrupoCalidad', ")
                .append("    dbgrupoCalidad.nombreCompleto AS 'nombreGrupoCalidad', ")
                .append("    dbcalidad.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcalidad ")
                .append("        LEFT JOIN ")
                .append("    dbgrupoCalidad ON dbgrupoCalidad.id = dbcalidad.idgrupoCalidad ")
                .append("WHERE ")
                .append("    dbcalidad.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesObj = new calidad();

                _calidadesObj.setId(rs.getInt(1));
                _calidadesObj.setCodigo(rs.getString(2));
                _calidadesObj.setNombreCompleto(rs.getString(3));
                _calidadesObj.setDescripcion(rs.getString(4));
                
                grupoCalidad _grpCalidad = new grupoCalidad();
                _grpCalidad.setId(rs.getInt(5));
                _grpCalidad.setNombreCompleto(rs.getString(6));
                _calidadesObj.setGrpCalidad(_grpCalidad);
                
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
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbcalidad.id AS 'id', ")
                .append("    dbcalidad.codigo AS 'codigo', ")
                .append("    dbcalidad.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcalidad.descripcion AS 'descripcion', ")
                .append("    dbcalidad.idgrupoCalidad AS 'idgrupoCalidad', ")
                .append("    dbgrupoCalidad.nombreCompleto AS 'nombreGrupoCalidad', ")
                .append("    dbcalidad.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcalidad ")
                .append("        LEFT JOIN ")
                .append("    dbgrupoCalidad ON dbgrupoCalidad.id = dbcalidad.idgrupoCalidad ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbcalidad.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesObj = new calidad();

                _calidadesObj.setId(rs.getInt(1));
                _calidadesObj.setCodigo(rs.getString(2));
                _calidadesObj.setNombreCompleto(rs.getString(3));
                _calidadesObj.setDescripcion(rs.getString(4));
                
                grupoCalidad _grpCalidad = new grupoCalidad();
                _grpCalidad.setId(rs.getInt(5));
                _grpCalidad.setNombreCompleto(rs.getString(6));
                _calidadesObj.setGrpCalidad(_grpCalidad);
                
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

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT  ")
                .append("    dbcalidad.id AS 'id', ")
                .append("    dbcalidad.codigo AS 'codigo', ")
                .append("    dbcalidad.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcalidad.descripcion AS 'descripcion', ")
                .append("    dbcalidad.idgrupoCalidad AS 'idgrupoCalidad', ")
                .append("    dbgrupoCalidad.nombreCompleto AS 'nombreGrupoCalidad', ")
                .append("    dbcalidad.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcalidad ")
                .append("        LEFT JOIN ")
                .append("    dbgrupoCalidad ON dbgrupoCalidad.id = dbcalidad.idgrupoCalidad ")
                .append("WHERE dbcalidad.id = ")
                .append(id)
                .append(" AND dbcalidad.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _calidadesObj.setId(rs.getInt(1));
                _calidadesObj.setCodigo(rs.getString(2));
                _calidadesObj.setNombreCompleto(rs.getString(3));
                _calidadesObj.setDescripcion(rs.getString(4));
                
                grupoCalidad _grpCalidad = new grupoCalidad();
                _grpCalidad.setId(rs.getInt(5));
                _grpCalidad.setNombreCompleto(rs.getString(6));
                _calidadesObj.setGrpCalidad(_grpCalidad);
                
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
