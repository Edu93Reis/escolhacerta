package com.escolhacerta.managedBeans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.escolhacerta.control.Pesquisa;
import com.escolhacerta.control.Produto;
import com.escolhacerta.model.ProdutoDAO;

@SuppressWarnings("deprecation")
@ManagedBean(name = "modeloManagedBean")
@ViewScoped
public class ModeloManagedBean {
	private Pesquisa pesquisa;
	private Produto produto;
	private ProdutoDAO produtoDAO;
	private List<Produto> produtos;
	private List<Produto> produtosCategoria;
	private String categoria;
	private List<String> wstComments = new ArrayList<String>();
	private List<String> bstComments = new ArrayList<String>();
	private BigDecimal mediaPrecos;
	private List<BigDecimal> precos = new ArrayList<BigDecimal>();
	private int divAux = 0;
	
	public ModeloManagedBean(){
		this.pesquisa = new Pesquisa();
		this.produto = new Produto();
		this.produtoDAO = new ProdutoDAO();
		this.produtos = new ArrayList<Produto>();
		this.produtosCategoria = new ArrayList<Produto>();
		this.mediaPrecos = new BigDecimal("0.0");
		//this.divAux = produtoDAO.getPrecos("Celular Windows", "W-480").size();
		//this.sizeQuery = produtoDAO.listarProdutoCategoria(categoria).size();
		try{
			produtosCategoria.addAll(produtoDAO.listarProdutoCategoria(this.getIdentificador()));
			produtos.addAll(produtoDAO.listaProdutoQuery(this.getIdentificador()));
			this.produto = produtos.get(0);
			this.precos.addAll(produtoDAO.getPrecos(this.produto.getNmProduto(), this.produto.getModelo()));
			this.divAux = this.precos.size();
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
		
	public String getIdentificador(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
		String id = request.getParameter("q");
		
		return id;
	}
	
	public String getNome() {
		//int cd = Integer.valueOf(this.getIdentificador());
		int cd = 1;
		Produto p = new Produto();
		p.setNmProduto(produtoDAO.getNomeProduto(cd));
		
		String nome = p.getNmProduto();
		
		return nome;
	}
	
	/*** Retorna os dois comentários melhor pontuados de produto com nome semelhante e mesmo modelo ***/
	public List<String> getWstComments(){
		//acessa o primeiro item da lista produtos (o atual, só tem um neste acesso),
		//deste objeto retiram-se os nomes do modelo e produto para parâmetro do select
		String produto = produtos.get(0).getNmProduto();
		String modelo = produtos.get(0).getModelo();
		
		int cont = 1;
		produtoDAO = new ProdutoDAO();
		List<String> p = produtoDAO.getWstComments(produto, modelo);
		for(String prod : p){
			this.wstComments.add(prod);
			cont ++;
			if(cont>=2 || cont == p.size()){
				break;
			}
		}
		
		return this.wstComments;
	}

	/*** Retorna os dois comentários menor pontuados de produto com nome semelhante e mesmo modelo ***/
	public List<String> getBstComments(){
		//acessa o primeiro item da lista produtos (o atual, só tem um neste acesso),
		//deste objeto retiram-se os nomes do modelo e produto para parâmetro do select
		String produto = produtos.get(0).getNmProduto();
		String modelo = produtos.get(0).getModelo();
		int categoria = produtos.get(0).getIdCategoria();
		//String modelo = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modelo");
		int cont = 1;
		produtoDAO = new ProdutoDAO();
		
		List<String> p = produtoDAO.getBstComments(produto, modelo);
		//for(String prod : produtoDAO.getBstComments(produto, modelo)){
		for(String prod : p){
			this.bstComments.add(prod);
			cont ++;
			if(cont>=2 || cont == p.size()){
				break;
			}
		}
		
		//System.out.println(produto + " " + modelo + " " + categoria + " " + produtoDAO.getBstComments("Celular Windows", "W-480").size());
		
		return this.bstComments;
	}
	
	public int getMediaPrecos(){
		try{
			for(BigDecimal preco: this.precos){
				//aqui é feita a soma dos preços a média
				//mediaPrecos.add(valor) nao funciona, é preciso usar atribuição
				mediaPrecos = mediaPrecos.add(preco);
			}
			
			mediaPrecos = mediaPrecos.divide(new BigDecimal(String.valueOf(divAux)), 2, RoundingMode.HALF_EVEN);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		//consigo pegar tamanho da lista, basta achar como pegar o produto
		//mediaPrecos = new BigDecimal(String.valueOf(divAux));
		
		//return mediaPrecos;
		return divAux;
	}


	public List<Produto> getPesquisaString() throws SQLException {
		/*String query = this.getIdentificador();
		try{
			for(Produto p : produtoDAO.listaProdutoQuery(this.validaQuery(query))){
				produtos.add(p);
			}
			//PesquisaManagedBean.size = produtos.size();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}*/
		
		return produtos;
	}
	 
	
	public String validaQuery(String query){
		String[] nulos = {"á","é","í","ó","ú","´","ä","ë","ï","ö","ü","¨",
				"ã","õ","~","à","è","ì","ò","ù","`","^","â","ê","î","ô","û"};
		for(String n:nulos){
			query = query.toLowerCase().replaceAll(Pattern.quote(n), "_");
		}
		return query;
	}
	
	public List<Produto> getBstProdutos() throws SQLException{
		int idCategoria = 1;
		
		int i = 0;
		try{
			for(Produto p: produtoDAO.listarProdutoCategoria(idCategoria)){
				produtos.add(p);
				while(i<5){
					i++;
					if(i==4 || i == produtoDAO.listarProdutoCategoria(idCategoria).size())
					   break;
				}
			}
			
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		
		return produtos;
	}
	
	public List<Produto> getWstProdutos() throws SQLException {
		int idCategoria = 1;
		
		try{
			List<Produto> p = produtoDAO.listarProdutoCategoria(idCategoria);
			int i = p.size();
			int cont = 5;
			
			while(cont != 0){
				produtos.add(p.get(i--));
				if(cont == i){
					break;
				}
				cont--;
			}
			
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		
		return produtos;
	}
	
	public Pesquisa getPesquisa() {
		return pesquisa;
	}
	
	/** recebe dado setado para a query de pesquisa e retorna o path da página para onde será enviado **/
	public String getSearch(){
		String query = pesquisa.getQuery();
		
		return "/pesquisa?q="+query;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
}