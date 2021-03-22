package com.mkss.infotek.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkss.infotek.proyectofinal.entity.Categoria;
import com.mkss.infotek.proyectofinal.repository.CategoriaRepository;


/**
 * Representa la clase de Servicio donde implementaremos los metodos de la interface ICategoriaService.
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> listaCategorias() {

		return (List<Categoria>) categoriaRepository.findAll();
	}

}
