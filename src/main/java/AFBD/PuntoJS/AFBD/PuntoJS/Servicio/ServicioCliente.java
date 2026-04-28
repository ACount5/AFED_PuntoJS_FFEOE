package AFBD.PuntoJS.AFBD.PuntoJS.Servicio;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Cliente;
import AFBD.PuntoJS.AFBD.PuntoJS.Repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCliente {
    @Autowired
    RepositorioCliente repositorioCliente;

    //Crear
    public Cliente crearCliente(Cliente cliente){
       return repositorioCliente.save(cliente);
    }
    //Listar
    public List<Cliente> listar(){
        return repositorioCliente.findAll();
    }
    //Buscar por ID
    public Cliente buscarClientePorID(int id){
        return repositorioCliente.findById(id).orElse(null);
    }
    //Borrar por ID
    public void borrarClientePorID(int id){
        repositorioCliente.deleteById(id);
        System.out.println("El cliente con id: " + id + "ha sido eliminado.");
    }
    //Actualizar
    public Cliente actualizar(int id, Cliente nuevo) {
        Cliente existente = buscarClientePorID(id);

        existente.setNombre(nuevo.getNombre());
        existente.setEmail(nuevo.getEmail());
        existente.setTelefono(nuevo.getTelefono());
        existente.setEmpresa(nuevo.getEmpresa());

        return repositorioCliente.save(existente);
    }
}
