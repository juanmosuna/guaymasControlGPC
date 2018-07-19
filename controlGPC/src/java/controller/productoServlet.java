/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.productoDAOImpl;
import database.baseDatos;
import entity.categoriaProducto;
import entity.producto;
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
@WebServlet(name = "productoServlet", urlPatterns = {"/productoServlet.do"})
public class productoServlet extends HttpServlet {

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
        productoDAOImpl _productoDAO = new productoDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();

        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _codigo = (request.getParameter("codigo") != null && !request.getParameter("codigo").isEmpty() ? request.getParameter("codigo").trim() : new String());
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _descripcion = (request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty() ? request.getParameter("descripcion").trim() : new String());
            int _idCategoriaProducto = (request.getParameter("idCategoriaProducto") != null && !request.getParameter("idCategoriaProducto").isEmpty() ? Integer.valueOf(request.getParameter("idCategoriaProducto").trim()) : 0);
            
            switch (_opcion) {
                case 1: {

                    producto _productoObj = new producto();

                    _productoObj.setCodigo(_codigo);
                    _productoObj.setNombreCompleto(_nombreCompleto);
                    _productoObj.setDescripcion(_descripcion);
                    
                    categoriaProducto _ctgProducto = new categoriaProducto();
                    _ctgProducto.setId(_idCategoriaProducto);
                    _productoObj.setCtgProducto(_ctgProducto);
                    
                    _productoObj.setIdEstado(1);

                    if (!_productoDAO.agregarRegistro(_productoObj)) {
                        mensajeAlerta = "success, Se ha agregado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al agregar el registro ... !!";
                    }

                    break;
                }
                case 2: {

                    producto _productoObj = new producto();

                    _productoObj.setId(_id);
                    _productoObj.setCodigo(_codigo);
                    _productoObj.setNombreCompleto(_nombreCompleto);
                    _productoObj.setDescripcion(_descripcion);
                    
                    categoriaProducto _ctgProducto = new categoriaProducto();
                    _ctgProducto.setId(_idCategoriaProducto);
                    _productoObj.setCtgProducto(_ctgProducto);
                    
                    _productoObj.setIdEstado(2);

                    if (!_productoDAO.modificarRegistro(_productoObj)) {
                        mensajeAlerta = "success, Se ha modificado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al modificar el registro ... !!";
                    }

                    break;
                }
                case 3: {

                    if (!_productoDAO.eliminarRegistro(_id)) {
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
            response.sendRedirect("/controlGPC/catalogos/producto/productoTabla.jsp?m="+mensajeAlerta);
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
