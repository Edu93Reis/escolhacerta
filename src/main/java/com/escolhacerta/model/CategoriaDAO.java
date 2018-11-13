package com.escolhacerta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.util.ConnectionFactory;

public class CategoriaDAO {
	private Connection conn = null;
	//private String categorias;
	private List<String> categorias = new ArrayList<String>();
	private List<String> fstcategories = new ArrayList<String>();
	private List<String> sndcategories = new ArrayList<String>();
	private Categoria c = new Categoria();
	
	public CategoriaDAO() {
		try{
			this.conn = new ConnectionFactory().getConnection();
		}catch(Exception cn){
			System.out.println("Erro de conexão na página ProdutoDAO! "+cn);
		}
	}
	
	public boolean addCategoria(){
		try{
			PreparedStatement stmt = conn
					.prepareStatement("insert into categoria (nmCategoria) values (?)");
			
			stmt.setString(1, c.getCategoria());
			return true;
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
	}
	
	public List<String> listarCategoria() throws SQLException {
			String ctg = "SELECT nmCategoria FROM categoria;";
			PreparedStatement ps = conn.prepareStatement(ctg);
			//Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
			//Pelo fato de gerar uma lista de valores, é necessário percorrer os dados através do laço while
			ResultSet rs = ps.executeQuery();
			//Faz a verificação enquanto houverem registros, percorre e resgata os valores
			while(rs.next()){				
				Categoria c = new Categoria();
				//c.setCategoria(rs.getString(1));
				c.setCategoria(rs.getString("nmCategoria"));
				categorias.add(c.getCategoria());
			}
			ps.execute();
			rs.close();
			ps.close();
			//conn.close();
			
			return categorias;
			
			//link ref
			// https://www.devmedia.com.br/java-primefaces-criando-uma-tela-de-cadastro/31796
	}
	
	
	public List<String> listarFstCategorias() throws SQLException {
		String ctg = "SELECT nmCategoria FROM categoria WHERE idCategoria <= 10";
		PreparedStatement ps = conn.prepareStatement(ctg);
		//Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
		//Pelo fato de gerar uma lista de valores, é necessário percorrer os dados através do laço while
		ResultSet rs = ps.executeQuery();
		//Faz a verificação enquanto houverem registros, percorre e resgata os valores
		Categoria c = new Categoria();
		while(rs.next()){				
			c.setCategoria(rs.getString("nmCategoria"));
			fstcategories.add(c.getCategoria());
		}
	
		ps.execute();
		rs.close();
		ps.close();
		//conn.close();
		
		return fstcategories;
		
		//link ref
		// https://www.devmedia.com.br/java-primefaces-criando-uma-tela-de-cadastro/31796
	}
	
	public List<String> listarSndCategories() throws SQLException {
		String ctg = "SELECT nmCategoria FROM categoria WHERE idCategoria > 10";
		
		PreparedStatement ps = conn.prepareStatement(ctg);
		ResultSet rs = ps.executeQuery();
		Categoria c = new Categoria();
		while(rs.next()){
			//funciona mas come memória, aplicacao trava
			//while(rs.getInt("idCategoria")>7){
			c.setCategoria(rs.getString("nmCategoria"));
			sndcategories.add(c.getCategoria());
			//}
		}
		
		ps.execute();
		ps.close();
		rs.close();
		conn.close();
		
		return sndcategories;
	}
	
}
