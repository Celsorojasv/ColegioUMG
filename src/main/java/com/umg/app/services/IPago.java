package com.umg.app.services;

import java.util.List;

import com.umg.app.models.entity.Pagos;


public interface IPago {

	public List<Pagos> findAllByStudent(Long id);
	public void save (Pagos pagos);

}
