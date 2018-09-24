package com.escolhacerta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
			//ip/porta/nomedobanco	
			"jdbc:mysql://localhost:3306/escolhacertaBD?useTimezone=true&serverTimezone=UTC" 
			,"root"
			,"root"		
		);
	}
	
	//abre uma conex�o no formato de sess�o do Hibernate
	/*public static Session getSession(){
		return sessionFactory.openSession();
	}*/
		
	//fecha a conex�o
	/*public static void closeSession(){
		sessionFactory.close();
	}*/
}

	
