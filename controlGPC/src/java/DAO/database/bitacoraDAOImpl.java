/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.bitacora;
import entity.tipoMovimiento;
import entity.usuario;
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
public class bitacoraDAOImpl implements catalogosInterface {

    private Connection _conn;

    public bitacoraDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        bitacora _bitacoraObj = (bitacora) o;

        String _consulta = "INSERT INTO controlGPC.dbbitacora "
                + "(tabla, "
                + "idTipoMovimiento, "
                + "comentario, "
                + "idUsuario, "
                + "fechaHora, "
                + "idEstado) "
                + "VALUES "
                + "(?, ?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _bitacoraObj.getTabla());
        st.setInt(2, _bitacoraObj.getTpMovimiento().getId());
        st.setString(3, _bitacoraObj.getComentario());
        st.setInt(4, _bitacoraObj.getUsuario().getId());
        st.setString(5, _bitacoraObj.getFechaHora());
        st.setInt(6, _bitacoraObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        bitacora _bitacoraObj = (bitacora) o;

        String _consulta = "UPDATE controlGPC.dbbitacora "
                + "SET "
                + "tabla = ?, "
                + "idTipoMovimiento = ?, "
                + "comentario = ?, "
                + "idUsuario = ?, "
                + "fechaHora = ?, "
                + "idEstado = ? "
                + "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _bitacoraObj.getTabla());
        st.setInt(2, _bitacoraObj.getTpMovimiento().getId());
        st.setString(3, _bitacoraObj.getComentario());
        st.setInt(4, _bitacoraObj.getUsuario().getId());
        st.setString(5, _bitacoraObj.getFechaHora());
        st.setInt(6, _bitacoraObj.getIdEstado());

        st.setInt(7, _bitacoraObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE controlGPC.dbbitacora SET idEstado = 3 WHERE id = ?;";

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

        bitacora _bitacoraObj;

        List<bitacora> _listaBitacora = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbbitacora.id AS 'id', "
                + "    dbbitacora.tabla AS 'tabla', "
                + "    dbbitacora.idTipoMovimiento AS 'idTipoMovimiento', "
                + "    dbtipoMovimiento.nombreCompleto AS 'nombreTipoMovimiento', "
                + "    dbbitacora.comentario AS 'comentario', "
                + "    dbbitacora.idUsuario AS 'idUsuario', "
                + "    dbusuario.nombreCompleto AS 'nombreUsuario', "
                + "    dbbitacora.fechaHora AS 'fechaHora', "
                + "    dbbitacora.idEstado AS 'idEstado' "
                + "FROM "
                + "    controlGPC.dbbitacora "
                + "        LEFT JOIN "
                + "    dbtipoMovimiento ON dbtipoMovimiento.id = dbbitacora.idTipoMovimiento "
                + "        LEFT JOIN "
                + "    dbusuario ON dbusuario.id = dbbitacora.idUsuario "
                + "WHERE "
                + "    dbbitacora.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _bitacoraObj = new bitacora();

                _bitacoraObj.setId(rs.getInt(1));
                _bitacoraObj.setTabla(rs.getString(2));

                tipoMovimiento _tpMovimiento = new tipoMovimiento();

                _tpMovimiento.setId(rs.getInt(3));
                _tpMovimiento.setNombreCompleto(rs.getString(4));
                _bitacoraObj.setTpMovimiento(_tpMovimiento);

                _bitacoraObj.setComentario(rs.getString(5));

                usuario _usuario = new usuario();

                _usuario.setId(rs.getInt(6));
                _usuario.setNombreCompleto(rs.getString(7));

                _bitacoraObj.setUsuario(_usuario);

                _bitacoraObj.setFechaHora(rs.getString(8));
                _bitacoraObj.setIdEstado(rs.getInt(9));

                _listaBitacora.add(_bitacoraObj);
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

        return _listaBitacora;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        bitacora _bitacoraObj;

        List<bitacora> _listaBitacora = new ArrayList();

        String _consulta = "SELECT  "
                + "    dbbitacora.id AS 'id', "
                + "    dbbitacora.tabla AS 'tabla', "
                + "    dbbitacora.idTipoMovimiento AS 'idTipoMovimiento', "
                + "    dbtipoMovimiento.nombreCompleto AS 'nombreTipoMovimiento', "
                + "    dbbitacora.comentario AS 'comentario', "
                + "    dbbitacora.idUsuario AS 'idUsuario', "
                + "    dbusuario.nombreCompleto AS 'nombreUsuario', "
                + "    dbbitacora.fechaHora AS 'fechaHora', "
                + "    dbbitacora.idEstado AS 'idEstado' "
                + "FROM "
                + "    controlGPC.dbbitacora "
                + "        LEFT JOIN "
                + "    dbtipoMovimiento ON dbtipoMovimiento.id = dbbitacora.idTipoMovimiento "
                + "        LEFT JOIN "
                + "    dbusuario ON dbusuario.id = dbbitacora.idUsuario "
                + "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbbitacora.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _bitacoraObj = new bitacora();

                _bitacoraObj.setId(rs.getInt(1));
                _bitacoraObj.setTabla(rs.getString(2));

                tipoMovimiento _tpMovimiento = new tipoMovimiento();

                _tpMovimiento.setId(rs.getInt(3));
                _tpMovimiento.setNombreCompleto(rs.getString(4));
                _bitacoraObj.setTpMovimiento(_tpMovimiento);

                _bitacoraObj.setComentario(rs.getString(5));

                usuario _usuario = new usuario();

                _usuario.setId(rs.getInt(6));
                _usuario.setNombreCompleto(rs.getString(7));

                _bitacoraObj.setUsuario(_usuario);

                _bitacoraObj.setFechaHora(rs.getString(8));
                _bitacoraObj.setIdEstado(rs.getInt(9));

                _listaBitacora.add(_bitacoraObj);
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

        return _listaBitacora;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        bitacora _bitacoraObj = new bitacora();

        String _consulta = "SELECT  "
                + "    dbbitacora.id AS 'id', "
                + "    dbbitacora.tabla AS 'tabla', "
                + "    dbbitacora.idTipoMovimiento AS 'idTipoMovimiento', "
                + "    dbtipoMovimiento.nombreCompleto AS 'nombreTipoMovimiento', "
                + "    dbbitacora.comentario AS 'comentario', "
                + "    dbbitacora.idUsuario AS 'idUsuario', "
                + "    dbusuario.nombreCompleto AS 'nombreUsuario', "
                + "    dbbitacora.fechaHora AS 'fechaHora', "
                + "    dbbitacora.idEstado AS 'idEstado' "
                + "FROM "
                + "    controlGPC.dbbitacora "
                + "        LEFT JOIN "
                + "    dbtipoMovimiento ON dbtipoMovimiento.id = dbbitacora.idTipoMovimiento "
                + "        LEFT JOIN "
                + "    dbusuario ON dbusuario.id = dbbitacora.idUsuario "
                + "WHERE dbbitacora.id = " + id + " AND dbbitacora.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _bitacoraObj.setId(rs.getInt(1));
                _bitacoraObj.setTabla(rs.getString(2));

                tipoMovimiento _tpMovimiento = new tipoMovimiento();

                _tpMovimiento.setId(rs.getInt(3));
                _tpMovimiento.setNombreCompleto(rs.getString(4));
                _bitacoraObj.setTpMovimiento(_tpMovimiento);

                _bitacoraObj.setComentario(rs.getString(5));

                usuario _usuario = new usuario();

                _usuario.setId(rs.getInt(6));
                _usuario.setNombreCompleto(rs.getString(7));

                _bitacoraObj.setUsuario(_usuario);

                _bitacoraObj.setFechaHora(rs.getString(8));
                _bitacoraObj.setIdEstado(rs.getInt(9));

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

        return _bitacoraObj;
    }

}
