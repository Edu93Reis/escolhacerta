package com.escolhacerta.model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.util.ConnectionFactory;
import com.escolhacerta.validation.CadastroValidation;

public class UsuarioDAO {
	private Connection conn;
	private Usuario usuario = new Usuario();
	private CadastroValidation cv = new CadastroValidation();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private int id = 0;
	private String nome, email, senha;
	/*private List<String> ids = new ArrayList<String>();
	private List<String> emails = new ArrayList<String>();
	private List<String> senhas = new ArrayList<String>();*/
	private Usuario loggedUser = new Usuario();
	
	public UsuarioDAO()  {
		//construtor abre a conexão
		try{
			this.conn = new ConnectionFactory().getConnection();
		} catch(Exception cn){
			System.out.println(cn);
		}
	}
	
	// grava no banco de dados toda a instancia de um objeto Usuario
	public boolean adiciona(Usuario usuario) {
		try { 
			//+ "(emailUsuario, nmUsuario, idPassword, dtNasc, nmCidade, nmEstado, cdCep)" +
			PreparedStatement stmt = conn.prepareStatement("insert into usuario "
					+ "(emailUsuario, nmUsuario, idPassword, dtNasc, cdCPF, nmCidade, nmEstado, cdCep)" + 
										" values (?, ?, ?, ?, ?, ?, ?,?)");

			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			Date data = cv.converteData(usuario.getNasc().toString());
			stmt.setDate(4, data);
			stmt.setString(5, usuario.getCPF());
			stmt.setString(6, usuario.getCidade());
			stmt.setString(7, usuario.getEstado());
			stmt.setString(8, usuario.getCep());
			stmt.execute();
			stmt.close();
			
			return true;
			//return true;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
			
			/*Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);*/
			//return false;
		}
	}

	
	
	public boolean loginUsuario(String email, String senha){
		boolean res = false;
		try{
			PreparedStatement stmt = conn.prepareStatement("select emailUsuario, idPassword FROM usuario "
					+ "where emailUsuario =? and idPassword =?");
			
			stmt.setString(1, email);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){				
				res = true;
			}
			
			stmt.close();
			rs.close();
		}catch (SQLException ex){
			throw new RuntimeException(ex);
		} 
		return res;
	}
	
	public Usuario getLoggedUser(String email){
		try{
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE emailUsuario = ?");
			
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				loggedUser.setIdUser(rs.getInt("idUsuario"));
				loggedUser.setEmail(rs.getString("emailUsuario"));
				loggedUser.setNome(rs.getString("nmUsuario"));
				loggedUser.setSenha(rs.getString("idPassword"));
				loggedUser.setCPF(rs.getString("cdCPF"));
				loggedUser.setNasc(rs.getDate("dtNasc"));
				loggedUser.setCidade(rs.getString("nmCidade"));
				loggedUser.setEstado(rs.getString("nmEstado"));
				loggedUser.setCep(rs.getString("cdCep"));
			}
			rs.close();
			stmt.close();
			
		}catch(SQLException ex){
			throw new RuntimeException(ex);
		}
		return loggedUser;
	}

	public String getNome() {
		return nome;
	}

	public void deleta(String login) {
		try {
			PreparedStatement stmt = conn.prepareStatement("delete from usuario where login=?");
			stmt.setString(1, login);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Usuario> getUser(){
		return this.usuarios;
	}

}
