package mainApp.service;

import java.util.List;

import mainApp.dto.Departamento;

public interface IDepartamentoService {

	// METODOS DEL CRUD
	public List<Departamento> listaDepartamentos(); // LISTAR TODOS LOS DEPARTAMENTOS

	public Departamento addDepartamento(Departamento departamento); // ADD NUEVO DEPARTAMENTO

	public Departamento getDepartamentoById(Integer codigo); // GET DEPARTAMENTO BY ID

	public List<Departamento> listarDepartamentoNombre(String nombre); // LISTA DEPARTAMENTO POR NOMBRE

	public Departamento actualizarDepartamento(Departamento departamento); // ACTUALIZA DATOS DEL DEPARTAMENTO

	public void deleteDepartamento(Integer codigo); // ELIMINA EL DEPARTAMENTO

}
