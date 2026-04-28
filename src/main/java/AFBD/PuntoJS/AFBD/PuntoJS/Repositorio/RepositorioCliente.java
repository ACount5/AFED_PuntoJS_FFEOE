package AFBD.PuntoJS.AFBD.PuntoJS.Repositorio;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCliente  extends JpaRepository<Cliente,Integer> {

}
