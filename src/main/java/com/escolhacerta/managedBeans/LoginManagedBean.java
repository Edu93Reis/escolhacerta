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

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = 269534515641225657L;
	private static Usuario usuario;
	private String email;
	private String senha;
	//private List<Usuario> listUser;
	private UsuarioDAO u;
	private Connection conn;
	public static boolean log = false;
	
	//https://www.devmedia.com.br/jsf-session-criando-um-modulo-de-login/30975
	public String autentica(){
		//listUser = u.loginUsuario();
		String url="";
		boolean teste = u.loginUsuario(email, senha); 
		try{
			//if(email.equalsIgnoreCase("edu") && senha.equalsIgnoreCase("123")){
			if(teste == true){
				usuario = new Usuario();
				
				//usuario = u.getLoggedUser(email);
				
				//return "/restricted/areadousuario.xhtml?faces-redirect=true";
				url = "/restricted/areadousuario.xhtml?faces-redirect=true";
			}
			FacesContext context = FacesContext.getCurrentInstance();
			//if(!(email.equals("Edu"))){
			/*if(!(email.equals())){
				FacesUtil.failure("Email incorreto!");
			}else if(!(senha.equals("123"))){
				FacesUtil.failure("Senha incorreta!");
			}*/
			
			return url;
		}catch(Exception e){
			throw new RuntimeException("Erro ao logar: ", e);
		}
	}
	
	public String logout (){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		usuario = null;
		return "/login.xhtml?faces-redirect=true";
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
	
}
