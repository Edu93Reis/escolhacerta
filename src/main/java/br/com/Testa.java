package br.com;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.control.Produto;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.managedBeans.CadastroManagedBean;
import com.escolhacerta.managedBeans.LoginManagedBean;
import com.escolhacerta.managedBeans.ProdutoManagedBean;
import com.escolhacerta.model.CategoriaDAO;
import com.escolhacerta.model.ProdutoDAO;
import com.escolhacerta.model.UsuarioDAO;

public class Testa {

	public static void main(String[] args) throws SQLException {
		UsuarioDAO u = new UsuarioDAO();
		CategoriaDAO cD = new CategoriaDAO();
		Categoria cat = new Categoria();
		Usuario usuario = new Usuario();
		Produto produto = new Produto();
		ProdutoManagedBean p = new ProdutoManagedBean();
		CadastroManagedBean c = new CadastroManagedBean();
		ProdutoDAO pd = new ProdutoDAO();
		LoginManagedBean l = new LoginManagedBean();
		
		//System.out.println(c.getDebuga());
		String valor = "600,00";
		
		//cat.setCategoria("Informática");
		/*produto.setNmProduto("Celular Windws");
		produto.setComent("Preço acessível, bastante memória. Defeitos: pouco suporte, muitos aplicativos não rodam.");
		produto.setIdCategoria(2);
		produto.setModelo("Windows Phone 450");
		produto.setPreco(new BigDecimal(valor.replaceAll("\\.", "").replace(",", ".")));
		produto.setPontuacao(3);*/
		
		//pd.adiciona(produto);
		
		System.out.println(p.getMediaPontuacao());
		//System.out.println(pd.listarProdutoCategoria("Eletrônicos"));
		//System.out.println(pd.getPrecos("Testinho"));
		
		//System.out.println(u.loginUsuario("eu@eu.com", "123"));
		//System.out.println(pd.getCategoria("Câmeras"));
		//System.out.println(u.getUser());
		//l.autentica();
		/*for(Usuario teste : u.loginUsuario()){
			System.out.println(teste.getCPF());
		}*/
		/*usuario.setNome("Oiasass");
		usuario.setEmail("a@bc.com");
		usuario.setSenha("hajhaj");
		//usuario.setNasc(1222/09/09);
		usuario.setCep(00344050);
		usuario.setCPF("091020192-20");
		usuario.setCidade("opaoo");
		usuario.setEstado("apaas");*/		
		
		//u.adiciona(usuario);
		
		//produto.setNome("Notebook Fatec");
		//produto.setComent("Branco Fatec");
		//produto.setDtCadastro('2018-02-08');
		/*produto.setModelo("AC1234");
		produto.setPreco(new BigDecimal(2200.50));
		produto.setPontuacao(4);
		produto.setIdCategoria(1);
		
		pd.adiciona(produto); */
		//u.adiciona(usuario);
		//try{
			//System.out.println(
			//cD.listarCategoria();
			//System.out.println(cD.getCategorias());
			//p.inicializar();
			//System.out.println(cD.getCategoria());
			//System.out.println(p.getCategorias());
		/*}catch (Exception e){
			System.out.println("Erro: ");
			System.out.println(e.getMessage());
		}*/
		
	}

}
