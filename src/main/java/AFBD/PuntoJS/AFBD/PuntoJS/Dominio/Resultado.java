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
public class Resultado {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer idResultado;
    private float valor;
    private Date fecha;
    @ManyToOne
    @JoinColumn(name = "idCampania")
    private Campania campania;

}
