/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.PA2Proyecto.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 50497
 */

@Data
@NoArgsConstructor
@Entity
public class Vacuna {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idV;
    private String cant;
    private String nombreVacuna;

}
