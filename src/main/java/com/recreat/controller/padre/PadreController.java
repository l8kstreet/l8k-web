/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.controller.padre;

import com.recreat.dto.TablaDTO;
import com.recreat.service.TablaService;
import com.recreat.session.UsuarioSession;
import com.recreat.spring.SisLocFactory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jaquise
 */
@Controller
public class PadreController {
    
    @Autowired
    private UsuarioSession sessionUsuario;
    
    private TablaService tablaService;

    public PadreController() {
        tablaService = SisLocFactory.getInstance().getTablaService();
    }
    
    @RequestMapping(value = "/padre/listarPaises", method = RequestMethod.GET)
    public @ResponseBody List<TablaDTO> listarPaises() throws Exception {
        
        return tablaService.listarPaises();
    }
    
    @RequestMapping(value = "/padre/guardarImagenTemporar", method = RequestMethod.POST)
    public @ResponseBody String guardarImagenTemporar(@RequestParam MultipartFile file) throws Exception {
        
        String name = sessionUsuario.getUsuario().getUsuario() + "_" + UUID.randomUUID().toString() + "_" + "logo.jpg";
        File localFile = new File("D:/Proyectos/l8kstreet/l8k-web/target/l8k-web/resources/img/temp" + File.separator + name);

        // Creamos la imagen
        BufferedImage imagen = ImageIO.read(file.getInputStream());

        // Escribimos la imagen en el archivo.
        ImageIO.write(imagen, "jpg", localFile);

        return name;
    }
    
}
