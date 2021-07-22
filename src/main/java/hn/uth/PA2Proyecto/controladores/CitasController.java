/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.controladores;

import hn.uth.PA2Proyecto.modelos.Citas;
import hn.uth.PA2Proyecto.servicios.CitasService;
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
public class CitasController {
     @Autowired
     private CitasService servicioC;
     private EstablecimientoService sEstab;
     private PersonasService sPersona;
     private VacunaService sVacuna;
    
    @RequestMapping("/citas")
    public String citas(Model model){
        model.addAttribute("listaCitas", servicioC.getLista());
        return "/citas";
    }
    
    @GetMapping("/crearC")
    public String abrirFormularioCrearCita(Model model){
        model.addAttribute("citas", new Citas());
        model.addAttribute("listaEstab", sEstab.getLista());
        model.addAttribute("persona", sPersona.getLista());
        model.addAttribute("vacuna", sVacuna.getLista());
        
        return "citasFormulario";
    }
    
    @GetMapping("/actualizarC/{id}")
    public String abrirFormularioActualizarCita(@PathVariable Long id, Model model){
        model.addAttribute("citas", servicioC.getEntidad(id));
        return "citasFormulario";
    }
    
    @PostMapping("/guardarC")
    public String guardarFormularioCita(Citas citas, Model model){
        servicioC.guardar(citas);
        return "/citas";
    }
    
    @GetMapping("/eliminarC/{id}")
    public String eliminarCita(@PathVariable Long id, Model model){
        servicioC.eliminar(id);
        return "/citas";
    }
}
