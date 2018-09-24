package br.com;

import com.escolhacerta.control.Usuario;
import com.escolhacerta.model.UsuarioDAO;

public class Testa {

	public static void main(String[] args) {
		UsuarioDAO u = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		usuario.setNome("Brick");
		usuario.setEmail("teste1@teste.com");
		usuario.setSenha("ooooo");
		usuario.setCep(00347000);
		usuario.setCidade("Rio de Janeiro");
		usuario.setEstado("Rio de Janeiro");
		usuario.setCPF("0000000000000-00");		
		
		u.adiciona(usuario);
	}

}
