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
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jaquise
 */
@Controller
public class NegocioController {
    
    @Autowired
    private UsuarioSession sessionUsuario;
    
    private final NegocioService servicioNegocio;
    
    public NegocioController(){
        servicioNegocio = SisLocFactory.getInstance().getNegocioService();
    }
    
    @RequestMapping(value = "/controller/mantenimiento/negocio-listar", method = RequestMethod.POST)
    public @ResponseBody List<NegocioType> listar(@RequestBody NegocioType negocio) throws Exception {
        
        return servicioNegocio.listar(negocio);
    }
    
    @RequestMapping(value = "/controller/mantenimiento/negocio-insertar", method = RequestMethod.POST)
    public @ResponseBody void insertar(@RequestBody NegocioType negocio) throws Exception {

        File tempFile = new File("D:/Proyectos/l8kstreet/l8k-web/target/l8k-web/resources/img/temp" + File.separator + negocio.getLogo());
        File localFile = new File("D:/Proyectos/l8kstreet/l8k-web/target/l8k-web/resources/img/negociologo" + File.separator + negocio.getLogo());
        
        tempFile.renameTo(localFile);
        //tempFile.delete();

        negocio.setUsuarioId(sessionUsuario.getUsuario().getUsuarioId());
        servicioNegocio.insertar(negocio);
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
        servicioNegocio.actualizar(negocio);
    }
    
}
