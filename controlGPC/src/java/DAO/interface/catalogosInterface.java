/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

/**
 *
 * @author elara
 */
public interface catalogosInterface {

    public boolean agregarRegistro(Object o) throws Exception;

    public boolean modificarRegistro(Object o) throws Exception;

    public boolean eliminarRegistro(int id) throws Exception;

    public Object consultarTodos() throws Exception;

    public Object consultarPor(String _campo, String _dato) throws Exception;

    public Object consultarPorId(int id) throws Exception;

}
