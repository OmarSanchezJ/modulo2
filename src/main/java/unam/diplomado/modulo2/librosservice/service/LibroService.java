package unam.diplomado.modulo2.librosservice.service;

import java.util.List;

import unam.diplomado.modulo2.librosservice.domain.Libro;

public interface LibroService {

	Libro crearLibro(String id, Libro libro);
	List<Libro> obtenerLibro();
	Libro actualizarLibro(String id, Libro libro);
	
}
