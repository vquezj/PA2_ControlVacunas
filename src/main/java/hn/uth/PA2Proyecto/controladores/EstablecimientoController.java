/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.controladores;

import hn.uth.PA2Proyecto.modelos.Establecimiento;
import hn.uth.PA2Proyecto.servicios.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 50497
 */

@Controller
public class EstablecimientoController {
    @Autowired
    
    private EstablecimientoService sEstablecimiento;
    
    @RequestMapping("/establecimiento")
    public String establecimiento(Model model){
        model.addAttribute("lista", sEstablecimiento.getLista());
        return "/establecimiento";
    }
    
    @GetMapping("/crearEstablecimiento")
    public String abrirFormularioCrearEstablecimiento(Model model){
        model.addAttribute("establecimiento", new Establecimiento());
        return "establecimientoFormulario";
    }
    
    @GetMapping("/actualizarEstablecimiento/{id}")
    public String abrirFormularioActualizarEstablecimiento(@PathVariable Long id, Model model){
        model.addAttribute("establecimiento", sEstablecimiento.getEntidad(id));
        return "EstablecimientoFormulario";
    }
    
    @PostMapping("/guardarEstablecimiento")
    public String guardarFormularioEstablecimiento(Establecimiento establecimiento, Model model){
        sEstablecimiento.guardar(establecimiento);
        return "/establecimiento";
    }
    
    @GetMapping("/eliminarEstablecimiento/{id}")
    public String eliminarRE(@PathVariable Long id, Model model){
        sEstablecimiento.eliminar(id);
        return "/establecimiento";
    }
}
