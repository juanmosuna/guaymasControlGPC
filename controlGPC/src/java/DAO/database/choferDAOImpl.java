/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.chofer;
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
public class choferDAOImpl implements catalogosInterface {
    
    private Connection _conn;

    public choferDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        chofer _choferObj = (chofer) o;

        String _consulta = "INSERT INTO controlGPC.dbchofer " +
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
                    "fotoChofer, " +
                    "licenciaManejo, " +
                    "idEstado) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _choferObj.getNombreCompleto());
        st.setString(2, _choferObj.getDescripcion());
        st.setString(3, _choferObj.getDomicilio());
        st.setString(4, _choferObj.getCodigoPostal());
        st.setString(5, _choferObj.getLocalidad());
        st.setString(6, _choferObj.getCiudad());
        st.setString(7, _choferObj.getEstado());
        st.setString(8, _choferObj.getPais());
        st.setString(9, _choferObj.getTelefono());
        st.setString(10, _choferObj.getMobile());
        st.setString(11, _choferObj.getFax());
        st.setString(12, _choferObj.getCorreoElectronico());        
        st.setString(13, javax.xml.bind.DatatypeConverter.printBase64Binary(_choferObj.getFotoChofer()));
        st.setString(14, _choferObj.getLicenciaManejo());
        st.setInt(15, _choferObj.getIdEstado());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        chofer _choferObj = (chofer) o;

        String _consulta = "UPDATE controlGPC.dbchofer " +
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
            "fotoChofer = ?, " +
            "licenciaManejo = ?, " +
            "idEstado = ? " +
            "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _choferObj.getNombreCompleto());
        st.setString(2, _choferObj.getDescripcion());
        st.setString(3, _choferObj.getDomicilio());
        st.setString(4, _choferObj.getCodigoPostal());
        st.setString(5, _choferObj.getLocalidad());
        st.setString(6, _choferObj.getCiudad());
        st.setString(7, _choferObj.getEstado());
        st.setString(8, _choferObj.getPais());
        st.setString(9, _choferObj.getTelefono());
        st.setString(10, _choferObj.getMobile());
        st.setString(11, _choferObj.getFax());
        st.setString(12, _choferObj.getCorreoElectronico());        
        st.setString(13, javax.xml.bind.DatatypeConverter.printBase64Binary(_choferObj.getFotoChofer()));
        st.setString(14, _choferObj.getLicenciaManejo());
        st.setInt(15, _choferObj.getIdEstado());
        
        st.setInt(16, _choferObj.getId());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE controlGPC.dbchofer idEstado = 3 WHERE id = ?;";

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

        chofer _choferObj;

        List<chofer> _listaChofer = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbchofer.id AS 'id', " +
                "    dbchofer.nombreCompleto AS 'nombreCompleto', " +
                "    dbchofer.descripcion AS 'descripcion', " +
                "    dbchofer.domicilio AS 'domicilio', " +
                "    dbchofer.codigoPostal AS 'codigoPostal', " +
                "    dbchofer.localidad AS 'localidad', " +
                "    dbchofer.ciudad AS 'ciudad', " +
                "    dbchofer.estado AS 'estado', " +
                "    dbchofer.pais AS 'pais', " +
                "    dbchofer.telefono AS 'telefono', " +
                "    dbchofer.mobile AS 'mobile', " +
                "    dbchofer.fax AS 'fax', " +
                "    dbchofer.correoElectronico AS 'correoElectronico', " +                
                "    dbchofer.fotoChofer AS 'fotoTransportista', " +
                "    dbchofer.licenciaManejo AS 'licenciaManejo', " +
                "    dbchofer.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbchofer " +
                "WHERE " +
                "    dbchofer.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _choferObj = new chofer();

