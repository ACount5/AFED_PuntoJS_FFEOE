package AFBD.PuntoJS.AFBD.PuntoJS.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Empleado {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String email;
    private String rol;
    @OneToMany(mappedBy = "empleado")
    @JsonIgnore
    private List<Tarea> tareas;

}
