/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.controller;

import com.recreat.service.UsuarioService;
import com.recreat.session.UsuarioSession;
import com.recreat.spring.SisLocFactory;
import com.recreat.type.UsuarioType;
import com.recreat.util.Constante;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author jaquise
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioSession sessionUsuario;
    
    private final UsuarioService servicioUsuario;

    public UsuarioController() {
        servicioUsuario = SisLocFactory.getInstance().getUsuarioService();
    }

    @RequestMapping(value = "/login/confirm_verification/{user}/{id}", method = RequestMethod.GET)
    public View usuarioConfirm(@PathVariable String user, @PathVariable String id) throws Exception {

        UsuarioType usuario = new UsuarioType();
        usuario.setUsuarioId(id);
        //usuario.setUsuario(user);
        usuario.setEstado(Constante.ESTADO_ACTIVO);

        servicioUsuario.actualizar(usuario);
        return new RedirectView("/l8k-web/login.html");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody UsuarioType logear(@RequestBody UsuarioType usuario) throws Exception {

        String usu = usuario.getUsuario();
        String pass = usuario.getContrasenha();
        
        UsuarioType result = servicioUsuario.logearUsuario(usu, pass);
        sessionUsuario.setUsuario(result);
        return result;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public @ResponseBody UsuarioType insertar(@ModelAttribute UsuarioType usuario, @RequestParam String txtDia, @RequestParam String cboMes, @RequestParam String txtAnho) throws Exception {
        
        int dia = Integer.parseInt(txtDia);
        int mes = Integer.parseInt(cboMes);
        int anho = Integer.parseInt(txtAnho);

        Date fecha = new Date(anho, mes, dia);
        usuario.setFechaNacimiento(fecha);
        usuario.setEstado(Constante.ESTADO_INACTIVO);

        servicioUsuario.insertar(usuario);
        servicioUsuario.sendConfirmEmail(usuario);
        return usuario;
    }

    @RequestMapping(value = "/usuario/{user}", method = RequestMethod.GET)
    public @ResponseBody String verificarUsurio(@PathVariable String user) throws Exception {

        Boolean result = servicioUsuario.verificarUsuario(user);
        return result == true ? "{\"result\":1}" : "{\"result\":0}";
    }
    
}
