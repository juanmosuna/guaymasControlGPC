/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.tipoMovimientoDAOImpl;
import database.baseDatos;
import entity.tipoMovimiento;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "tipoMovimientoServlet", urlPatterns = {"/tipoMovimientoServlet.do"})
public class tipoMovimientoServlet extends HttpServlet {

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
        tipoMovimientoDAOImpl _tipoMovimientoDAO = new tipoMovimientoDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();
        
        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion").trim() : new String());
            
            switch (_opcion) {
                case 1: {
                    
                    tipoMovimiento _tpMvimientoObj = new tipoMovimiento();
                    
                    _tpMvimientoObj.setNombreCompleto(_nombreCompleto);
                    _tpMvimientoObj.setDescripcion(_descripcion);
                    _tpMvimientoObj.setIdEstado(1);
                    
                    if(!_tipoMovimientoDAO.agregarRegistro(_tpMvimientoObj)){
                        mensajeAlerta = "Se agrego satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    tipoMovimiento _tpMvimientoObj = new tipoMovimiento();
                    
                    _tpMvimientoObj.setId(_id);
                    _tpMvimientoObj.setNombreCompleto(_nombreCompleto);
                    _tpMvimientoObj.setDescripcion(_descripcion);
                    _tpMvimientoObj.setIdEstado(2);
                    
                    if(!_tipoMovimientoDAO.modificarRegistro(_tpMvimientoObj)){
                        mensajeAlerta = "Se modifico satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 3: {
                    
                    if(!_tipoMovimientoDAO.eliminarRegistro(_id)){
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
            response.sendRedirect("/controlGPC/catalogos/tipoMovimiento/tipoMovimientoTabla.jsp");
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
