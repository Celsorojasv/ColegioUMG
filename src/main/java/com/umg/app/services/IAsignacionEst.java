package com.umg.app.services;
import java.util.List;

import com.umg.app.models.entity.AsignacionEst;

public interface IAsignacionEst {
	
	 public List<AsignacionEst> findAll();
	 
	 public List<AsignacionEst> findAllByStudent(Long id);
	 
	 public List<AsignacionEst> findAllByCourse(Long id);
	 
	 public void save (AsignacionEst AsignacionEst);
	 
	 public AsignacionEst findOne(long id);
	 
	 public void delete(long id);
	 }