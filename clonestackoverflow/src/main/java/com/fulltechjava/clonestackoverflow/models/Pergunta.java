package com.fulltechjava.clonestackoverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "perguntas")
public class Pergunta {

	public Pergunta() {

	}	
	

	public Pergunta( String tituloPergunta, String descricao_pergunta, Usuario usuario) {
		super();
		
		this.tituloPergunta = tituloPergunta;
		this.descricao_pergunta = descricao_pergunta;
		this.usuario = usuario;
	}

	public Pergunta(String descricao_pergunta) {
		this.descricao_pergunta = descricao_pergunta;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TITULO_PERGUNTA")
	private String tituloPergunta;

	@Column(name = "DESCRICAO_PERGUNTA")
	private String descricao_pergunta;

	@Column(name = "DATA_PERGUNTA")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date data_pergunta;

	@ManyToOne
	@JoinColumn(name = "GOOGLE_ID_USUARIO")
	private Usuario usuario;

	@OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Resposta> respostas;

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo_pergunta() {
		return tituloPergunta;
	}


	public void setTitulo_pergunta(String titulo_pergunta) {
		this.tituloPergunta = titulo_pergunta;
	}


	public String getDescricao_pergunta() {
		return descricao_pergunta;
	}


	public void setDescricao_pergunta(String descricao_pergunta) {
		this.descricao_pergunta = descricao_pergunta;
	}


	public Date getData_pergunta() {
		return data_pergunta;
	}


	public void setData_pergunta(Date data_pergunta) {
		this.data_pergunta = data_pergunta;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Resposta> getRespostas() {
		return respostas;
	}


	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	

}