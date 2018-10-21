package com.escolhacerta.managedBeans;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.util.FacesUtil;

//import org.hibernate.Session;
//import org.hibernate.criterion.Order;

import com.escolhacerta.control.Produto;
import com.escolhacerta.model.CategoriaDAO;
import com.escolhacerta.model.ProdutoDAO;
import com.escolhacerta.util.HibernateUtil;


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
	private Categoria categoria;
	
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
	
	public List<Produto> getProdutos(){
		return produtos;
	}
	
	public Categoria getCategoria(){
		return this.categoria;
	}
	
}
