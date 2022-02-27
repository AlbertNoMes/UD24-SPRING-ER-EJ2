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

import mainApp.dto.Departamento;
import mainApp.service.DepartamentoServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
	
	@Autowired
	DepartamentoServiceImpl departamentoServiceImpl;
	
	// MAPEAMOS LOS METODOS DEL ServiceImpl
	@GetMapping("/departamentos") // PERMITE LISTAR LOS DEPARTAMENTOS CON EL /api/departamentos EN EL POSTMAN
	public List<Departamento> listaDepartamento() {
		return departamentoServiceImpl.listaDepartamentos();
	}
	
	@GetMapping("departamentos/nombre/{nombre}") // PARA LISTAR POR UN nombre CONCRETO
	public List<Departamento> listarDepartamentoNombre(@PathVariable(name = "nombre") String nombre) {
		return departamentoServiceImpl.listarDepartamentoNombre(nombre);
	}
	
	@PostMapping("/departamentos") // PARA AÑADIR UN DEPARTAMENTO
	public Departamento saveDepartamento(@RequestBody Departamento departamento) {
		return departamentoServiceImpl.addDepartamento(departamento);
	}
	
	@GetMapping("/departamentos/{codigo}") // PARA LISTAR POR codigo
	public Departamento departamentoById(@PathVariable(name = "codigo") int codigo) {
		return departamentoServiceImpl.getDepartamentoById(codigo);
	}

	@PutMapping("/departamentos/{codigo}") // PARA ACTUALIZAR POR codigo
	public Departamento actualizarDepartamento(@PathVariable(name = "codigo") int codigo, @RequestBody Departamento departamento) {
		Departamento departamento_seleccionado = new Departamento();
		Departamento departamento_actualizado = new Departamento();

		departamento_seleccionado = departamentoServiceImpl.getDepartamentoById(codigo);
		
		departamento_seleccionado.setNombre(departamento.getNombre());
		departamento_seleccionado.setPresupuesto(departamento.getPresupuesto());
		
		departamento_actualizado=departamentoServiceImpl.actualizarDepartamento(departamento_seleccionado);
		
		System.out.println("El departamento actualizado es: "+departamento_actualizado);

		return departamento_actualizado;
	}
	
	@DeleteMapping("/departamentos/{codigo}") // PARA BORRAR POR codigo
	public void deleteDepartamento(@PathVariable(name="codigo") int codigo) {
		departamentoServiceImpl.deleteDepartamento(codigo);
	}

}
