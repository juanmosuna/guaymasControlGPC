/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.contactoClienteDAOImpl;
import database.baseDatos;
import entity.cliente;
import entity.contactoCliente;
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
public class contactoClienteServlet extends HttpServlet {

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
        contactoClienteDAOImpl _contactoClienteDAO = new contactoClienteDAOImpl(_baseDatos.getConnection());

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
            int _idCliente = (request.getParameter("idCliente") != null && !request.getParameter("idCliente").isEmpty() ? Integer.valueOf(request.getParameter("idCliente").trim()) : 0);
            byte[] _fotoContactoCliente = null;
            
            if (_opcion != 3) {
                Part filePart = request.getPart("fotoContactoCliente");

                if (filePart != null) {
                    is = filePart.getInputStream();
                    _fotoContactoCliente = new byte[is.available()];
                    is.read(_fotoContactoCliente, 0, _fotoContactoCliente.length);
                }
            }
            
            switch (_opcion) {
                case 1: {
                    
                    contactoCliente _contactoClienteObj = new contactoCliente();
                    
                    _contactoClienteObj.setNombreCompleto(_nombreCompleto);
                    _contactoClienteObj.setDescripcion(_descripcion);
                    _contactoClienteObj.setDomicilio(_domicilio);
                    _contactoClienteObj.setCodigoPostal(_codigoPostal);
                    _contactoClienteObj.setLocalidad(_localidad);
                    _contactoClienteObj.setCiudad(_ciudad);
                    _contactoClienteObj.setEstado(_estado);
                    _contactoClienteObj.setPais(_pais);
                    _contactoClienteObj.setTelefono(_telefono);
                    _contactoClienteObj.setMobile(_mobile);
                    _contactoClienteObj.setFax(_fax);
                    _contactoClienteObj.setCorreoElectronico(_correoElectronico);
                    _contactoClienteObj.setFotoContactoCliente(_fotoContactoCliente);
                    
                    cliente _clienteObj = new cliente();
                    _clienteObj.setId(_idCliente);
                    
                    _contactoClienteObj.setCliente(_clienteObj);
                    _contactoClienteObj.setIdEstado(1);
                    
                    if(!_contactoClienteDAO.agregarRegistro(_contactoClienteObj)){
                        mensajeAlerta = "Se agrego satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    contactoCliente _contactoClienteObj = new contactoCliente();
                    
                    _contactoClienteObj.setId(_id);
                    _contactoClienteObj.setNombreCompleto(_nombreCompleto);
                    _contactoClienteObj.setDescripcion(_descripcion);
                    _contactoClienteObj.setDomicilio(_domicilio);
                    _contactoClienteObj.setCodigoPostal(_codigoPostal);
                    _contactoClienteObj.setLocalidad(_localidad);
                    _contactoClienteObj.setCiudad(_ciudad);
                    _contactoClienteObj.setEstado(_estado);
                    _contactoClienteObj.setPais(_pais);
                    _contactoClienteObj.setTelefono(_telefono);
                    _contactoClienteObj.setMobile(_mobile);
                    _contactoClienteObj.setFax(_fax);
                    _contactoClienteObj.setCorreoElectronico(_correoElectronico);
                    _contactoClienteObj.setFotoContactoCliente(_fotoContactoCliente);
                    
                    cliente _clienteObj = new cliente();
                    _clienteObj.setId(_idCliente);
                    
                    _contactoClienteObj.setCliente(_clienteObj);
                    _contactoClienteObj.setIdEstado(2);
                    
                    if(!_contactoClienteDAO.modificarRegistro(_contactoClienteObj)){
                        mensajeAlerta = "Se modifico satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 3: {
                    
                    if(!_contactoClienteDAO.eliminarRegistro(_id)){
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
            response.sendRedirect("/controlGPC/catalogos/contactoCliente/contactoClienteTabla.jsp");
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
