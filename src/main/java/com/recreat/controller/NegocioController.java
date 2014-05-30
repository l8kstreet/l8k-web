/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.recreat.controller;

import com.recreat.service.NegocioService;
import com.recreat.session.UsuarioSession;
import com.recreat.spring.SisLocFactory;
import com.recreat.type.NegocioType;
import com.recreat.type.UsuarioType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.jsp.PageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author jaquise
 */
@Controller
public class NegocioController {
    
    @Autowired
    private UsuarioSession sessionUsuario;
    
    private final NegocioService negocioService;
    
    public NegocioController(){
        negocioService = SisLocFactory.getInstance().getNegocioService();
    }
    
    @RequestMapping(value = "/controller/mantenimiento/negocio-listar", method = RequestMethod.POST)
    public @ResponseBody List<NegocioType> listar(@RequestBody NegocioType negocio) throws Exception {
        
        return negocioService.listar(negocio);
    }
    
    @RequestMapping(value = "/controller/mantenimiento/negocio-insertar", method = RequestMethod.POST)
    public @ResponseBody void insertar(@RequestBody NegocioType negocio) throws Exception {

        File tempFile = new File("D:/Proyectos/l8kstreet/l8k-web/target/l8k-web/resources/img/temp" + File.separator + negocio.getLogo());
        File localFile = new File("D:/Proyectos/l8kstreet/l8k-web/target/l8k-web/resources/img/negociologo" + File.separator + negocio.getLogo());
        
        tempFile.renameTo(localFile);
        //tempFile.delete();

        negocio.setUsuarioId(sessionUsuario.getUsuario().getUsuarioId());
        negocioService.insertar(negocio);
        //return negocio;
    }
    
    @RequestMapping(value = "/controller/mantenimiento/negocio-actualizar", method = RequestMethod.POST)
    public @ResponseBody void actualizar(@RequestBody NegocioType negocio) throws Exception {

        File tempFile = new File("D:/Proyectos/l8kstreet/l8k-web/target/l8k-web/resources/img/temp" + File.separator + negocio.getLogo());
        
        if (tempFile.exists()) {
            File localFile = new File("D:/Proyectos/l8kstreet/l8k-web/target/l8k-web/resources/img/negociologo" + File.separator + negocio.getLogo());
            tempFile.renameTo(localFile);
            //tempFile.delete();
        }

        negocio.setUsuario(null);
        negocioService.actualizar(negocio);
    }
    
}
