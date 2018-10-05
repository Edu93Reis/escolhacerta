package com.escolhacerta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try{
			return DriverManager.getConnection(
				//ip/porta/nomedobanco	
				"jdbc:mysql://localhost:3306/escolhacertaBD?useTimezone=true&serverTimezone=UTC" 
				,"root"
				,"root"		
			);
		} catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		}
	}
}

	
