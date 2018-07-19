package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.database.tipoDocumentoDAOImpl;
import database.baseDatos;
import entity.tipoDocumento;
import entity.tipoMovimiento;
import entity.unidadMedida;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juan_m_osuna
 */
public class tipoDocumentoServlet extends HttpServlet {

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
        tipoDocumentoDAOImpl _tipoDocumentoDAO = new tipoDocumentoDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();
        
        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion").trim() : new String());
            int _idtipoMovimiento = (request.getParameter("idTipoMovimiento") != null && !request.getParameter("idTipoMovimiento").isEmpty() ? Integer.valueOf(request.getParameter("idTipoMovimiento").trim()) : 0);
            
            switch (_opcion) {
                case 1: {
                    
                    tipoDocumento _tipoDocumentoObj = new tipoDocumento();
                    
                    _tipoDocumentoObj.setNombreCompleto(_nombreCompleto);
                    _tipoDocumentoObj.setDescripcion(_descripcion);
                    
                    tipoMovimiento _tipoMovimiento = new tipoMovimiento();
                    _tipoMovimiento.setId(_idtipoMovimiento);
                    _tipoDocumentoObj.setTipoMovimiento(_tipoMovimiento);
                    
                    _tipoDocumentoObj.setIdEstado(1);
                    
                    if(!_tipoDocumentoDAO.agregarRegistro(_tipoDocumentoObj)){
                        mensajeAlerta = "success, Se ha agregado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al agregar el registro ... !!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    tipoDocumento _tipoDocumentoObj = new tipoDocumento();
                    
                    _tipoDocumentoObj.setId(_id);
                    _tipoDocumentoObj.setNombreCompleto(_nombreCompleto);
                    _tipoDocumentoObj.setDescripcion(_descripcion);
                    
                    tipoMovimiento _tipoMovimiento = new tipoMovimiento();
                    _tipoMovimiento.setId(_idtipoMovimiento);
                    _tipoDocumentoObj.setTipoMovimiento(_tipoMovimiento);
                   
                    _tipoDocumentoObj.setIdEstado(2);
                    
                    if(!_tipoDocumentoDAO.modificarRegistro(_tipoDocumentoObj)){
                        mensajeAlerta = "success, Se ha modificado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al modificar el registro ... !!";
                    }                 
                    
                    break;
                }
                case 3: {
                    
                    if(!_tipoDocumentoDAO.eliminarRegistro(_id)){
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
            response.sendRedirect("/controlGPC/catalogos/tipoDocumento/tipoDocumentoTabla.jsp?m="+mensajeAlerta);
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
