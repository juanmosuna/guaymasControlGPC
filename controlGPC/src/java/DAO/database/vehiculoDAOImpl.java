/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.database;

import DAO.interfaces.catalogosInterface;
import entity.tipoVehiculo;
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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("INSERT INTO controlGPC.dbvehiculo ")
                .append("(nombrePropietario, ")
                .append("idTransportista, ")
                .append("marca, ")
                .append("modelo, ")
                .append("idTipoVehiculo, ")
                .append("numeroSerie, ")
                .append("placas, ")
                .append("numeroEconomico, ")
                .append("tarjetaCirculacion, ")
                .append("polizaSeguro, ")
                .append("fechaPoliza, ")
                .append("idEstado) ")
                .append("VALUES ")
                .append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _vehiculoObj.getNombrePropietario());
        st.setInt(2, _vehiculoObj.getTransportista().getId());
        st.setString(3, _vehiculoObj.getMarca());
        st.setString(4, _vehiculoObj.getModelo());
        st.setInt(5, _vehiculoObj.getTipoVehiculo().getId());
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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbvehiculo ")
                .append("SET ")
                .append("nombrePropietario = ?, ")
                .append("idTransportista = ?, ")
                .append("marca = ?, ")
                .append("modelo = ?, ")
                .append("idTipoVehiculo = ?, ")
                .append("numeroSerie = ?, ")
                .append("placas = ?, ")
                .append("numeroEconomico = ?, ")
                .append("tarjetaCirculacion = ?, ")
                .append("polizaSeguro = ?, ")
                .append("fechaPoliza = ?, ")
                .append("idEstado = ? ")
                .append("WHERE id = ?;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

        st.setString(1, _vehiculoObj.getNombrePropietario());
        st.setInt(2, _vehiculoObj.getTransportista().getId());
        st.setString(3, _vehiculoObj.getMarca());
        st.setString(4, _vehiculoObj.getModelo());
        st.setInt(5, _vehiculoObj.getTipoVehiculo().getId());
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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("UPDATE controlGPC.dbvehiculo SET idEstado = 3 WHERE id = ?;");

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

        vehiculo _vehiculoObj;

        List<vehiculo> _listaArchivos = new ArrayList();

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbvehiculo.id AS 'id', ")
                .append("    dbvehiculo.nombrePropietario AS 'nombrePropietario', ")
                .append("    dbvehiculo.idTransportista AS 'idTransportista', ")
                .append("    dbtransportista.nombreCompleto AS 'nombreTransportista', ")
                .append("    dbvehiculo.marca AS 'marca', ")
                .append("    dbvehiculo.modelo AS 'modelo', ")
                .append("    dbvehiculo.idTipoVehiculo AS 'idTipoVehiculo', ")
                .append("    dbtipoVehiculo.nombreCompleto AS 'nombreTipoVehiculo', ")
                .append("    dbvehiculo.numeroSerie AS 'numeroSerie', ")
                .append("    dbvehiculo.placas AS 'placas', ")
                .append("    dbvehiculo.numeroEconomico AS 'numeroEconomico', ")
                .append("    dbvehiculo.tarjetaCirculacion AS 'tarjetaCirculacion', ")
                .append("    dbvehiculo.polizaSeguro AS 'polizaSeguro', ")
                .append("    dbvehiculo.fechaPoliza AS 'fechaPoliza', ")
                .append("    dbvehiculo.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbvehiculo ")
                .append("        LEFT JOIN ")
                .append("    dbtransportista ON dbtransportista.id = dbvehiculo.idTransportista ")
                .append("        LEFT JOIN ")
                .append("    dbtipoVehiculo ON dbtipoVehiculo.id = dbvehiculo.idTipoVehiculo ")
                .append("WHERE ")
                .append("    dbvehiculo.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
                
                tipoVehiculo _tpVehiculo = new tipoVehiculo();
                _tpVehiculo.setId(rs.getInt(7));
                _tpVehiculo.setNombreCompleto(rs.getString(8));                
                _vehiculoObj.setTipoVehiculo(_tpVehiculo);
                
                _vehiculoObj.setNumeroSerie(rs.getString(9));
                _vehiculoObj.setPlacas(rs.getString(10));
                _vehiculoObj.setNumeroEconomico(rs.getString(11));
                _vehiculoObj.setTarjetaCirculacion(rs.getString(12));
                _vehiculoObj.setPolizaSeguro(rs.getString(13));
                _vehiculoObj.setFechaPoliza(rs.getString(14));
                _vehiculoObj.setIdEstado(rs.getInt(15));

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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbvehiculo.id AS 'id', ")
                .append("    dbvehiculo.nombrePropietario AS 'nombrePropietario', ")
                .append("    dbvehiculo.idTransportista AS 'idTransportista', ")
                .append("    dbtransportista.nombreCompleto AS 'nombreTransportista', ")
                .append("    dbvehiculo.marca AS 'marca', ")
                .append("    dbvehiculo.modelo AS 'modelo', ")
                .append("    dbvehiculo.idTipoVehiculo AS 'idTipoVehiculo', ")
                .append("    dbtipoVehiculo.nombreCompleto AS 'nombreTipoVehiculo', ")
                .append("    dbvehiculo.numeroSerie AS 'numeroSerie', ")
                .append("    dbvehiculo.placas AS 'placas', ")
                .append("    dbvehiculo.numeroEconomico AS 'numeroEconomico', ")
                .append("    dbvehiculo.tarjetaCirculacion AS 'tarjetaCirculacion', ")
                .append("    dbvehiculo.polizaSeguro AS 'polizaSeguro', ")
                .append("    dbvehiculo.fechaPoliza AS 'fechaPoliza', ")
                .append("    dbvehiculo.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbvehiculo ")
                .append("        LEFT JOIN ")
                .append("    dbtransportista ON dbtransportista.id = dbvehiculo.idTransportista ")
                .append("        LEFT JOIN ")
                .append("    dbtipoVehiculo ON dbtipoVehiculo.id = dbvehiculo.idTipoVehiculo ")
                .append("WHERE ")
                .append(_campo)
                .append(" LIKE '%")
                .append(_dato)
                .append("%' AND dbvehiculo.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
                
                tipoVehiculo _tpVehiculo = new tipoVehiculo();
                _tpVehiculo.setId(rs.getInt(7));
                _tpVehiculo.setNombreCompleto(rs.getString(8));               
                _vehiculoObj.setTipoVehiculo(_tpVehiculo);
                
                _vehiculoObj.setNumeroSerie(rs.getString(9));
                _vehiculoObj.setPlacas(rs.getString(10));
                _vehiculoObj.setNumeroEconomico(rs.getString(11));
                _vehiculoObj.setTarjetaCirculacion(rs.getString(12));
                _vehiculoObj.setPolizaSeguro(rs.getString(13));
                _vehiculoObj.setFechaPoliza(rs.getString(14));
                _vehiculoObj.setIdEstado(rs.getInt(15));

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

        StringBuilder _consulta = new StringBuilder();

        _consulta.append("SELECT  ")
                .append("    dbvehiculo.id AS 'id', ")
                .append("    dbvehiculo.nombrePropietario AS 'nombrePropietario', ")
                .append("    dbvehiculo.idTransportista AS 'idTransportista', ")
                .append("    dbtransportista.nombreCompleto AS 'nombreTransportista', ")
                .append("    dbvehiculo.marca AS 'marca', ")
                .append("    dbvehiculo.modelo AS 'modelo', ")
                .append("    dbvehiculo.idTipoVehiculo AS 'idTipoVehiculo', ")
                .append("    dbtipoVehiculo.nombreCompleto AS 'nombreTipoVehiculo', ")
                .append("    dbvehiculo.numeroSerie AS 'numeroSerie', ")
                .append("    dbvehiculo.placas AS 'placas', ")
                .append("    dbvehiculo.numeroEconomico AS 'numeroEconomico', ")
                .append("    dbvehiculo.tarjetaCirculacion AS 'tarjetaCirculacion', ")
                .append("    dbvehiculo.polizaSeguro AS 'polizaSeguro', ")
                .append("    dbvehiculo.fechaPoliza AS 'fechaPoliza', ")
                .append("    dbvehiculo.idEstado AS 'idEstado' ")
                .append("FROM ")
                .append("    controlGPC.dbvehiculo ")
                .append("        LEFT JOIN ")
                .append("    dbtransportista ON dbtransportista.id = dbvehiculo.idTransportista ")
                .append("        LEFT JOIN ")
                .append("    dbtipoVehiculo ON dbtipoVehiculo.id = dbvehiculo.idTipoVehiculo ")
                .append("WHERE dbvehiculo.id = ")
                .append(id)
                .append(" AND dbvehiculo.idEstado <> 3;");

        PreparedStatement st = this._conn.prepareStatement(_consulta.toString());

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
                
                tipoVehiculo _tpVehiculo = new tipoVehiculo();
                _tpVehiculo.setId(rs.getInt(7));
                _tpVehiculo.setNombreCompleto(rs.getString(8));                
                _vehiculoObj.setTipoVehiculo(_tpVehiculo);
                
                _vehiculoObj.setNumeroSerie(rs.getString(9));
                _vehiculoObj.setPlacas(rs.getString(10));
                _vehiculoObj.setNumeroEconomico(rs.getString(11));
                _vehiculoObj.setTarjetaCirculacion(rs.getString(12));
                _vehiculoObj.setPolizaSeguro(rs.getString(13));
                _vehiculoObj.setFechaPoliza(rs.getString(14));
                _vehiculoObj.setIdEstado(rs.getInt(15));

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
