package com.escolhacerta.managedBeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.model.UsuarioDAO;
import com.escolhacerta.util.FacesUtil;
import com.escolhacerta.util.SessionUtil;

import sun.security.action.GetLongAction;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = 269534515641225657L;
	static Usuario usuario;
	private String email = "";
	private String senha = "";
	//private List<Usuario> listUser;
	private UsuarioDAO u = new UsuarioDAO();
	private Connection conn;
	private SessionUtil session;
	private boolean log = false;
	
	//https://www.devmedia.com.br/jsf-session-criando-um-modulo-de-login/30975
	public String autentica(){
		//listUser = u.loginUsuario();
		String url="";
		boolean teste = u.loginUsuario(email, senha); 
		try{
			if(teste == true){
				LoginManagedBean.usuario = new Usuario();
				this.log = true;
				this.setUsuario(email);
				
				SessionUtil.getSession();
				SessionUtil.setParam("usuario", this.getUsuario().getNome());
				//FacesContext context = FacesContext.getCurrentInstance();
				url = "/restricted/areadousuario.xhtml?faces-redirect=true";
				
			}
			
			return url;
		}catch(Exception e){
			FacesUtil.failure("Erro ao logar!");
			throw new RuntimeException("Erro ao logar: ", e);
		} 
		
	}
	
	public String logout (){
		SessionUtil.invalidate();
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		LoginManagedBean.usuario = null;
		this.log = false;
		return "/index.xhtml?faces-redirect=true";
	}
	
	public void incluiUsuario() {
		if(usuario != null){
			//trocar adiciona para atualiza
			//criar botão para remoção
			u.adiciona(usuario);
		
			FacesUtil.success("Parabéns, você está cadastrado!");
			//usuario = new Usuario();
		} else {
			FacesUtil.failure("Erro ao cadastrar!");
			//usuario = new Usuario();
		}
	}
	
	/** Recebe usuário atualizado e, caso não nulo, exclui do banco de dados **/
	public void excluiUsuario(){
		if(usuario != null){
			//trocar adiciona para atualiza
			//criar botão para remoção
			u.exclui(usuario);
		
			FacesUtil.success("Usuário excluídos com sucesso!");
			//usuario = new Usuario();
		} else {
			FacesUtil.failure("Erro ao excluir!");
			//usuario = new Usuario();
		}
	}
	
	/** Recebe usuário atualizado e, caso não nulo, atualiza no banco de dados **/
	public void atualizaUsuario(){
		if(usuario != null){
			//trocar adiciona para atualiza
			//criar botão para remoção
			u.atualiza(usuario);
		
			FacesUtil.success("Dados atualizados com sucesso");
			//usuario = new Usuario();
		} else {
			FacesUtil.failure("Erro ao atualizar!");
			//usuario = new Usuario();
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String email) {
		LoginManagedBean.usuario = u.getLoggedUser(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean getLog(){
		return this.log;
	}
	
	
	//descobrir como acessar dados da sessão no JSF
	public SessionUtil getSession() {
		return session;
	}
}
