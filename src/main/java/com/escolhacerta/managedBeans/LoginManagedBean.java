package com.escolhacerta.managedBeans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//view scope --> CDI
//import javax.faces.view.ViewScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.model.UsuarioDAO;

/* Managed Beans -- Classe que "une" todo o conte�do no JSF
 fazendo o link coms as regra de neg�cio e, desta forma, delegando fun��es a camada de view */

/* nome pelo qual ser� feita a chamada de dados na camada de view (HTML)
   ao usar o binding --> #{loginManagedBean} */
@SuppressWarnings("deprecation")
@ManagedBean(name = "loginManagedBean")
@Named
@ViewScoped
public class LoginManagedBean{
	//inst�ncia do DAO (Classe de persist�ncia de Dados do usu�rio para ser manipulada pelo ManagedBean)
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	//inst�ncia da classe de Usu�rio
	private Usuario usuario = new Usuario();
	
	/*Caso o dado recebido no input esteja avisa que o usu�rio n�o foi encontrado e n�o efetua login
	 * caso contr�rio, encaminha para index */
	public String envia() {
		if (usuario == null) {
			usuario = new Usuario();
			//valida��o para o login do usu�rio
			//FacesContext executa controle das requisi��es JSF
			//getCurrentInstance devolve a inst�ncia da requisi��o atual
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Uus�rio n�o encontrado",
							"Erro no Login!"));
			return null;
		} else {
			return "/main";
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
