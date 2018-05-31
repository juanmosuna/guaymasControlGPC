/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.transportista;
import entity.vehiculo;
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
public class vehiculoDAOImpl implements catalogosInterface {
    
    private Connection _conn;

    public vehiculoDAOImpl(Connection _conn) {
        this._conn = _conn;
    }

    @Override
    public boolean agregarRegistro(Object o) throws Exception {

        vehiculo _vehiculoObj = (vehiculo) o;

        String _consulta = "INSERT INTO controlGPC.dbvehiculo " +
                "(nombrePropietario, " +
                "idTransportista, " +
                "marca, " +
                "modelo, " +
                "tipo, " +
                "numeroSerie, " +
                "placas, " +
                "numeroEconomico, " +
                "tarjetaCirculacion, " +
                "polizaSeguro, " +
                "fechaPoliza, " +
                "idEstado) " +
                "VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _vehiculoObj.getNombrePropietario());
        st.setInt(2, _vehiculoObj.getTransportista().getId());
        st.setString(3, _vehiculoObj.getMarca());
        st.setString(4, _vehiculoObj.getModelo());
        st.setString(5, _vehiculoObj.getTipo());
        st.setString(6, _vehiculoObj.getNumeroSerie());
        st.setString(7, _vehiculoObj.getPlacas());
        st.setString(8, _vehiculoObj.getNumeroEconomico());
        st.setString(9, _vehiculoObj.getTarjetaCirculacion());
        st.setString(10, _vehiculoObj.getPolizaSeguro());
        st.setString(11, _vehiculoObj.getFechaPoliza());
        st.setInt(12, _vehiculoObj.getIdEstado());
        

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean modificarRegistro(Object o) throws Exception {

        vehiculo _vehiculoObj = (vehiculo) o;

        String _consulta = "UPDATE controlGPC.dbvehiculo " +
            "SET " +
            "nombrePropietario = ?, " +
            "idTransportista = ?, " +
            "marca = ?, " +
            "modelo = ?, " +
            "tipo = ?, " +
            "numeroSerie = ?, " +
            "placas = ?, " +
            "numeroEconomico = ?, " +
            "tarjetaCirculacion = ?, " +
            "polizaSeguro = ?, " +
            "fechaPoliza = ?, " +
            "idEstado = ? " +
            "WHERE id = ?;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        st.setString(1, _vehiculoObj.getNombrePropietario());
        st.setInt(2, _vehiculoObj.getTransportista().getId());
        st.setString(3, _vehiculoObj.getMarca());
        st.setString(4, _vehiculoObj.getModelo());
        st.setString(5, _vehiculoObj.getTipo());
        st.setString(6, _vehiculoObj.getNumeroSerie());
        st.setString(7, _vehiculoObj.getPlacas());
        st.setString(8, _vehiculoObj.getNumeroEconomico());
        st.setString(9, _vehiculoObj.getTarjetaCirculacion());
        st.setString(10, _vehiculoObj.getPolizaSeguro());
        st.setString(11, _vehiculoObj.getFechaPoliza());
        st.setInt(12, _vehiculoObj.getIdEstado());
        
        st.setInt(13, _vehiculoObj.getId());

        boolean resultado = st.execute();

        if (st != null) {
            st.close();
        }

        return resultado;
    }

    @Override
    public boolean eliminarRegistro(int id) throws Exception {

        String _consulta = "UPDATE controlGPC.dbvehiculo SET idEstado = 3 WHERE id = ?;";

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

        vehiculo _vehiculoObj;

        List<vehiculo> _listaArchivos = new ArrayList();

        String _consulta = "SELECT  " +
                    "    dbvehiculo.id AS 'id', " +
                    "    dbvehiculo.nombrePropietario AS 'nombrePropietario', " +
                    "    dbvehiculo.idTransportista AS 'idTransportista', " +
                    "    dbtransportista.nombreCompleto AS 'nombreTransportista', " +
                    "    dbvehiculo.marca AS 'marca', " +
                    "    dbvehiculo.modelo AS 'modelo', " +
                    "    dbvehiculo.tipo AS 'tipo', " +
                    "    dbvehiculo.numeroSerie AS 'numeroSerie', " +
                    "    dbvehiculo.placas AS 'placas', " +
                    "    dbvehiculo.numeroEconomico AS 'numeroEconomico', " +
                    "    dbvehiculo.tarjetaCirculacion AS 'tarjetaCirculacion', " +
                    "    dbvehiculo.polizaSeguro AS 'polizaSeguro', " +
                    "    dbvehiculo.fechaPoliza AS 'fechaPoliza', " +
                    "    dbvehiculo.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    controlGPC.dbvehiculo " +
                    "        LEFT JOIN " +
                    "    dbtransportista ON dbtransportista.id = dbvehiculo.idTransportista " +
                    "WHERE " +
                    "    dbvehiculo.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _vehiculoObj = new vehiculo();

                _vehiculoObj.setId(rs.getInt(1));
                _vehiculoObj.setNombrePropietario(rs.getString(2));
                
                transportista _transportista = new transportista();
                
                _transportista.setId(rs.getInt(3));
                _transportista.setNombreCompleto(rs.getString(4));
                _vehiculoObj.setTransportista(_transportista);
                
                _vehiculoObj.setMarca(rs.getString(5));
                _vehiculoObj.setModelo(rs.getString(6));
                _vehiculoObj.setTipo(rs.getString(7));
                _vehiculoObj.setNumeroSerie(rs.getString(8));
                _vehiculoObj.setPlacas(rs.getString(9));
                _vehiculoObj.setNumeroEconomico(rs.getString(10));
                _vehiculoObj.setTarjetaCirculacion(rs.getString(11));
                _vehiculoObj.setPolizaSeguro(rs.getString(12));
                _vehiculoObj.setFechaPoliza(rs.getString(13));
                _vehiculoObj.setIdEstado(rs.getInt(14));

                _listaArchivos.add(_vehiculoObj);
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

        return _listaArchivos;
    }

    @Override
    public Object consultarPor(String _campo, String _dato) throws Exception {

        vehiculo _vehiculoObj;

        List<vehiculo> _listaArchivos = new ArrayList();

        String _consulta = "SELECT  " +
                    "    dbvehiculo.id AS 'id', " +
                    "    dbvehiculo.nombrePropietario AS 'nombrePropietario', " +
                    "    dbvehiculo.idTransportista AS 'idTransportista', " +
                    "    dbtransportista.nombreCompleto AS 'nombreTransportista', " +
                    "    dbvehiculo.marca AS 'marca', " +
                    "    dbvehiculo.modelo AS 'modelo', " +
                    "    dbvehiculo.tipo AS 'tipo', " +
                    "    dbvehiculo.numeroSerie AS 'numeroSerie', " +
                    "    dbvehiculo.placas AS 'placas', " +
                    "    dbvehiculo.numeroEconomico AS 'numeroEconomico', " +
                    "    dbvehiculo.tarjetaCirculacion AS 'tarjetaCirculacion', " +
                    "    dbvehiculo.polizaSeguro AS 'polizaSeguro', " +
                    "    dbvehiculo.fechaPoliza AS 'fechaPoliza', " +
                    "    dbvehiculo.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    controlGPC.dbvehiculo " +
                    "        LEFT JOIN " +
                    "    dbtransportista ON dbtransportista.id = dbvehiculo.idTransportista " +
                    "WHERE " + _campo + " LIKE '%" + _dato + "%' AND dbvehiculo.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _vehiculoObj = new vehiculo();

                _vehiculoObj.setId(rs.getInt(1));
                _vehiculoObj.setNombrePropietario(rs.getString(2));
                
                transportista _transportista = new transportista();
                
                _transportista.setId(rs.getInt(3));
                _transportista.setNombreCompleto(rs.getString(4));
                _vehiculoObj.setTransportista(_transportista);
                
                _vehiculoObj.setMarca(rs.getString(5));
                _vehiculoObj.setModelo(rs.getString(6));
                _vehiculoObj.setTipo(rs.getString(7));
                _vehiculoObj.setNumeroSerie(rs.getString(8));
                _vehiculoObj.setPlacas(rs.getString(9));
                _vehiculoObj.setNumeroEconomico(rs.getString(10));
                _vehiculoObj.setTarjetaCirculacion(rs.getString(11));
                _vehiculoObj.setPolizaSeguro(rs.getString(12));
                _vehiculoObj.setFechaPoliza(rs.getString(13));
                _vehiculoObj.setIdEstado(rs.getInt(14));

                _listaArchivos.add(_vehiculoObj);
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

        return _listaArchivos;
    }

    @Override
    public Object consultarPorId(int id) throws Exception {

        vehiculo _vehiculoObj = new vehiculo();

        String _consulta = "SELECT  " +
                    "    dbvehiculo.id AS 'id', " +
                    "    dbvehiculo.nombrePropietario AS 'nombrePropietario', " +
                    "    dbvehiculo.idTransportista AS 'idTransportista', " +
                    "    dbtransportista.nombreCompleto AS 'nombreTransportista', " +
                    "    dbvehiculo.marca AS 'marca', " +
                    "    dbvehiculo.modelo AS 'modelo', " +
                    "    dbvehiculo.tipo AS 'tipo', " +
                    "    dbvehiculo.numeroSerie AS 'numeroSerie', " +
                    "    dbvehiculo.placas AS 'placas', " +
                    "    dbvehiculo.numeroEconomico AS 'numeroEconomico', " +
                    "    dbvehiculo.tarjetaCirculacion AS 'tarjetaCirculacion', " +
                    "    dbvehiculo.polizaSeguro AS 'polizaSeguro', " +
                    "    dbvehiculo.fechaPoliza AS 'fechaPoliza', " +
                    "    dbvehiculo.idEstado AS 'idEstado' " +
                    "FROM " +
                    "    controlGPC.dbvehiculo " +
                    "        LEFT JOIN " +
                    "    dbtransportista ON dbtransportista.id = dbvehiculo.idTransportista " +
                    "WHERE dbvehiculo.id = " + id + " AND dbvehiculo.idEstado <> 3;";

        PreparedStatement st = this._conn.prepareStatement(_consulta);

        ResultSet rs = st.executeQuery();

        try {

            while (rs.next()) {

                _vehiculoObj.setId(rs.getInt(1));
                _vehiculoObj.setNombrePropietario(rs.getString(2));
                
                transportista _transportista = new transportista();
                
                _transportista.setId(rs.getInt(3));
                _transportista.setNombreCompleto(rs.getString(4));
                _vehiculoObj.setTransportista(_transportista);
                
                _vehiculoObj.setMarca(rs.getString(5));
                _vehiculoObj.setModelo(rs.getString(6));
                _vehiculoObj.setTipo(rs.getString(7));
                _vehiculoObj.setNumeroSerie(rs.getString(8));
                _vehiculoObj.setPlacas(rs.getString(9));
                _vehiculoObj.setNumeroEconomico(rs.getString(10));
                _vehiculoObj.setTarjetaCirculacion(rs.getString(11));
                _vehiculoObj.setPolizaSeguro(rs.getString(12));
                _vehiculoObj.setFechaPoliza(rs.getString(13));
                _vehiculoObj.setIdEstado(rs.getInt(14));

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

        return _vehiculoObj;
    }
    
}
