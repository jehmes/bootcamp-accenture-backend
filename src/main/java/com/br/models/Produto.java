package com.br.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	@NotNull(message="Nome não pode ser nulo")
	@NotBlank(message="Nome não pode ser vázio")
	private String nome;
	
	@Column(name = "preco")  
	private float preco;
	
	@Column(name = "preco_total")
	private float precoTotal;
	
	@Column(name = "descricao")
	@NotNull(message="Descrição não pode ser nulo")
	@NotBlank(message="Descrição não pode ser vázio")
	private String descricao;
	
	@Lob
	@Column(name = "url")
	private String url;
	
	@Column(name = "formato_imagem")
	private String formato_imagem;

	public Produto() {
		super();
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

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(float precoTotal) {
		this.precoTotal = precoTotal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFormato_imagem() {
		return formato_imagem;
	}

	public void setFormato_imagem(String formato_imagem) {
		this.formato_imagem = formato_imagem;
	}

	
}
