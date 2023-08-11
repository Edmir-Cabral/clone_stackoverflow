package com.fulltechjava.clonestackoverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
	public Usuario(Integer id) {
		this.id = id;
	}
	
	public Usuario(String email, String idGoogle, String nome) {
		this.email = email;
		this.idGoogle = idGoogle;
		this.nome = nome;
	}
	
	public Usuario(Integer id, String idGoogle, String email, String nome) {
		super();
		this.id = id;
		this.idGoogle = idGoogle;
		this.email = email;
		this.nome = nome;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
