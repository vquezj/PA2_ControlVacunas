package hn.uth.PA2Proyecto.modelos;

import java.time.LocalDate;
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
    private LocalDate fechaNac;
    private String genero;
    private String ocupacion;
    private String direccion;
    private String telefono;
    private String establecimientoSalud;
    private LocalDate primeraDosis;
    private LocalDate segundaDosis;
    private String nombreVacuna;
}
