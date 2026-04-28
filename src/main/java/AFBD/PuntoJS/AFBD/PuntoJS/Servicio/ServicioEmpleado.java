package AFBD.PuntoJS.AFBD.PuntoJS.Servicio;


import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Empleado;
import AFBD.PuntoJS.AFBD.PuntoJS.Repositorio.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpleado {
     @Autowired
    RepositorioEmpleado repositorioEmpleado;
    //Crear
    public Empleado crearEmpleado(Empleado empleado){
        return repositorioEmpleado.save(empleado);
    }
    //Listar
    public List<Empleado> listar(){
        return repositorioEmpleado.findAll();
    }
    //Buscar por ID
    public Empleado buscarEmpleadoPorID(int id){
        return repositorioEmpleado.findById(id).orElse(null);
    }
    //Borrar por ID
    public void borrarEmpleadoPorID(int id){
        repositorioEmpleado.deleteById(id);
        System.out.println("El empleado con id: " + id + "ha sido eliminado.");
    }
    //Actualizar
    public Empleado actualizar(int id, Empleado nuevo) {
        Empleado existente = repositorioEmpleado.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        existente.setNombre(nuevo.getNombre());
        existente.setEmail(nuevo.getEmail());
        existente.setRol(nuevo.getRol());

        return repositorioEmpleado.save(existente);
    }

}
