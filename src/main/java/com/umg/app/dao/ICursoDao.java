package com.umg.app.dao;

import java.util.List;

import com.umg.app.models.entity.Curso;

public interface ICursoDao {

	public List<Curso> findAll();
	
	public void save(Curso curso);
	
	public Curso findOne(long id);
	
	public void delete(long id);
	
}
