package com.escolhacerta.managedBeans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.model.CategoriaDAO;
import com.escolhacerta.util.HibernateUtil;


@SuppressWarnings("deprecation")
@ManagedBean(name = "categoriaManagedBean")
@Named
@ViewScoped
public class CategoriaManagedBean {
	/*
	 * EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-pu");
	 * */
	
	//inst�ncia do DAO (Classe de persist�ncia de Dados do usu�rio para ser manipulada pelo ManagedBean)
		private CategoriaDAO categoriaDAO = new CategoriaDAO();
		//inst�ncia da classe de Usu�rio
		private Categoria categoria = new Categoria();
		
		//
		@PostConstruct
		public void init(){
			Session session = HibernateUtil.getSession();
			
			session.createCriteria(Categoria.class)
				.addOrder(Order.asc("idCategoria"))
				.list();
			
			session.close();
		}
		
		/*Caso o dado recebido no input esteja avisa que o usu�rio n�o foi encontrado e n�o efetua login
		 * caso contr�rio, encaminha para index */
		public String envia() {
			if (categoria == null) {
				categoria = new Categoria();
				//valida��o para o login do usu�rio
				//FacesContext executa controle das requisi��es JSF
				//getCurrentInstance devolve a inst�ncia da requisi��o atual
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Categoria inexistente",
								"Erro!"));
				return null;
			} else {
				return "/main";
			}
		}
		
		public Categoria getCategoria() {
			return categoria;
		}
		
		public void setCategoria(Categoria Categoria) {
			this.categoria = categoria;
		}
}
