package AFBD.PuntoJS.AFBD.PuntoJS.Servicio;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Campania;
import AFBD.PuntoJS.AFBD.PuntoJS.Repositorio.RepositorioCampania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.catalog.CatalogManager;
import java.util.List;

@Service
public class ServicioCampania {
    @Autowired
    RepositorioCampania repositorioCampania;
    //Crear
    public Campania crearCampania(Campania campania){
        return repositorioCampania.save(campania);
    }
    //Listar
    public List<Campania> listar(){
        return repositorioCampania.findAll();
    }
    //Buscar por ID
    public Campania buscarCampaniaPorID(int id){
        return repositorioCampania.findById(id).orElse(null);
    }
    //Borrar por ID
    public void borrarCampaniaPorID(int id){
        repositorioCampania.deleteById(id);
        System.out.println("La campaña con id: " + id + "ha sido eliminada.");
    }
    //Actualizar
    public Campania actualizar(int id, Campania nueva) {
        Campania existente = buscarCampaniaPorID(id);

        existente.setNombre(nueva.getNombre());
        existente.setTipo(nueva.getTipo());
        existente.setFechaInicio(nueva.getFechaInicio());
        existente.setFechaFin(nueva.getFechaFin());

        return repositorioCampania.save(existente);
    }
}
