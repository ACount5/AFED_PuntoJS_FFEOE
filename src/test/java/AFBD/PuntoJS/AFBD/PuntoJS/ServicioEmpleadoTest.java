package AFBD.PuntoJS.AFBD.PuntoJS;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Empleado;
import AFBD.PuntoJS.AFBD.PuntoJS.Servicio.ServicioEmpleado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ServicioEmpleadoTest {
    @Autowired
    private ServicioEmpleado servicioEmpleado;

    // CASO 1: Alta de un nuevo empleado
    @Test
    void testCrearEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Ana Bohueles");
        empleado.setEmail("ana@gmail.com");
        empleado.setRol("Desarrollador");

        Empleado guardado = servicioEmpleado.crearEmpleado(empleado);
        assertNotNull(guardado);
        assertNotNull(guardado.getIdEmpleado());
        assertEquals("Ana Bohueles", guardado.getNombre());
        assertEquals("ana@gmail.com", guardado.getEmail());
    }

    //CASO 2: Modificación de datos
    @Test
    void testActualizarEmpleado() {
        // Creamos un empleado previo
        Empleado empleado = new Empleado();
        empleado.setNombre("Jefferson Martin");
        empleado.setEmail("jeff@gmail.com");
        empleado.setRol("Tester");

        Empleado guardado = servicioEmpleado.crearEmpleado(empleado);

        // Introducimos nuevos datos
        Empleado nuevo = new Empleado();
        nuevo.setNombre("Jeff Actualizado");
        nuevo.setEmail("jeff_actualizado@gmail.com");
        nuevo.setRol("Administrador");

        Empleado actualizado = servicioEmpleado.actualizar(guardado.getIdEmpleado(), nuevo);

        assertNotNull(actualizado);
        assertEquals("Jeff Actualizado", actualizado.getNombre());
        assertEquals("jeff_actualizado@gmail.com", actualizado.getEmail());
        assertEquals("Administrador", actualizado.getRol());
    }
    // CASO 3: Eliminación de un empleado
    @Test
    void testEliminarEmpleado() {
        // Creamos un empleado previo
        Empleado empleado = new Empleado();
        empleado.setNombre("Carlos Ribagorda");
        empleado.setEmail("carlos@gmail.com");
        empleado.setRol("Soporte");

        Empleado guardado = servicioEmpleado.crearEmpleado(empleado);

        // Se elimina
        servicioEmpleado.borrarEmpleadoPorID(guardado.getIdEmpleado());

        // Se verifica
        Empleado eliminado = servicioEmpleado.buscarEmpleadoPorID(guardado.getIdEmpleado());

        assertNull(eliminado);
    }
}