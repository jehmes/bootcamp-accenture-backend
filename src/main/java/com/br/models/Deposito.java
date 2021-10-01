package com.br.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

// Testando commit...

@Entity
@Table(name = "deposito")
public class Deposito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	@NotNull(message="Nome não pode ser nulo")
	@NotBlank(message="Nome não pode ser vázio")
	@Min(4)
	private String nome;
	
	@Lob
	@Column(name = "url")
	private String url;
	
	@Column(name = "tipo_material")
	private String[] tipoMaterial;
	
	@Column(name = "formato_imagem")
	private String formato_imagem;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id") 
	private EnderecoDeposito endereco;
	
	public Deposito() {
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
	public EnderecoDeposito getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDeposito endereco) {
		this.endereco = endereco;
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

	public String[] getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String[] tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	
	
}
