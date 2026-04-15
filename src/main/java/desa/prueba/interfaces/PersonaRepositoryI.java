package desa.prueba.interfaces;

import java.util.List;

import desa.prueba.model.Persona;
import desa.prueba.util.ErrorCond;

public interface PersonaRepositoryI {
	boolean existeRut(String rut);

	ErrorCond guardar(Persona persona);

	List<Persona> listar();

	String borrar(Long id);
	
	boolean existeId(Long id);

}
