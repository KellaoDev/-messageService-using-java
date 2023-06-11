package br.edu.ifgoiano.entidade;

public class Usuario {
	
	private Integer id;
	private String nome;
	private String email;
	private String avisoEmail;
	
	public String getAvisoEmail() {
		return avisoEmail;
	}
	public void setAvisoEmail(String avisoEmail) {
		this.avisoEmail = avisoEmail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
