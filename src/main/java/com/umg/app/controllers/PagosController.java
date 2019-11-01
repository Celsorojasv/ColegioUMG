package com.umg.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.umg.app.dao.IEstudianteDao;
import com.umg.app.models.entity.Pagos;
import com.umg.app.services.IPago;

@Controller
public class PagosController {

	@Autowired
	private IPago servicio;
	
	@Autowired
	private IEstudianteDao ser;
	
	@RequestMapping(value = "/PagoEst/{id}")
	public String listarases(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("titulo", "Listado Pagos del Estudiante.");
		model.addAttribute("PagoEst", servicio.findAllByStudent(id));
		return "listarPagEs";
	}
	
	
	@RequestMapping(value = "/FormPaE")
	public String FormAsE(Model model) {
		Pagos pago = new Pagos();
		model.addAttribute("estudiantes", ser.findAll());
		model.addAttribute("titulo", "Nueva Pago Estudiante");
		model.addAttribute("boton", "Realizar Pago");
		model.addAttribute("pago", pago);
		return "FormPaE";
	}
	
	@RequestMapping(value = "/CrearPaE" , method = RequestMethod.POST)
	public String CrearAS(@ModelAttribute("pago") Pagos pago){
		servicio.save(pago);
		return "redirect:/ListadoPagosEs";
	}
	

}
