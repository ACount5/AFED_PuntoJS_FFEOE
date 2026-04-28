package AFBD.PuntoJS.AFBD.PuntoJS.Controlador;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Tarea;
import AFBD.PuntoJS.AFBD.PuntoJS.Servicio.ServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class ControladorTarea {
    @Autowired
    private ServicioTarea servicioTarea;
    // Crear
    @PostMapping("/crear")
    public Tarea crear(@RequestBody Tarea tarea) {
        return servicioTarea.crearTarea(tarea);
    }

    // Listar
    @GetMapping("/lista")
    public List<Tarea> listar() {
        return servicioTarea.listar();
    }

    // Buscar por id
    @GetMapping("/buscar/{id}")
    public Tarea obtener(@PathVariable int id) {
        return servicioTarea.buscarTareaPorID(id);
    }

    // Borrar por id
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable int id) {
        servicioTarea.borrarTareaPorID(id);
    }

    // Actualizar
    @PutMapping("actualizar/{id}")
    public Tarea actualizar(@PathVariable int id, @RequestBody Tarea tarea) {
        return servicioTarea.actualizar(id, tarea);
    }

}
