package com.mkss.infotek.proyectofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkss.infotek.proyectofinal.entity.Procedencia;
import com.mkss.infotek.proyectofinal.repository.ProcedenciaRepository;


/**
 * Representa la clase de Servicio donde implementaremos los metodos de la interface IProcedenciaService.
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Service
public class ProcedenciaServiceImpl implements IProcedenciaService{

	@Autowired
	private ProcedenciaRepository procedenciaRepository;
	
	
	/**
	 * Metodo que devuelve una lista de Procedencias
	 */
	@Override
	public List<Procedencia> listaProcedencias() {
		
		return (List<Procedencia>) procedenciaRepository.findAll();
	}

}
