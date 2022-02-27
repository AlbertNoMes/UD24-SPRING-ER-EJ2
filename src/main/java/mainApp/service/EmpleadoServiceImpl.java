package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IEmpleadoDAO;
import mainApp.dto.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired // TRAE TODA LA FUNCIONALIDAD DEL DAO. UN COPIAR Y PEGAR
	IEmpleadoDAO iEmpleadoDAO;
	
	@Override
	public List<Empleado> listaEmpleados() {
		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado addEmpleado(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}

	public Empleado getEmpleadoById(String DNI) {
		return iEmpleadoDAO.findById(DNI).get();
	}

	@Override
	public List<Empleado> listarEmpleadoNombre(String nombre) {
		return iEmpleadoDAO.findByNombre(nombre);
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void deleteEmpleado(String DNI) {
		iEmpleadoDAO.deleteById(DNI);
	}
	
	

}
