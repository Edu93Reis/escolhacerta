package br.com;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		/*produto.setNmProduto("Celular Windows");
		produto.setComent("Preço acessível, bastante memória. Defeitos: pouco suporte, muitos aplicativos não rodam.");
		produto.setIdCategoria(2);
		produto.setModelo("Windows Phone 450");
		produto.setPreco(new BigDecimal("600.00"));
		//produto.setPreco(new BigDecimal(valor.replaceAll("\\.", "").replace(",", ".")));
		produto.setPontuacao(3);
		
		pd.adiciona(produto);
		pd.adicionaModelo(produto);*/
		
		//System.out.println(p.getMediaPontuacao());
		//System.out.println(pd.listarProdutoCategoria("Eletrônicos"));
		//System.out.println(pd.getPrecos("Testinho"));
		
		//System.out.println(u.loginUsuario("eu@eu.com", "123"));
		//System.out.println(pd.getCategoria("Câmeras"));
		//System.out.println(u.getUser());
		//l.autentica();
		/*for(Usuario teste : u.loginUsuario()){
			System.out.println(teste.getCPF());
		}*/
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		usuario.setNome("Son Goku");
		usuario.setEmail("goku@bc.com");
		usuario.setSenha("123");
		try {
			usuario.setNasc(formatter.parse("1987-12-02"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario.setCep("00354150");
		usuario.setCPF("081030192-20");
		usuario.setCidade("Santos");
		usuario.setEstado("São Paulo");		
		
		System.out.println(u.adiciona(usuario)); */
		
		//System.out.println(p.getProdutosCategoria("Celulares"));
		
		System.out.println(p.getMediaPrecos());
		//System.out.println(p.getMediaPontuacao());
		//System.out.println(pd.getPontuacao("Teste"));
		//System.out.println(pd.getPrecos("Teste"));
		
		//System.out.println(pd.listarProdutoCategoria("Celulares"));
		
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
