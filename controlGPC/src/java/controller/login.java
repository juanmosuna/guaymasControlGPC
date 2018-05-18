/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.usuarioDAOImpl;
import database.baseDatos;
import entity.usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juan_m_osuna
 */
public class login extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        String _mensajeError = new String();
        boolean _error = false;
        
        String _username = String.valueOf(request.getParameter("nombreUsuario"));
        String _password = String.valueOf(request.getParameter("contrasena"));
        
        if (!_username.isEmpty() && !_password.isEmpty()){
        
            baseDatos _baseDatos = new baseDatos();

            usuarioDAOImpl _usuarioDAOImpl = new usuarioDAOImpl(_baseDatos.getConnection());
            
            usuario _usuario = (usuario) _usuarioDAOImpl.login(_username.replace("%", ""), _password.replace("%", ""));
            
            if (_usuario.getId() != 0){
            
                if (_usuario.isCuentaActiva()){

                    if (_usuario.getPerfilUsuario().isIngresoPlataforma()){

                        _error = false;

                        session.setAttribute( "usuario", _usuario );

                        response.sendRedirect("plataforma.jsp");

                    }else{
                        _error = true;
                        _mensajeError = "No tiene privilegio para ingresar a la plataforma, consulte con su administrador del sistema ...";
                    }
                }else{
                    _error = true;
                    _mensajeError = "Su cuenta de usuario se encuentra deshabilitada, consulte con su administrador del sistema ...";
                }
                
            }else{
                _error = true;
                _mensajeError = "No se encontr&oacute; la cuenta de usuario, intente de nuevo por favor ...";
            }
        
        }else{
            _error = true;
            _mensajeError = "Nombre de usuario y/o contrase&ntilde;a incorrecto ...";
        }
        
        if (_error){

            session.setAttribute( "mensajeError", _mensajeError );
            response.sendRedirect("index.jsp");
            
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
