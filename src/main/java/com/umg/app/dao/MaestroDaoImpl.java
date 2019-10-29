package com.umg.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.umg.app.models.entity.Maestro;

@Repository
public class MaestroDaoImpl implements IMaestroDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Maestro> findAll() {
		return em.createQuery("from Maestro").getResultList();
	}

	@Override
	@Transactional
	public void save(Maestro maestro) {
		if(maestro.getIdMa() != null && maestro.getIdMa()>0) {
			em.merge(maestro);
		}
		else {
			em.persist(maestro);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Maestro findOne(long id) {
		return em.find(Maestro.class,id);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Maestro maestro = findOne(id);
		em.remove(maestro);
	}

}
