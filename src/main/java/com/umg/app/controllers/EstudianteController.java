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

import com.umg.app.dao.IEstudianteDao;
import com.umg.app.models.entity.Estudiante;

@Controller
public class EstudianteController {

	@Autowired
	private IEstudianteDao estudianteDao;

	@RequestMapping(value = "/estudiantesL", method = RequestMethod.GET)
	public String listadoEstudiantes(Model model) {
		model.addAttribute("titulo", "Listado Estudiantes.");
		model.addAttribute("estudiantes", estudianteDao.findAll());
		return "estudiantesL";
	}

	@RequestMapping(value = "/formEs")
	public String add(Model model) {
		Estudiante estudiante = new Estudiante();
		model.addAttribute("titulo", "Formulario de Estudiantes.");
		model.addAttribute("boton", "Crear Estudiante");
		model.addAttribute("estudiante", estudiante);
		return "formEs";
	}

	@RequestMapping(value = "/formEs", method = RequestMethod.POST)
	public String save(@Valid Estudiante estudiante, BindingResult result, Model model, SessionStatus status) {
		if (result.hasFieldErrors()) {
			model.addAttribute("titulo", "Formulario de Estudiante.");
			model.addAttribute("boton", "Editar");
			return "formEs";
		}
		estudianteDao.save(estudiante);
		status.setComplete();
		return "redirect:estudiantesL";
	}

	@RequestMapping(value = "/formEs/{idEs}")
	public String edit(@PathVariable(value = "idEs") Long id, Model model) {
		Estudiante estudiante = null;
		if (id > 0) {
			estudiante = estudianteDao.findOne(id);
		} else { 
			return "redirect:estudiantesL";
		}
		model.addAttribute("titulo", "Editar Estudiante");
		model.addAttribute("boton", "Editar");
		model.addAttribute("estudiante", estudiante);
		return "formEs";
	}

	@RequestMapping(value = "/eliminarEs/{idEs}")
	public String delete(@PathVariable(value = "idEs") Long id, Model model) {
		if (id > 0) {
			estudianteDao.delete(id);
		}
		return "redirect:/estudiantesL";
	}
	

	@RequestMapping(value = "/ListadoPagosEs", method = RequestMethod.GET)
	public String listadoPEstudiantes(Model model) {
		model.addAttribute("titulo", "Listado Estudiantes.");
		model.addAttribute("estudiantes", estudianteDao.findAll());
		return "ListadoPagosEs";
	}

}
