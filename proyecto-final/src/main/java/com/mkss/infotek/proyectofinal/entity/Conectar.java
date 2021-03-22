/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkss.infotek.proyectofinal.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;


/**
 * Representa la coneccion con la base de datos para
 * hacer la restauracion de la base de datos
 * @version 1.0
 * @author Marcelo Kleibson
 *
 */
public class Conectar {

	private static String user = "root";
	private static String pass = "root";
	private static String bd = "comidadb";
	private static String url = "jdbc:mysql://localhost:3306/" + bd;

	public static String getUser() {
		return user;
	}

	public static String getPass() {
		return pass;
	}

	public static String getBd() {
		return bd;
	}

	private Connection con = null;

	
	/**
	 * conecta con la base de datos
	 */
	public Conectar() {
		Statement s;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			s =  con.createStatement();
			
			//mostra las bases de datos
			s.executeUpdate("show databases");
			
			

			if (con != null) {
				System.out.println("Conexion en Linea");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

	/**
	 * 
	 * @return la coneccion
	 */
	public Connection getConectar() {
		return con;
	}

	
	/**
	 * desconecta la coneccion
	 */
	public void desconectar() {
		con = null;
	}

	/**
	 * 
	 * @param args pasamos los argumentos
	 */
	public static void main(String[] args) {
		Conectar c = new Conectar();
		c.getConectar();
	}

}
