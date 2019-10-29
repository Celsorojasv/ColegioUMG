package com.umg.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.umg.app.dao.ICursoDao;
import com.umg.app.models.entity.Curso;

@Controller
public class CursoController {

	@Autowired
	private ICursoDao cursoDao;

	@RequestMapping(value = "/cursosL", method = RequestMethod.GET)
	public String listadoCursos(Model model) {
		model.addAttribute("titulo", "Listado Cursos.");
		model.addAttribute("cursos", cursoDao.findAll());
		return "cursosL";
	}

	@RequestMapping(value = "/formCur")
	public String add(Model model) {
		Curso curso = new Curso();
		model.addAttribute("titulo", "Formulario de Curso");
		model.addAttribute("boton", "Crear Curso");
		model.addAttribute("curso", curso);
		return "formCur";
	}

	@RequestMapping(value = "/formCur", method = RequestMethod.POST)
	public String save(@Valid Curso curso, BindingResult result, Model model , SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Curso.");
			model.addAttribute("boton", "Editar");
			return "formCur";
		}
		cursoDao.save(curso);
		status.setComplete();
		return "redirect:cursosL";
	}
	
	

	@RequestMapping(value = "/formCur/{idCu}")
	public String edit(@PathVariable(value = "idCu") Long id, Model model) {
		Curso curso = null;
		if (id > 0) {
			curso = cursoDao.findOne(id);
		} else {
			return "redirect:cursosL";
		}
		model.addAttribute("titulo", "Editar Curso");
		model.addAttribute("boton", "Editar");
		model.addAttribute("curso", curso);
		return "formCur";
	}
	
	@RequestMapping(value = "/eliminarCur/{idCu}")
	public String delete(@PathVariable(value = "idCu") Long id , Model model) {
		if (id > 0) {
			cursoDao.delete(id);
		} 
		return "redirect:/cursosL";
	}
	
	//ESTO VA EN EL MAIN CONTROLLER
	@GetMapping(value = "index")
	public String index(Model model) {
		model.addAttribute("titulo", "index");
		return "index";
	}

}
