/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 50497
 */
@Controller
public class LoginController {
    @Autowired
    
    @GetMapping({"/", "/login"})
    public String login(){
        return "login";
    }
    
    @RequestMapping("/principal")
    public String abrirMenu(){
        return "principal";
    }
}
