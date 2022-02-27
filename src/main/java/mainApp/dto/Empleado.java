package mainApp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleados") // NOMBRE DE LA TABLA EN LA BD
public class Empleado {
	
	// ATRIBUTOS
	@Id
	private String DNI;
	private String nombre;
	private String apellidos;
	
	@ManyToOne
	@JoinColumn(name="departamento") // NOMBRE DE LA CLAVE FORANEA
	private Departamento departamento; // TRAEMOS UN OBJETO departamento

	// CONSTRUCTOR POR DEFECTO
	public Empleado() {
		super();
	}

	// CONSTRUCTOR CON TODO
	public Empleado(String dNI, String nombre, String apellidos, Departamento departamento) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
	}

	// GETTERS & SETTERS
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	// METODO TOSTRING
	@Override
	public String toString() {
		return "Empleado [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", departamento="
				+ departamento + "]";
	}
	
}
