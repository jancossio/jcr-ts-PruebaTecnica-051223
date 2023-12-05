package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="partidas")
public class Partida {

	@Id
	@Column(name = "dni")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	
    @ManyToOne
    @JsonIgnoreProperties("juegos")
    @JoinColumn(name = "id")
    Juego juego;
		
    @ManyToMany(mappedBy = "partidas")
	@JsonIgnore
	private List<User> usuarios;


	public Partida() {

	}

	public Partida(Integer id, String nombre, List<User> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
