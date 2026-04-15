package desa.prueba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import desa.prueba.model.Persona;
import desa.prueba.service.PersonaServiceImpl;
import desa.prueba.util.ErrorCond;

@RestController
public class AplicacionIndex {

	List<Map<String, String>> errores = new ArrayList<>();
	@Autowired
	private PersonaServiceImpl personaService;

	@GetMapping(value = "/api/getRegistro")
	public List<?> getRegistro() {
		return personaService.listar();
	}

	@PostMapping("/api/getAddRegistro")
	public ResponseEntity<?> getAddRegistro(@ModelAttribute Persona persona) {
		ErrorCond error = personaService.guardar(persona);
		Map<String, Object> respuesta = new HashMap<>();
		if (error != null && error.getCampo() != null) {
            respuesta.put("status", 400);
            respuesta.put("mensaje", "Hay registros con error");
            respuesta.put("errores", error);
            return ResponseEntity.badRequest().body(respuesta);
		}
		respuesta.put("status", 200);
		respuesta.put("mensaje", "Guardado");
		return ResponseEntity.ok(respuesta);
	}

	@RequestMapping(value = "/api/getDelRegistro/{id}", method = RequestMethod.DELETE)
	public String getDelRegistro(@PathVariable Long id) {
		return personaService.borrar(id);
	}
}
