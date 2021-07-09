/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 50497
 */

@Controller
public class MenuController {
    @Autowired
    
    @RequestMapping("/")
    public String principal(){
        return "principal";
    }
    
    @RequestMapping("/abrirIndex")
    public String abrirIndex(){
        return "redirect:index";
    }
    
    @RequestMapping("/abrirVacuna")
    public String abrirVacuna(){
        return "redirect:vacuna";
    }
}
