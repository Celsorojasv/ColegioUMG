package com.umg.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umg.app.dao.ICursoDao;
import com.umg.app.models.entity.Tareas;
import com.umg.app.services.ITareas;


@Controller
public class TareasController {
	@Autowired
	private ITareas servicio;
	
	@Autowired
	private ICursoDao ser;

	@RequestMapping(value = "/TareasC/{id}")
	public String listarases(@PathVariable(value = "id") Long id, Model model) {
		
		model.addAttribute("titulo", "Listado Tareas del Curso.");
		model.addAttribute("TareasC", servicio.findAllByCourse(id));
		return "listarTarCu";
	}
	
	@RequestMapping(value = "/FormTaC")
	public String FormAsE(Model model) {
		Tareas tarea = new Tareas();
		model.addAttribute("cursos", ser.findAll());
		model.addAttribute("titulo", "Nueva Tarea En el Curso");
		model.addAttribute("boton", "Crear Tarea");
		model.addAttribute("tarea", tarea);
		return "FormTaC";
	}
	
	@RequestMapping(value = "/CrearTaC" , method = RequestMethod.POST)
	public String CrearTA(@ModelAttribute("tarea") Tareas tarea){	
		servicio.save(tarea);
		return "redirect:/ListadoTareasCurso";
	}
	
	
}
