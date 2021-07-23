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

public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String ident;
    private String nombre;
    private String fechaNac;
    private String genero;
    private String ocupacion;
    private String depto;
    private String direccion;
    private String telefono;
    private String establecimientoSalud;
    private String primeraDosis;
    private String segundaDosis;
    private String nombreVacuna;
}
