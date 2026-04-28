package AFBD.PuntoJS.AFBD.PuntoJS.Controlador;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Cliente;
import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Resultado;
import AFBD.PuntoJS.AFBD.PuntoJS.Servicio.ServicioResultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados")
public class ControladorResultado {
    @Autowired
    private ServicioResultado servicioResultado;
    // Crear
    @PostMapping("/crear")
    public Resultado crear(@RequestBody Resultado resultado) {
        return servicioResultado.crearResultado(resultado);
    }

    // Listar
    @GetMapping("/lista")
    public List<Resultado> listar() {
        return servicioResultado.listar();
    }

    // Buscar por id
    @GetMapping("/buscar/{id}")
    public Resultado obtener(@PathVariable int id) {
        return servicioResultado.buscarResultadoPorID(id);
    }

    // Borrar por id
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable int id) {
        servicioResultado.borrarResultadoporID(id);
    }

    // Actualizar
    @PutMapping("actualizar/{id}")
    public Resultado actualizar(@PathVariable int id, @RequestBody Resultado resultado) {
        return servicioResultado.actualizar(id, resultado);
    }

}
