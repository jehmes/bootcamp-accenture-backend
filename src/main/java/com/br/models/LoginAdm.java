package com.br.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginAdm {

	@Email
	private String email;
	
	@NotNull(message="Senha não pode ser nulo")
	@NotBlank(message="Senha não pode ser vázio")
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
