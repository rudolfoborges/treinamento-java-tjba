package br.jus.tjba.treinamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contato")
public class Contato {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=100)
	private String nome;
	
	@Column(nullable=false, length=100)
	private String email;
	
	@Column(name="numero_telefone", length=11)
	private Long numeroTelefone;
	
	@Column(name="numero_celular", length=11)
	private Long numeroCelular;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Long numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Long getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(Long numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
}
