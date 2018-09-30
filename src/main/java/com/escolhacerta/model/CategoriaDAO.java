package com.escolhacerta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.escolhacerta.control.Categoria;

public class CategoriaDAO {
	private Connection conn;
	//private String categorias;
	private List<String> categorias = new ArrayList<String>();
	private Categoria c = new Categoria();
	
	public void listarCategoria() throws SQLException{
		String ctg = "SELECT * FROM categoria;";
			PreparedStatement ps = conn.prepareStatement(ctg);
			//Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
			//Pelo fato de gerar uma lista de valores, é necessário percorrer os dados através do laço while
			ResultSet rs = ps.executeQuery();
			//Faz a verificação enquanto houverem registros, percorre e resgata os valores
			while(rs.next()){
				c.setCategoria(rs.getObject("nmCategoria").toString());
				//categorias.add(rs.getObject("nmCategoria").toString());
			}
			ps.execute();
			rs.close();
			ps.close();
	}
	
	public List<String> getCategorias(){
		return categorias;
	}
	
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
