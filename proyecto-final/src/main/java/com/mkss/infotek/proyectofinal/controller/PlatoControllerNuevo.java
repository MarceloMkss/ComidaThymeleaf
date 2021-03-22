package com.mkss.infotek.proyectofinal.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mkss.infotek.proyectofinal.entity.Categoria;
import com.mkss.infotek.proyectofinal.entity.Conectar;
import com.mkss.infotek.proyectofinal.entity.Plato;
import com.mkss.infotek.proyectofinal.entity.Procedencia;
import com.mkss.infotek.proyectofinal.service.ICategoriaService;
import com.mkss.infotek.proyectofinal.service.IPlatoService;
import com.mkss.infotek.proyectofinal.service.IProcedenciaService;

import lombok.extern.java.Log;


/**
 * Representa el Controlador que llamara las vistas correspondientes
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Log
@Controller
@RequestMapping("/views/platos")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class PlatoControllerNuevo { // extends HttpServlet

	@Autowired
	private IPlatoService platoService;

	@Autowired
	private ICategoriaService categoriaService;

	@Autowired
	private IProcedenciaService procedenciaService;
	
	private static final String UPLOAD_DIRECTORY = "pruebaDirectorio";

	
	/**
	 * 
	 * @param model nos da acceso al metodo addAttribute que nos permite enviar
	 *              informacion al formulario
	 * @return retorna el listado de todos los platos en el formulario listar
	 */
	@GetMapping("/")
	public String listarPlatos(Model model) { // doGet

		List<Plato> listadoPlatos = platoService.listarTodos();

		model.addAttribute("titulo", "Listado de Platos");
		model.addAttribute("platos", listadoPlatos);
		log.info(listadoPlatos.toString());

		return "/views/platos/listar";
	}

	/**
	 * enviamos informacion al formulario
	 * 
	 * @param model nos da acceso al metodo addAttribute que nos permite enviar
	 *              informacion al formulario
	 * @return retorna el formulario para crear una nueva receta
	 */
	@GetMapping("/create")
	public String crear(Model model) {

		/**
		 * paso el constructor vacio para que el usuario pueda rellenar en el formulario
		 */
		Plato plato = new Plato();

		List<Categoria> listCategorias = categoriaService.listaCategorias();
		List<Procedencia> listProcedencias = procedenciaService.listaProcedencias();

		model.addAttribute("titulo", "Formulario: Nueva Receta");
		model.addAttribute("platos", plato);
		model.addAttribute("categorias", listCategorias);
		model.addAttribute("procedencias", listProcedencias);
		log.info(listCategorias.toString());

		return "/views/platos/crear";

	}

	/**
	 * 
	 * @param plato donde guardaremos el plato
	 * @return redirecciona a la lista de los platos
	 */
	@PostMapping("/save")
	public String guardar(@ModelAttribute Plato plato) {

		platoService.guardar(plato);
		System.out.println("Plato guardado con exito");
		log.info(plato.toString());

		return "redirect:/views/platos/";

	}

	/**
	 * Metodo para editar un plato
	 * 
	 * @param idPlato se enlaza con el parametro {id} que viene de la vista
	 * @param model   nos da acceso al metodo addAttribute que nos permite enviar
	 *                informacion al formulario
	 * @return retorna el formulario para crear una nueva receta, ademas vienen con
	 *         los select categorias y procedencias rellenados desde la base de
	 *         datos mysql.
	 */
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idPlato, Model model) {

		/**
		 * paso el constructor vacio para que el usuario pueda rellenar en el formulario
		 */
		Plato plato = platoService.buscarPorId(idPlato);

		List<Categoria> listCategorias = categoriaService.listaCategorias();
		List<Procedencia> listProcedencias = procedenciaService.listaProcedencias();

		model.addAttribute("titulo", "Formulario: Editar Plato");
		model.addAttribute("platos", plato);
		model.addAttribute("categorias", listCategorias);
		model.addAttribute("procedencias", listProcedencias);

		return "/views/platos/crear";

	}

	
	/**
	 * Metodo para Eliminar un plato
	 * @param idPlato id se enlaza con el parametro {id} que viene de la vista
	 * @return redirecciona a la lista de los platos ya atualizada sin el dato que hemos borrado
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idPlato) {

		platoService.eliminar(idPlato);
		System.out.println("Registro eliminado correctamente");

		return "redirect:/views/platos/";

	}

	
	/**
	 * Metodo para la llamada de formulario restauracion
	 * @return retorna el formulario de restauracion	 * 
	 */
	@GetMapping("/restaurar")
	public String Upload(Model model) {
		
		model.addAttribute("titulo", "Formulario: Restaurar Base de Datos");

		return "/views/platos/restauracion";

	}

	

	/**
	 * 
	 * @param request me da acceso al directorio del archivo
	 * @return retorna a la vista de listar platos
	 * @throws ServletException gestion de errores
	 * @throws IOException gestion de errores
	 */
	@PostMapping("/upload")	
	public String guardarBD(HttpServletRequest request) throws ServletException, IOException{
		
		
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		String fichero = null;

		try {
			for (Part part : request.getParts()) {
				fichero = part.getSubmittedFileName();

				log.info("Nombre de fichero: [" + fichero + "]");

				if (fichero != null && fichero.trim().length() > 0) {
					log.info("Nombre de fichero ACEPTADO: [" + fichero + "]");
					part.write(uploadPath + File.separator + fichero);
						log.info(uploadPath);
					
				}
			}
		} catch (IOException | ServletException e) {
			
			e.printStackTrace();
		}
		
		
		String backup = "";
		
		
		backup = "cmd /c mysql  -u" + Conectar.getUser() + " -p" + Conectar.getPass() + " < " + uploadPath + File.separator + fichero;
		
		Process proceso = Runtime.getRuntime().exec(backup);
		log.info(backup);
		int processComplete = 0;

		try {

			processComplete = proceso.waitFor();

		} catch (InterruptedException e) {

			log.info("proceso completado");
		}

		if (processComplete == 0) {
			log.info("proceso correcto");
		} else {
			log.info("ha habido un error");
		}
		

		return "redirect:/views/platos/";

	}
}
