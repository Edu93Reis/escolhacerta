package br.com;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.escolhacerta.control.Categoria;
import com.escolhacerta.control.Produto;
import com.escolhacerta.control.Usuario;
import com.escolhacerta.managedBeans.CadastroManagedBean;
import com.escolhacerta.managedBeans.LoginManagedBean;
import com.escolhacerta.managedBeans.PesquisaManagedBean;
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
		List<Produto> lp = new ArrayList<Produto>();
		ProdutoManagedBean p = new ProdutoManagedBean();
		CadastroManagedBean c = new CadastroManagedBean();
		PesquisaManagedBean pes = new PesquisaManagedBean();
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
		
		//System.out.println(p.getMediaPrecos());
		//System.out.println(p.getMediaPontuacao());
		//lp.addAll(pes.getProdutosCategoria());
		//System.out.println(lp.get(1).getIdProduto());
		//System.out.println(pes.getNome());
		//System.out.println(pd.getNomeProduto(1));
		//System.out.println(pd.listarProdutoId(1));
		//System.out.println(pd.listarProdutoCategoria("Celulares"));
		//System.out.println(pd.getPrecos("Celular Windows", "w-480"));
		//System.out.println(pd.getPontuacao("Celular Windows", "w-480"));
		
		//System.out.println(u.loginUsuario("eu@eu.com", "123"));
		//System.out.println(pd.getCategoria("Câmeras"));
		//System.out.println(u.getUser());
		//l.autentica();
		/*for(Usuario teste : u.loginUsuario()){
			System.out.println(teste.getCPF());
		}*/
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		usuario.setEmail("bonovox@u2.com");
		usuario.setNome("Bono Vox");
		usuario.setSenha("bonovox");
		try {
			usuario.setNasc(formatter.parse("1963-08-12"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario.setCPF("182.130.122-21");
		usuario.setCidade("Rio de Janeiro");
		usuario.setEstado("Rio de Janeiro");	
		usuario.setCep("10342-151");
		
		//c.incluiUsuario(usuario);
		System.out.println(pd.getProdutosUsuario("eduardo.reis93@gmail.com"));
		
		
		//String teste = "Sun Jan 02 00:00:00 BRT 1927";
		
		//System.out.println(usuario.getNasc());
		
		//u.adiciona(usuario); 
		
		//System.out.println(pes.getProdutosCategoria("Celulares"));
		
		//System.out.println(p.getMediaPrecos());
		//System.out.println(p.getMediaPontuacao());
		//System.out.println(pd.getPontuacao("Teste"));
		//System.out.println(pd.getPrecos("Teste"));
		
		try{
		/*	List<Produto> prod = pd.listarProdutoCategoria("Celulares");
			
			if("".equals(prod) || !(prod.isEmpty()) ){
				for(Produto pdt : prod){
					System.out.println(pdt.getNmProduto());
					System.out.println(pdt.getComent());
					System.out.println(pdt.getDtCadastro());
					System.out.println(pdt.getPontuacao());
				}
			}*/
			//System.out.println(pes.getProdutosCategoria());
			//System.out.println(cD.listarAllCategoria());
			//System.out.println(pd.listarProdutoCategoria("Celulares"));
			//System.out.println(pd.getWstComments("Celular Windows", "W-480"));
			/*System.out.println(pes.validaQuery("Mótöròllã"));
			System.out.println(pes.validaQuery("BÌchínhü dî pelõcíà"));
			System.out.println(pes.validaQuery("àbrà`çõès"));*/
			//List<Produto> teste =  pd.listaProdutoQuery("Notebook");
			//System.out.println(teste.get(teste.size()).getNmProduto());
			//System.out.println(pd.listaProdutoQuery("Notebook"));
			//System.out.println(pes.pesquisaString("Samsüng"));
			//List<Produto> teste = pes.bstProdutos(0);
			//System.out.println(pes.wstProdutos(1));
			
			//System.out.println(u.getLoggedUser("eduardo.reis93@gmail.com"));
			//l.setUsuario("eduardo.reis93@gmail.com");
			//System.out.println(l.getUsuario().getNome());
			//System.out.println(u.adiciona(usuario));
		}catch(Exception ex){
			System.out.println(ex);
		}
	
		/*SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			java.util.Date d = data.parse("2018-02-08");
			java.sql.Date da = new java.sql.Date(d.getTime());
		
			produto.setNmProduto("Notebook Fatec");
			produto.setComent("Branco Fatec");
			produto.setDtCadastro(da);
			produto.setModelo("AC1234");
			produto.setPreco(new BigDecimal(2200.50));
			produto.setPontuacao(4);
			produto.setIdCategoria(1);
			
			p.incluiProduto();
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
