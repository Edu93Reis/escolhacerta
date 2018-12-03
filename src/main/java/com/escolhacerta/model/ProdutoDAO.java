package com.escolhacerta.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlCommandLink;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.control.Produto;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.util.ConnectionFactory;
import java.math.BigDecimal;

public class ProdutoDAO {
	private Connection conn;
	private Produto produto = new Produto();
	private Categoria categoria = new Categoria();
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Produto> produtoCategoria = new ArrayList<Produto>();
	private List<Produto> produtosUsuario = new ArrayList<Produto>();
	private List<String> bstProdutosComments = new ArrayList<String>();
	private List<String> wstProdutosComments = new ArrayList<String>();
	private HtmlCommandLink btnCategoria;
	private List<BigDecimal> precos = new ArrayList<BigDecimal>();
	private List<Integer> pontuacao = new ArrayList<Integer>();
	private String nome;
	
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
		//int idProduto = 0;
		
		try {
			String query = "insert into Produto (nmProduto, dsDescricao, idCategoria, nmModelo, cdPreco, pontuacao) "
					+ "values (?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(query);

			
				pstmt.setString(1, produto.getNmProduto());
				pstmt.setString(2, produto.getComent());
				pstmt.setInt(3, produto.getIdCategoria());
				pstmt.setString(4, produto.getModelo());
				pstmt.setBigDecimal(5, produto.getPreco());
				pstmt.setInt(6, produto.getPontuacao());
				
			pstmt.executeUpdate();
			pstmt.close();
			
			/*String id = "SELECT idProduto FROM Produto WHERE nmProduto = ?";
			
			PreparedStatement idstmt = conn.prepareStatement(id);
			idstmt.setString(1, produto.getNmProduto());
			ResultSet rs = idstmt.executeQuery();
			
			while(rs.next()){
				idProduto = (rs.getInt("idProduto"));
			}*/
			
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		//estou mexendo aqui
		//this.relacionaUsuario(1, idProduto);
	}
	
