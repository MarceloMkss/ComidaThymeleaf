package com.mkss.infotek.proyectofinal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Representa las clases que trabajaremos con la base de datos de categoria
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Entity
@Table(name="categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria implements Serializable {

	private static final long serialVersionUID = 9064158250478071260L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	/*
	 * @ToString.Exclude
	 * 
	 * @EqualsAndHashCode.Exclude
	 * 
	 * @OneToMany(mappedBy = "categoria") //, fetch = FetchType.LAZY) private final
	 * Set<Plato> platos = new HashSet<>();
	 */
	
}
