package com.mkss.infotek.proyectofinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkss.infotek.proyectofinal.entity.Plato;


/**
 * Representa la interface donde irá los metodos del CRUD de mi aplicacion.
 * 
 * @version 1.0
 * @author Marcelo Kleibson *
 * 
 */
@Repository
public interface PlatoRepository extends CrudRepository<Plato, Long> {

}
