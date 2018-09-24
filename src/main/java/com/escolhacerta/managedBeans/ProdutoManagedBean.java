package com.escolhacerta.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.escolhacerta.control.Produto;
import com.escolhacerta.util.HibernateUtil;


@SuppressWarnings("deprecation")
@ManagedBean(name = "produtoManagedBean")
@ViewScoped
public class ProdutoManagedBean {
	//salva a listagem de produtos do banco de dados
	//dentro do Arraylist para futura listagem
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@PostConstruct
	public void inicializar(){
		new HibernateUtil();
		Session session = HibernateUtil.getSession();
		
		this.produtos = session.createCriteria(Produto.class)
				.addOrder(Order.asc("dtCadastro"))
				.list();
		
		session.close();
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
}
