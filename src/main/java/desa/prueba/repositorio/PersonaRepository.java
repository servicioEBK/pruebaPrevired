package desa.prueba.repositorio;

import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import desa.prueba.model.Persona;

@Repository
public class PersonaRepository {


private final JdbcTemplate jdbcTemplate;

    public PersonaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void crearTabla() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS personas");
        jdbcTemplate.execute(
            "CREATE TABLE personas (" +
            "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
            "nombre VARCHAR(100), " +
            "apellido VARCHAR(100), " +
            "rut_dni VARCHAR(100), " +
            "cargo VARCHAR(100), " +
            "salario VARCHAR(100))"
        );
    }
    
    

    public List<Persona> listar() {
        return jdbcTemplate.query(
            "SELECT id, nombre, apellido, rut_dni, cargo, salario FROM personas ORDER BY id",
            (rs, rowNum) -> new Persona(
                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("rut_dni"),
                rs.getString("cargo"),
                rs.getString("salario")
            )
        );
    }
    
    public void agregar(String nombre, String apellido, String rut_dni, String cargo, String salario) {
		// TODO Auto-generated method stub
    	jdbcTemplate.update(
                "INSERT INTO personas(nombre, apellido, rut_dni, cargo, salario) VALUES (?, ?, ?, ?, ?)",
                nombre, apellido, rut_dni, cargo, salario
            );
		
	}
    
    public void agregar(Persona persona) {
        jdbcTemplate.update(
            "INSERT INTO personas(nombre, apellido, rut_dni, cargo, salario) VALUES (?, ?, ?, ?, ?)",
            persona.getNombre(), persona.getApellido(), persona.getRut_dni(), persona.getCargo(), persona.getSalario()
        );
    }
    
    public void eliminar(Long id) {
        jdbcTemplate.update(
            "DELETE from personas where id = ?",id);
    }
    
    public boolean existeRut(String rut) {
        String sql = "SELECT COUNT(*) FROM personas WHERE rut_dni = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, rut);
        return count != null && count > 0;
    }


	public boolean existeId(Long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(*) FROM personas WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
	}


	
	    
	}