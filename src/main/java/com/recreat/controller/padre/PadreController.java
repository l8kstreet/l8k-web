/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recreat.controller.padre;

import com.recreat.dto.TablaDTO;
import com.recreat.service.TablaService;
import com.recreat.spring.SisLocFactory;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jaquise
 */
@Controller
public class PadreController {
    
    private TablaService tablaService;

    public PadreController() {
        tablaService = SisLocFactory.getInstance().getTablaService();
    }
    
    
    @RequestMapping(value = "/padre/listarPaises", method = RequestMethod.GET)
    public @ResponseBody List<TablaDTO> listarPaises() throws Exception {
        
        return tablaService.listarPaises();
    }
    
}
