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
    
    public List<UsuarioType> listar(UsuarioType usuario) throws Exception;
    public String insertar(UsuarioType usuario) throws Exception;
    public void actualizar(UsuarioType usuario) throws Exception;
    public void eliminar(String usuarioId) throws Exception;
    public UsuarioType logearUsuario(String usuario, String contrasenha) throws Exception;
    public void sendConfirmEmail(final UsuarioType usuario) throws Exception;
    public Boolean verificarUsuario(String usuario) throws Exception;
    
}
