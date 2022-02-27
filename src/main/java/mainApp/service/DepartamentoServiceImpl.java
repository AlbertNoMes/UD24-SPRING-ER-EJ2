package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mainApp.dao.IDepartamentoDAO;
import mainApp.dto.Departamento;

public class DepartamentoServiceImpl implements IDepartamentoService{
	
	@Autowired // TRAE TODA LA FUNCIONALIDAD DEL DAO. UN COPIAR Y PEGAR
	IDepartamentoDAO iDepartamentoDAO;

	@Override
	public List<Departamento> listaDepartamentos() {
		return iDepartamentoDAO.findAll();
	}

	@Override
	public Departamento addDepartamento(Departamento departamento) {
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public Departamento getDepartamentoById(int codigo) {
		return iDepartamentoDAO.findById(codigo).get();
	}

	@Override
	public List<Departamento> listarDepartamentoNombre(String nombre) {
		return iDepartamentoDAO.findByNombre(nombre);
	}

	@Override
	public Departamento actualizarDepartamento(Departamento departamento) {
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public void deleteDepartamento(int codigo) {
		iDepartamentoDAO.deleteById(codigo);
		
	}

}
