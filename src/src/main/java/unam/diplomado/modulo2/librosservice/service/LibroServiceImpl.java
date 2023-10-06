package unam.diplomado.modulo2.librosservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import unam.diplomado.modulo2.librosservice.domain.Libro;
import unam.diplomado.modulo2.librosservice.repository.LibroRepository;

public class LibroServiceImpl implements LibroService{

	@Autowired
    private LibroRepository libroRepository;
 
    @Override
    public List<Libro> obtenerLibro(){
		return libroRepository.findAll();
    }

	@Override
	public Libro crearLibro(String id, Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
