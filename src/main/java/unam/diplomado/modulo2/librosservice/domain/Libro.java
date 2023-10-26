package unam.diplomado.modulo2.librosservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="libros")

public class Libro {
	
	@Id
	private String id;
	private String titulo;
	private String autores;
	private String editorial;
	private String edicion;
	private Double paginas;
	private Double precio;
	private Double existencia;
	private String isbn;
	

}
