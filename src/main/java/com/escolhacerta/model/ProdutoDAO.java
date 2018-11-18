package com.escolhacerta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandLink;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.control.Produto;
import com.escolhacerta.util.ConnectionFactory;
import java.math.BigDecimal;

public class ProdutoDAO {
	private Connection conn;
	private Produto produto = new Produto();
	private Categoria categoria = new Categoria();
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Produto> produtoCategoria = new ArrayList<Produto>();
	private HtmlCommandLink btnCategoria;
	private List<BigDecimal> precos = new ArrayList<BigDecimal>();
	private List<Integer> pontuacao = new ArrayList<Integer>();
	
	public ProdutoDAO()  {
		//construtor abre a conexão
		try{
			this.conn = new ConnectionFactory().getConnection();
		} catch(Exception cn){
			System.out.println("Erro de conexão na página ProdutoDAO! "+cn);
		}
	}
	
	//ainda não funciona
	//Categoria
	public int getCategoria(String categoria){
		int cdCategoria = 0;
		
		try{
			PreparedStatement stmt = conn.prepareStatement("SELECT idCategoria FROM produto "
					+ "WHERE nmProduto=?");
			stmt.setString(1, categoria);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				cdCategoria = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ex){
			throw new RuntimeException("Nâo foi possível selecionar", ex);
		}
		
		produto.setIdCategoria(cdCategoria);
		
		return cdCategoria;
	}
	
	// grava no banco de dados toda a instancia de um objeto Usuario
	public void adiciona(Produto produto) {
		//java.sql.Date nasc = new java.sql.Date(usuario.getNasc());
		//this.usuario = usuario;
		
		try {
			//"(nmProduto, dsDescricao, dtCadastro, nmModelo, cdPreco, pontuacao, idCategoria)"
			/*PreparedStatement stmt = conn.prepareStatement("insert into produto "
					+ "(nmProduto, nmMarca, nmModelo, cdPreco, dsDescricao, pontuacao, idCategoria)" + 
										" values (?, ?, ?, ?, ?, ?, ?)");*/
			/*PreparedStatement stmt = conn.prepareStatement("insert into produto "
					+ "(nmProduto, nmModelo, cdPreco, dsDescricao, pontuacao, idCategoria)" + 
										" values (?, ?, ?, ?, ?, ?)");*/
			
			/*
				Preciso destes inserts:
				
				 INSERT INTO produto (nmProduto, dsDescricao, dtCadastro, idCategoria)
					VALUES ('Teste', 'Teste maroto, Testando ...', default, 1);
				 INSERT INTO modelo (nmModelo, cdPreco, pontuacao)
					VALUES ('Testinho', 200.03, 5);
				 
			*/
			
			
			String query = "insert into Produto (nmProduto, dsDescricao, idCategoria) values (?,?,?)";// +
					//"insert into Modelo (nmModelo, cdPreco, pontuacao) values (?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);

			
				pstmt.setString(1, produto.getNmProduto());
				pstmt.setString(2, produto.getComent());
				pstmt.setInt(3, produto.getIdCategoria());
				/*pstmt.setString(4, produto.getModelo());
				pstmt.setBigDecimal(5, produto.getPreco());
				pstmt.setInt(6, produto.getPontuacao());*/
				
			pstmt.executeUpdate();
			pstmt.close();
			//cdstmt.executeUpdate();
			//cdstmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		//estou mexendo aqui
		
		//this.relacionaModelo(produto.getIdProduto(), idModelo);
		//this.relacionaUsuario(idUsuario, idModelo);
	}
	
	// grava no banco de dados toda a instancia de um objeto Usuario
	public void adicionaModelo(Produto produto) {
		try {
			String query = "insert into Modelo (nmModelo, cdPreco, pontuacao) values (?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);

			
				pstmt.setString(1, produto.getModelo());
				pstmt.setBigDecimal(2, produto.getPreco());
				pstmt.setInt(3, produto.getPontuacao());
				
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void relacionaModelo(String idProduto, String idModelo){
		String query = "INSERT INTO modeloProduto (idProduto, idModelo) VALUES (?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, idProduto);
			stmt.setString(2, idModelo);
			
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException ex){
			throw new RuntimeException(ex);
		}
	}
	
	public void relacionaUsuario(String idUsuario, String idProduto){
		String query = "INSERT INTO usuarioProduto (idProduto, idUsuario) VALUES (?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, idUsuario);
			stmt.setString(2, idProduto);
			
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException ex){
			throw new RuntimeException(ex);
		}
	}
	
	public List<BigDecimal> getPrecos(String nmProduto){
		String sql = "SELECT cdPreco FROM modelo as m join Produto as p WHERE nmProduto = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nmProduto);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Produto p = new Produto();
				p.setPreco(rs.getBigDecimal("cdPreco"));
				precos.add(p.getPreco());
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		return precos;
	}
	
	public List<Integer> getPontuacao(String nmProduto){
		String sql = "SELECT pontuacao FROM modelo as m join Produto as p WHERE nmProduto = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nmProduto);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Produto p = new Produto();
				p.setPontuacao(rs.getInt("pontuacao"));
				pontuacao.add(p.getPontuacao());
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		return pontuacao;
	}	
	
	public List<Produto> listarProdutoCategoria(String nmCategoria) throws SQLException {
		String sql = "SELECT Modelo.idModelo, Produto.nmProduto, Produto.dsDescricao, Produto.dtCadastro, Produto.idCategoria, "
				+ "Categoria.nmCategoria, Modelo.nmModelo, Modelo.cdPreco, Modelo.pontuacao"+
					 "FROM Produto join Categoria join Modelo WHERE Categoria.nmCategoria = ?" +
				     "and Produto.idCategoria = Categoria.idCategoria";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Produto p;
		try{
			stmt.setString(1, nmCategoria);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				p = new Produto();
				p.setNmProduto(rs.getString("nmProduto"));
				p.setComent(rs.getString("dsDescricao"));
				p.setDtCadastro(rs.getDate("dtCadastro"));
				//adicionar nmCategoria ao produto, ou usar grande if com todas as opções de retorno por id
				//p.setNmCategoria(rs.getInt("nmCategoria"));
				p.setIdCategoria(rs.getInt("idCategoria"));
				p.setModelo(rs.getString("nmModelo"));
				p.setPreco(rs.getBigDecimal("cdPreco"));
				p.setPontuacao(rs.getInt("pontuacao"));
				produtoCategoria.add(p);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
			//throw new RuntimeException(ex);
		}
		
		return produtoCategoria;
	}
	
}
