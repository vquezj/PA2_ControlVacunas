/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.servicios;

import hn.uth.PA2Proyecto.modelos.Establecimiento;
import hn.uth.PA2Proyecto.repositorios.EstablecimientoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 50497
 */
@Service
public class EstablecimientoService {
    @Autowired
    private EstablecimientoRepositorio repoEstablecimiento;
    
    public void guardar(Establecimiento establecimiento){
        repoEstablecimiento.save(establecimiento);
    }
    
    public void eliminar(Long id){
        repoEstablecimiento.deleteById(id);    
    }
    
    public Optional<Establecimiento> getEntidad(Long id){
        return repoEstablecimiento.findById(id);
    }
    
    public List<Establecimiento> getListaEstab(){
        return (List<Establecimiento>) repoEstablecimiento.findAll();
    }
}
