/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.repositorios;

import hn.uth.PA2Proyecto.modelos.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 50497
 */
@Repository
public interface UserRepositorio extends CrudRepository<User, Long> {
    public Optional<User> findByUsername(String username);
}
