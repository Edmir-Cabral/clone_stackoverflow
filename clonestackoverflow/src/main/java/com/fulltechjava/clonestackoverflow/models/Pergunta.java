package com.fulltechjava.clonestackoverflow.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "TITULO_PERGUNTA")
	private String titulo_pergunta;
	
	@Column(name = "DESCRICAO_PERGUNTA")
	private String descricao_pergunta;
	
	@Column(name = "DATA_PERGUNTA")
	private Date data_pergunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "resposta")
	private List<Resposta> respostas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo_pergunta() {
		return titulo_pergunta;
	}

	public void setTitulo_pergunta(String titulo_pergunta) {
		this.titulo_pergunta = titulo_pergunta;
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
	
}
