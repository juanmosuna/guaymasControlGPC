/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.cliente;
import entity.contactoCliente;
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
public class contactoClienteDAOImpl implements catalogosInterface {

    private Connection _conn;

    public contactoClienteDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        contactoCliente _contactoClienteObj = (contactoCliente) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbcontactoCliente ")
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
                .append("fotoContactoCliente, ")
                .append("idCliente, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _contactoClienteObj.getNombreCompleto());
        st.setString(2, _contactoClienteObj.getDescripcion());
        st.setString(3, _contactoClienteObj.getDomicilio());
        st.setString(4, _contactoClienteObj.getCodigoPostal());
        st.setString(5, _contactoClienteObj.getLocalidad());
        st.setString(6, _contactoClienteObj.getCiudad());
        st.setString(7, _contactoClienteObj.getEstado());
        st.setString(8, _contactoClienteObj.getPais());
        st.setString(9, _contactoClienteObj.getTelefono());
        st.setString(10, _contactoClienteObj.getMobile());
        st.setString(11, _contactoClienteObj.getFax());
        st.setString(12, _contactoClienteObj.getCorreoElectronico());
        st.setString(13, javax.xml.bind.DatatypeConverter.printBase64Binary(_contactoClienteObj.getFotoContactoCliente()));
        st.setInt(14, _contactoClienteObj.getCliente().getId());
        st.setInt(15, _contactoClienteObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        contactoCliente _contactoClienteObj = (contactoCliente) o;

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbcontactoCliente ")
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
                .append("fotoContactoCliente = ?, ")
                .append("idCliente = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _contactoClienteObj.getNombreCompleto());
        st.setString(2, _contactoClienteObj.getDescripcion());
        st.setString(3, _contactoClienteObj.getDomicilio());
        st.setString(4, _contactoClienteObj.getCodigoPostal());
        st.setString(5, _contactoClienteObj.getLocalidad());
        st.setString(6, _contactoClienteObj.getCiudad());
        st.setString(7, _contactoClienteObj.getEstado());
        st.setString(8, _contactoClienteObj.getPais());
        st.setString(9, _contactoClienteObj.getTelefono());
        st.setString(10, _contactoClienteObj.getMobile());
        st.setString(11, _contactoClienteObj.getFax());
        st.setString(12, _contactoClienteObj.getCorreoElectronico());
        st.setString(13, javax.xml.bind.DatatypeConverter.printBase64Binary(_contactoClienteObj.getFotoContactoCliente()));
        st.setInt(14, _contactoClienteObj.getCliente().getId());
        st.setInt(15, _contactoClienteObj.getIdEstado());

        st.setInt(16, _contactoClienteObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbcontactoCliente SET idEstado = 3 WHERE id = ?;");

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

        contactoCliente _contactoClienteObj;

        List<contactoCliente> _listaContactoCliente = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbcontactoCliente.id AS 'id', ")
                .append("    dbcontactoCliente.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcontactoCliente.descripcion AS 'descripcion', ")
                .append("    dbcontactoCliente.domicilio AS 'domicilio', ")
                .append("    dbcontactoCliente.codigoPostal AS 'codigoPostal', ")
                .append("    dbcontactoCliente.localidad AS 'localidad', ")
                .append("    dbcontactoCliente.ciudad AS 'ciudad', ")
                .append("    dbcontactoCliente.estado AS 'estado', ")
                .append("    dbcontactoCliente.pais AS 'pais', ")
                .append("    dbcontactoCliente.telefono AS 'telefono', ")
                .append("    dbcontactoCliente.mobile AS 'mobile', ")
                .append("    dbcontactoCliente.fax AS 'fax', ")
                .append("    dbcontactoCliente.correoElectronico AS 'correoElectronico', ")
                .append("    dbcontactoCliente.fotoContactoCliente AS 'fotoContactoCliente', ")
                .append("    dbcontactoCliente.idCliente AS 'idCliente', ")
                .append("    dbcliente.nombreCompleto AS 'nombreCliente', ")
                .append("    dbcontactoCliente.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcontactoCliente ")
                .append("LEFT JOIN dbcliente ON dbcliente.id = dbcontactoCliente.idCliente ")
                .append("WHERE ")
                .append("    dbtransportista.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _contactoClienteObj = new contactoCliente();

                _contactoClienteObj.setId(rs.getInt(1));
                _contactoClienteObj.setNombreCompleto(rs.getString(2));
                _contactoClienteObj.setDescripcion(rs.getString(3));
                _contactoClienteObj.setDomicilio(rs.getString(4));
                _contactoClienteObj.setCodigoPostal(rs.getString(5));
                _contactoClienteObj.setLocalidad(rs.getString(6));
                _contactoClienteObj.setCiudad(rs.getString(7));
                _contactoClienteObj.setEstado(rs.getString(8));
                _contactoClienteObj.setPais(rs.getString(9));
                _contactoClienteObj.setTelefono(rs.getString(10));
                _contactoClienteObj.setMobile(rs.getString(11));
                _contactoClienteObj.setFax(rs.getString(12));
                _contactoClienteObj.setCorreoElectronico(rs.getString(13));
                _contactoClienteObj.setFotoContactoCliente(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));

                cliente _clt = new cliente();
                _clt.setId(rs.getInt(15));
                _clt.setNombreCompleto(rs.getString(16));
                _contactoClienteObj.setCliente(_clt);

                _contactoClienteObj.setIdEstado(rs.getInt(17));

                _listaContactoCliente.add(_contactoClienteObj);
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

        return _listaContactoCliente;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        contactoCliente _contactoClienteObj;

        List<contactoCliente> _listaContactoCliente = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbcontactoCliente.id AS 'id', ")
                .append("    dbcontactoCliente.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcontactoCliente.descripcion AS 'descripcion', ")
                .append("    dbcontactoCliente.domicilio AS 'domicilio', ")
                .append("    dbcontactoCliente.codigoPostal AS 'codigoPostal', ")
                .append("    dbcontactoCliente.localidad AS 'localidad', ")
                .append("    dbcontactoCliente.ciudad AS 'ciudad', ")
                .append("    dbcontactoCliente.estado AS 'estado', ")
                .append("    dbcontactoCliente.pais AS 'pais', ")
                .append("    dbcontactoCliente.telefono AS 'telefono', ")
                .append("    dbcontactoCliente.mobile AS 'mobile', ")
                .append("    dbcontactoCliente.fax AS 'fax', ")
                .append("    dbcontactoCliente.correoElectronico AS 'correoElectronico', ")
                .append("    dbcontactoCliente.fotoContactoCliente AS 'fotoContactoCliente', ")
                .append("    dbcontactoCliente.idCliente AS 'idCliente', ")
                .append("    dbcliente.nombreCompleto AS 'nombreCliente', ")
                .append("    dbcontactoCliente.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcontactoCliente ")
                .append("LEFT JOIN dbcliente ON dbcliente.id = dbcontactoCliente.idCliente ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbtransportista.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _contactoClienteObj = new contactoCliente();

                _contactoClienteObj.setId(rs.getInt(1));
                _contactoClienteObj.setNombreCompleto(rs.getString(2));
                _contactoClienteObj.setDescripcion(rs.getString(3));
                _contactoClienteObj.setDomicilio(rs.getString(4));
                _contactoClienteObj.setCodigoPostal(rs.getString(5));
                _contactoClienteObj.setLocalidad(rs.getString(6));
                _contactoClienteObj.setCiudad(rs.getString(7));
                _contactoClienteObj.setEstado(rs.getString(8));
                _contactoClienteObj.setPais(rs.getString(9));
                _contactoClienteObj.setTelefono(rs.getString(10));
                _contactoClienteObj.setMobile(rs.getString(11));
                _contactoClienteObj.setFax(rs.getString(12));
                _contactoClienteObj.setCorreoElectronico(rs.getString(13));
                _contactoClienteObj.setFotoContactoCliente(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));

                cliente _clt = new cliente();
                _clt.setId(rs.getInt(15));
                _clt.setNombreCompleto(rs.getString(16));
                _contactoClienteObj.setCliente(_clt);

                _contactoClienteObj.setIdEstado(rs.getInt(17));

                _listaContactoCliente.add(_contactoClienteObj);
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

        return _listaContactoCliente;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        contactoCliente _contactoClienteObj = new contactoCliente();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbcontactoCliente.id AS 'id', ")
                .append("    dbcontactoCliente.nombreCompleto AS 'nombreCompleto', ")
                .append("    dbcontactoCliente.descripcion AS 'descripcion', ")
                .append("    dbcontactoCliente.domicilio AS 'domicilio', ")
                .append("    dbcontactoCliente.codigoPostal AS 'codigoPostal', ")
                .append("    dbcontactoCliente.localidad AS 'localidad', ")
                .append("    dbcontactoCliente.ciudad AS 'ciudad', ")
                .append("    dbcontactoCliente.estado AS 'estado', ")
                .append("    dbcontactoCliente.pais AS 'pais', ")
                .append("    dbcontactoCliente.telefono AS 'telefono', ")
                .append("    dbcontactoCliente.mobile AS 'mobile', ")
                .append("    dbcontactoCliente.fax AS 'fax', ")
                .append("    dbcontactoCliente.correoElectronico AS 'correoElectronico', ")
                .append("    dbcontactoCliente.fotoContactoCliente AS 'fotoContactoCliente', ")
                .append("    dbcontactoCliente.idCliente AS 'idCliente', ")
                .append("    dbcliente.nombreCompleto AS 'nombreCliente', ")
                .append("    dbcontactoCliente.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbcontactoCliente ")
                .append("LEFT JOIN dbcliente ON dbcliente.id = dbcontactoCliente.idCliente ")
                .append("WHERE dbcontactoCliente.id = " + id + " AND dbtransportista.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _contactoClienteObj.setId(rs.getInt(1));
                _contactoClienteObj.setNombreCompleto(rs.getString(2));
                _contactoClienteObj.setDescripcion(rs.getString(3));
                _contactoClienteObj.setDomicilio(rs.getString(4));
                _contactoClienteObj.setCodigoPostal(rs.getString(5));
                _contactoClienteObj.setLocalidad(rs.getString(6));
                _contactoClienteObj.setCiudad(rs.getString(7));
                _contactoClienteObj.setEstado(rs.getString(8));
                _contactoClienteObj.setPais(rs.getString(9));
                _contactoClienteObj.setTelefono(rs.getString(10));
                _contactoClienteObj.setMobile(rs.getString(11));
                _contactoClienteObj.setFax(rs.getString(12));
                _contactoClienteObj.setCorreoElectronico(rs.getString(13));
                _contactoClienteObj.setFotoContactoCliente(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));

                cliente _clt = new cliente();
                _clt.setId(rs.getInt(15));
                _clt.setNombreCompleto(rs.getString(16));
                _contactoClienteObj.setCliente(_clt);

                _contactoClienteObj.setIdEstado(rs.getInt(17));

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

        return _contactoClienteObj;
    }

}
