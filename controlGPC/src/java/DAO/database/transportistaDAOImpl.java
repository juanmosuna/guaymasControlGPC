/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.transportista;
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
public class transportistaDAOImpl implements catalogosInterface {

    private Connection _conn;

    public transportistaDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        transportista _transportistaObj = (transportista) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbtransportista ")
                .append("(nombreCompleto, ")
                .append("descripcion, ")
                .append("domicilio, ")
                .append("codigoPostal, ")
                .append("localidad, ")
                .append("ciudad, ")
                .append("estado, ")
                .append("pais, ")
                .append("telefono, ")
                .append("mobile, ")
                .append("fax, ")
                .append("correoElectronico, ")
                .append("paginaWeb, ")
                .append("fotoTransportista, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _transportistaObj.getNombreCompleto());
        st.setString(2, _transportistaObj.getDescripcion());
        st.setString(3, _transportistaObj.getDomicilio());
        st.setString(4, _transportistaObj.getCodigoPostal());
        st.setString(5, _transportistaObj.getLocalidad());
        st.setString(6, _transportistaObj.getCiudad());
        st.setString(7, _transportistaObj.getEstado());
        st.setString(8, _transportistaObj.getPais());
        st.setString(9, _transportistaObj.getTelefono());
        st.setString(10, _transportistaObj.getMobile());
        st.setString(11, _transportistaObj.getFax());
        st.setString(12, _transportistaObj.getCorreoElectronico());
        st.setString(13, _transportistaObj.getPaginaWeb());
        st.setString(14, javax.xml.bind.DatatypeConverter.printBase64Binary(_transportistaObj.getFotoTransportista()));
        st.setInt(15, _transportistaObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        transportista _transportistaObj = (transportista) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbtransportista ")
                .append("SET ")
                .append("nombreCompleto = ?, ")
                .append("descripcion = ?, ")
                .append("domicilio = ?, ")
                .append("codigoPostal = ?, ")
                .append("localidad = ?, ")
                .append("ciudad = ?, ")
                .append("estado = ?, ")
                .append("pais = ?, ")
                .append("telefono = ?, ")
                .append("mobile = ?, ")
                .append("fax = ?, ")
                .append("correoElectronico = ?, ")
                .append("paginaWeb = ?, ")
                .append("fotoTransportista = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _transportistaObj.getNombreCompleto());
        st.setString(2, _transportistaObj.getDescripcion());
        st.setString(3, _transportistaObj.getDomicilio());
        st.setString(4, _transportistaObj.getCodigoPostal());
        st.setString(5, _transportistaObj.getLocalidad());
        st.setString(6, _transportistaObj.getCiudad());
        st.setString(7, _transportistaObj.getEstado());
        st.setString(8, _transportistaObj.getPais());
        st.setString(9, _transportistaObj.getTelefono());
        st.setString(10, _transportistaObj.getMobile());
        st.setString(11, _transportistaObj.getFax());
        st.setString(12, _transportistaObj.getCorreoElectronico());
        st.setString(13, _transportistaObj.getPaginaWeb());
        st.setString(14, javax.xml.bind.DatatypeConverter.printBase64Binary(_transportistaObj.getFotoTransportista()));
        st.setInt(15, _transportistaObj.getIdEstado());

        st.setInt(16, _transportistaObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbtransportista SET idEstado = 3 WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setInt(1, 1);

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public Object consultarTodos() throws Exception {

        transportista _transportistaObj;

        List<transportista> _listaTransportista = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtransportista.id AS 'id', ")
                .append("    dbtransportista.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtransportista.descripcion AS 'descripcion', ")
                .append("    dbtransportista.domicilio AS 'domicilio', ")
                .append("    dbtransportista.codigoPostal AS 'codigoPostal', ")
                .append("    dbtransportista.localidad AS 'localidad', ")
                .append("    dbtransportista.ciudad AS 'ciudad', ")
                .append("    dbtransportista.estado AS 'estado', ")
                .append("    dbtransportista.pais AS 'pais', ")
                .append("    dbtransportista.telefono AS 'telefono', ")
                .append("    dbtransportista.mobile AS 'mobile', ")
                .append("    dbtransportista.fax AS 'fax', ")
                .append("    dbtransportista.correoElectronico AS 'correoElectronico', ")
                .append("    dbtransportista.paginaWeb AS 'paginaWeb', ")
                .append("    dbtransportista.fotoTransportista AS 'fotoTransportista', ")
                .append("    dbtransportista.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtransportista ")
                .append("WHERE ")
                .append("    dbtransportista.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _transportistaObj = new transportista();

                _transportistaObj.setId(rs.getInt(1));
                _transportistaObj.setNombreCompleto(rs.getString(2));
                _transportistaObj.setDescripcion(rs.getString(3));
                _transportistaObj.setDomicilio(rs.getString(4));
                _transportistaObj.setCodigoPostal(rs.getString(5));
                _transportistaObj.setLocalidad(rs.getString(6));
                _transportistaObj.setCiudad(rs.getString(7));
                _transportistaObj.setEstado(rs.getString(8));
                _transportistaObj.setPais(rs.getString(9));
                _transportistaObj.setTelefono(rs.getString(10));
                _transportistaObj.setMobile(rs.getString(11));
                _transportistaObj.setFax(rs.getString(12));
                _transportistaObj.setCorreoElectronico(rs.getString(13));
                _transportistaObj.setPaginaWeb(rs.getString(14));
                _transportistaObj.setFotoTransportista(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(15)));
                _transportistaObj.setIdEstado(rs.getInt(16));

                _listaTransportista.add(_transportistaObj);
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

        return _listaTransportista;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        transportista _transportistaObj;

        List<transportista> _listaTransportista = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtransportista.id AS 'id', ")
                .append("    dbtransportista.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtransportista.descripcion AS 'descripcion', ")
                .append("    dbtransportista.domicilio AS 'domicilio', ")
                .append("    dbtransportista.codigoPostal AS 'codigoPostal', ")
                .append("    dbtransportista.localidad AS 'localidad', ")
                .append("    dbtransportista.ciudad AS 'ciudad', ")
                .append("    dbtransportista.estado AS 'estado', ")
                .append("    dbtransportista.pais AS 'pais', ")
                .append("    dbtransportista.telefono AS 'telefono', ")
                .append("    dbtransportista.mobile AS 'mobile', ")
                .append("    dbtransportista.fax AS 'fax', ")
                .append("    dbtransportista.correoElectronico AS 'correoElectronico', ")
                .append("    dbtransportista.paginaWeb AS 'paginaWeb', ")
                .append("    dbtransportista.fotoTransportista AS 'fotoTransportista', ")
                .append("    dbtransportista.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtransportista ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbtransportista.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _transportistaObj = new transportista();

                _transportistaObj.setId(rs.getInt(1));
                _transportistaObj.setNombreCompleto(rs.getString(2));
                _transportistaObj.setDescripcion(rs.getString(3));
                _transportistaObj.setDomicilio(rs.getString(4));
                _transportistaObj.setCodigoPostal(rs.getString(5));
                _transportistaObj.setLocalidad(rs.getString(6));
                _transportistaObj.setCiudad(rs.getString(7));
                _transportistaObj.setEstado(rs.getString(8));
                _transportistaObj.setPais(rs.getString(9));
                _transportistaObj.setTelefono(rs.getString(10));
                _transportistaObj.setMobile(rs.getString(11));
                _transportistaObj.setFax(rs.getString(12));
                _transportistaObj.setCorreoElectronico(rs.getString(13));
                _transportistaObj.setPaginaWeb(rs.getString(14));
                _transportistaObj.setFotoTransportista(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(15)));
                _transportistaObj.setIdEstado(rs.getInt(16));

                _listaTransportista.add(_transportistaObj);
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

        return _listaTransportista;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        transportista _transportistaObj = new transportista();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbtransportista.id AS 'id', ")
                .append("    dbtransportista.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbtransportista.descripcion AS 'descripcion', ")
                .append("    dbtransportista.domicilio AS 'domicilio', ")
                .append("    dbtransportista.codigoPostal AS 'codigoPostal', ")
                .append("    dbtransportista.localidad AS 'localidad', ")
                .append("    dbtransportista.ciudad AS 'ciudad', ")
                .append("    dbtransportista.estado AS 'estado', ")
                .append("    dbtransportista.pais AS 'pais', ")
                .append("    dbtransportista.telefono AS 'telefono', ")
                .append("    dbtransportista.mobile AS 'mobile', ")
                .append("    dbtransportista.fax AS 'fax', ")
                .append("    dbtransportista.correoElectronico AS 'correoElectronico', ")
                .append("    dbtransportista.paginaWeb AS 'paginaWeb', ")
                .append("    dbtransportista.fotoTransportista AS 'fotoTransportista', ")
                .append("    dbtransportista.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbtransportista ")
                .append("WHERE dbtransportista.id = ")
                .append(id)
                .append(" AND dbtransportista.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _transportistaObj.setId(rs.getInt(1));
                _transportistaObj.setNombreCompleto(rs.getString(2));
                _transportistaObj.setDescripcion(rs.getString(3));
                _transportistaObj.setDomicilio(rs.getString(4));
                _transportistaObj.setCodigoPostal(rs.getString(5));
                _transportistaObj.setLocalidad(rs.getString(6));
                _transportistaObj.setCiudad(rs.getString(7));
                _transportistaObj.setEstado(rs.getString(8));
                _transportistaObj.setPais(rs.getString(9));
                _transportistaObj.setTelefono(rs.getString(10));
                _transportistaObj.setMobile(rs.getString(11));
                _transportistaObj.setFax(rs.getString(12));
                _transportistaObj.setCorreoElectronico(rs.getString(13));
                _transportistaObj.setPaginaWeb(rs.getString(14));
                _transportistaObj.setFotoTransportista(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(15)));
                _transportistaObj.setIdEstado(rs.getInt(16));

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

        return _transportistaObj;
    }

}
