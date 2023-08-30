package com.fulltechjava.clonestackoverflow.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respostas")
public class Resposta {
	
	public Resposta() {
		
	}

	public Resposta(String resposta) {
		this.descricao_resposta = resposta;
	}
	
	public Resposta(Integer id, String descricao_resposta, Date data_resposta, Pergunta pergunta, Usuario usuario) {
		
	}
	
	
	public Resposta( String descricao_resposta, Usuario usuario, Pergunta pergunta) {
		super();
		
		this.descricao_resposta = descricao_resposta;
		this.usuario = usuario;
		this.pergunta = pergunta;
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
	@JoinColumn(name = "GOOGLE_ID_USUARIO")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERGUNTA")
	private Pergunta pergunta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao_resposta() {
		return descricao_resposta;
	}

	public void setDescricao_resposta(String descricao_resposta) {
		this.descricao_resposta = descricao_resposta;
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

	@Override
	public String toString() {
		return "Resposta [id=" + id + ", descricao_resposta=" + descricao_resposta + ", data_resposta=" + data_resposta;
	}
}
