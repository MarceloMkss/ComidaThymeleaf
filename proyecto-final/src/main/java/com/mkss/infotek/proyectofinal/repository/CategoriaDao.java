package com.mkss.infotek.proyectofinal.repository;

import com.mkss.infotek.proyectofinal.entity.Categoria;

/**
 * Representa la interface donde irá los metodos del CRUD de mi aplicacion.
 * 
 * @version 1.0
 * @author Marcelo Kleibson *
 * 
 */
public interface CategoriaDao {

	 Iterable<Categoria> listarCategorias(); 
	

}
