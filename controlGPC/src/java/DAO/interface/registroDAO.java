/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Interface;

/**
 *
 * @author juan_m_osuna
 */
public interface registroDAO {
    
    public boolean agregar(Object _objeto) throws Exception;
    public boolean eliminar(int _indice) throws Exception;
    public boolean modificar(Object _objeto) throws Exception;
    public Object buscarPorId(int _indice) throws Exception;
    public Object buscarPor(String _campo, String _dato) throws Exception;
    public Object buscarTodos() throws Exception;

}
