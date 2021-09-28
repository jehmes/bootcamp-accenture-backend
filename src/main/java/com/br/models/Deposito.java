package com.br.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.models.EnderecoDeposito;

// Testando commit...

@Entity
@Table(name = "deposito")
public class Deposito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String nome;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id") 
	private EnderecoDeposito endereco;
	
//	@OneToMany(mappedBy="deposito")
//	private List<User> users;

	public Deposito() {
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
	public EnderecoDeposito getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDeposito endereco) {
		this.endereco = endereco;
	}
//	public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	
	
}
