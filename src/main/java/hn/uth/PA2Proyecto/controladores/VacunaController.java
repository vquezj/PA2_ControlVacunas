/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.controladores;

import hn.uth.PA2Proyecto.modelos.Vacuna;
import hn.uth.PA2Proyecto.servicios.VacunaService;
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
public class VacunaController {
    @Autowired
    
    private VacunaService servicioV;
    
    @RequestMapping("/vacuna")
    public String vacuna(Model model){
        model.addAttribute("listaV", servicioV.getListaV());
        return "/vacuna";
    }
    
    @GetMapping("/crearRV")
    public String abrirFormularioCrearVacuna(Model model){
        model.addAttribute("vacuna", new Vacuna());
        return "vacunaFormulario";
    }
    
    @GetMapping("/actualizarRV/{idV}")
    public String abrirFormularioActualizarVacuna(@PathVariable Long idV, Model model){
        model.addAttribute("vacuna", servicioV.getEntidadV(idV));
        return "vacunaFormulario";
    }
    
    @PostMapping("/guardarRV")
    public String guardarFormularioVacuna(Vacuna vacuna, Model model){
        servicioV.guardarV(vacuna);
        return "redirect:/vacuna";
    }
    
    @GetMapping("/eliminarRV/{idV}")
    public String eliminarRV(@PathVariable Long idV, Model model){
        servicioV.eliminarV(idV);
        return "redirect:/vacuna";
    }
}
