package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.repository.modelo.Estudiante;

public interface IEstudianteRepo {

	public Estudiante buscar(Integer id);
	
	public List<Estudiante> buscarTodos();
	
	public void actualizar(Estudiante estu);
	
	public void Insertar(Estudiante estu);
	
	public void Borrar(Integer id);
	
}
