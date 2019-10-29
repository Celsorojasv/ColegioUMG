package com.umg.app.dao;

import java.util.List;

import com.umg.app.models.entity.Estudiante;

public interface IEstudianteDao {
	public List<Estudiante> findAll();
	
	public void save(Estudiante estudiante);
	
	public Estudiante findOne(long id);
	
	public void delete(long id);
}
