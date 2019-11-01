package com.umg.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umg.app.services.ITareas;


@Controller
public class TareasController {
	@Autowired
	private ITareas servicio;

	@RequestMapping(value = "/TareasC/{id}")
	public String listarases(@PathVariable(value = "id") Long id, Model model) {
		
		model.addAttribute("titulo", "Listado Tareas del Curso.");
		model.addAttribute("TareasC", servicio.findAllByCourse(id));
		return "listarTarCu";
	}
	
	
}
