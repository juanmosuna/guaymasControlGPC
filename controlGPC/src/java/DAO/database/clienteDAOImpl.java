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
public class clienteDAOImpl implements catalogosInterface {
    
    private Connection _conn;

    public clienteDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        cliente _clienteObj = (cliente) o;

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("INSERT INTO controlGPC.dbcliente " )
                    .append("(nombreCompleto, " )
                    .append("descripcion, " )
                    .append("domicilio, " )
                    .append("codigoPostal, " )
                    .append("localidad, " )
                    .append("ciudad, " )
                    .append("estado, " )
                    .append("pais, " )
                    .append("telefono, " )
                    .append("mobile, " )
                    .append("fax, " )
                    .append("correoElectronico, " )
                    .append("paginaWeb, " )
                    .append("fotoCliente, " )
                    .append("idEstado) " )
                    .append("VALUES " )
                    .append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _clienteObj.getNombreCompleto());
        st.setString(2, _clienteObj.getDescripcion());
        st.setString(3, _clienteObj.getDomicilio());
        st.setString(4, _clienteObj.getCodigoPostal());
        st.setString(5, _clienteObj.getLocalidad());
        st.setString(6, _clienteObj.getCiudad());
        st.setString(7, _clienteObj.getEstado());
        st.setString(8, _clienteObj.getPais());
        st.setString(9, _clienteObj.getTelefono());
        st.setString(10, _clienteObj.getMobile());
        st.setString(11, _clienteObj.getFax());
        st.setString(12, _clienteObj.getCorreoElectronico());
        st.setString(13, _clienteObj.getPaginaWeb());
        st.setString(14, javax.xml.bind.DatatypeConverter.printBase64Binary(_clienteObj.getFotoCliente()));
        st.setInt(15, _clienteObj.getIdEstado());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        cliente _clienteObj = (cliente) o;
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbcliente " )
            .append("SET " )
            .append("nombreCompleto = ?, " )
            .append("descripcion = ?, " )
            .append("domicilio = ?, " )
            .append("codigoPostal = ?, " )
            .append("localidad = ?, " )
            .append("ciudad = ?, " )
            .append("estado = ?, " )
            .append("pais = ?, " )
            .append("telefono = ?, " )
            .append("mobile = ?, " )
            .append("fax = ?, " )
            .append("correoElectronico = ?, " )
            .append("paginaWeb = ?, " )
            .append("fotoCliente = ?, " )
            .append("idEstado = ? " )
            .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _clienteObj.getNombreCompleto());
        st.setString(2, _clienteObj.getDescripcion());
        st.setString(3, _clienteObj.getDomicilio());
        st.setString(4, _clienteObj.getCodigoPostal());
        st.setString(5, _clienteObj.getLocalidad());
        st.setString(6, _clienteObj.getCiudad());
        st.setString(7, _clienteObj.getEstado());
        st.setString(8, _clienteObj.getPais());
        st.setString(9, _clienteObj.getTelefono());
        st.setString(10, _clienteObj.getMobile());
        st.setString(11, _clienteObj.getFax());
        st.setString(12, _clienteObj.getCorreoElectronico());
        st.setString(13, _clienteObj.getPaginaWeb());
        st.setString(14, javax.xml.bind.DatatypeConverter.printBase64Binary(_clienteObj.getFotoCliente()));
        st.setInt(15, _clienteObj.getIdEstado());
        
        st.setInt(17, _clienteObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("UPDATE controlGPC.dbcliente SET idEstado = 3 WHERE id = ?;");

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

        cliente _clienteObj;

        List<cliente> _listaCliente = new ArrayList();
        
        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  " )
                .append("    dbcliente.id AS 'id', " )
                .append("    dbcliente.nombreCompleto AS 'nombreCompleto', " )
                .append("    dbcliente.descripcion AS 'descripcion', " )
                .append("    dbcliente.domicilio AS 'domicilio', " )
                .append("    dbcliente.codigoPostal AS 'codigoPostal', " )
                .append("    dbcliente.localidad AS 'localidad', " )
                .append("    dbcliente.ciudad AS 'ciudad', " )
                .append("    dbcliente.estado AS 'estado', " )
                .append("    dbcliente.pais AS 'pais', " )
                .append("    dbcliente.telefono AS 'telefono', " )
                .append("    dbcliente.mobile AS 'mobile', " )
                .append("    dbcliente.fax AS 'fax', " )
                .append("    dbcliente.correoElectronico AS 'correoElectronico', " )
                .append("    dbcliente.paginaWeb AS 'paginaWeb', " )
                .append("    dbcliente.fotoTransportista AS 'fotoCliente', " )
                .append("    dbcliente.idEstado AS 'idEstado' " )
                .append("FROM " )
                .append("    controlGPC.dbcliente ")
                .append( "WHERE " )
                .append("    dbcliente.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _clienteObj = new cliente();

                _clienteObj.setId(rs.getInt(1));
                _clienteObj.setNombreCompleto(rs.getString(2));
                _clienteObj.setDescripcion(rs.getString(3));
                _clienteObj.setDomicilio(rs.getString(4));
                _clienteObj.setCodigoPostal(rs.getString(5));
                _clienteObj.setLocalidad(rs.getString(6));
                _clienteObj.setCiudad(rs.getString(7));
                _clienteObj.setEstado(rs.getString(8));
                _clienteObj.setPais(rs.getString(9));
                _clienteObj.setTelefono(rs.getString(10));
                _clienteObj.setMobile(rs.getString(11));
                _clienteObj.setFax(rs.getString(12));
                _clienteObj.setCorreoElectronico(rs.getString(13));
                _clienteObj.setPaginaWeb(rs.getString(14));
                _clienteObj.setFotoCliente(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(15)));
                _clienteObj.setIdEstado(rs.getInt(16));

                _listaCliente.add(_clienteObj);
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

        return _listaCliente;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        cliente _clienteObj;

        List<cliente> _listaCliente = new ArrayList();

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT  " )
                .append("    dbcliente.id AS 'id', " )
                .append("    dbcliente.nombreCompleto AS 'nombreCompleto', " )
                .append("    dbcliente.descripcion AS 'descripcion', " )
                .append("    dbcliente.domicilio AS 'domicilio', " )
                .append("    dbcliente.codigoPostal AS 'codigoPostal', " )
                .append("    dbcliente.localidad AS 'localidad', " )
                .append("    dbcliente.ciudad AS 'ciudad', " )
                .append("    dbcliente.estado AS 'estado', " )
                .append("    dbcliente.pais AS 'pais', " )
                .append("    dbcliente.telefono AS 'telefono', " )
                .append("    dbcliente.mobile AS 'mobile', " )
                .append("    dbcliente.fax AS 'fax', " )
                .append("    dbcliente.correoElectronico AS 'correoElectronico', " )
                .append("    dbcliente.paginaWeb AS 'paginaWeb', " )
                .append("    dbcliente.fotoTransportista AS 'fotoCliente', " )
                .append("    dbcliente.idEstado AS 'idEstado' " )
                .append("FROM " )
                .append("    controlGPC.dbcliente " )
                .append("WHERE " )
                .append(_campo)
                .append(" LIKE '%" )
                .append(_dato)
                .append("%' AND dbcliente.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _clienteObj = new cliente();

                _clienteObj.setId(rs.getInt(1));
                _clienteObj.setNombreCompleto(rs.getString(2));
                _clienteObj.setDescripcion(rs.getString(3));
                _clienteObj.setDomicilio(rs.getString(4));
                _clienteObj.setCodigoPostal(rs.getString(5));
                _clienteObj.setLocalidad(rs.getString(6));
                _clienteObj.setCiudad(rs.getString(7));
                _clienteObj.setEstado(rs.getString(8));
                _clienteObj.setPais(rs.getString(9));
                _clienteObj.setTelefono(rs.getString(10));
                _clienteObj.setMobile(rs.getString(11));
                _clienteObj.setFax(rs.getString(12));
                _clienteObj.setCorreoElectronico(rs.getString(13));
                _clienteObj.setPaginaWeb(rs.getString(14));
                _clienteObj.setFotoCliente(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(15)));
                _clienteObj.setIdEstado(rs.getInt(16));

                _listaCliente.add(_clienteObj);
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

        return _listaCliente;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        cliente _clienteObj = new cliente();

        StringBuilder _consulta = new StringBuilder();
        
        _consulta.append("SELECT  " )
                .append("    dbcliente.id AS 'id', " )
                .append("    dbcliente.nombreCompleto AS 'nombreCompleto', " )
                .append("    dbcliente.descripcion AS 'descripcion', " )
                .append("    dbcliente.domicilio AS 'domicilio', " )
                .append("    dbcliente.codigoPostal AS 'codigoPostal', " )
                .append("    dbcliente.localidad AS 'localidad', " )
                .append("    dbcliente.ciudad AS 'ciudad', " )
                .append("    dbcliente.estado AS 'estado', " )
                .append("    dbcliente.pais AS 'pais', " )
                .append("    dbcliente.telefono AS 'telefono', " )
                .append("    dbcliente.mobile AS 'mobile', " )
                .append("    dbcliente.fax AS 'fax', " )
                .append("    dbcliente.correoElectronico AS 'correoElectronico', " )
                .append("    dbcliente.paginaWeb AS 'paginaWeb', " )
                .append("    dbcliente.fotoTransportista AS 'fotoCliente', " )
                .append("    dbcliente.idEstado AS 'idEstado' " )
                .append("FROM " )
                .append("    controlGPC.dbcliente ")
                .append("WHERE dbcliente.id = " )
                .append(id)
                .append(" AND dbcliente.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _clienteObj.setId(rs.getInt(1));
                _clienteObj.setNombreCompleto(rs.getString(2));
                _clienteObj.setDescripcion(rs.getString(3));
                _clienteObj.setDomicilio(rs.getString(4));
                _clienteObj.setCodigoPostal(rs.getString(5));
                _clienteObj.setLocalidad(rs.getString(6));
                _clienteObj.setCiudad(rs.getString(7));
                _clienteObj.setEstado(rs.getString(8));
                _clienteObj.setPais(rs.getString(9));
                _clienteObj.setTelefono(rs.getString(10));
                _clienteObj.setMobile(rs.getString(11));
                _clienteObj.setFax(rs.getString(12));
                _clienteObj.setCorreoElectronico(rs.getString(13));
                _clienteObj.setPaginaWeb(rs.getString(14));
                _clienteObj.setFotoCliente(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(15)));
                _clienteObj.setIdEstado(rs.getInt(18));

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

        return _clienteObj;
    }
    
}
