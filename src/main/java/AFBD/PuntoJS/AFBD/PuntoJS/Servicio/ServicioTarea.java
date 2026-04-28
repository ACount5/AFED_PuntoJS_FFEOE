package AFBD.PuntoJS.AFBD.PuntoJS.Servicio;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Tarea;
import AFBD.PuntoJS.AFBD.PuntoJS.Repositorio.RepositorioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTarea {
    @Autowired
    RepositorioTarea repositorioTarea;
    //Crear
    public Tarea crearTarea(Tarea tarea){
        return repositorioTarea.save(tarea);
    }
    //Listar
    public List<Tarea> listar(){
        return repositorioTarea.findAll();
    }
    //Buscar por ID
    public Tarea buscarTareaPorID(int id){
        return repositorioTarea.findById(id).orElse(null);
    }
    //Borrar por ID
    public void borrarTareaPorID(int id){
        repositorioTarea.deleteById(id);
        System.out.println("La tarea con id: " + id + "ha sido eliminada.");
    }
    //Actualizar
    public Tarea actualizar(int id, Tarea nueva) {
        Tarea existente = buscarTareaPorID(id);

        existente.setDescripcion(nueva.getDescripcion());
        existente.setEstado(nueva.getEstado());
        existente.setFechaLimite(nueva.getFechaLimite());

        return repositorioTarea.save(existente);
    }
}
