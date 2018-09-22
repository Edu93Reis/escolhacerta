package com.escolhacerta.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.control.Usuario;



public class UsuarioDAO {
	private EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("usuarios");
	private EntityManager em = factory.createEntityManager();
	
/* inserir usuario, buscar um usuario, listar usuarios, remover usuario, alterar dados usuario */
	public Usuario getUsuario(String emailUsuario, String senha) {
		try {
			//createQuery cria uma lista de objetos
			Usuario usuario = (Usuario) em
					.createQuery(
							"SELECT u from Usuario u where u.emailUsuario = :email and u.senha = :senha")
							.setParameter("email", emailUsuario)
							.setParameter("senha", senha).getSingleResult();
			return usuario;
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	/*public boolean setUsuario(String emailUsuario, String nmUsuario, String idPassword, 
								Date dtNasc, String nmCidade, String nmEstado, String cdCep){
		Usuario user = (Usuario) em.setParameter("email", emailUsuario)
								   .setParameter("nome", nmUsuario)
		
		//salvar como integer devido ao id
		Integer newUser = session.save(user); 
		
	}*/
	
	public boolean inserirUsuario(Usuario usuario) {
		try {
			//cria o insert dos dados recebidos no select
			em.persist(usuario);
			return true;
		} catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean atualizaUsuario(Usuario usuario) {
		try {
			//cria insert para os dados recebidos
			em.refresh(usuario);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean deletaUsuario(Usuario usuario) {
		try {
			//cria delete para os dados recebidos
			em.remove(usuario);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
