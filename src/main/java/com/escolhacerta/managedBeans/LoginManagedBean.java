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

import sun.security.action.GetLongAction;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = 269534515641225657L;
	private static Usuario usuario;
	private String email = "";
	private String senha = "";
	//private List<Usuario> listUser;
	private UsuarioDAO u = new UsuarioDAO();
	private Connection conn;
	private boolean log = false;
	
	//https://www.devmedia.com.br/jsf-session-criando-um-modulo-de-login/30975
	public String autentica(){
		//listUser = u.loginUsuario();
		String url="";
		boolean teste = u.loginUsuario(email, senha); 
		try{
			//if(email.equalsIgnoreCase("edu") && senha.equalsIgnoreCase("123")){
			if(teste == true){
				this.usuario = new Usuario();
				this.log = true;
				//usuario = u.getLoggedUser(email);
				
				//return "/restricted/areadousuario.xhtml?faces-redirect=true";
				FacesContext context = FacesContext.getCurrentInstance();
				url = "/restricted/areadousuario.xhtml?faces-redirect=true";
			}
			
			return url;
		}catch(Exception e){
			FacesUtil.failure("Erro ao logar!");
			throw new RuntimeException("Erro ao logar: ", e);
		}
	}
	
	public String logout (){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		this.usuario = null;
		this.log = false;
		return "/index.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
}
