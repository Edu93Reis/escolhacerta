package com.escolhacerta.control;

import java.io.Serializable;

/*** Classe da camada de controle responsável pela Pesquisa de dados, segue o modelo do DER ***/
public class Pesquisa implements Serializable {
	private static final long serialVersionUID = 8556865941286727266L;
	private String query;
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	/*** método responsável por receber a query da pesquisa ***/
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
}
