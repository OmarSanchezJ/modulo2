package unam.diplomado.modulo2.librosservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.modulo2.librosservice.domain.Libro;


public interface LibroRepository 
	extends MongoRepository<Libro, String>{

}
