package br.com;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.control.Produto;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.managedBeans.CadastroManagedBean;
import com.escolhacerta.managedBeans.ProdutoManagedBean;
import com.escolhacerta.model.CategoriaDAO;
import com.escolhacerta.model.ProdutoDAO;
import com.escolhacerta.model.UsuarioDAO;

public class Testa {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO u = new UsuarioDAO();
		//CategoriaDAO cD = new CategoriaDAO();
		//Categoria c = new Categoria();
		Usuario usuario = new Usuario();
		Produto produto = new Produto();
		ProdutoManagedBean p = new ProdutoManagedBean();
		//CadastroManagedBean c = new CadastroManagedBean();
		ProdutoDAO pd = new ProdutoDAO();
		
		/*usuario.setNome("Oiasass");
		usuario.setEmail("a@bc.com");
		usuario.setSenha("hajhaj");
		//usuario.setNasc(1222/09/09);
		usuario.setCep(00344050);
		usuario.setCPF("091020192-20");
		usuario.setCidade("opaoo");
		usuario.setEstado("apaas");*/		
		
		//u.adiciona(usuario);
		
		produto.setNome("Notebook Acer");
		produto.setComent("Pior notebook que comprei. Não recomendo!");
		//produto.setDtCadastro('2018-02-08');
		produto.setModelo("AC1234");
		produto.setPreco(new BigDecimal(2200.50));
		produto.setPontuacao(4);
		produto.setIdCategoria(1);
		
		pd.adiciona(produto);
		//u.adiciona(usuario);
		//try{
			//System.out.println(
			//cD.listarCategoria();
			//System.out.println(cD.getCategorias());
			//p.inicializar();
			System.out.println(p.getCategorias());
		/*}catch (Exception e){
			System.out.println("Erro: ");
			System.out.println(e.getMessage());
		}*/
		
	}

}
