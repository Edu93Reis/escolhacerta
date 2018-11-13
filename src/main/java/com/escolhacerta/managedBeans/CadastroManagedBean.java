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
	private ProdutoDAO produtoDAO;
	//private UsuarioDAO usuarioDAO = new UsuarioDAO();
	//instância da classe de Usuário
	//private Usuario usuario = new Usuario();
	private Usuario usuario;
	private Produto produto;
	private Integer idProduto;
	private String nomeProduto;
	private Part imagemProduto;
	private List<String> estados;
	private List<Usuario> debuga;
	private static int codProduto = 1;
	private static int point = 0;
	private HtmlCommandLink star;
	
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
	
	//https://www.devmedia.com.br/armazenando-imagens-no-mysql/32104
	public void incluiProduto() {
		String imagemURL = "/resources/img/produtos/";
		
		if(imagemProduto != null && imagemProduto.getSubmittedFileName() != null){ 
			//trocar nome para id
			//imagemURL = imagemURL + imagemProduto.getSubmittedFileName();
			String nmImgProduto = String.valueOf(codProduto);
			codProduto ++;
			imagemURL = imagemURL + imagemProduto + nmImgProduto;
			
			try{
				//cria espaço na memória para o conteúdo da imagem do tamanho da imagem
				byte[] bytesImagem = new byte[(int) imagemProduto.getSize()];
				//lê contéudo da imagem e insere no array de bytes
				imagemProduto.getInputStream().read(bytesImagem);
				//cria referência para o arquivo que será enviado
				File f = new File(imagemURL);
				
				//objeto recebe arquivo de referência para a manipulação
				FileOutputStream FOS = new FileOutputStream(f);
				//escreve o conteúdo da imagem recebida no arquivo (servidor)
				FOS.write(bytesImagem);
				FOS.close();
			}catch(Exception e){
				throw new RuntimeException("Erro upload de imagem: ", e);
			}
			
			/*File imagemProduto = new File("C:/imagem.jpg");
			BufferedImage img = ImageIO.read(imagemProduto);
			int height = img.getHeight();
			int width = img.getWidth();*/
		}
		
		int idCategoria = 0; 
		
		if(usuario != null){
			produto.setIdCategoria(idCategoria);
			produto.setPontuacao(point);
			produtoDAO.adiciona(produto);
		
			FacesUtil.success("Produto cadastrado com sucesso");
		} else {
			FacesUtil.failure("Erro ao cadastrar produto!");
		}
	}
	
	public void pontuation(){
		if(this.star.getId().equals("one")){
			this.star.setStyle("color: yellow;");
			point = 1;
		}if(this.star.getId().equals("two")){
			this.star.setStyle("color: yellow;");
			point = 2;
		}if(this.star.getId().equals("three")){
			this.star.setStyle("color: yellow;");
			point = 3;
		}if(this.star.getId().equals("four")){
			this.star.setStyle("color: yellow;");
			point = 4;
		}if(this.star.getId().equals("five")){
			this.star.setStyle("color: yellow;");
			point = 5;
		}	
		
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public HtmlCommandLink getStar() {
		return star;
	}

	public void setStar(HtmlCommandLink star) {
		this.star = star;
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
