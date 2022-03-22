package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Estudiante;

public interface IEstudianteService {

	public Estudiante buscarService(Integer id);
	
	public List<Estudiante> buscarTodosService();
	
	public void actualizarService(Estudiante estu);
	
	public void InsertarService(Estudiante estu);
	
	public void BorrarService(Integer id);
	
}
