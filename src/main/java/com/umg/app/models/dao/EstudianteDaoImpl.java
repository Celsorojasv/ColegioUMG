package com.umg.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.umg.app.models.entity.Estudiante;

@Repository
public class EstudianteDaoImpl implements IEstudianteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Estudiante> findAll() {

		return em.createQuery("from Estudiante").getResultList();
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) {
		if(estudiante.getIdEstu() != null && estudiante.getIdEstu()>0) {
			em.merge(estudiante);
		}
		else {
			em.persist(estudiante);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Estudiante findOne(long id) {
		return em.find(Estudiante.class,id);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Estudiante estudiante = findOne(id);
		em.remove(estudiante);
	}

}
