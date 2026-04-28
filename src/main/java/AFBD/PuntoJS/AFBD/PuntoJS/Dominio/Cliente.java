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
public class Cliente {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String email;
    private String telefono;
    private String empresa;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Campania> campanias;


}
