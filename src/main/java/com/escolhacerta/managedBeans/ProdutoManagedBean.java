package com.escolhacerta.managedBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.escolhacerta.control.Categoria;

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
	private List<Produto> produtos = new ArrayList<Produto>();
	
	//private List<String> categorias = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar(){
		/*new CategoriaDAO();
		new Categoria();*/
	}
	
	public List<Categoria> getCategorias() throws SQLException {
		CategoriaDAO cd = new CategoriaDAO();
		
		List<Categoria> listaCategoria = cd.listarCategoria();
		
		return listaCategoria;
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
}
