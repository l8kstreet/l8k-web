/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.service;

import com.recreat.type.UsuarioType;
import java.util.List;

/**
 *
 * @author jaquise
 */
public interface IUsuarioService {
    
    public List<UsuarioType> listar() throws Exception;
    public void insertar(UsuarioType usuario) throws Exception;
    public void actualizar(UsuarioType usuario) throws Exception;
    public void eliminar(UsuarioType usuario) throws Exception;
    public UsuarioType logearUsuario(String usuario, String contrasenha) throws Exception;
    
}
