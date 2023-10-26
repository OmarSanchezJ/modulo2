package unam.diplomado.modulo2.librosservice.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import unam.diplomado.modulo2.librosservice.domain.Libro;

@RequestMapping(path="api/libros", produces="application/json")
@Tag(name="libro",
    description="Api del Recurso libros")
@CrossOrigin(origins="*")

public interface LibroApi {
	Libro crearLibro(
			@NotNull @RequestBody LibroController request);
}
