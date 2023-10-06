package unam.diplomado.modulo2.librosservices.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info=@Info(
		version = "v1",
		title = "Microservicio de Agregar Libro - endpoint",
		description = "Definicion del endpoint agregar libro",
		contact = @Contact(
				name = "UNAM",
				url = "https://www.unam.mx/",
		        email = "omar@economia.unam.mx")))

public class OpenApiConfig {

}
