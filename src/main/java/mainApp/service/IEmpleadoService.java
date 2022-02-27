package mainApp.service;

import java.util.List;

import mainApp.dto.Empleado;

public interface IEmpleadoService {

	// METODOS DEL CRUD
	public List<Empleado> listaEmpleados(); // LISTAR TODOS LOS EMPLEADOS

	public Empleado addEmpleado(Empleado empleado); // ADD NUEVO EMPLEADO

	public Empleado getEmpleadoById(String DNI); // GET EMPLEADO BY ID

	public List<Empleado> listarEmpleadoNombre(String nombre); // LISTA EMPLEADO POR NOMBRE

	public Empleado actualizarEmpleado(Empleado empleado); // ACTUALIZA DATOS DEL EMPLEADO

	public void deleteEmpleado(String DNI); // ELIMINA EL EMPLEADO

}
