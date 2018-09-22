package com.escolhacerta.control;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	private Integer idUsuario;
	private String email;
	private String nome;
	private String senha;
	private Date nasc;
	private String cpf;
	private Integer idEndereco;
	private String cidade;
	private String estado;
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
		if(nome.equals(null) || nome.getClass().toString() != "String" || nome.equals("  ")){
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
		if(senha.equals(null) || senha.equals("  ") || senha.getClass().toString() != "String"){
			System.out.println("Insira valor no campo senha!");
		}else{		
			this.senha = senha;
		}
	}
	
	//@TemporalType.Date --> necess�rio para lidar com datas no Java com precis�o
	@Temporal(TemporalType.DATE)
	@Column(name="nascimento", nullable=false)
	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		if(nasc.equals(null) || !(nasc.getClass().isAssignableFrom(new Date().getClass())) ) {
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
		if(cpf.equals(null) || cpf.equals("") || cpf.equals("  ") || cpf.contains("   ") || cpf.getClass().toString() != "String"){
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
		if(cidade.equals(null) || cidade.getClass().toString() != "String" || cidade.equals("  ")){
			System.out.println("Insira valor no campo cidade!");
		}else{		
			this.cidade = cidade;
		}
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		if(estado.equals(null) || estado.equals("  ") || estado.getClass().toString() != "String") {
			System.out.println("Insira valor no campo estado!");
		}else{		
			this.estado = estado;
		}
	}
	
	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
}