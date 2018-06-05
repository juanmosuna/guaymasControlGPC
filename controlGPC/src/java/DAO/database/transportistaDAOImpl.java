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

        String _consulta = "INSERT INTO controlGPC.dbtransportista " +
                    "(nombreCompleto, " +
                    "descripcion, " +
                    "domicilio, " +
                    "codigoPostal, " +
                    "localidad, " +
                    "ciudad, " +
                    "estado, " +
                    "pais, " +
                    "telefono, " +
                    "mobile, " +
                    "fax, " +
                    "correoElectronico, " +
                    "paginaWeb, " +
                    "fotoTransportista, " +
                    "idEstado) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE controlGPC.dbtransportista " +
            "SET " +
            "nombreCompleto = ?, " +
            "descripcion = ?, " +
            "domicilio = ?, " +
            "codigoPostal = ?, " +
            "localidad = ?, " +
            "ciudad = ?, " +
            "estado = ?, " +
            "pais = ?, " +
            "telefono = ?, " +
            "mobile = ?, " +
            "fax = ?, " +
            "correoElectronico = ?, " +
            "paginaWeb = ?, " +
            "fotoTransportista = ?, " +
            "idEstado = ? " +
            "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "UPDATE controlGPC.dbtransportista SET idEstado = 3 WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);
        
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

        String _consulta = "SELECT  " +
                "    dbtransportista.id AS 'id', " +
                "    dbtransportista.nombreCompleto AS 'nombreCompleto', " +
                "    dbtransportista.descripcion AS 'descripcion', " +
                "    dbtransportista.domicilio AS 'domicilio', " +
                "    dbtransportista.codigoPostal AS 'codigoPostal', " +
                "    dbtransportista.localidad AS 'localidad', " +
                "    dbtransportista.ciudad AS 'ciudad', " +
                "    dbtransportista.estado AS 'estado', " +
                "    dbtransportista.pais AS 'pais', " +
                "    dbtransportista.telefono AS 'telefono', " +
                "    dbtransportista.mobile AS 'mobile', " +
                "    dbtransportista.fax AS 'fax', " +
                "    dbtransportista.correoElectronico AS 'correoElectronico', " +
                "    dbtransportista.paginaWeb AS 'paginaWeb', " +
                "    dbtransportista.fotoTransportista AS 'fotoTransportista', " +
                "    dbtransportista.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbtransportista " +
                "WHERE " +
                "    dbtransportista.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  " +
                "    dbtransportista.id AS 'id', " +
                "    dbtransportista.nombreCompleto AS 'nombreCompleto', " +
                "    dbtransportista.descripcion AS 'descripcion', " +
                "    dbtransportista.domicilio AS 'domicilio', " +
                "    dbtransportista.codigoPostal AS 'codigoPostal', " +
                "    dbtransportista.localidad AS 'localidad', " +
                "    dbtransportista.ciudad AS 'ciudad', " +
                "    dbtransportista.estado AS 'estado', " +
                "    dbtransportista.pais AS 'pais', " +
                "    dbtransportista.telefono AS 'telefono', " +
                "    dbtransportista.mobile AS 'mobile', " +
                "    dbtransportista.fax AS 'fax', " +
                "    dbtransportista.correoElectronico AS 'correoElectronico', " +
                "    dbtransportista.paginaWeb AS 'paginaWeb', " +
                "    dbtransportista.fotoTransportista AS 'fotoTransportista', " +
                "    dbtransportista.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbtransportista " +
                "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbtransportista.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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

        String _consulta = "SELECT  " +
                "    dbtransportista.id AS 'id', " +
                "    dbtransportista.nombreCompleto AS 'nombreCompleto', " +
                "    dbtransportista.descripcion AS 'descripcion', " +
                "    dbtransportista.domicilio AS 'domicilio', " +
                "    dbtransportista.codigoPostal AS 'codigoPostal', " +
                "    dbtransportista.localidad AS 'localidad', " +
                "    dbtransportista.ciudad AS 'ciudad', " +
                "    dbtransportista.estado AS 'estado', " +
                "    dbtransportista.pais AS 'pais', " +
                "    dbtransportista.telefono AS 'telefono', " +
                "    dbtransportista.mobile AS 'mobile', " +
                "    dbtransportista.fax AS 'fax', " +
                "    dbtransportista.correoElectronico AS 'correoElectronico', " +
                "    dbtransportista.paginaWeb AS 'paginaWeb', " +
                "    dbtransportista.fotoTransportista AS 'fotoTransportista', " +
                "    dbtransportista.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbtransportista " +
                "WHERE dbtransportista.id = " + id + " AND dbtransportista.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
