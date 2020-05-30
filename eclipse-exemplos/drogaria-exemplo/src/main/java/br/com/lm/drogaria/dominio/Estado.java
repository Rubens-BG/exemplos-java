package br.com.lm.drogaria.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain {
	
	
	
	@Column(length = 2, nullable = false)
	private String sigla;
	@Column(length = 50, nullable = false)
	private String nome;
	
	//Getters e Setters

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
