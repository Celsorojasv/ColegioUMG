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

import com.umg.app.models.entity.AsignacionEst;
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
		model.addAttribute("titulo", "Listado Asignaciones del Estudiante.");
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
		
		model.addAttribute("titulo", "Listado Asignaciones Curso - Estudiantes.");
		model.addAttribute("asignCu", servicio.findAllByCourse(id));
		return "ListAsignadosCursos";
	}
	
	
	@RequestMapping(value = "/CreaAsign",  method = { RequestMethod.GET, RequestMethod.POST })
	public String CrearAsigEst(@Valid AsignacionEst Aest , BindingResult result , Model model, SessionStatus status) {
		if(result.hasErrors()){
			model.addAttribute("titulo", "Formulario de Curso.");
			model.addAttribute("boton", "Editar");
			model.addAttribute("Aest", Aest);
			return "CreaAsign";
		}
		servicio.save(Aest);
		status.setComplete();
		return "CreaAsign";
	}
	
}

