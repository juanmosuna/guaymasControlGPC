/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.database.usuarioDAOImpl;
import database.baseDatos;
import entity.empresa;
import entity.departamento;
import entity.localidad;
import entity.perfilUsuario;
import entity.usuario;
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
 * @author juan_m_osuna
 */
public class usuarioServlet extends HttpServlet {

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
        usuarioDAOImpl _usuarioDAO = new usuarioDAOImpl(_baseDatos.getConnection());

        String mensajeAlerta = new String();
        
        InputStream is = null;
        
        try {

            int _opcion = (request.getParameter("op") != null && !request.getParameter("op").isEmpty() ? Integer.valueOf(request.getParameter("op").trim()) : 0);

            int _id = (request.getParameter("id") != null && !request.getParameter("id").isEmpty() ? Integer.valueOf(request.getParameter("id").trim()) : 0);
            String _nombreCompleto = (request.getParameter("nombreCompleto") != null && !request.getParameter("nombreCompleto").isEmpty() ? request.getParameter("nombreCompleto").trim() : new String());
            String _sexo = (request.getParameter("sexo") != null && !request.getParameter("sexo").isEmpty() ? request.getParameter("sexo").trim() : new String());
            int _idDepartamento = (request.getParameter("idDepartamento") != null && !request.getParameter("idDepartamento").isEmpty() ? Integer.valueOf(request.getParameter("idDepartamento").trim()) : 0);
            int _idEmpresa = (request.getParameter("idEmpresa") != null && !request.getParameter("idEmpresa").isEmpty() ? Integer.valueOf(request.getParameter("idEmpresa").trim()) : 0);
            int _idLocalidad = (request.getParameter("idLocalidad") != null && !request.getParameter("idLocalidad").isEmpty() ? Integer.valueOf(request.getParameter("idLocalidad").trim()) : 0);
            int _idPerfilUsuario = (request.getParameter("idPerfilUsuario") != null && !request.getParameter("idPerfilUsuario").isEmpty() ? Integer.valueOf(request.getParameter("idPerfilUsuario").trim()) : 0);
            String _cuenta = (request.getParameter("cuenta") != null && !request.getParameter("cuenta").isEmpty() ? request.getParameter("cuenta").trim() : new String());
            String _contrasena = (request.getParameter("contrasena") != null && !request.getParameter("contrasena").isEmpty() ? request.getParameter("contrasena").trim() : new String());
            boolean _cuentaActiva = (request.getParameter("cuentaActiva") != null && !request.getParameter("cuentaActiva").isEmpty() ? (request.getParameter("cuentaActiva").equals("on") ? true  : false ) : false);
            
            byte[] _fotoUsuario = null;
            
            if (_opcion != 3) {
                Part filePart = request.getPart("fotoUsuario");

                if (filePart != null) {
                    is = filePart.getInputStream();
                    _fotoUsuario = new byte[is.available()];
                    is.read(_fotoUsuario, 0, _fotoUsuario.length);
                }
            }
            
            switch (_opcion) {
                case 1: {
                    
                    usuario _usuarioObj = new usuario();
                    
                    _usuarioObj.setNombreCompleto(_nombreCompleto);
                    _usuarioObj.setSexo(_sexo);
                    
                    departamento _departamento = new departamento();
                    _departamento.setId(_idDepartamento);
                    _usuarioObj.setDepartamento(_departamento);
                    
                    empresa _empresa = new empresa();
                    _empresa.setId(_idEmpresa);
                    _usuarioObj.setEmpresa(_empresa);
                    
                    localidad _localidad = new localidad();
                    _localidad.setId(_idLocalidad);
                    _usuarioObj.setLocalidad(_localidad);
                    
                    perfilUsuario _perfilUsuario =new perfilUsuario();
                    _perfilUsuario.setId(_idPerfilUsuario);
                    _usuarioObj.setPerfilUsuario(_perfilUsuario);
                    
                    _usuarioObj.setCuenta(_cuenta);
                    _usuarioObj.setContrasena(_contrasena);
                    _usuarioObj.setFotoUsuario(_fotoUsuario);
                    _usuarioObj.setCuentaActiva(_cuentaActiva);
                    _usuarioObj.setIdEstado(1);
                    
                    if(!_usuarioDAO.agregarRegistro(_usuarioObj)){
                        mensajeAlerta = "success, Se ha agregado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al agregar el registro ... !!";
                    }                   
                    
                    break;
                }
                case 2: {
                    
                    usuario _usuarioObj = new usuario();
                    
                    _usuarioObj.setId(_id);                    
                    _usuarioObj.setNombreCompleto(_nombreCompleto);
                    _usuarioObj.setSexo(_sexo);
                    
                    departamento _departamento = new departamento();
                    _departamento.setId(_idDepartamento);
                    _usuarioObj.setDepartamento(_departamento);
                    
                    empresa _empresa = new empresa();
                    _empresa.setId(_idEmpresa);
                    _usuarioObj.setEmpresa(_empresa);
                    
                    localidad _localidad = new localidad();
                    _localidad.setId(_idLocalidad);
                    _usuarioObj.setLocalidad(_localidad);
                    
                    perfilUsuario _perfilUsuario =new perfilUsuario();
                    _perfilUsuario.setId(_idPerfilUsuario);
                    _usuarioObj.setPerfilUsuario(_perfilUsuario);
                    
                    _usuarioObj.setCuenta(_cuenta);
                    _usuarioObj.setContrasena(_contrasena);
                    _usuarioObj.setFotoUsuario(_fotoUsuario);
                    _usuarioObj.setCuentaActiva(_cuentaActiva);
                    _usuarioObj.setIdEstado(2);
                    
                    if(!_usuarioDAO.modificarRegistro(_usuarioObj)){
                        mensajeAlerta = "success, Se ha modificado el registro satisfactoriamente ... !!";
                    } else {
                        mensajeAlerta = "danger, Error al modificar el registro ... !!";
                    }                 
                    
                    break;
                }
                case 3: {
                    
                    if(!_usuarioDAO.eliminarRegistro(_id)){
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
            response.sendRedirect("/controlGPC/catalogos/usuario/usuarioTabla.jsp?m="+mensajeAlerta);
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
