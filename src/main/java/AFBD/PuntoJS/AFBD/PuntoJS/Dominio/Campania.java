package AFBD.PuntoJS.AFBD.PuntoJS.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Campania {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idCampania;
    @Column(nullable = false)
    private String nombre;
    private String tipo;
    private Date fechaInicio;
    private Date fechaFin;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "campania")
    @JsonIgnore
    private List<Tarea> tareas;

    @OneToMany(mappedBy = "campania", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Resultado> resultados;
}
