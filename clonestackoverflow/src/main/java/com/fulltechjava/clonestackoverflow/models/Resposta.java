package com.fulltechjava.clonestackoverflow.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resposta {

	public Resposta(String resposta) {
		this.descricao_resposta = resposta;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DESCRICAO_RESPOSTA")
	private String descricao_resposta;
	

	@Column(name = "DATA_RESPOSTA")
	private Date data_resposta;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_pergunta")
	private Pergunta pergunta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResposta() {
		return descricao_resposta;
	}

	public void setResposta(String resposta) {
		this.descricao_resposta = resposta;
	}

	public Date getData_resposta() {
		return data_resposta;
	}

	public void setData_resposta(Date data_resposta) {
		this.data_resposta = data_resposta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	
	
}
