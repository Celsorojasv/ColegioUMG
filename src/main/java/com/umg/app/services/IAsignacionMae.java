package com.umg.app.services;

import java.util.List;

import com.umg.app.models.entity.AsignacionMae;

public interface IAsignacionMae {

	public List<AsignacionMae> findAll();
	 
	 public List<AsignacionMae> findAllByTeacher(Long id);
	 
	 public void save (AsignacionMae AsignacionMae);
	 
	 public AsignacionMae findOne(long id);
	 
	 public void delete(long id);
}
