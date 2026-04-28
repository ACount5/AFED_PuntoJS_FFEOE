package AFBD.PuntoJS.AFBD.PuntoJS.Repositorio;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEmpleado  extends JpaRepository<Empleado,Integer> {
}
