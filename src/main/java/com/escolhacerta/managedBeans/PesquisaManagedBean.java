package com.escolhacerta.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandLink;
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
	private ProdutoDAO produtoDAO;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	//retorna produtos
	public List<Produto> getProdutosCategoria(String categoria){
		try{
			produtos = produtoDAO.listarProdutoCategoria(categoria);
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
		int size  = produtos.size();
		
		return size;
	}
	
	
}
