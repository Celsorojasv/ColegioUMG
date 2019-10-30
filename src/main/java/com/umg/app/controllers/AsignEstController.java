package com.umg.app.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.umg.app.services.IAsignacionEst;

@Controller
public class AsignEstController {

	@Autowired 
	private IAsignacionEst servicio;
	
	
	@RequestMapping(value = "/listarAsEs", method = RequestMethod.GET)
	public String listadoAsEs(Model model) {
		model.addAttribute("titulo", "Listado Asignaciones.");
		model.addAttribute("asignEs", servicio.findAll());
		return "/listarAsEs";
	}
	
	@RequestMapping(value = "/AsigEst/{id}")
	public String listarases(@PathVariable(value = "id") Long id, Model model) {
	
		model.addAttribute("titulo", "Listado Asignaciones.");
		model.addAttribute("asignEs", servicio.findAllByStudent(id));
		return "/listarAsEs";
	}
	
	
	@RequestMapping(value = "/AsigEstD/{id}")
	public String delete(@PathVariable(value = "id") Long id , Model model) {
		if (id > 0) {
			servicio.delete(id);
		} 
		return "redirect:/estudiantesL";
	}
	
	@RequestMapping(value = "/AsigCur/{id}")
	public String ListaEsCu(@PathVariable(value = "id") Long id, Model model) {
	
		model.addAttribute("titulo", "Listado Asignaciones.");
		model.addAttribute("asignCu", servicio.findAllByCourse(id));
		return "ListAsignadosCursos";
	}
}

