package com.mkss.infotek.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkss.infotek.proyectofinal.entity.Plato;
import com.mkss.infotek.proyectofinal.repository.PlatoRepository;


/**
 * Representa la clase de Servicio donde implementaremos los metodos de la interface IPlatoService.
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Service
public class IPlatoServiceImpl implements IPlatoService {

	@Autowired
	private PlatoRepository PlatoRepository;
	
	
	/**
	 * Metodo para listar todo los platos
	 */
	@Override
	public List<Plato> listarTodos() {

		return (List<Plato>) PlatoRepository.findAll();
	}

	
	/**
	 * Metodo para inserta un plato en la base de datos
	 */
	@Override
	public void guardar(Plato plato) {
		
		PlatoRepository.save(plato);


	}

	/**
	 * Metodo par buscar un plato por su Id
	 */
	@Override
	public Plato buscarPorId(Long id) {

		return PlatoRepository.findById(id).orElse(null);
	}

	
	/**
	 * Metodo para Eliminar un Registro
	 */
	@Override
	public void eliminar(Long id) {
		
		PlatoRepository.deleteById(id);


	}

}
