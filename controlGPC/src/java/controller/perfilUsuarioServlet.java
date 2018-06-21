/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.perfilUsuarioDAOImpl;
import database.baseDatos;
import entity.perfilUsuario;
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
@WebServlet(name = "perfilUsuarioServlet", urlPatterns = {"/perfilUsuarioServlet.do"})
public class perfilUsuarioServlet extends HttpServlet {

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
        perfilUsuarioDAOImpl _perfilUsuarioDAO = new perfilUsuarioDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();

        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion").trim() : new String());
            boolean _accesoPlataforma = (request.getParameter("accesoPlataforma") != null && !request.getParameter("accesoPlataforma").isEmpty() ? (request.getParameter("accesoPlataforma").equals("on") ? true : false ) : false);
            boolean _gestionCatalogos = (request.getParameter("gestionCatalogos") != null && !request.getParameter("gestionCatalogos").isEmpty() ? (request.getParameter("gestionCatalogos").equals("on") ? true  : false ) : false);
            boolean _gestionUsuario = (request.getParameter("gestionUsuario") != null && !request.getParameter("gestionUsuario").isEmpty() ? (request.getParameter("gestionUsuario").equals("on") ? true  : false ) : false);
            boolean _gestionDocumentos = (request.getParameter("gestionDocumentos") != null && !request.getParameter("gestionDocumentos").isEmpty() ? (request.getParameter("gestionDocumentos").equals("on") ? true  : false ) : false);
            boolean _agregarDocumento = (request.getParameter("agregarDocumento") != null && !request.getParameter("agregarDocumento").isEmpty() ? (request.getParameter("agregarDocumento").equals("on") && _gestionDocumentos ? true  : false ) : false);
            boolean _eliminarDocumento = (request.getParameter("eliminarDocumento") != null && !request.getParameter("eliminarDocumento").isEmpty() ? (request.getParameter("eliminarDocumento").equals("on") && _gestionDocumentos ? true  : false ) : false);
            boolean _modificarDocumento = (request.getParameter("modificarDocumento") != null && !request.getParameter("modificarDocumento").isEmpty() ? (request.getParameter("modificarDocumento").equals("on") && _gestionDocumentos ? true  : false ) : false);
            boolean _buscarDocumento = (request.getParameter("buscarDocumento") != null && !request.getParameter("buscarDocumento").isEmpty() ? (request.getParameter("buscarDocumento").equals("on") && _gestionDocumentos ? true  : false ) : false);
            boolean _imprimirDocumento = (request.getParameter("imprimirDocumento") != null && !request.getParameter("imprimirDocumento").isEmpty() ? (request.getParameter("imprimirDocumento").equals("on") && _gestionDocumentos ? true  : false ) : false);

            switch (_opcion) {
                case 1: {

                    perfilUsuario _perfilUsuarioObj = new perfilUsuario();

                    _perfilUsuarioObj.setNombreCompleto(_nombreCompleto);
                    _perfilUsuarioObj.setDescripcion(_descripcion);
                    _perfilUsuarioObj.setAccesoPlataforma(_accesoPlataforma);
                    _perfilUsuarioObj.setGestionCatalogos(_gestionCatalogos);
                    _perfilUsuarioObj.setGestionUsuario(_gestionUsuario);
                    _perfilUsuarioObj.setGestionDocumentos(_gestionDocumentos);
                    _perfilUsuarioObj.setAgregarDocumento(_agregarDocumento);
                    _perfilUsuarioObj.setEliminarDocumento(_eliminarDocumento);
                    _perfilUsuarioObj.setModificarDocumento(_modificarDocumento);
                    _perfilUsuarioObj.setBuscarDocumento(_buscarDocumento);
                    _perfilUsuarioObj.setImprimirDocumento(_imprimirDocumento);
                    _perfilUsuarioObj.setIdEstado(1);

                    if (!_perfilUsuarioDAO.agregarRegistro(_perfilUsuarioObj)) {
                        mensajeAlerta = "success, Se ha agregado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al agregar el registro ... !!";
                    }

                    break;
                }
                case 2: {

                    perfilUsuario _perfilUsuarioObj = new perfilUsuario();
                    
                    _perfilUsuarioObj.setId(_id);
                    _perfilUsuarioObj.setNombreCompleto(_nombreCompleto);
                    _perfilUsuarioObj.setDescripcion(_descripcion);
                    _perfilUsuarioObj.setAccesoPlataforma(_accesoPlataforma);
                    _perfilUsuarioObj.setGestionCatalogos(_gestionCatalogos);
                    _perfilUsuarioObj.setGestionUsuario(_gestionUsuario);
                    _perfilUsuarioObj.setGestionDocumentos(_gestionDocumentos);
                    _perfilUsuarioObj.setAgregarDocumento(_agregarDocumento);
                    _perfilUsuarioObj.setEliminarDocumento(_eliminarDocumento);
                    _perfilUsuarioObj.setModificarDocumento(_modificarDocumento);
                    _perfilUsuarioObj.setBuscarDocumento(_buscarDocumento);
                    _perfilUsuarioObj.setImprimirDocumento(_imprimirDocumento);
                    _perfilUsuarioObj.setIdEstado(2);

                    if (!_perfilUsuarioDAO.modificarRegistro(_perfilUsuarioObj)) {
                        mensajeAlerta = "success, Se ha modificado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al modificar el registro ... !!";
                    }

                    break;
                }
                case 3: {

                    if (!_perfilUsuarioDAO.eliminarRegistro(_id)) {
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
            
            response.sendRedirect("/controlGPC/catalogos/perfilUsuario/perfilUsuarioTabla.jsp?m="+mensajeAlerta);
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
