package com.escolhacerta.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.model.UsuarioDAO;
import com.escolhacerta.util.FacesUtil;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
//@ApplicationScoped
public class CadastroManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//instância do DAO (Classe de persistência de Dados do usuário para ser manipulada pelo ManagedBean)
	private UsuarioDAO usuarioDAO;
	//private UsuarioDAO usuarioDAO = new UsuarioDAO();
	//instância da classe de Usuário
	//private Usuario usuario = new Usuario();
	private Usuario usuario;
	private List<String> estados;
	private List<Usuario> debuga;
	
	@SuppressWarnings("serial")
	public CadastroManagedBean(){
		this.usuarioDAO = new UsuarioDAO();
		this.usuario = new Usuario();
		this.estados = new ArrayList<String>(){
			{
				 add("Acre"); add("Alagoas"); add("Amapá"); add("Amazonas"); add("Bahia");
				 add("Ceará"); add("Distrito Federal"); add("Espírito Santo"); add("Goiás"); add("Maranhão");
				 add("Mato Grosso"); add("Mato Grosso do Sul"); add("Minas Gerais"); add("Pará"); add("Paraíba");
				 add("Paraná"); add("Pernambuco"); add("Piauí"); add("Rio de Janeiro"); add("Rio Grande do Norte");
				 add("Rio Grande do Sul"); add("Rondônia"); add("Roraima"); add("Santa Catarina");
				 add("São Paulo"); add("Sergipe"); add("Tocantins");
				 }
		};
	}
	
	public void debugaUsuario(){
		if(usuario != null){
			debuga.add(usuario);
		
			FacesUtil.success("Parabéns, você está cadastrado!");
			//usuario = new Usuario();
		} else {
			FacesUtil.failure("Erro ao cadastrar!");
			usuario = new Usuario();
		}
	}
	
	public List<Usuario> getDebuga(){
		return this.debuga;
	}
	
	//@PostConstruct
	public void incluiUsuario() {
		if(usuario != null){
			usuarioDAO.adiciona(usuario);
		
			FacesUtil.success("Parabéns, você está cadastrado!");
			//usuario = new Usuario();
		} else {
			FacesUtil.failure("Erro ao cadastrar!");
			//usuario = new Usuario();
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setEstados(String estado) {
		if(estado.equals(null)) {
			System.out.println("Insira valor no campo estado!");
		}else{
			this.estados.add(estado);
		}
	}
	
	public List<String> getEstados(){
		return this.estados;
	}

}
