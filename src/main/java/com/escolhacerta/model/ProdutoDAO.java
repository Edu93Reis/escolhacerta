package com.escolhacerta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandLink;

import com.escolhacerta.control.Produto;
import com.escolhacerta.util.ConnectionFactory;

public class ProdutoDAO {
	private Connection conn;
	private Produto produto = new Produto();
	private List<Produto> produtos = new ArrayList<Produto>();
	private HtmlCommandLink categoria;
	
	public ProdutoDAO()  {
		//construtor abre a conexão
		try{
			this.conn = new ConnectionFactory().getConnection();
		} catch(Exception cn){
			System.out.println("Erro de conexão na página ProdutoDAO! "+cn);
		}
	}
	
	// grava no banco de dados toda a instancia de um objeto Usuario
	public void adiciona(Produto produto) {
		//java.sql.Date nasc = new java.sql.Date(usuario.getNasc());
		//this.usuario = usuario;
		
		try {
			//"(nmProduto, dsDescricao, dtCadastro, nmModelo, cdPreco, pontuacao, idCategoria)"
			PreparedStatement stmt = conn.prepareStatement("insert into produto "
					+ "(nmProduto, dsDescricao, nmModelo, cdPreco, pontuacao, idCategoria)" + 
										" values (?, ?, ?, ?, ?, ?)");

				stmt.setString(1, produto.getNome());
				stmt.setString(2, produto.getComent());
				//stmt.setDate(3, new java.sql.Date(produto.getDtCadastro().getTime()));
				stmt.setString(3, produto.getModelo());
				stmt.setBigDecimal(4, produto.getPreco());
				stmt.setInt(5, produto.getPontuacao());
				stmt.setInt(6, produto.getIdCategoria());
			
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
