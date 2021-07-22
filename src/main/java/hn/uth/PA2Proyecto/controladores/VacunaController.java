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
    
    private VacunaService sVacuna;
    
    @RequestMapping("/vacuna")
    public String vacuna(Model model){
        model.addAttribute("lista", sVacuna.getLista());
        return "/vacuna";
    }
    
    @GetMapping("/crearV")
    public String abrirFormularioCrearVacuna(Model model){
        model.addAttribute("vacuna", new Vacuna());
        return "vacunaFormulario";
    }
    
    @GetMapping("/actualizarV/{id}")
    public String abrirFormularioActualizarVacuna(@PathVariable Long id, Model model){
        model.addAttribute("vacuna", sVacuna.getEntidad(id));
        return "vacunaFormulario";
    }
    
    @PostMapping("/guardarVacuna")
    public String guardarFormularioVacuna(Vacuna vacuna, Model model){
        sVacuna.guardar(vacuna);
        return "/vacuna";
    }
    
    @GetMapping("/eliminarV/{id}")
    public String eliminarRV(@PathVariable Long id, Model model){
        sVacuna.eliminar(id);
        return "/vacuna";
    }
}
