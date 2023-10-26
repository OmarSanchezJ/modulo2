package unam.diplomado.modulo2.librosservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.modulo2.librosservice.domain.Libro;
import unam.diplomado.modulo2.librosservice.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
    private LibroRepository libroRepository;
 
    @Override
    public List<Libro> obtenerLibro(){
		return libroRepository.findAll();
    }

	@Override
	public Libro crearLibro(String id, Libro libro) {
		return null;
	}
	
	@Override
	public Libro actualizarLibro(String id, Libro libro) {
		Optional<Libro> libroExistente = libroRepository.findById(id);
		if(libroExistente.isPresent()) {
			Libro libroActualizar = libroExistente.get();
			libroActualizar.setTitulo(libro.getTitulo());
			libroRepository.save(libroActualizar);
			return libroActualizar;
			}
		return null;
	}
	
	}
	
