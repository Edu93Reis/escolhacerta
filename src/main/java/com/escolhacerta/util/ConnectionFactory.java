package com.escolhacerta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
	public Connection getConnection() {
		try{
			// o erro está aqui. (classnotfound, causa um nullpointerexception
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
				//ip/porta/nomedobanco
				//"jdbc:mysql://localhost:3306/escolhacertaBD?useTimezone=true&serverTimezone=UTC"	
				"jdbc:mysql://localhost:3306/escolhacertaBD?useTimezone=true&serverTimezone=UTC" 
				,"root"
				,"root"		
			);
		} catch(SQLException excecao) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, excecao);
			throw new RuntimeException("Erro ao abrir conexão!", excecao);
		} catch(ClassNotFoundException nf) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, nf);
			throw new RuntimeException("Driver não encontrado!", nf);
		}
	}
}

	
