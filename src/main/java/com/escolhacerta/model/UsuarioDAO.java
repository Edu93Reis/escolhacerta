package com.escolhacerta.model;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.util.ConnectionFactory;

public class UsuarioDAO {
	private Connection conn;
	//private Usuario usuario;
	
	public UsuarioDAO() {
		//construtor abre a conexão
		try {
			this.conn = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// grava no banco de dados toda a instancia de um objeto Usuario
	public void adiciona(Usuario usuario) {
		//java.sql.Date nasc = new java.sql.Date(usuario.getNasc());
		//this.usuario = usuario;
		
		try { 
			//+ "(emailUsuario, nmUsuario, idPassword, dtNasc, nmCidade, nmEstado, cdCep)" +
			PreparedStatement stmt = conn.prepareStatement("insert into usuario "
					+ "(emailUsuario, nmUsuario, idPassword, dtNasc, cdCPF, nmCidade, nmEstado, cdCep)" + 
										" values (?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getNome());
			stmt.setString(3, usuario.getSenha());
			stmt.setDate(4, new java.sql.Date(usuario.getNasc().getTime()));
			stmt.setString(5, usuario.getCPF());
			stmt.setString(5, usuario.getCidade());
			stmt.setString(6, usuario.getEstado());
			stmt.setInt(7, usuario.getCep());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
