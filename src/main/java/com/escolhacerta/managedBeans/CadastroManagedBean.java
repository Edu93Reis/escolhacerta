package com.escolhacerta.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.model.UsuarioDAO;

@SuppressWarnings("deprecation")
@ManagedBean(name = "cadastroManagedBean")
@ViewScoped
public class CadastroManagedBean implements Serializable {
	//instância do DAO (Classe de persistência de Dados do usuário para ser manipulada pelo ManagedBean)
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	//instância da classe de Usuário
	private Usuario usuario = new Usuario();
	private List<String> estados = new ArrayList<String>(){
		{
		 add("Acre"); add("Alagoas"); add("Amapá"); add("Amazonas"); add("Bahia");
		 add("Ceará"); add("Distrito Federal"); add("Espírito Santo"); add("Goiás"); add("Maranhão");
		 add("Mato Grosso"); add("Mato Grosso do Sul"); add("Minas Gerais"); add("Pará"); add("Paraíba");
		 add("Paraná"); add("Pernambuco"); add("Piauí"); add("Rio de Janeiro"); add("Rio Grande do Norte");
		 add("Rio Grande do Sul"); add("Rondônia"); add("Roraima"); add("Santa Catarina");
		 add("São Paulo"); add("Sergipe"); add("Tocantins");
		 }
	};
	
	public void incluiUsuario(){
		usuarioDAO.adiciona(usuario);
		
		String msg = "Parabéns, você está cadastrado!";
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
