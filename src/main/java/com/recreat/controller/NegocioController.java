/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.controller;

import com.recreat.service.LocalService;
import com.recreat.service.NegocioService;
import com.recreat.session.UsuarioSession;
import com.recreat.spring.SisLocFactory;
import com.recreat.type.LocalType;
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
    private final LocalService servicioLocal;

    public NegocioController() {
        servicioNegocio = SisLocFactory.getInstance().getNegocioService();
        servicioLocal = SisLocFactory.getInstance().getLocalService();
    }

    @RequestMapping(value = "/controller/mantenimiento/negocio-listar", method = RequestMethod.POST)
    public @ResponseBody List<NegocioType> listar(@RequestBody NegocioType negocio) throws Exception {

        negocio.setUsuarioId(sessionUsuario.getUsuario().getUsuarioId());
        List<NegocioType> list = servicioNegocio.listar(negocio);

        LocalType local;
        for (NegocioType item : list) {
            local = new LocalType();
            local.setNegocioId(item.getNegocioId());
            item.setListLocal(servicioLocal.listar(local));
        }

        return list;
    }

    @RequestMapping(value = "/controller/mantenimiento/negocio-insertar", method = RequestMethod.POST)
    public @ResponseBody void insertar(@RequestBody NegocioType negocio) throws Exception {

        File tempFile = new File(getUrlTemp("temp/" + negocio.getLogo()));
        File localFile = new File(getUrlTemp("negociologo/" + negocio.getLogo()));

        tempFile.renameTo(localFile);
        //tempFile.delete();

        negocio.setUsuarioId(sessionUsuario.getUsuario().getUsuarioId());
        servicioNegocio.insertar(negocio);
        //return negocio;
    }

    @RequestMapping(value = "/controller/mantenimiento/negocio-actualizar", method = RequestMethod.POST)
    public @ResponseBody void actualizar(@RequestBody NegocioType negocio) throws Exception {

        File tempFile = new File(getUrlTemp("temp/" + negocio.getLogo()));

        if (tempFile.exists()) {
            File localFile = new File(getUrlTemp("negociologo/" + negocio.getLogo()));
            tempFile.renameTo(localFile);
            //tempFile.delete();
        }

        servicioNegocio.actualizar(negocio);
    }

    //Local
    @RequestMapping(value = "/controller/mantenimiento/negocio-local-insertar", method = RequestMethod.POST)
    public @ResponseBody void insertarLocal(@RequestBody LocalType local) throws Exception {

        if (local.getFotos() != null) {
            for (String img : local.getFotos()) {
                File tempFile = new File(getUrlTemp("temp/" + img));
                File localFile = new File(getUrlTemp("locales/" + img));
                tempFile.renameTo(localFile);
            }
        }

        servicioLocal.insertar(local);
    }

    @RequestMapping(value = "/controller/mantenimiento/negocio-local-actualizar", method = RequestMethod.POST)
    public @ResponseBody void actualizarLocal(@RequestBody LocalType local) throws Exception {

        if (local.getFotos() != null) {
            for (String img : local.getFotos()) {
                File tempFile = new File(getUrlTemp("temp/" + img));

                if (tempFile.exists()) {
                    File localFile = new File(getUrlTemp("locales/" + img));
                    tempFile.renameTo(localFile);
                }
            }
        }

        servicioLocal.actualizar(local);
    }

    private String getUrlTemp(String archivoImgen) {
        String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
        path = path.substring(0, path.lastIndexOf("/WEB-INF"));

        return path + File.separator + "resources" + File.separator + "img" + File.separator + archivoImgen;
    }

}
