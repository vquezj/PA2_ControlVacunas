/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.servicios;

import hn.uth.PA2Proyecto.modelos.Citas;
import hn.uth.PA2Proyecto.repositorios.CitasRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 50497
 */
@Service
public class CitasService {
    @Autowired
    
    private CitasRepositorio repositorioC;
    
    public void guardar(Citas citas){
        repositorioC.save(citas);
    }
    
    public void eliminar(Long id){
        repositorioC.deleteById(id);    
    }
    
    public Optional<Citas> getEntidad(Long id){
        return repositorioC.findById(id);
    }
    
    public List<Citas> getLista(){
        return (List<Citas>) repositorioC.findAll();
    }
    
   
}
