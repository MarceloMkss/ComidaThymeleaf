package com.mkss.infotek.proyectofinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mkss.infotek.proyectofinal.service.IPlatoService;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
@ComponentScan
public class ProyectoFinalApplication implements CommandLineRunner{
	
	
	
	@Autowired
	private IPlatoService platoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		log.info(platoService.listarTodos().toString());
		
	}

}
