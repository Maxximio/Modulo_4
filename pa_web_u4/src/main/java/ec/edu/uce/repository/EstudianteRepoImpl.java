package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.repository.modelo.Estudiante;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Estudiante buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> myQuery=this.entityManager.createQuery("select e from Estudiente e",Estudiante.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Estudiante estu) {
		this.entityManager.merge(estu);
	}

	@Override
	public void Insertar(Estudiante estu) {
		this.entityManager.persist(estu);
	}

	@Override
	public void Borrar(Integer id) {
		Estudiante estu=this.buscar(id);
		this.entityManager.remove(estu);
		
	}

}
