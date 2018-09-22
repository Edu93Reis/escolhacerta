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

/* Managed Beans -- Classe que "une" todo o conteúdo no JSF
 fazendo o link coms as regra de negócio e, desta forma, delegando funções a camada de view */

/* nome pelo qual será feita a chamada de dados na camada de view (HTML)
   ao usar o binding --> #{loginManagedBean} */
@SuppressWarnings("deprecation")
@ManagedBean(name = "loginManagedBean")
@Named
@ViewScoped
public class LoginManagedBean{
	//instância do DAO (Classe de persistência de Dados do usuário para ser manipulada pelo ManagedBean)
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	//instância da classe de Usuário
	private Usuario usuario = new Usuario();
	
	/*Caso o dado recebido no input esteja avisa que o usuário não foi encontrado e não efetua login
	 * caso contrário, encaminha para index */
	public String envia() {
		if (usuario == null) {
			usuario = new Usuario();
			//validação para o login do usuário
			//FacesContext executa controle das requisições JSF
			//getCurrentInstance devolve a instância da requisição atual
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Uusário não encontrado",
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
