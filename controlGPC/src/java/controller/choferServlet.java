/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.choferDAOImpl;
import database.baseDatos;
import entity.chofer;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author elara
 */
public class choferServlet extends HttpServlet {

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
        choferDAOImpl _choferDAO = new choferDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();
        
        InputStream is = null;
        
        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion").trim() : new String());
            String _domicilio = (request.getParameter("domicilio") != null && !request.getParameter("domicilio").isEmpty() ? String.valueOf(request.getParameter("domicilio").trim()) : new String());
            String _codigoPostal = (request.getParameter("codigoPostal") != null && !request.getParameter("codigoPostal").isEmpty() ? String.valueOf(request.getParameter("codigoPostal").trim()) : new String());
            String _localidad = (request.getParameter("localidad") != null && !request.getParameter("localidad").isEmpty() ? String.valueOf(request.getParameter("localidad").trim()) : new String());
            String _ciudad = (request.getParameter("ciudad") != null && !request.getParameter("ciudad").isEmpty() ? String.valueOf(request.getParameter("ciudad").trim()) : new String());
            String _estado = (request.getParameter("estado") != null && !request.getParameter("estado").isEmpty() ? String.valueOf(request.getParameter("estado").trim()) : new String());
            String _pais = (request.getParameter("pais") != null && !request.getParameter("pais").isEmpty() ? String.valueOf(request.getParameter("pais").trim()) : new String());
            String _telefono = (request.getParameter("telefono") != null && !request.getParameter("telefono").isEmpty() ? String.valueOf(request.getParameter("telefono").trim()) : new String());
            String _mobile = (request.getParameter("mobile") != null && !request.getParameter("mobile").isEmpty() ? String.valueOf(request.getParameter("mobile").trim()) : new String());
            String _fax = (request.getParameter("fax") != null && !request.getParameter("fax").isEmpty() ? String.valueOf(request.getParameter("fax").trim()) : new String());
            String _correoElectronico = (request.getParameter("correoElectronico") != null && !request.getParameter("correoElectronico").isEmpty() ? String.valueOf(request.getParameter("correoElectronico").trim()) : new String());
            byte[] _fotoChofer = null;
            String _licenciaManejo = (request.getParameter("licenciaManejo") != null && !request.getParameter("licenciaManejo").isEmpty() ? String.valueOf(request.getParameter("licenciaManejo").trim()) : new String());
            
            if (_opcion != 3) {
                Part filePart = request.getPart("fotoChofer");

                if (filePart != null) {
                    is = filePart.getInputStream();
                    _fotoChofer = new byte[is.available()];
                    is.read(_fotoChofer, 0, _fotoChofer.length);
                }
            }
            
            switch (_opcion) {
                case 1: {
                    
                    chofer _choferObj = new chofer();
                    
                    _choferObj.setNombreCompleto(_nombreCompleto);
                    _choferObj.setDescripcion(_descripcion);
                    _choferObj.setDomicilio(_domicilio);
                    _choferObj.setCodigoPostal(_codigoPostal);
                    _choferObj.setLocalidad(_localidad);
                    _choferObj.setCiudad(_ciudad);
                    _choferObj.setEstado(_estado);
                    _choferObj.setPais(_pais);
                    _choferObj.setTelefono(_telefono);
                    _choferObj.setMobile(_mobile);
                    _choferObj.setFax(_fax);
                    _choferObj.setCorreoElectronico(_correoElectronico);
                    _choferObj.setFotoChofer(_fotoChofer);
                    _choferObj.setLicenciaManejo(_licenciaManejo);
                    _choferObj.setIdEstado(1);
                    
                    if(!_choferDAO.agregarRegistro(_choferObj)){
                        mensajeAlerta = "Se agrego satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    chofer _choferObj = new chofer();
                    
                    _choferObj.setId(_id);
                    _choferObj.setNombreCompleto(_nombreCompleto);
                    _choferObj.setDescripcion(_descripcion);
                    _choferObj.setDomicilio(_domicilio);
                    _choferObj.setCodigoPostal(_codigoPostal);
                    _choferObj.setLocalidad(_localidad);
                    _choferObj.setCiudad(_ciudad);
                    _choferObj.setEstado(_estado);
                    _choferObj.setPais(_pais);
                    _choferObj.setTelefono(_telefono);
                    _choferObj.setMobile(_mobile);
                    _choferObj.setFax(_fax);
                    _choferObj.setCorreoElectronico(_correoElectronico);
                    _choferObj.setFotoChofer(_fotoChofer);
                    _choferObj.setLicenciaManejo(_licenciaManejo);
                    _choferObj.setIdEstado(2);
                    
                    if(!_choferDAO.modificarRegistro(_choferObj)){
                        mensajeAlerta = "Se modifico satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 3: {
                    
                    if(!_choferDAO.eliminarRegistro(_id)){
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
            response.sendRedirect("/controlGPC/catalogos/chofer/choferTabla.jsp");
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
