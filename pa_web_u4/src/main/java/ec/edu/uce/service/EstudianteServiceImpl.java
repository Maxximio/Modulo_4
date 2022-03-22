package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IEstudianteRepo;
import ec.edu.uce.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepo repoEstu;
	
	@Override
	public Estudiante buscarService(Integer id) {
		// TODO Auto-generated method stub
		return this.repoEstu.buscar(id);
	}

	@Override
	public List<Estudiante> buscarTodosService() {
		// TODO Auto-generated method stub
		return this.repoEstu.buscarTodos();
	}

	@Override
	public void actualizarService(Estudiante estu) {
		this.repoEstu.actualizar(estu);
	}

	@Override
	public void InsertarService(Estudiante estu) {
		// TODO Auto-generated method stub
		this.repoEstu.Insertar(estu);
	}

	@Override
	public void BorrarService(Integer id) {
		this.repoEstu.Borrar(id);
	}

}
