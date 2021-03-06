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
    private VacunaRepositorio repoVacuna;
    
    public void guardar(Vacuna vacuna){
        repoVacuna.save(vacuna);
    }
    
    public void eliminar(Long id){
        repoVacuna.deleteById(id);    
    }
    
    public Optional<Vacuna> getEntidad(Long id){
        return repoVacuna.findById(id);
    }
    
    public List<Vacuna> getLista(){
        return (List<Vacuna>) repoVacuna.findAll();
    }
}
