package com.umg.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.umg.app.dao.IMaestroDao;
import com.umg.app.models.entity.Maestro;


@Controller
public class MaestroController {

	@Autowired
	private IMaestroDao maestroDao;
	

	@RequestMapping(value = "/maestrosL", method = RequestMethod.GET)
	public String listadomaestros(Model model) {
		model.addAttribute("titulo", "Listado Maestros.");
		model.addAttribute("maestros", maestroDao.findAll());
		return "maestrosL";
	}
	
	@RequestMapping(value = "/formMa")
	public String add(Model model) {
		Maestro maestro = new Maestro();
		model.addAttribute("titulo", "Formulario de Maestros.");
		model.addAttribute("boton", "Crear Maestro");
		model.addAttribute("maestro", maestro);
		return "formMa";
	}
	
	@RequestMapping(value = "/formMa", method = RequestMethod.POST)
	public String save(@Valid Maestro maestro, BindingResult result, Model model, SessionStatus status) {
		if (result.hasFieldErrors()) {
			model.addAttribute("titulo", "Formulario de Maestros.");
			model.addAttribute("boton", "Editar");
			return "formMa";
		}
		maestroDao.save(maestro);
		status.setComplete();
		return "redirect:maestrosL";
	}
	
	@RequestMapping(value = "/formMa/{idMa}")
	public String edit(@PathVariable(value = "idMa") Long id, Model model) {
		Maestro maestro = null;
		if (id > 0) {
			maestro = maestroDao.findOne(id);
		} else { 
			return "redirect:maestrosL";
		}
		model.addAttribute("titulo", "Editar Maestro");
		model.addAttribute("boton", "Editar");
		model.addAttribute("maestro", maestro);
		return "formMa";
	}
	
	@RequestMapping(value = "/eliminarMa/{idMa}")
	public String delete(@PathVariable(value = "idMa") Long id, Model model) {
		if (id > 0) {
			maestroDao.delete(id);
		}
		return "redirect:/maestrosL";
	}
	
}
