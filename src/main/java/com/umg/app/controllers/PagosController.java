package com.umg.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umg.app.services.IPago;

@Controller
public class PagosController {

	@Autowired
	private IPago servicio;
	
	@RequestMapping(value = "/PagoEst/{id}")
	public String listarases(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("titulo", "Listado Pagos del Estudiante.");
		model.addAttribute("PagoEst", servicio.findAllByStudent(id));
		return "listarPagEs";
	}

}
