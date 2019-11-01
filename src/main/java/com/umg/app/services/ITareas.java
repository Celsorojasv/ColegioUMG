package com.umg.app.services;

import java.util.List;

import com.umg.app.models.entity.Tareas;



public interface ITareas {

	public List<Tareas> findAllByCourse(Long id);
	public void save (Tareas tareas);

	
}
