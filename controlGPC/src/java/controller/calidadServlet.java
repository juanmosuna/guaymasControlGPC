/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.calidadDAOImpl;
import database.baseDatos;
import entity.calidad;
import entity.grupoCalidad;
import entity.tipoAlmacen;
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
public class calidadServlet extends HttpServlet {

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
        calidadDAOImpl _calidadDAO = new calidadDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();
        
        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _codigo = (request.getParameter("codigo") != null && !request.getParameter("codigo").isEmpty() ? request.getParameter("codigo").trim() : new String());
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion").trim() : new String());
            int _idGrupoCalidad = (request.getParameter("idgrupoCalidad") != null && !request.getParameter("idgrupoCalidad").isEmpty() ? Integer.valueOf(request.getParameter("idgrupoCalidad").trim()) : 0);

            switch (_opcion) {
                case 1: {
                    
                    calidad _calidadObj = new calidad();
                    
                    _calidadObj.setCodigo(_codigo);
                    _calidadObj.setNombreCompleto(_nombreCompleto);
                    _calidadObj.setDescripcion(_descripcion);
                    
                    grupoCalidad _grupoCalidad = new grupoCalidad();
                    _grupoCalidad.setId(_idGrupoCalidad);
                    _calidadObj.setGrpCalidad(_grupoCalidad);
                    
                    _calidadObj.setIdEstado(1);
                    
                    if(!_calidadDAO.agregarRegistro(_calidadObj)){
                       mensajeAlerta = "success, Se ha agregado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al agregar el registro ... !!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    calidad _calidadObj = new calidad();
                    
                    _calidadObj.setId(_id);
                    _calidadObj.setCodigo(_codigo);
                    _calidadObj.setNombreCompleto(_nombreCompleto);
                    _calidadObj.setDescripcion(_descripcion);
                    
                    grupoCalidad _grupoCalidad = new grupoCalidad();
                    _grupoCalidad.setId(_id);
                    _calidadObj.setGrpCalidad(_grupoCalidad);
                    
                    _calidadObj.setIdEstado(2);
                    
                    if(!_calidadDAO.modificarRegistro(_calidadObj)){
                        mensajeAlerta = "success, Se ha modificado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al modificar el registro ... !!";
                    }                
                    
                    break;
                }
                case 3: {
                    
                    if(!_calidadDAO.eliminarRegistro(_id)){
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
            response.sendRedirect("/controlGPC/catalogos/calidad/calidadTabla.jsp?m="+mensajeAlerta);
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
