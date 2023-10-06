package unam.diplomado.modulo2.librosservice.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.modulo2.librosservice.domain.Libro;
import unam.diplomado.modulo2.librosservice.repository.LibroRepository;

@RestController
@RequestMapping(path="api/libros", produces="application/json")
@CrossOrigin(origins="*")

public class LibroController {
	
	@Autowired
	private LibroRepository libroRepository;
	
	
	@GetMapping
	public List<Libro> obtenerLibro(){
		return libroRepository.findAll();
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro crearLibro(@RequestBody Libro libro) {
		return libroRepository.insert(libro);
	}

}
