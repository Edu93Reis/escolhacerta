package com.escolhacerta.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.hibernate.Session;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.util.HibernateUtil;

public class CategoriaDAO {
	Session session = HibernateUtil.getSession();
	
	//public Categoria getCategoria(String nmCategoria) {
		/*
		 EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("PU");
     	 em = emf.createEntityManager();
     	 em.getTransaction().begin();
     	 em.persist(new Pessoa("NOMEQUALQUER"));
     	 em.getTransaction().commit();
		
		*/
		
		/*try {
			//createQuery cria uma lista de objetos
			em.getTransaction().begin();
			Categoria cat = (Categoria) em
					.createQuery(
							"SELECT c from Categoria c where c.nmCategoria = :nmCategoria")
							.setParameter("nmCategoria", nmCategoria).getSingleResult();			
			return cat;			
		} catch (NoResultException ex) {
			em.getTransaction().rollback();
			return null;
		} */
	//}
	
	/* public boolean inserirCategoria(Categoria categoria) {
		try {
			//cria insert para os dados recebidos
			em.getTransaction().begin();
			em.persist(categoria);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			return false;
		}
	}
	
	 public boolean atualizaCategoria(Categoria categoria) {
		try {
			//cria insert para os dados recebidos
			em.getTransaction().begin();
			em.refresh(categoria);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deletaCategoria(Categoria categoria) {
		try {
			//cria delete para os dados recebidos
			em.getTransaction().begin();
			em.remove(categoria);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	} */

}
