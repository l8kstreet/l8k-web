/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.controller;

import com.recreat.service.IUsuarioService;
import com.recreat.type.UsuarioType;
import com.recreat.util.Constante;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author jaquise
 */
@Controller
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goLogin(ModelMap model){
        return "seguridad/login";
    }
    
    @RequestMapping(value = "/login/confirm_verification/{user}/{id}", method = RequestMethod.GET)
    public String goConfirm(@PathVariable String user, @PathVariable String id) throws Exception{
        
        UsuarioType usuario = new UsuarioType();
        usuario.setUsuarioId(id);
        //usuario.setUsuario(user);
        usuario.setEstado(Constante.ESTADO_ACTIVO);
        
        usuarioService.actualizar(usuario);
        
        return "seguridad/login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String goMain(@ModelAttribute UsuarioType usuario, ModelMap model) throws Exception{
        
        String usu = usuario.getUsuario();
        String pass = usuario.getContrasenha();
        
        UsuarioType obj = usuarioService.logearUsuario(usu, pass);
        if(obj != null){
            return "page/main";
        }
        else{
            model.addAttribute("negarAcceso", 1);
            return "seguridad/login";
        }
    }
    
    @RequestMapping(value = "/login/registrar", method = RequestMethod.GET)
    public String goCreateUsuario(ModelMap model) throws Exception {
        return "seguridad/registrar";
    }

    @RequestMapping(value = "/login/registrar", method = RequestMethod.POST)
    public View createUsuario(@ModelAttribute UsuarioType usuario, @RequestParam String txtDia, @RequestParam String cboMes, @RequestParam String txtAnho, ModelMap model) throws Exception {
        
        int dia = Integer.parseInt(txtDia);
        int mes = Integer.parseInt(cboMes);
        int anho = Integer.parseInt(txtAnho);
        
        Date fecha = new Date(anho, mes, dia);
        usuario.setFechaNacimiento(fecha);
        
        usuarioService.insertar(usuario);
        return new RedirectView("/l8k-web/faces/login");
    }
    
}
