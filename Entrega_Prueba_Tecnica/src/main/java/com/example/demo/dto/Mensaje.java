package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mensajes")
public class Mensaje {

	@Id
	@Column(name = "dni")
	private Integer id;
	@Column(name = "texto")
	private String texto;
	
		
	@ManyToOne
	@JsonIgnoreProperties("usuarios")
	@JoinColumn(name = "id")
	User usuario;
			
	@ManyToOne
	@JsonIgnoreProperties("partis")
	@JoinColumn(name = "id")
	Parti parti;
	
	public Mensaje() {

	}

	public Mensaje(Integer id, String texto, User usuario, Parti parti) {
		super();
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.parti = parti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}

