/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.almacenDAOImpl;
import DAO.database.bitacoraDAOImpl;
import database.baseDatos;
import entity.almacen;
import entity.bitacora;
import entity.tipoAlmacen;
import entity.unidadMedida;
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
@WebServlet(name = "almacenServlet", urlPatterns = {"/almacenServlet.do"})
public class almacenServlet extends HttpServlet {

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
        almacenDAOImpl _almacenDAO = new almacenDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();
        
        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _codigo = (request.getParameter("codigo") != null && !request.getParameter("codigo").isEmpty() ? request.getParameter("codigo").trim() : new String());
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion").trim() : new String());
            int _idtipoAlmacen = (request.getParameter("idtipoAlmacen") != null && !request.getParameter("idtipoAlmacen").isEmpty() ? Integer.valueOf(request.getParameter("idtipoAlmacen").trim()) : 0);
            double _capacidad = (request.getParameter("capacidad") != null && !request.getParameter("capacidad").isEmpty() ? Double.valueOf(request.getParameter("capacidad").trim().replace(",", "")) : 0.0);
            int _idunidadMedida = (request.getParameter("idunidadMedida") != null && !request.getParameter("idunidadMedida").isEmpty() ? Integer.valueOf(request.getParameter("idunidadMedida").trim()) : 0);
            int _secciones = (request.getParameter("secciones") != null && !request.getParameter("secciones").isEmpty() ? Integer.valueOf(request.getParameter("secciones").trim()) : 0);
            int _lados = (request.getParameter("lados") != null && !request.getParameter("lados").isEmpty() ? Integer.valueOf(request.getParameter("lados").trim()) : 0);
            int _segmentos = (request.getParameter("segmentos") != null && !request.getParameter("segmentos").isEmpty() ? Integer.valueOf(request.getParameter("segmentos").trim()) : 0);
            int _niveles = (request.getParameter("niveles") != null && !request.getParameter("niveles").isEmpty() ? Integer.valueOf(request.getParameter("niveles").trim()) : 0);

            switch (_opcion) {
                case 1: {
                    
                    almacen _almacenObj = new almacen();
                    
                    _almacenObj.setCodigo(_codigo);
                    _almacenObj.setNombreCompleto(_nombreCompleto);
                    _almacenObj.setDescripcion(_descripcion);
                    
                    tipoAlmacen _tpAlmacen = new tipoAlmacen();
                    _tpAlmacen.setId(_idtipoAlmacen);
                    
                    _almacenObj.setTpAlmacen(_tpAlmacen);
                    _almacenObj.setCapacidad(_capacidad);
                    
                    unidadMedida _unidadMedida = new unidadMedida();
                    _unidadMedida.setId(_idunidadMedida);
                    
                    _almacenObj.setUndMedida(_unidadMedida);
                    _almacenObj.setSecciones(_secciones);
                    _almacenObj.setLados(_lados);
                    _almacenObj.setSegmentos(_segmentos);
                    _almacenObj.setNiveles(_niveles);
                    _almacenObj.setIdEstado(1);
                    
                    if(!_almacenDAO.agregarRegistro(_almacenObj)){
                        mensajeAlerta = "Se agrego satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    almacen _almacenObj = new almacen();
                    
                    _almacenObj.setId(_id);
                    _almacenObj.setCodigo(_codigo);
                    _almacenObj.setNombreCompleto(_nombreCompleto);
                    _almacenObj.setDescripcion(_descripcion);
                    
                    tipoAlmacen _tpAlmacen = new tipoAlmacen();
                    _tpAlmacen.setId(_idtipoAlmacen);
                    
                    _almacenObj.setTpAlmacen(_tpAlmacen);
                    _almacenObj.setCapacidad(_capacidad);
                    
                    unidadMedida _unidadMedida = new unidadMedida();
                    _unidadMedida.setId(_idunidadMedida);
                    
                    _almacenObj.setUndMedida(_unidadMedida);
                    _almacenObj.setSecciones(_secciones);
                    _almacenObj.setLados(_lados);
                    _almacenObj.setSegmentos(_segmentos);
                    _almacenObj.setNiveles(_niveles);
                    _almacenObj.setIdEstado(2);
                    
                    if(!_almacenDAO.modificarRegistro(_almacenObj)){
                        mensajeAlerta = "Se modifico satisfactoriamente";
                    }else {
                        mensajeAlerta = "Error!!";
                    }                   
                    
                    break;
                }
                case 3: {
                    
                    if(!_almacenDAO.eliminarRegistro(_id)){
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
            response.sendRedirect("/controlGPC/catalogos/almacen/almacenTabla.jsp");
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
