package com.mkss.infotek.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de la Pagina de Inicio
 * 
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * 
	 * @param model nos da acceso al metodo addAttribute que nos permite enviar informacion al formulario
	 * @return
	 */
	@GetMapping
	public String getIndex(Model model) {

		model.addAttribute("titulo", "Bien Venido al Sistema");

		return "/home";
	}

}