	public void relacionaUsuario(int idUsuario, int idProduto){
		String query = "INSERT INTO usuarioProduto (idProduto, idUsuario) VALUES (?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, idUsuario);
			stmt.setInt(2, idProduto);
			
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		}catch (SQLException ex){
			throw new RuntimeException(ex);
		}
	}
	
	public List<BigDecimal> getPrecos(String nmProduto, String nmModelo){
		String sql = "SELECT cdPreco FROM Produto WHERE nmProduto like ? and nmModelo = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+nmProduto+"%");
			stmt.setString(2, nmModelo);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Produto p = new Produto();
				p.setPreco(rs.getBigDecimal("cdPreco"));
				precos.add(p.getPreco());
			}
			rs.close();
			stmt.close();
			//conn.close();
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		return precos;
	}
	
	public List<Integer> getPontuacao(String nmProduto, String nmModelo){
		String sql = "SELECT pontuacao FROM Produto WHERE nmProduto like ? and nmModelo = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nmProduto);
			stmt.setString(2, nmModelo);
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
	
	
	public String getNomeProduto(int idProduto){
		String sql = "SELECT nmProduto FROM Produto WHERE idProduto = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idProduto);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				nome = rs.getString("nmProduto");
			}
			rs.close();
			stmt.close();
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		
		return nome;
	}
	
	public List<Produto> listarProdutoCategoria(String nmCategoria) throws SQLException {
		String sql = "SELECT p.idProduto, p.nmProduto, p.dsDescricao, p.dtCadastro, p.idCategoria, "
				+ "c.nmCategoria, p.nmModelo, p.cdPreco, p.pontuacao"+
					 " FROM Produto p inner join Categoria c ON c.nmCategoria = ? and p.idCategoria = c.idCategoria";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Produto p;
		try{
			stmt.setString(1, nmCategoria);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				p = new Produto();
				//p.setModelo(rs.getNString("nmModelo"));
				p.setIdProduto(rs.getInt("idProduto"));
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
			//conn.close();
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
			//throw new RuntimeException(ex);
		}
		
		return produtoCategoria;
	}

	
	/** Recebe id do produto recuperado da url no ManagedBean faz o select **/
	public List<Produto> listarProdutoId(int idProduto) throws SQLException {
		String sql = "SELECT p.idProduto, p.nmProduto, p.dsDescricao, p.dtCadastro, p.idCategoria, "
				+ "c.nmCategoria, p.nmModelo, p.cdPreco, p.pontuacao"+
					 " FROM Produto p inner join Categoria c ON c.idCategoria = p.idCategoria and p.idProduto = ?";
		
		/*** Resgatar idModelo e idProduto registrado para o produto e aplicar **/
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Produto p;
		try{
			stmt.setInt(1, idProduto);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				p = new Produto();
				//p.setModelo(rs.getNString("nmModelo"));
				p.setIdProduto(rs.getInt("idProduto"));
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

	/*** retorna comentários menos pontuados de um produto para todos os que tem o mesmo modelo modelo **/
	
	public List<String> getWstComments(String produto, String modelo){
		//"WHERE nmProduto LIKE ? and nmModelo = ? "+
		String query = "SELECT dsDescricao FROM Produto " +
					   "WHERE nmModelo = ? "+
					   "ORDER BY pontuacao ASC";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(query);
			
			Produto p = new Produto();
			
			//stmt.setString(1, "%"+produto+"%");
			stmt.setString(1, modelo);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				p.setComent(rs.getString("dsDescricao"));
				wstProdutosComments.add(p.getComent());
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		
		return wstProdutosComments;
	}
	
	/*** retorna comentários mais pontuados de um produto para todos os que tem o mesmo modelo modelo **/
	public List<String> getBstComments(String produto, String modelo){
		//String produto = "Notebook";
		//String modelo = "";
		
		//"WHERE nmProduto LIKE ? and nmModelo = ? "+
		String query = "SELECT dsDescricao FROM Produto " +
						"WHERE nmModelo = ? "+
						"ORDER BY pontuacao DESC";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(query);
			
			Produto p = new Produto();
			
			//stmt.setString(1, "%"+produto+"%");
			stmt.setString(1, modelo);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				p.setComent(rs.getString("dsDescricao"));
				bstProdutosComments.add(p.getComent());
			}
		}catch(SQLException ex){
			System.out.println(ex);
		}
		
		return bstProdutosComments;
	}
	
	public List<Produto> listaProdutoQuery(String query) throws SQLException {
		String sql = "SELECT p.idProduto, p.nmProduto, p.dsDescricao, p.dtCadastro, p.idCategoria, "
				+ "c.nmCategoria, p.nmModelo, p.cdPreco, p.pontuacao"+
					 " FROM Produto p inner join Categoria c ON p.nmProduto LIKE ? and p.idCategoria = c.idCategoria";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Produto p;
		try{
			stmt.setString(1, "%"+query+"%");
			//stmt.setString(2, "%"+query+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				p = new Produto();
				//p.setModelo(rs.getNString("nmModelo"));
				p.setIdProduto(rs.getInt("idProduto"));
				p.setNmProduto(rs.getString("nmProduto"));
				p.setComent(rs.getString("dsDescricao"));
				p.setDtCadastro(rs.getDate("dtCadastro"));
				//adicionar nmCategoria ao produto, ou usar grande if com todas as opções de retorno por id
				//p.setNmCategoria(rs.getInt("nmCategoria"));
				p.setIdCategoria(rs.getInt("idCategoria"));
				p.setModelo(rs.getString("nmModelo"));
				p.setPreco(rs.getBigDecimal("cdPreco"));
				p.setPontuacao(rs.getInt("pontuacao"));
				produtos.add(p);
			}
			rs.close();
			stmt.close();
			//conn.close();
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
			//throw new RuntimeException(ex);
		}
		
		return produtos;
	}
	
	public List<Produto> listarProdutoCategoria(int idCategoria) throws SQLException {
		String sql = "SELECT p.idProduto, p.nmProduto, p.dsDescricao, p.dtCadastro, p.idCategoria, "
				+ "c.nmCategoria, p.nmModelo, p.cdPreco, p.pontuacao"+
				  " FROM Produto p inner join Categoria c ON c.idCategoria = ? and p.idCategoria = c.idCategoria"
				+" order by p.pontuacao";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		Produto p;
		try{
			stmt.setInt(1, idCategoria);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				p = new Produto();
				//p.setModelo(rs.getNString("nmModelo"));
				p.setIdProduto(rs.getInt("idProduto"));
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
			//conn.close();
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
			//throw new RuntimeException(ex);
		}
		
		return produtoCategoria;
	}

	public List<Produto> getProdutosUsuario(String emailUsuario){
		String query = "SELECT p.idProduto, p.nmProduto, p.nmModelo, p.dsDescricao, p.pontuacao, p.cdPreco FROM produto as p "
				+ "INNER JOIN usuario as u INNER JOIN usuarioProduto as up "
				+  "ON u.emailUsuario = ? and up.idUsuario = u.idUsuario and up.idProduto = p.idProduto "
				+ "INNER JOIN categoria as c ON c.idCategoria = p.idCategoria";
		
		Produto p ;
		try{
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, emailUsuario);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				p = new Produto();
				p.setIdProduto(rs.getInt("idProduto"));
				p.setNmProduto(rs.getString("nmProduto"));
				p.setModelo(rs.getString("nmModelo"));
				p.setComent(rs.getString("dsDescricao"));
				p.setPontuacao(rs.getInt("pontuacao"));
				p.setPreco(rs.getBigDecimal("cdPreco"));
		
				produtosUsuario.add(p);
			}
			rs.close();
			stmt.close();
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		
		return produtosUsuario;
	}
	
	public boolean atualizaProduto(Produto produto) {
		String sql = "UPDATE Produto as p INNER JOIN Categoria as c " +
				"SET p.idProduto = ?, p.nmProduto = ?, p.dsDescricao = ?, p.nmModelo = ?, " + 
				"p.cdPreco = ?, p.pontuacao = ? " +
				"WHERE c.idCategoria = p.idCategoria and p.idProduto = ?";
		
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, produto.getIdProduto());
			stmt.setString(2, produto.getNmProduto());
			stmt.setString(3, produto.getComent());
			stmt.setString(4, produto.getModelo());
			stmt.setBigDecimal(5, produto.getPreco());
			stmt.setInt(6, produto.getPontuacao());
			stmt.setInt(7, produto.getIdProduto());
			stmt.executeUpdate();
			stmt.close();
			
			return true;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
