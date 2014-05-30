/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.session;

import com.recreat.type.UsuarioType;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 *
 * @author jaquise
 */
@Component
public class UsuarioSession {
    
    private final String id = UUID.randomUUID().toString();
    private UsuarioType usuario;

    public UsuarioType getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioType usuario) {
        this.usuario = usuario;
    }
    
}
