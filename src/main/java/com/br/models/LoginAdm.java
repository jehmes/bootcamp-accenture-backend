package com.br.models;

public class LoginAdm {

	private String email;
	private String senha;
	
	public LoginAdm(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	public LoginAdm() {
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
