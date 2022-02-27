package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Empleado;

public interface IEmpleadoDAO extends JpaRepository<Empleado, String>{
	
	public List<Empleado> findByNombre(String nombre);

}
