package com.escolhacerta.managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.servlet.http.Part;

import com.escolhacerta.control.Produto;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.model.ProdutoDAO;
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
	
	//https://www.devmedia.com.br/armazenando-imagens-no-mysql/32104
	
	
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

	public int getIdUsuario(String email){
		//acessa UsuarioDAO e verifica id para o email
		int idUser = 0;
		
		//idUser = UsuarioDAO.getIdUser(email);
		
		return idUser;
	}
	
	public int getIdProduto(String produto){
		//acessa UsuarioDAO e verifica id para o email
		int idProduto = 0;
		
		//idProduto = UsuarioDAO.getIdProduto(produto);
		
		return idProduto;
	}
	
	public int getIdCategoria(String categoria){
		//acessa UsuarioDAO e verifica id para o email
		int idCategoria = 0;
		
		//idCategoria = UsuarioDAO.getIdCategoria(email);
		
		return idCategoria;
	}
}
