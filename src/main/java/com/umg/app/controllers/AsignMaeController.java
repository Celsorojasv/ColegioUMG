package com.umg.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umg.app.services.IAsignacionMae;



@Controller
public class AsignMaeController {

	@Autowired 
	private IAsignacionMae servicio;

	@RequestMapping(value = "/listarAs", method = RequestMethod.GET)
	public String listadoAsMa(Model model) {
		model.addAttribute("titulo", "Listado Asignaciones.");
		model.addAttribute("asignMa", servicio.findAll());
		return "/listarAsMa";
	}
	
	@RequestMapping(value = "/AsigMa/{id}")
	public String listarases(@PathVariable(value = "id") Long id, Model model) {
	
		model.addAttribute("titulo", "Listado Asignaciones.");
		model.addAttribute("asignMa", servicio.findAllByTeacher(id));
		return "/listarAsMa";
	}
	
	@RequestMapping(value = "/AsigMaD/{id}")
	public String delete(@PathVariable(value = "id") Long id , Model model) {
		if (id > 0) {
			servicio.delete(id);
		} 
		return "redirect:/maestrosL";
	}
	
	
}
