package io.quarkiverso;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;


@Path("/saludo")
public class SaludoResource {

    @ConfigProperty(name = "saludo.mensaje", defaultValue = "Hola")
    String mensaje;

    @ConfigProperty(name = "saludo.version", defaultValue = "1.0")
    String version;

    @GET
    @Counted(value = "saludo_total", description = "Cuántas veces se llamó al endpoint")
    @Timed(value = "saludo_tiempo", description = "Tiempo de respuesta del endpoint")
    public String saludar(@QueryParam("nombre") String nombre) {
        String quien = (nombre != null) ? nombre : "viajero";
        return mensaje + ", " + quien + "! (v" + version + ")";
    }
}

