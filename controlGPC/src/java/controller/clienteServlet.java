/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.clienteDAOImpl;
import database.baseDatos;
import entity.cliente;
import java.io.IOException;
import java.io.InputStream;
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
public class clienteServlet extends HttpServlet {

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
        clienteDAOImpl _clienteDAO = new clienteDAOImpl(_baseDatos.getConnection());

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
            String _paginaWeb = (request.getParameter("paginaWeb") != null && !request.getParameter("paginaWeb").isEmpty() ? String.valueOf(request.getParameter("paginaWeb").trim()) : new String());
            byte[] _fotoCliente = null;
            
            if (_opcion != 3) {
                Part filePart = request.getPart("fotoCliente");

                if (filePart != null) {
                    is = filePart.getInputStream();
                    _fotoCliente = new byte[is.available()];
                    is.read(_fotoCliente, 0, _fotoCliente.length);
                }
            }
            
            switch (_opcion) {
                case 1: {
                    
                    cliente _clienteObj = new cliente();
                    
                    _clienteObj.setNombreCompleto(_nombreCompleto);
                    _clienteObj.setDescripcion(_descripcion);
                    _clienteObj.setDomicilio(_domicilio);
                    _clienteObj.setCodigoPostal(_codigoPostal);
                    _clienteObj.setLocalidad(_localidad);
                    _clienteObj.setCiudad(_ciudad);
                    _clienteObj.setEstado(_estado);
                    _clienteObj.setPais(_pais);
                    _clienteObj.setTelefono(_telefono);
                    _clienteObj.setMobile(_mobile);
                    _clienteObj.setFax(_fax);
                    _clienteObj.setCorreoElectronico(_correoElectronico);
                    _clienteObj.setFotoCliente(_fotoCliente);
                    _clienteObj.setPaginaWeb(_paginaWeb);
                    _clienteObj.setIdEstado(1);
                    
                    if(!_clienteDAO.agregarRegistro(_clienteObj)){
                        mensajeAlerta = "success, Se ha agregado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al agregar el registro ... !!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    cliente _clienteObj = new cliente();
                    
                    _clienteObj.setId(_id);
                    _clienteObj.setNombreCompleto(_nombreCompleto);
                    _clienteObj.setDescripcion(_descripcion);
                    _clienteObj.setDomicilio(_domicilio);
                    _clienteObj.setCodigoPostal(_codigoPostal);
                    _clienteObj.setLocalidad(_localidad);
                    _clienteObj.setCiudad(_ciudad);
                    _clienteObj.setEstado(_estado);
                    _clienteObj.setPais(_pais);
                    _clienteObj.setTelefono(_telefono);
                    _clienteObj.setMobile(_mobile);
                    _clienteObj.setFax(_fax);
                    _clienteObj.setCorreoElectronico(_correoElectronico);
                    _clienteObj.setFotoCliente(_fotoCliente);
                    _clienteObj.setPaginaWeb(_paginaWeb);
                    _clienteObj.setIdEstado(2);
                    
                    if(!_clienteDAO.modificarRegistro(_clienteObj)){
                        mensajeAlerta = "success, Se ha modificado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al modificar el registro ... !!";
                    }                 
                    
                    break;
                }
                case 3: {
                    
                    if(!_clienteDAO.eliminarRegistro(_id)){
                        mensajeAlerta = "success, Se ha eliminado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al eliminar el registro ... !!";
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
            response.sendRedirect("/controlGPC/catalogos/cliente/clienteTabla.jsp?m="+mensajeAlerta);
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
