package com.umg.app.models.dao;

import java.util.List;

import com.umg.app.models.entity.Maestro;

public interface IMaestroDao {
	 public List<Maestro> findAll();
	 
	 public void save (Maestro maestro);
	 
	 public Maestro findOne(long id);
	 
	 public void delete(long id);
	 }
 