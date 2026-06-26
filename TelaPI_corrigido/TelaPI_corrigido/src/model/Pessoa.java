package model;

import java.time.LocalDate;

public class Pessoa {
	private String nome, email, senha;
	private LocalDate nasc;   // data de nascimento como LocalDate
	private boolean em;       // true = estudante do ensino médio

	public Pessoa(String nome, LocalDate nasc, String email, String senha, boolean em) {
		this.nome = nome;
		this.nasc = nasc;
		this.email = email;
		this.senha = senha;
		this.em = em;          // corrigido: antes ignorava o parâmetro e sempre ficava false
	}
	
	public boolean isEm() {
		return em;
	}

	public void setEm(boolean em) {
		this.em = em;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNasc() {
		return nasc;
	}

	public void setNasc(LocalDate nasc) {
		this.nasc = nasc;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
