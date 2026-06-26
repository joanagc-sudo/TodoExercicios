package model;

public class Pessoa {
	private String nome, cpf, email, idade;

	
	public Pessoa(String nome, String cpf, String idade, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nopme) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	

}
