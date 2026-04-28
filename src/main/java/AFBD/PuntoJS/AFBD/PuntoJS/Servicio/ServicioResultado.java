package AFBD.PuntoJS.AFBD.PuntoJS.Servicio;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Resultado;
import AFBD.PuntoJS.AFBD.PuntoJS.Repositorio.RepositorioResultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioResultado {
    @Autowired
    RepositorioResultado repositorioResultado;

    //Crear
    public Resultado crearResultado(Resultado resultado){
        return repositorioResultado.save(resultado);
    }
    //Listar
    public List<Resultado> listar(){
        return repositorioResultado.findAll();
    }
    //Buscar por ID
    public Resultado buscarResultadoPorID(int id){
        return repositorioResultado.findById(id).orElse(null);
    }
    //Borrar por ID
    public void borrarResultadoporID(int id){
        repositorioResultado.deleteById(id);
        System.out.println("El resultado con id: " + id + "ha sido eliminado.");
    }
    //Actualizar
    public Resultado actualizar(int id, Resultado nuevo) {
        Resultado existente = buscarResultadoPorID(id);

        existente.setValor(nuevo.getValor());
        existente.setFecha(nuevo.getFecha());

        return repositorioResultado.save(existente);
    }
}
