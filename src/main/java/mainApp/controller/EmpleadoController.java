package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Empleado;
import mainApp.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	// MAPEAMOS LOS METODOS DEL ServiceImpl
	@GetMapping("/empleados") // PERMITE LISTAR LOS EMPLEADOS CON EL /api/empleados EN EL POSTMAN
	public List<Empleado> listaEmpleado() {
		return empleadoServiceImpl.listaEmpleados();
	}
	
	@GetMapping("empleados/nombre/{nombre}") // PARA LISTAR POR UN nombre CONCRETO
	public List<Empleado> listarEmpleadoNombre(@PathVariable(name = "nombre") String nombre) {
		return empleadoServiceImpl.listarEmpleadoNombre(nombre);
	}
	
	@PostMapping("/empleados") // PARA AÑADIR UN DEPARTAMENTO
	public Empleado saveEmpleado(@RequestBody Empleado empleado) {
		return empleadoServiceImpl.addEmpleado(empleado);
	}
	
	@GetMapping("/empleados/{codigo}") // PARA LISTAR POR codigo
	public Empleado articuloById(@PathVariable(name = "codigo") String DNI) {
		return empleadoServiceImpl.getEmpleadoById(DNI);
	}

	@PutMapping("/empleados/{codigo}") // PARA ACTUALIZAR POR codigo
	public Empleado actualizarEmpleado(@PathVariable(name = "codigo") String DNI, @RequestBody Empleado empleado) {
		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();

		empleado_seleccionado = empleadoServiceImpl.getEmpleadoById(DNI);
		
		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellidos(empleado.getApellidos());
		empleado_seleccionado.setDepartamento(empleado.getDepartamento());
		
		empleado_actualizado=empleadoServiceImpl.actualizarEmpleado(empleado_seleccionado);
		
		System.out.println("El empleado actualizado es: "+empleado_actualizado);

		return empleado_actualizado;
	}
	
	@DeleteMapping("/empleados/{codigo}") // PARA BORRAR POR codigo
	public void deleteEmpleado(@PathVariable(name="codigo") String DNI) {
		empleadoServiceImpl.deleteEmpleado(DNI);
	}

}
