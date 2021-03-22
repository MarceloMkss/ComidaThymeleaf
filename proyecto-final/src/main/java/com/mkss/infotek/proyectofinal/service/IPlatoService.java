package com.mkss.infotek.proyectofinal.service;

import java.util.List;

import com.mkss.infotek.proyectofinal.entity.Plato;

/**
 * Representa la interface donde tendremos los metodos para el  Crud de Plato
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
public interface IPlatoService {
	
	/**
	 * Metodo para listar
	 * @return retorna una lista de platos
	 */
	public List<Plato> listarTodos();
	
	/**
	 * Metodo para guardar un plato
	 * @param plato
	 */
	public void guardar(Plato plato);
	
	/**
	 * Metodo para buscar un plato por su Id
	 * @param id donde recibimos la buesqueda del plato
	 * @return retorna la id del plato
	 */
	public Plato buscarPorId(Long id);
	
	/**
	 * Metodo para eliminar un registro
	 * @param id donde recibimos la id a ser eliminada
	 */
	public void eliminar(Long id);
	

}
