package com.mkss.infotek.proyectofinal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkss.infotek.proyectofinal.entity.Procedencia;


/**
 * Representa el acceso a datos, donde nos permitira coger los datos que hay en la base de datos de procedencia
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Repository
public interface ProcedenciaRepository extends CrudRepository<Procedencia, Long> {

}
