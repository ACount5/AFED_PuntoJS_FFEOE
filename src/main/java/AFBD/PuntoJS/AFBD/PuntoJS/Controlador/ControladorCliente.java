package AFBD.PuntoJS.AFBD.PuntoJS.Controlador;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Cliente;
import AFBD.PuntoJS.AFBD.PuntoJS.Servicio.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {
    @Autowired
    private ServicioCliente servicioCliente;

    // Crear
    @PostMapping("/crear")
    public Cliente crear(@RequestBody Cliente cliente) {
        return servicioCliente.crearCliente(cliente);
    }

    // Listar
    @GetMapping("/lista")
    public List<Cliente> listar() {
        return servicioCliente.listar();
    }

    // Buscar por id
    @GetMapping("/buscar/{id}")
    public Cliente obtener(@PathVariable int id) {
        return servicioCliente.buscarClientePorID(id);
    }

    // Borrar por id
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable int id) {
        servicioCliente.borrarClientePorID(id);
    }

    // Actualizar
    @PutMapping("actualizar/{id}")
    public Cliente actualizar(@PathVariable int id, @RequestBody Cliente cliente) {
        return servicioCliente.actualizar(id, cliente);
    }
}
