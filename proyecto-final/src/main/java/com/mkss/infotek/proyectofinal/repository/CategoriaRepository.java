package com.mkss.infotek.proyectofinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkss.infotek.proyectofinal.entity.Categoria;


/**
 * Representa el acceso a datos, donde nos permitira coger los datos que hay en la base de datos de Categoria
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
