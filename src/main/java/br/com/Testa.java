package br.com;

import java.sql.SQLException;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.managedBeans.CadastroManagedBean;
import com.escolhacerta.model.CategoriaDAO;
import com.escolhacerta.model.UsuarioDAO;

public class Testa {

	public static void main(String[] args) throws SQLException {
		//UsuarioDAO u = new UsuarioDAO();
		CategoriaDAO cD = new CategoriaDAO();
		Categoria c = new Categoria();
		//Usuario usuario = new Usuario();
		//CadastroManagedBean c = new CadastroManagedBean();
		
		/*usuario.setNome("Oiasass");
		usuario.setEmail("a@bc.com");
		usuario.setSenha("hajhaj");
		//usuario.setNasc(12220909);
		usuario.setCep(00344050);
		usuario.setCPF("091020192120-20");
		usuario.setCidade("opaoo");
		usuario.setEstado("apaas");*/		
		
		//u.adiciona(usuario);
		//u.adiciona(usuario);
		//try{
			//System.out.println(
			cD.listarCategoria();
			System.out.println(c.getCategoria());
		/*}catch (Exception e){
			System.out.println("Erro: ");
			System.out.println(e.getMessage());
		}*/
		System.out.println();
		
	}

}
