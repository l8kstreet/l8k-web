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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jaquise
 */
@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;
    private UsuarioType objUsuario;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goLogin(ModelMap model) {
        return "seguridad/login";
    }

    @RequestMapping(value = "/login/confirm_verification/{user}/{id}", method = RequestMethod.GET)
    public String goLoginConfirm(@PathVariable String user, @PathVariable String id) throws Exception {

        UsuarioType usuario = new UsuarioType();
        usuario.setUsuarioId(id);
        //usuario.setUsuario(user);
        usuario.setEstado(Constante.ESTADO_ACTIVO);

        usuarioService.actualizar(usuario);

        return "seguridad/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String goMain(@ModelAttribute UsuarioType usuario, ModelMap model) throws Exception {

        String usu = usuario.getUsuario();
        String pass = usuario.getContrasenha();

        UsuarioType obj = usuarioService.logearUsuario(usu, pass);
        if (obj != null) {
            if (obj.getEstado().equals(Constante.ESTADO_INACTIVO)) {
                model.addAttribute("tipo", 0);
                model.addAttribute("objUsuario", obj);
                return "seguridad/confirmar";
            } else {
                return "page/main";
            }
        } else {
            model.addAttribute("negarAcceso", 1);
            return "seguridad/login";
        }
    }

    @RequestMapping(value = "/login/registro", method = RequestMethod.GET)
    public String goCreateUsuario(ModelMap model) throws Exception {
        return "seguridad/registrar";
    }

    @RequestMapping(value = "/login/registro/confirm", method = RequestMethod.POST)
    public String createUsuario(@ModelAttribute UsuarioType usuario, @RequestParam String txtDia, @RequestParam String cboMes, @RequestParam String txtAnho, ModelMap model) throws Exception {

        int dia = Integer.parseInt(txtDia);
        int mes = Integer.parseInt(cboMes);
        int anho = Integer.parseInt(txtAnho);

        Date fecha = new Date(anho, mes, dia);
        usuario.setFechaNacimiento(fecha);

        usuarioService.insertar(usuario);
        usuarioService.sendConfirmEmail(usuario);

        model.addAttribute("tipo", 1);
        model.addAttribute("objUsuario", usuario);
        return "seguridad/confirmar";
    }
    
    @RequestMapping(value = "/verificarUsuario/{user}", method = RequestMethod.GET)
    public @ResponseBody String goVerificarUsurio(ModelMap model, @PathVariable String user) throws Exception {
        
        Boolean result = usuarioService.verificarUsuario(user);
        
        if(result == true)
            return "{\"result\":1}";
        else
            return "{\"result\":0}";
    }
    
}
