package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Departamento;

public interface IDepartamentoDAO extends JpaRepository<Departamento, Integer>{

	public List<Departamento> findByNombre(String nombre);
	
}
