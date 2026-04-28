package AFBD.PuntoJS.AFBD.PuntoJS.Controlador;


import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Campania;
import AFBD.PuntoJS.AFBD.PuntoJS.Servicio.ServicioCampania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campañas")
public class ControladorCampania {
    @Autowired
    private ServicioCampania servicioCampania;
    // Crear
    @PostMapping("/crear")
    public Campania crear(@RequestBody Campania campania) {
        return servicioCampania.crearCampania(campania);
    }

    // Listar
    @GetMapping("/lista")
    public List<Campania> listar() {
        return servicioCampania.listar();
    }

    // Buscar por id
    @GetMapping("/buscar/{id}")
    public Campania obtener(@PathVariable int id) {
        return servicioCampania.buscarCampaniaPorID(id);
    }

    // Borrar por id
    @DeleteMapping("/borrar/{id}")
    public void eliminar(@PathVariable int id) {
        servicioCampania.borrarCampaniaPorID(id);
    }

    // Actualizar
    @PutMapping("actualizar/{id}")
    public Campania actualizar(@PathVariable int id, @RequestBody Campania campania) {
        return servicioCampania.actualizar(id, campania);
    }
}
