package AFBD.PuntoJS.AFBD.PuntoJS.Controlador;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Empleado;
import AFBD.PuntoJS.AFBD.PuntoJS.Servicio.ServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class ControladorEmpleado {
    @Autowired
    private ServicioEmpleado servicioEmpleado;
    // Crear
    @PostMapping("/crear")
    public Empleado crear(@RequestBody Empleado empleado) {
        return servicioEmpleado.crearEmpleado(empleado);
    }

    // Listar
    @GetMapping("/lista")
    public List<Empleado> listar() {
        return servicioEmpleado.listar();
    }

    // Buscar por id
    @GetMapping("/buscar/{id}")
    public Empleado obtener(@PathVariable int id) {
        return servicioEmpleado.buscarEmpleadoPorID(id);
    }

    // Borrar por id
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable int id) {
        servicioEmpleado.borrarEmpleadoPorID(id);
    }

    // Actualizar
    @PutMapping("actualizar/{id}")
    public Empleado actualizar(@PathVariable int id, @RequestBody Empleado empleado) {
        return servicioEmpleado.actualizar(id, empleado);
    }
}
