/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.controladores;

import hn.uth.PA2Proyecto.modelos.Persona;
import hn.uth.PA2Proyecto.servicios.EstablecimientoService;
import hn.uth.PA2Proyecto.servicios.PersonasService;
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
public class PersonasController {
    @Autowired
    
    private PersonasService servicio;
    private VacunaService servVacuna;
    private EstablecimientoService servEstablecimiento;
    
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("lista", servicio.getLista());
        return "/index";
    }
    
    @GetMapping("/crear")
    public String abrirFormularioCrearPersona(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("vacuna", servVacuna.getLista());
        model.addAttribute("establecimiento", servEstablecimiento.getLista());
        return "personaFormulario";
    }
    
    @GetMapping("/actualizar/{id}")
    public String abrirFormularioActualizarPersona(@PathVariable Long id, Model model){
        model.addAttribute("persona", servicio.getEntidad(id));
        return "personaFormulario";
    }
    
    @PostMapping("/guardarFormulario")
    public String guardarFormularioPersona(Persona persona, Model model){
        servicio.guardar(persona);
        return "redirect:/index";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id, Model model){
        servicio.eliminar(id);
        return "redirect:/index";
    }
            
}
