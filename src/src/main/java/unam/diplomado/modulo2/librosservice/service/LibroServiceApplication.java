package unam.diplomado.modulo2.librosservice.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import unam.diplomado.modulo2.librosservice.api.LibroController;


@SpringBootApplication
@ComponentScan(basePackageClasses = LibroController.class)
public class LibroServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LibroServiceApplication.class, args);
	}
}
