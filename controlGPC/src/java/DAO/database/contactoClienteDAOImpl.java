/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
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

        String _consulta = "INSERT INTO controlGPC.dbcontactoCliente " +
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
                    "fotoContactoCliente, " +
                    "idEstado) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
        st.setInt(14, _contactoClienteObj.getIdEstado());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        contactoCliente _contactoClienteObj = (contactoCliente) o;

        String _consulta = "UPDATE controlGPC.dbcontactoCliente " +
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
            "fotoContactoCliente = ?, " +
            "idEstado = ? " +
            "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
        st.setInt(14, _contactoClienteObj.getIdEstado());
        
        st.setInt(15, _contactoClienteObj.getId());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE controlGPC.dbcontactoCliente SET idEstado = 3 WHERE id = ?;";

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

        contactoCliente _contactoClienteObj;

        List<contactoCliente> _listaContactoCliente = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbcontactoCliente.id AS 'id', " +
                "    dbcontactoCliente.nombreCompleto AS 'nombreCompleto', " +
                "    dbcontactoCliente.descripcion AS 'descripcion', " +
                "    dbcontactoCliente.domicilio AS 'domicilio', " +
                "    dbcontactoCliente.codigoPostal AS 'codigoPostal', " +
                "    dbcontactoCliente.localidad AS 'localidad', " +
                "    dbcontactoCliente.ciudad AS 'ciudad', " +
                "    dbcontactoCliente.estado AS 'estado', " +
                "    dbcontactoCliente.pais AS 'pais', " +
                "    dbcontactoCliente.telefono AS 'telefono', " +
                "    dbcontactoCliente.mobile AS 'mobile', " +
                "    dbcontactoCliente.fax AS 'fax', " +
                "    dbcontactoCliente.correoElectronico AS 'correoElectronico', " +
                "    dbcontactoCliente.fotoContactoCliente AS 'fotoContactoCliente', " +
                "    dbcontactoCliente.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcontactoCliente " +
                "WHERE " +
                "    dbtransportista.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
                _contactoClienteObj.setIdEstado(rs.getInt(15));

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

        String _consulta = "SELECT  " +
                "    dbcontactoCliente.id AS 'id', " +
                "    dbcontactoCliente.nombreCompleto AS 'nombreCompleto', " +
                "    dbcontactoCliente.descripcion AS 'descripcion', " +
                "    dbcontactoCliente.domicilio AS 'domicilio', " +
                "    dbcontactoCliente.codigoPostal AS 'codigoPostal', " +
                "    dbcontactoCliente.localidad AS 'localidad', " +
                "    dbcontactoCliente.ciudad AS 'ciudad', " +
                "    dbcontactoCliente.estado AS 'estado', " +
                "    dbcontactoCliente.pais AS 'pais', " +
                "    dbcontactoCliente.telefono AS 'telefono', " +
                "    dbcontactoCliente.mobile AS 'mobile', " +
                "    dbcontactoCliente.fax AS 'fax', " +
                "    dbcontactoCliente.correoElectronico AS 'correoElectronico', " +
                "    dbcontactoCliente.fotoContactoCliente AS 'fotoContactoCliente', " +
                "    dbcontactoCliente.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcontactoCliente " +
                "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbtransportista.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
                _contactoClienteObj.setIdEstado(rs.getInt(15));

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

        String _consulta = "SELECT  " +
                "    dbcontactoCliente.id AS 'id', " +
                "    dbcontactoCliente.nombreCompleto AS 'nombreCompleto', " +
                "    dbcontactoCliente.descripcion AS 'descripcion', " +
                "    dbcontactoCliente.domicilio AS 'domicilio', " +
                "    dbcontactoCliente.codigoPostal AS 'codigoPostal', " +
                "    dbcontactoCliente.localidad AS 'localidad', " +
                "    dbcontactoCliente.ciudad AS 'ciudad', " +
                "    dbcontactoCliente.estado AS 'estado', " +
                "    dbcontactoCliente.pais AS 'pais', " +
                "    dbcontactoCliente.telefono AS 'telefono', " +
                "    dbcontactoCliente.mobile AS 'mobile', " +
                "    dbcontactoCliente.fax AS 'fax', " +
                "    dbcontactoCliente.correoElectronico AS 'correoElectronico', " +
                "    dbcontactoCliente.fotoContactoCliente AS 'fotoContactoCliente', " +
                "    dbcontactoCliente.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbcontactoCliente " +
                "WHERE dbcontactoCliente.id = " + id + " AND dbtransportista.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

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
                _contactoClienteObj.setIdEstado(rs.getInt(15));

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
