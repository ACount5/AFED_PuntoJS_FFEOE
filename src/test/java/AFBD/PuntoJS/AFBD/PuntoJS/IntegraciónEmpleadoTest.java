package AFBD.PuntoJS.AFBD.PuntoJS;

import AFBD.PuntoJS.AFBD.PuntoJS.Dominio.Empleado;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegraciónEmpleadoTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearYBuscarEmpleadoIntegracion() throws Exception {

        String empleadoJson = """
                {
                    "nombre": "Ricardo",
                    "email": "richar@gmail.com",
                    "rol": "Analista"
                }
                """;
        String respuesta = mockMvc.perform(post("/empleados/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(empleadoJson))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        Empleado empleadoCreado = objectMapper.readValue(respuesta, Empleado.class);

        mockMvc.perform(get("/empleados/buscar/" + empleadoCreado.getIdEmpleado()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ricardo"))
                .andExpect(jsonPath("$.email").value("richar@gmail.com"))
                .andExpect(jsonPath("$.rol").value("Analista"));
    }
}