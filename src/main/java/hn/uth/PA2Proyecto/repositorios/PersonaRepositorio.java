/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.repositorios;

import hn.uth.PA2Proyecto.modelos.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 50497
 */
public interface PersonaRepositorio extends CrudRepository<Persona, Long>{
    
}
