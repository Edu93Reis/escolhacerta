package com.escolhacerta.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("escolhaCerta");
	//sess�o = conex�o no hibernate
	//configura f�brica de sess�es do Hibernate 
	//para persist�ncia de dados 
	private static final SessionFactory sessionFactory;
	
	static {
		
		//representa configura��o do Hibernate
		try{
			//representa configura��o do Hibernate
			Configuration config = new Configuration();
			//l� as configura��es do hibernate.cfg.xml
			config.configure();
			
			//aplica as configura��es passadas no hibernate.cfg.xml
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(config.getProperties()).getBootstrapServiceRegistry();
			
			//atribui uma fabrica de sess�es � vari�vel
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}catch(Throwable er){
			System.err.println("Erro na criação SessionFactory" + er);
			throw new ExceptionInInitializerError(er);
		}
	}
	
	//abre uma conex�o no formato de sess�o do Hibernate
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//fecha a conex�o
	public static void closeSession(){
		sessionFactory.close();
	}
}
