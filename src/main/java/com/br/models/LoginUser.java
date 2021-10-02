package com.br.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;


public class LoginUser {
	
	private int id;

	@CPF
	private String login;
	
	@NotNull(message="Senha não pode ser nulo")
	@NotBlank(message="Senha não pode ser vázio")
	private String senha;
	

	public LoginUser() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
