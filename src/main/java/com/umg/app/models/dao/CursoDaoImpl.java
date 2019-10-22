package com.umg.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.umg.app.models.entity.Curso;

@Repository
public class CursoDaoImpl implements ICursoDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Curso> findAll() {

		return em.createQuery("from Curso").getResultList();
	}

	@Override
	@Transactional
	public void save(Curso curso) {
		if(curso.getIdCurso() != null && curso.getIdCurso()>0){
			em.merge(curso);
		}else {
			em.persist(curso);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findOne(long id) {
		return em.find(Curso.class,id);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Curso curso = findOne(id);
		em.remove(curso);
	}

}
