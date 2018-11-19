package com.escolhacerta.managedBeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.escolhacerta.control.Produto;
import com.escolhacerta.model.ProdutoDAO;

@SuppressWarnings("deprecation")
@ManagedBean(name = "pesquisaManagedBean")
@ViewScoped
public class PesquisaManagedBean {
	//private Produto produto;
	private HtmlDataTable dataTable;
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private List<Produto> produtos = new ArrayList<Produto>();
	private String categoria;
	//private Integer size = 0;
	
	/*@PostConstruct
	public void init(){
		this.categoria = this.getIdentificador();
	}*/
	
	//retorna produtos
	//String categoria
	public List<Produto> getProdutosCategoria(){
		categoria = this.getIdentificador();
		//HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();    
		//categoria = request.getParameter("q");
		
		try{
			produtos.addAll(produtoDAO.listarProdutoCategoria(categoria));
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
	
	public int getSizeProduto(){
		int size = 0;
		try{
			categoria = this.getIdentificador();
			produtos.addAll(produtoDAO.listarProdutoCategoria(categoria));
			size  = produtos.size();
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
		
		return size;
	}
	
	/*public void setSizeProduto(int size){
		this.size = size;
	}*/
}
