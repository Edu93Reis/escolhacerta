package com.escolhacerta.managedBeans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.escolhacerta.control.Pesquisa;
import com.escolhacerta.control.Produto;
import com.escolhacerta.model.ProdutoDAO;

@SuppressWarnings("deprecation")
@ManagedBean(name = "pesquisaManagedBean")
@ViewScoped
public class PesquisaManagedBean {
	private Pesquisa pesquisa;
	private Produto produto;
	private HtmlDataTable dataTable;
	private ProdutoDAO produtoDAO;
	private List<Produto> produtos;
	private String categoria;
	//private List<Produto> produtosPesquisa; 
	private List<String> wstComments = new ArrayList<String>();
	private List<String> bstComments = new ArrayList<String>();
	private BigDecimal mediaPrecos;
	private List<BigDecimal> precos;
	//private Integer size = 0;
	
	public PesquisaManagedBean(){
		this.pesquisa = new Pesquisa();
		this.produto = new Produto();
		this.produtoDAO = new ProdutoDAO();
		this.produtos = new ArrayList<Produto>();
		this.mediaPrecos = new BigDecimal("0.0");
		this.precos = new ArrayList<BigDecimal>();
		//this.produtosPesquisa = new ArrayList<Produto>();
	}
	
	//retorna produtos
	//String categoria
	public List<Produto> getProdutosCategoria(){
		categoria = this.getIdentificador();
		//HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
		//categoria = request.getParameter("q");
		//categoria = "Celulares";
		try{
			for(Produto p : produtoDAO.listarProdutoCategoria(categoria)){
				produtos.add(p);
			}
			//produtos.addAll(produtoDAO.listarProdutoCategoria(categoria));
			//this.setSizeProduto(produtos.size());
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
			
		return produtos;
	}
	
	public List<Produto> getProdutosId(){
		categoria = this.getIdentificador();
		//HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
		//categoria = request.getParameter("q");
		//categoria = "1";
		
		try{
			produtos.addAll(produtoDAO.listarProdutoId(Integer.valueOf(categoria)));
			//this.setSizeProduto(produtos.size());
		}catch(Exception ex){
				throw new RuntimeException(ex);
		}
			
		return produtos;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public String getIdentificador(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
		String id = request.getParameter("q");
		
		return id;
	}
	
	public String getQuery(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
		String id = request.getParameter("r");
		
		return id;
	}

	/** recebe idCategoria, passa para o DAO que alimenta a lista produtos, 
	 * o size() desta lista alimenta a quantidade de retornos para a busca **/
	public int getSizeProduto(){
		int s = 0;
		try{
			categoria = this.getIdentificador();
			produtos.addAll(produtoDAO.listarProdutoCategoria(categoria));
			s = produtos.size();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
		
		return s;
	}
	
	/*public String getNome() {
		return this.nome;
	}*/
	
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
		
		int cont = 0;
		produtoDAO = new ProdutoDAO();
		List<String> p = produtoDAO.getWstComments(produto, modelo);
		for(String prod : p){
			this.wstComments.add(prod);
			cont ++;
			if(cont>=2){
				break;
			}
		}
		
		System.out.println(produto + " " + modelo + " " + produtoDAO.getWstComments("Celular Windows", "W-480").size());
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
		int cont = 0;
		produtoDAO = new ProdutoDAO();
		
		for(String prod : produtoDAO.getBstComments(produto, modelo)){
			this.bstComments.add(prod);
			cont ++;
			if(cont>=2){
				break;
			}
		}
		
		//System.out.println(produto + " " + modelo + " " + categoria + " " + produtoDAO.getBstComments("Celular Windows", "W-480").size());
		
		return this.bstComments;
	}
	
	public BigDecimal getMediaPrecos(){
		try{
			//getPrecos() recebe nomeDoProduto 
			//this.precos = produtoDAO.getPrecos("Teste");
			//String prod = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("produto");
			//String mod = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modelo");
			
			this.precos.addAll(produtoDAO.getPrecos("Celular Windows", "W-480"));
			//this.precos.addAll(produtoDAO.getPrecos(produtos.get(0).getNmProduto(), produtos.get(0).getModelo()));
			
			for(BigDecimal preco: this.precos){
				//mediaPrecos.add(valor) nao funciona, é preciso usar atribuição
				mediaPrecos = mediaPrecos.add(preco);
			}
			
			//System.out.println(mediaPrecos + prod  + mod);
			//System.out.println(mediaPrecos + this.produtos.get(0).getNmProduto() + this.produtos.get(0).getModelo());
			
			mediaPrecos = mediaPrecos.divide(new BigDecimal(String.valueOf(this.precos.size())), 2, RoundingMode.HALF_EVEN);
			//pontuacao perdendo precisao
			//return mediaPrecos;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			//return null;
		}
		
		return mediaPrecos;
	}


	public List<Produto> getPesquisaString() throws SQLException {
		String query = this.getIdentificador();
		try{
			for(Produto p : produtoDAO.listaProdutoQuery(this.validaQuery(query))){
				produtos.add(p);
			}
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
	 	
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
	
	public List<Produto> bstProdutos() throws SQLException{
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
	
	public List<Produto> wstProdutos() throws SQLException {
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
}
