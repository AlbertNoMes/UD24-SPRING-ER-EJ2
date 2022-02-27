package mainApp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "departamentos") // NOMBRE DE LA TABLA EN LA BD
public class Departamento {

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private int presupuesto;

	@OneToMany
	@JoinColumn(name = "codigo") // NOMBRE DE LA CLAVE QUE SERA FORANEA EN LA OTRA ENTIDAD
	private List<Empleado> empleado;

	// CONSTRUCTOR POR DEFECTO
	public Departamento() {
		super();
	}

	// CONSTRUCTOR CON TODO
	public Departamento(int codigo, String nombre, int presupuesto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	// GETTERS & SETTERS MENOS LA FORANEA
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleado")
	public List<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}

	// METODO TOSTRING MENOS LA CLAVE FORANEA
	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", presupuesto=" + presupuesto + "]";
	}

}
