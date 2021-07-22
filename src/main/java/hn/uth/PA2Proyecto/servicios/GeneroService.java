/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.servicios;

import hn.uth.PA2Proyecto.modelos.Genero;
import hn.uth.PA2Proyecto.repositorios.GeneroRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 50497
 */
@Service
public class GeneroService {
    @Autowired
    private GeneroRepositorio repoGenero;
    
     public void guardar(Genero genero){
        repoGenero.save(genero);
    }
    
    public void eliminar(Long id){
        repoGenero.deleteById(id);    
    }
    
    public Optional<Genero> getEntidad(Long id){
        return repoGenero.findById(id);
    }
    
    public List<Genero> getLista(){
        return (List<Genero>) repoGenero.findAll();
    }
}
