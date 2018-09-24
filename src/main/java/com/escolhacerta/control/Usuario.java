package com.escolhacerta.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/* indica��o de que esta � uma entidade da JPA (persistencia Java) */
@Entity
/* Indica��o do Hibernate de qual ser� a tabela em que ser�o persistidos os dados */
@Table(name="usuario")
/* A cada requisi��o realizada o bean � gravado em um �map�, chamado de �view map� 
** e, por conta disso, este bean deve implementar a interface Serializable */
public class Usuario implements Serializable {	
	private static final long serialVersionUID = 3445560597837908750L;
	private List<String> list_estados = new ArrayList<String>(){
		{
		 add("Acre"); add("Alagoas"); add("Amapá"); add("Amazonas"); add("Bahia");
		 add("Ceará"); add("Distrito Federal"); add("Espírito Santo"); add("Goiás"); add("Maranhão");
		 add("Mato Grosso"); add("Mato Grosso do Sul"); add("Minas Gerais"); add("Pará"); add("Paraíba");
		 add("Paraná"); add("Pernambuco"); add("Piauí"); add("Rio de Janeiro"); add("Rio Grande do Norte");
		 add("Rio Grande do Sul"); add("Rondônia"); add("Roraima"); add("Santa Catarina");
		 add("São Paulo"); add("Sergipe"); add("Tocantins");
		 }
	};
	private Integer idUsuario;
	private String email;
	private String nome;
	private String senha;
	private Date nasc;
	private String cpf;
	private Integer idEndereco;
	private String cidade;
	private String estado;
	private String estados;
	private Integer cep;
	
	//indica��o do Hibernate por annotations de 
	//@Id --> chave prim�ria, @GeneratedValue --> valor gerado automaticamente, e nome e caracter�sticas 
	//das colunas que equivalem ao atributo (atributo idUsuario == coluna idUsuario no MySQL)  
	@Id
	@GeneratedValue
	@Column(name="idUsuario", nullable=false, unique=true)
	public Integer getIdUser(){
		return this.idUsuario;
	}
	
	public void setIdUser(Integer idUsuario){
		this.idUsuario = idUsuario;
	}
	
	//indica��o de coluna � obrigat�ria para o funcionamento 
	//apenas quando o nome do atributo 
	//n�o bate com o nome da coluna no Banco de Dados, como nesse caso
	@Column(name="emailUsuario", nullable=false, unique=true)
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	@Column(name="nmUsuario", nullable=false, unique=true)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		//|| nome.getClass().toString() != "String" || nome.equals("  ")
		if(nome.equals(null)){
			System.out.println("Insira valor no campo nome!");
		}else{
			this.nome = nome;
		}
	}
	
	@Column(name="cdSenha", nullable=false)
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		// || senha.equals("  ") || senha.getClass().toString() != "String"
		if(senha.equals(null)){
			System.out.println("Insira valor no campo senha!");
		}else{		
			this.senha = senha;
		}
	}
	
	//@TemporalType.Date --> necess�rio para lidar com datas no Java com precis�o
	//@Temporal(TemporalType.DATE)
	//@Column(name="nascimento", nullable=false)
	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		//|| !(nasc.getClass().isAssignableFrom(new Date().getClass()))
		if(nasc.equals(null)) {
			System.out.println("Insira valor no campo nascimento!");
		}else{
			this.nasc = nasc;
		}
	}
	
	@Column(name="cdCpf", nullable=false, unique=true)
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cpf) {
		// || cpf.equals("") || cpf.equals("  ") || cpf.contains("   ") || cpf.getClass().toString() != "String"
		if(cpf.equals(null)){
			System.out.println("Insira valor no campo CPF!");
		}else{	
			this.cpf = cpf;
		}
	}
	
	//caso use dois Ids ele entende como uma composite Class
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getEndereco(){
		return idEndereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		//|| cidade.getClass().toString() != "String" || cidade.equals("  ")
		if(cidade.equals(null)){
			System.out.println("Insira valor no campo cidade!");
		}else{		
			this.cidade = cidade;
		}
	}
	
	public String getEstado() {
		return estado;
	}
	
	//|| estado.equals("  ") || estado.getClass().toString() != "String"
	public void setEstado(String estado) {
		if(estado.equals(null)) {
			System.out.println("Insira valor no campo estado!");
		}else{
			this.estado = estado;
		}
	}
	
	public void setEstados(){
		for(String estado : list_estados){
			this.estados = estado;
		}
	}
	
	
	
	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
}