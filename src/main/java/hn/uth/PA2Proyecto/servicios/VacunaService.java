/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.servicios;

import hn.uth.PA2Proyecto.modelos.Vacuna;
import hn.uth.PA2Proyecto.repositorios.VacunaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 50497
 */
@Service
public class VacunaService {
    @Autowired
    private VacunaRepositorio repositorioV;
    
    public void guardarV(Vacuna vacuna){
        repositorioV.save(vacuna);
    }
    
    public void eliminarV(Long id){
        repositorioV.deleteById(id);    
    }
    
    public Optional<Vacuna> getEntidadV(Long idV){
        return repositorioV.findById(idV);
    }
    
    public List<Vacuna> getListaV(){
        return (List<Vacuna>) repositorioV.findAll();
    }
}
