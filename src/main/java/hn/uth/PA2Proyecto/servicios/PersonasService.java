/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.servicios;

import hn.uth.PA2Proyecto.modelos.Persona;
import hn.uth.PA2Proyecto.repositorios.PersonaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 50497
 */
@Service
public class PersonasService {
    @Autowired
    private PersonaRepositorio repositorio;
    
    public void guardar(Persona persona){
        repositorio.save(persona);
    }
    
    public void eliminar(Long id){
        repositorio.deleteById(id);    
    }
    
    public Optional<Persona> getEntidad(Long id){
        return repositorio.findById(id);
    }
    
    public List<Persona> getLista(){
        return (List<Persona>) repositorio.findAll();
    }
}
