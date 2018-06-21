/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.vehiculoDAOImpl;
import database.baseDatos;
import entity.tipoVehiculo;
import entity.transportista;
import entity.vehiculo;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author elara
 */
@WebServlet(name = "vehiculoServlet", urlPatterns = {"/vehiculoServlet.do"})
public class vehiculoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String _nombreUsuario = (session.getAttribute("nombreUsuario") != null ? session.getAttribute("nombreUsuario").toString() : new String());

        SimpleDateFormat _formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat _formatoHora = new SimpleDateFormat("HH:mm:ss");

        baseDatos _baseDatos = new baseDatos();
        vehiculoDAOImpl _vehiculoDAO = new vehiculoDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();
        
        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _nombrePropietario = (request.getParameter("nombrePropietario") != null && !request.getParameter("nombrePropietario").isEmpty() ? request.getParameter("nombrePropietario").trim() : new String());
            int _idTransportista = (request.getParameter("idTransportista") != null && !request.getParameter("idTransportista").isEmpty() ? Integer.valueOf(request.getParameter("idTransportista").trim()) : 0);
            String _marca = (request.getParameter("marca") != null && !request.getParameter("marca").isEmpty() ? request.getParameter("marca").trim() : new String());
            String _modelo = (request.getParameter("modelo") != null && !request.getParameter("modelo").isEmpty() ? request.getParameter("modelo").trim() : new String());
            int _idTipoVehiculo = (request.getParameter("idTipoVehiculo") != null && !request.getParameter("idTipoVehiculo").isEmpty() ? Integer.valueOf(request.getParameter("idTipoVehiculo").trim()) : 0);
            String _numeroSerie = (request.getParameter("numeroSerie") != null && !request.getParameter("numeroSerie").isEmpty() ? request.getParameter("numeroSerie").trim() : new String());
            String _placas = (request.getParameter("placas") != null && !request.getParameter("placas").isEmpty() ? request.getParameter("placas").trim() : new String());
            String _numeroEconomico = (request.getParameter("numeroEconomico") != null && !request.getParameter("numeroEconomico").isEmpty() ? request.getParameter("numeroEconomico").trim() : new String());
            String _tarjetaCirculacion = (request.getParameter("tarjetaCirculacion") != null && !request.getParameter("tarjetaCirculacion").isEmpty() ? request.getParameter("tarjetaCirculacion").trim() : new String());
            String _polizaSeguro = (request.getParameter("polizaSeguro") != null && !request.getParameter("polizaSeguro").isEmpty() ? request.getParameter("polizaSeguro").trim() : new String());
            String _fechaPoliza = (request.getParameter("fechaPoliza") != null && !request.getParameter("fechaPoliza").isEmpty() ? request.getParameter("fechaPoliza").trim() : new String());
            
            switch (_opcion) {
                case 1: {
                    
                    vehiculo _vehiculoObj = new vehiculo();
                    
                    _vehiculoObj.setNombrePropietario(_nombrePropietario);
                    
                    transportista _trsp = new transportista();
                    _trsp.setId(_idTransportista);
                    
                    _vehiculoObj.setTransportista(_trsp);
                    _vehiculoObj.setMarca(_marca);
                    _vehiculoObj.setModelo(_modelo);
                    
                    tipoVehiculo _tpVehiculo = new tipoVehiculo();
                    _tpVehiculo.setId(_idTipoVehiculo);
                    
                    _vehiculoObj.setTipoVehiculo(_tpVehiculo);
                    _vehiculoObj.setNumeroSerie(_numeroSerie);
                    _vehiculoObj.setPlacas(_placas);
                    _vehiculoObj.setNumeroEconomico(_numeroEconomico);
                    _vehiculoObj.setTarjetaCirculacion(_tarjetaCirculacion);
                    _vehiculoObj.setPolizaSeguro(_polizaSeguro);
                    _vehiculoObj.setFechaPoliza(_fechaPoliza);
                    _vehiculoObj.setIdEstado(1);
                    
                    if(!_vehiculoDAO.agregarRegistro(_vehiculoObj)){
                        mensajeAlerta = "Se agrego satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    vehiculo _vehiculoObj = new vehiculo();
                    
                    _vehiculoObj.setId(_id);
                    _vehiculoObj.setNombrePropietario(_nombrePropietario);
                    
                    transportista _trsp = new transportista();
                    _trsp.setId(_idTransportista);
                    
                    _vehiculoObj.setTransportista(_trsp);
                    _vehiculoObj.setMarca(_marca);
                    _vehiculoObj.setModelo(_modelo);
                    
                    tipoVehiculo _tpVehiculo = new tipoVehiculo();
                    _tpVehiculo.setId(_idTipoVehiculo);
                    
                    _vehiculoObj.setTipoVehiculo(_tpVehiculo);
                    _vehiculoObj.setNumeroSerie(_numeroSerie);
                    _vehiculoObj.setPlacas(_placas);
                    _vehiculoObj.setNumeroEconomico(_numeroEconomico);
                    _vehiculoObj.setTarjetaCirculacion(_tarjetaCirculacion);
                    _vehiculoObj.setPolizaSeguro(_polizaSeguro);
                    _vehiculoObj.setFechaPoliza(_fechaPoliza);
                    _vehiculoObj.setIdEstado(2);
                    
                    if(!_vehiculoDAO.modificarRegistro(_vehiculoObj)){
                        mensajeAlerta = "Se modifico satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 3: {
                    
                    if(!_vehiculoDAO.eliminarRegistro(_id)){
                        mensajeAlerta = "Se elimino satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (_baseDatos != null) {
                _baseDatos.closeConnection();
            }
            response.sendRedirect("/controlGPC/catalogos/vehiculo/vehiculoTabla.jsp");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