                _choferObj.setId(rs.getInt(1));
                _choferObj.setNombreCompleto(rs.getString(2));
                _choferObj.setDescripcion(rs.getString(3));
                _choferObj.setDomicilio(rs.getString(4));
                _choferObj.setCodigoPostal(rs.getString(5));
                _choferObj.setLocalidad(rs.getString(6));
                _choferObj.setCiudad(rs.getString(7));
                _choferObj.setEstado(rs.getString(8));
                _choferObj.setPais(rs.getString(9));
                _choferObj.setTelefono(rs.getString(10));
                _choferObj.setMobile(rs.getString(11));
                _choferObj.setFax(rs.getString(12));
                _choferObj.setCorreoElectronico(rs.getString(13));               
                _choferObj.setFotoChofer(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));
                 _choferObj.setLicenciaManejo(rs.getString(15));
                _choferObj.setIdEstado(rs.getInt(16));

                _listaChofer.add(_choferObj);
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

        return _listaChofer;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        chofer _choferObj;

        List<chofer> _listaChofer = new ArrayList();

        String _consulta = "SELECT  " +
                "    dbchofer.id AS 'id', " +
                "    dbchofer.nombreCompleto AS 'nombreCompleto', " +
                "    dbchofer.descripcion AS 'descripcion', " +
                "    dbchofer.domicilio AS 'domicilio', " +
                "    dbchofer.codigoPostal AS 'codigoPostal', " +
                "    dbchofer.localidad AS 'localidad', " +
                "    dbchofer.ciudad AS 'ciudad', " +
                "    dbchofer.estado AS 'estado', " +
                "    dbchofer.pais AS 'pais', " +
                "    dbchofer.telefono AS 'telefono', " +
                "    dbchofer.mobile AS 'mobile', " +
                "    dbchofer.fax AS 'fax', " +
                "    dbchofer.correoElectronico AS 'correoElectronico', " +                
                "    dbchofer.fotoChofer AS 'fotoTransportista', " +
                "    dbchofer.licenciaManejo AS 'licenciaManejo', " +
                "    dbchofer.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbchofer " +
                "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbchofer.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _choferObj = new chofer();

                _choferObj.setId(rs.getInt(1));
                _choferObj.setNombreCompleto(rs.getString(2));
                _choferObj.setDescripcion(rs.getString(3));
                _choferObj.setDomicilio(rs.getString(4));
                _choferObj.setCodigoPostal(rs.getString(5));
                _choferObj.setLocalidad(rs.getString(6));
                _choferObj.setCiudad(rs.getString(7));
                _choferObj.setEstado(rs.getString(8));
                _choferObj.setPais(rs.getString(9));
                _choferObj.setTelefono(rs.getString(10));
                _choferObj.setMobile(rs.getString(11));
                _choferObj.setFax(rs.getString(12));
                _choferObj.setCorreoElectronico(rs.getString(13));               
                _choferObj.setFotoChofer(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));
                 _choferObj.setLicenciaManejo(rs.getString(15));
                _choferObj.setIdEstado(rs.getInt(16));

                _listaChofer.add(_choferObj);
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

        return _listaChofer;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        chofer _choferObj = new chofer();

        String _consulta = "SELECT  " +
                "    dbchofer.id AS 'id', " +
                "    dbchofer.nombreCompleto AS 'nombreCompleto', " +
                "    dbchofer.descripcion AS 'descripcion', " +
                "    dbchofer.domicilio AS 'domicilio', " +
                "    dbchofer.codigoPostal AS 'codigoPostal', " +
                "    dbchofer.localidad AS 'localidad', " +
                "    dbchofer.ciudad AS 'ciudad', " +
                "    dbchofer.estado AS 'estado', " +
                "    dbchofer.pais AS 'pais', " +
                "    dbchofer.telefono AS 'telefono', " +
                "    dbchofer.mobile AS 'mobile', " +
                "    dbchofer.fax AS 'fax', " +
                "    dbchofer.correoElectronico AS 'correoElectronico', " +                
                "    dbchofer.fotoChofer AS 'fotoTransportista', " +
                "    dbchofer.licenciaManejo AS 'licenciaManejo', " +
                "    dbchofer.idEstado AS 'idEstado' " +
                "FROM " +
                "    controlGPC.dbchofer " +
                "WHERE dbchofer.id = " + id + " AND dbchofer.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _choferObj.setId(rs.getInt(1));
                _choferObj.setNombreCompleto(rs.getString(2));
                _choferObj.setDescripcion(rs.getString(3));
                _choferObj.setDomicilio(rs.getString(4));
                _choferObj.setCodigoPostal(rs.getString(5));
                _choferObj.setLocalidad(rs.getString(6));
                _choferObj.setCiudad(rs.getString(7));
                _choferObj.setEstado(rs.getString(8));
                _choferObj.setPais(rs.getString(9));
                _choferObj.setTelefono(rs.getString(10));
                _choferObj.setMobile(rs.getString(11));
                _choferObj.setFax(rs.getString(12));
                _choferObj.setCorreoElectronico(rs.getString(13));               
                _choferObj.setFotoChofer(javax.xml.bind.DatatypeConverter.parseBase64Binary(rs.getString(14)));
                _choferObj.setLicenciaManejo(rs.getString(15));
                _choferObj.setIdEstado(rs.getInt(16));

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

        return _choferObj;
    }
    
}
