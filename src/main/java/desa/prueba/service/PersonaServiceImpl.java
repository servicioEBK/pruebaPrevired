package desa.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desa.prueba.interfaces.PersonaRepositoryI;
import desa.prueba.model.Persona;
import desa.prueba.repositorio.PersonaRepository;
import desa.prueba.util.ErrorCond;
import desa.prueba.util.MiConfig;

@Service
public class PersonaServiceImpl implements PersonaRepositoryI {

	@Autowired
	private MiConfig config;
	
	
	private final PersonaRepository personaRepository;

	public PersonaServiceImpl(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@Override
	public boolean existeRut(String rut) {
		// TODO Auto-generated method stub
		return personaRepository.existeRut(rut);

	}

	public ErrorCond guardar(Persona persona) {
		ErrorCond error = new ErrorCond();
		if (persona == null) {
			error.setCampo("persona");
			error.setMensaje(config.getPvacio());
			return error;
		}

		if (persona.getRut_dni() == null || persona.getRut_dni().trim().isEmpty()) {
			error.setCampo("rut_dni");
			error.setMensaje(config.getPrnulo());
			return error;
		}

		if (existeRut(persona.getRut_dni())) {
			error.setCampo("rut_dni");
			error.setMensaje(config.getPrexiste());
			return error;
		}

		if (Long.parseLong(persona.getSalario()) < 400000) {
			error.setCampo("salario");
			error.setMensaje(config.getPslimite());
			return error;
		} else {
			personaRepository.agregar(persona);
			return error;

		}

	}

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		List<Persona> lista = personaRepository.listar();

		return lista;

	}

	@Override
	public String borrar(Long id) {
		if (existeId(id)) {
			personaRepository.eliminar(id);
			return config.getPeok();
		} else {
			return  config.getPinexiste();
		}
	}

	@Override
	public boolean existeId(Long id) {
		return personaRepository.existeId(id);
	}

}
