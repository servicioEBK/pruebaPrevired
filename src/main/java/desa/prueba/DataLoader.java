package desa.prueba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import desa.prueba.repositorio.PersonaRepository;



@Configuration
public class DataLoader {

	 @Bean
	    public CommandLineRunner init(PersonaRepository repository) {
	        return args -> {
	            repository.crearTabla();
	            repository.agregar("Sergio", "Morande", "14234325", "Ejecutivo", "500000");
	            repository.agregar("Luis", "Rojas", "24567327", "Ventas", "700000");
	            repository.agregar("Paula", "Castillo", "16786543", "Asesor", "600000");
	        };
	    }
	 
	 
}
