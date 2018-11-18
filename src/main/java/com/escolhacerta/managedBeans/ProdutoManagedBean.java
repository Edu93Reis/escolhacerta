package com.escolhacerta.managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.util.FacesUtil;

//import org.hibernate.Session;
//import org.hibernate.criterion.Order;

import com.escolhacerta.control.Produto;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.model.CategoriaDAO;
import com.escolhacerta.model.ProdutoDAO;


@SuppressWarnings("deprecation")
@ManagedBean(name = "produtoManagedBean")
@ViewScoped
public class ProdutoManagedBean {
	//salva a listagem de produtos do banco de dados
	//dentro do Arraylist para futura listagem
	private List<Produto> produtos;
	private CategoriaDAO cd;
	//private List<String> listaCategoria = new ArrayList<String>();
	//@ManagedProperty(value = "#{categorias}")
	private List<String> categorias;
	private List<String> fstcategorias = new ArrayList<String>();
	private List<String> sndcategorias = new ArrayList<String>();
	private List<Integer> avaliacoes = new ArrayList<Integer>();
	private List<BigDecimal> precos = new ArrayList<BigDecimal>();
	private List<Produto> fstProdutos = new ArrayList<Produto>();
	private List<Produto> lstProdutos = new ArrayList<Produto>();
	private BigDecimal mediaPrecos = new BigDecimal("0.0");
	private int mediaPontuacao = 0;
	private Categoria categoria;
	//vindos de cadastroMB
	private Usuario usuario = new Usuario();
	private ProdutoDAO produtoDAO;
	private Produto produto;
	private Integer idProduto;
	private String nomeProduto;
	private Part imagemProduto;
	private static int codProduto = 1;
	private int point = 0;
	private HtmlCommandLink star;
	
	
	//construtor
	public ProdutoManagedBean(){
		this.produtos = new ArrayList<Produto>();
		this.categorias = new ArrayList<String>();
		this.categoria = new Categoria();
		this.produtoDAO = new ProdutoDAO();
		cd = new CategoriaDAO();
	}
	
	/*@PostConstruct
	public void inicializar(){
		new CategoriaDAO();
		//new Categoria();
	}*/
	
	//retorna lista com o nome de todas as categorias armazenadas no Banco de Dados
	public List<String> getCategorias() throws SQLException {
		//List<String> listaCategoria = cd.listarCategoria();

		/*for(String categoria : cd.listarCategoria()){
			listaCategoria.add(categoria);
		}*/		
			
		//return listaCategoria;
		try{
			this.categorias = cd.listarCategoria();
			return categorias;
		} catch(Exception ex){
			FacesUtil.failure("Erro ao listar: " + ex);
			return categorias;
		}
		
	}
	
	//retorna lista com o nome das 8 primeiras categorias armazenadas no Banco de Dados
	public List<String> getFstCategories() throws SQLException {
		List<String> listaCategoria = null;

		try{
			this.fstcategorias = cd.listarFstCategorias();			
			
			return fstcategorias;
		} catch(Exception ex){
			FacesUtil.failure("Erro ao listar: " + ex);
			return null;
		}
	}
	
	//retorna lista com o nome das 11 últimas categorias armazenadas no Banco de Dados
	public List<String> getSndCategories() throws SQLException {
		try{
			
			this.sndcategorias = cd.listarSndCategories();
			
			return sndcategorias;
		}catch(Exception ex){
			FacesUtil.failure("Erro ao listar: " + ex);
			return null;
		}
	}
	
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
		//point = valor recebido das estrelas 
		
		if(usuario != null){
			produto.setIdCategoria(idCategoria);
			produto.setPontuacao(point);
			produtoDAO.adiciona(produto);
		
			FacesUtil.success("Produto cadastrado com sucesso");
		} else {
			FacesUtil.failure("Erro ao cadastrar produto!");
		}
	}
	
	
	//recebe todas as pontuações de um produtoModelo e retorna sua média (médias são calculadas por modelo do produto)
	public Integer getMediaPontuacao(){
		try{
			//this.avaliacoes = produtoDAO.getPontuacao("Teste");
			this.avaliacoes.addAll(produtoDAO.getPontuacao("Teste")) ;
			
			for(Integer num: this.avaliacoes){
				mediaPontuacao += num;
			}
		
			//mediaPontuacao = Math.round(mediaPontuacao/this.avaliacoes.size());
			//pontuacao perdendo precisao
			return mediaPontuacao/this.avaliacoes.size();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return 0;
		}
	}
	
	public BigDecimal getMediaPrecos(){
		try{
			//getPrecos() recebe nomeDoProduto 
			//this.precos = produtoDAO.getPrecos("Teste"); 
			this.precos.addAll(produtoDAO.getPrecos("Teste"));
			
			for(BigDecimal preco: this.precos){
				//mediaPrecos.add(valor) nao funciona, é preciso usar atribuição
				mediaPrecos = mediaPrecos.add(preco);
			}
			
			mediaPrecos = mediaPrecos.divide(new BigDecimal(String.valueOf(this.precos.size())), 2, RoundingMode.HALF_EVEN);
			//pontuacao perdendo precisao
			
			return mediaPrecos;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return null;
		}
	}

	
	public List<Produto> getFstProduto(){
		//lista que recebe todos os produtos cadastrados de uma categoria
		//List<Produto> fstProdutosCategoria = getProdutos(nmCategoria);
		
		//aqui vai a lógica da árvore de decisão para o reposicionamento
		
		//fstProdutos.add(deve receber os produto da outra lista reposicionados);
		return fstProdutos;
	}
	
	public List<Produto> getWstProduto(){
		//lista que recebe todos os produtos cadastrados de uma categoria
		//List<Produto> lstProdutosCategoria = getProdutos(nmCategoria);
		
		//aqui vai a lógica da árvore de decisão para o reposicionamento
		
		//lstProdutos.add(deve receber os produto da outra lista reposicionados);
		
		return lstProdutos;
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
	
	public Categoria getCategoria(){
		return this.categoria;
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
	
	public HtmlCommandLink getStar() {
		return star;
	}

	public void setStar(HtmlCommandLink star) {
		this.star = star;
	}
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
