package com.escolhacerta.managedBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import com.escolhacerta.control.Categoria;
import com.escolhacerta.util.FacesUtil;

//import org.hibernate.Session;
//import org.hibernate.criterion.Order;

import com.escolhacerta.control.Produto;
import com.escolhacerta.model.CategoriaDAO;


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
	private List<Produto> fstProdutos = new ArrayList<Produto>();
	private List<Produto> lstProdutos = new ArrayList<Produto>();
	private int mediaPontuacao = 0;
	private Categoria categoria;
	
	//construtor
	public ProdutoManagedBean(){
		this.produtos = new ArrayList<Produto>();
		this.categorias = new ArrayList<String>();
		this.categoria = new Categoria();
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
	
	//recebe todas as pontuações de um produtoModelo e retorna sua média (médias são calculadas por modelo do produto)
	public Integer getMediaPontuacao(){
		this.avaliacoes.add(1); 
		this.avaliacoes.add(2); 
		this.avaliacoes.add(1); 
		this.avaliacoes.add(4);
		this.avaliacoes.add(5); 
		this.avaliacoes.add(4);
		
		for(Integer num: this.avaliacoes){
			mediaPontuacao += num;
		}
		
		//mediaPontuacao = Math.round(mediaPontuacao/this.avaliacoes.size());
		//pontuacao perdendo precisao
		return mediaPontuacao/this.avaliacoes.size();
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
}
