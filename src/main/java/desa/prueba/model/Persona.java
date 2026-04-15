package desa.prueba.model;

public class Persona {


    private Long id;    
	private String nombre;
    private String apellido;
    private String rut_dni;
    private String cargo;
    private String salario;
    
	public Persona(Long id, String nombre, String apellido, String rut_dni, String cargo, String salario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut_dni = rut_dni;
		this.cargo = cargo;
		this.salario = salario;
	}


    public Persona() {
    }


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut_dni() {
		return rut_dni;
	}

	public void setRut_dni(String rut_dni) {
		this.rut_dni = rut_dni;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}



}
