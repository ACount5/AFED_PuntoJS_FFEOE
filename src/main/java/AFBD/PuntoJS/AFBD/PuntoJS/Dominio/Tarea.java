package AFBD.PuntoJS.AFBD.PuntoJS.Dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tarea {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idTarea;
    private String descripcion;
    private String estado;
    private Date fechaLimite;
    @ManyToOne
    @JoinColumn(name= "idCampania")
    private Campania campania;
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;


}
