package com.fulltechjava.clonestackoverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	public Usuario() {
		
	}
	
	public Usuario(String idGoogle, String email, String nome) {
		super();
		this.idGoogle = idGoogle;
		this.email = email;
		this.nome = nome;
	}
	
	@Id
	@Column(name = "GOOGLE_ID")
	private String idGoogle;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "NOME")
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CRIACAO")
	private Date data_criacao;
	
	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
	private List<Pergunta> pergunta;
	
	@OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
	private List<Resposta> resposta;


	public String getIdGoogle() {
		return idGoogle;
	}

	public void setIdGoogle(String idGoogle) {
		this.idGoogle = idGoogle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	
	
}
