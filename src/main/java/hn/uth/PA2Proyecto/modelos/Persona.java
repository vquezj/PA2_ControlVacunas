package hn.uth.PA2Proyecto.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.BaseCalendar.Date;

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
    //private String ident;
    private String nombre;
    private String correo;
    /*private Date fechaNac;
    private String sexo;
    private String ocupacion;
    private String direccion;
    private String telefono;
    private String establecimientoSalud;
    private String codigoEstab;
    private Date fechaPDosis;
    private Date fechaSDosis;
    private String nombreVacuna;*/
}