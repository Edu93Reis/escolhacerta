package com.escolhacerta.managedBeans;

import java.io.Serializable;
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
	private UsuarioDAO u;
	
	public String autentica(){
		try{
			if(email.equals("edu") && senha.equals("123")){
				usuario = new Usuario();
				
				usuario.setNome("Edu");
				usuario.setEmail("Edu");
				usuario.setSenha("123");
				
				return "/restricted/areadousuario.xhtml?faces-redirect=true";
				//return "/areadousuario.xhtml?faces-redirect=true";
			}
			FacesContext context = FacesContext.getCurrentInstance();
			if(!(email.equals("edu"))){
				FacesUtil.failure("Email incorreto!");
			}else if(!(senha.equals("123"))){
				FacesUtil.failure("Senha incorreta!");
			}
			
			return null;
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
