/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.servicios;

import hn.uth.PA2Proyecto.modelos.Departamento;
import hn.uth.PA2Proyecto.repositorios.DepartamentoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 50497
 */
@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepositorio repoDepto;
    
    public void guardar(Departamento departamento){
        repoDepto.save(departamento);
    }
    
    public void eliminar(Long id){
        repoDepto.deleteById(id);    
    }
    
    public Optional<Departamento> getEntidad(Long id){
        return repoDepto.findById(id);
    }
    
    public List<Departamento> getLista(){
        return (List<Departamento>) repoDepto.findAll();
    }
}
