package unam.diplomado.modulo2.librosservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				version = "v1",
				title = "Libros Microservice Endpoints", 
				description = "Definición de los Endpoints de Libros",
				contact = @Contact(
					name = "OmarJesus Sanchez Jimenez", 
					url = "https://www.unam.mx/", 
				email = "omar@economia.unam.mx")))
public class OpenApiConfig {

}
