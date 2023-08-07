package com.fulltechjava.clonestackoverflow.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;


import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	public Usuario() {
		
	}
	
public Usuario(Integer id) {
		this.id = id;
	}
	
	public Usuario(Integer id, int idGoogle, String email, String nome,List<Pergunta> pergunta, List<Resposta> resposta) {
		super();
		this.id = id;
		this.idGoogle = idGoogle;
		this.email = email;
		this.nome = nome;
		this.respostas = resposta;
		this.perguntas = pergunta;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "GOOGLE_ID")
	private Integer idGoogle;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DATA_CRIACAO")
	private Date data_criacao;
	
	@OneToMany(mappedBy = "usuario")
	private List<Resposta> respostas;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pergunta> perguntas;
	
	public List<Resposta> getResposta() {
		return respostas;
	}
	
	public void setResposta(List<Resposta> resposta) {
		this.respostas = resposta;
	}
	
	public List<Pergunta> getPergunta() {
		return perguntas;
	}
	
	public void setPergunta(List<Pergunta> pergunta) {
		this.perguntas = pergunta;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdGoogle() {
		return idGoogle;
	}

	public void setIdGoogle(Integer idGoogle) {
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
