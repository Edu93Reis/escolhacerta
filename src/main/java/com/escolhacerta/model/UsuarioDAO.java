package com.escolhacerta.model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.util.ConnectionFactory;
import com.escolhacerta.validation.CadastroValidation;

public class UsuarioDAO {
	private Connection conn;
	private Usuario usuario = new Usuario();
	private CadastroValidation cv = new CadastroValidation();
	
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
		//java.sql.Date nasc = new java.sql.Date(usuario.getNasc());
		//this.usuario = usuario;
		
		try { 
			//+ "(emailUsuario, nmUsuario, idPassword, dtNasc, nmCidade, nmEstado, cdCep)" +
			PreparedStatement stmt = conn.prepareStatement("insert into usuario "
					+ "(emailUsuario, nmUsuario, idPassword, cdCPF, nmCidade, nmEstado, cdCep)" + 
										" values (?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			/*String dia = usuario.getNasc().toString().substring(9, 10);
			String mes = usuario.getNasc().toString().substring(6, 7);
			String ano = usuario.getNasc().toString().substring(0, 4);*/
			Date data = cv.converteData(usuario.getNasc().toString());
			stmt.setDate(4, data);
			stmt.setString(4, usuario.getCPF());
			stmt.setString(5, usuario.getCidade());
			stmt.setString(6, usuario.getEstado());
			stmt.setInt(7, usuario.getCep());
			stmt.execute();
			stmt.close();
			
			return true;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
			
			/*Logger lgr = Logger.getLogger(Connect.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);*/
			//return false;
		}
	}
	
	public boolean loginUsuario(Usuario usuario){
		List<String> emails = new ArrayList<String>();
		List<String> senhas = new ArrayList<String>();
		boolean log = false;
		try{
			PreparedStatement stmt = conn.prepareStatement("select * FROM usuario");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				emails.add(rs.getString("emailUsuario"));
				senhas.add(rs.getString("idPassword"));
			}

				for(String email : emails){
					if(email.equals(usuario.getEmail())){
						for(String senha : senhas){
							if(senha.equals(usuario.getSenha())){
								log = true;
							}else{
								log = false;
							}
						}
					}
				}
			
			//retorno true, managedBean, redireciona para index ou userArea e libera conteúdo desabilitado
			//retorno false, managedBean dispara mensagem de tentativa inválida de login 
			return log;
		}catch (SQLException ex){
			throw new RuntimeException(ex);
		}
	}

}
