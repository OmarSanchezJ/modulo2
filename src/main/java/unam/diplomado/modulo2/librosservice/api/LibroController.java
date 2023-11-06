package unam.diplomado.modulo2.librosservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import unam.diplomado.modulo2.librosservice.domain.Libro;
import unam.diplomado.modulo2.librosservice.repository.LibroRepository;
import unam.diplomado.modulo2.librosservice.service.LibroService;

@RestController
@RequestMapping(path="api/libros", produces="application/json")
@CrossOrigin(origins="*")

public class LibroController {
	
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public List<Libro> obtenerLibro(){
		return libroRepository.findAll();
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Libro crearLibro(@RequestBody Libro libro) {
		return libroRepository.insert(libro);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable("id") String id) {
		Optional<Libro> libro = libroRepository.findById(id);
		if (libro.isPresent()) {
			return new ResponseEntity<>(libro.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="{id}", consumes="application/json")
	public ResponseEntity<Libro> actualizarLibro(
		@PathVariable("id") String id, @RequestBody Libro libro) {
	    Libro libroActualizado = libroService.actualizarLibro(id, libro);
	    if (libroActualizado != null) {
	    	return new ResponseEntity<>(libroActualizado,HttpStatus.OK);
	    }
	    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarLibro(@PathVariable("id") String id) {
    libroRepository.deleteById(id);
    }

}
