package com.br.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "user")
@SequenceGenerator(name = "us_seq", sequenceName = "user_sq", initialValue = 1, allocationSize = 1)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	@NotNull(message="Nome não pode ser nulo")
	@NotBlank(message="Nome não pode ser vázio")
	private String nome;
	
	@Column(name = "cpf")
	@CPF
	private String cpf;
	
	@Column(name = "senha")
	@NotNull(message="Senha não pode ser nulo")
	@NotBlank(message="Nome não pode ser vázio")
	private String senha;
	
	@Column(name = "pontos")
	private float pontos;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EnderecoUser endereco;

	@ManyToOne(cascade = CascadeType.ALL)
	private Deposito deposito;
	
	@Column(name = "contato")
	@NotNull(message="Contato não pode ser nulo")
	@NotBlank(message="Contato não pode ser vázio")
	private String contato;
	
	@Column(name = "email")
	@Email
	private String email;
	
	
	
	public User() {
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public float getPontos() {
		return pontos;
	}
	public void setPontos(float pontos) {
		this.pontos = pontos;
	}
	public EnderecoUser getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoUser endereco) {
		this.endereco = endereco;
	}
	public Deposito getDeposito() {
		return deposito;
	}
	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}