/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.controller;

import com.recreat.service.IUsuarioService;
import com.recreat.type.UsuarioType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        model.addAttribute("acceso", 1);
        return "seguridad/login";
    }
    
    @RequestMapping(value = "/preba/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void prueba(@PathVariable long id){
        System.out.println("result: " + id);
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
            model.addAttribute("acceso", 0);
            return "seguridad/login";
        }
    }
    
    @RequestMapping(value = "/login/registrar", method = RequestMethod.GET)
    public String goCreateUsuario(ModelMap model) throws Exception {
        return "seguridad/registrar";
    }

    @RequestMapping(value = "/login/registrar", method = RequestMethod.POST)
    public View createUsuario(@ModelAttribute UsuarioType usuario, ModelMap model) throws Exception {
        usuarioService.insertar(usuario);
        return new RedirectView("/l8k-web/faces/login");
    }
    
}
