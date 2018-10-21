package com.escolhacerta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
private Connection conn = null;
	public Connection getConnection() {
		// o erro está aqui. (classnotfound, causa um nullpointerexception
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			System.out.println("Erro ao instânciar Driver, driver possivelemente não encontrado!: "+ e);
		}
		
		try{
			return DriverManager.getConnection(
				//ip/porta/nomedobanco
				//"jdbc:mysql://localhost:3306/escolhacertaBD?useTimezone=true&serverTimezone=UTC"	
				"jdbc:mysql://localhost:3306/escolhacertaBD?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false" 
				,"root"
				,"root"		
			);
		} catch(SQLException excecao) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, excecao.getMessage());
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, excecao.getSQLState());
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, excecao.getErrorCode());
			throw new RuntimeException("Erro ao abrir conexão!", excecao);
		} /*catch(ClassNotFoundException nf) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, nf);
			throw new RuntimeException("Driver não encontrado!", nf);
		}*/
	}

	/*public Connection getConnection(){
	return conn;
}

public void ConnectionFactory(){
	try{
		// o erro está aqui. (classnotfound, causa um nullpointerexception
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(
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

public void closeConnection(){
	try{
		conn.close();
	}catch(Exception e){
		System.out.println("Erro ao fechar conexão: "+ e);
	}
} */
	
}

	
