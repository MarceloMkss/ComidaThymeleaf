package com.mkss.infotek.proyectofinal.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las clases que trabajaremos con la base de datos de platos
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
@Entity
@Table(name="platos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato implements Serializable{
	
	
	private static final long serialVersionUID = -5722314814039975749L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	
	@ManyToOne //(fetch = FetchType.EAGER)
	@JoinColumn(name ="categoria_id" )
	private Categoria categoria;
	
	@ManyToOne //(fetch = FetchType.EAGER)	
	@JoinColumn(name ="procedencia_id" )
	private Procedencia procedencia;

}