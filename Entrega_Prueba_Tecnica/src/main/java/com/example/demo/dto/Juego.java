package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="juegos")
public class Juego {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	
	//@JsonIgnoreProperties
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	private List<Partida> partidas;


	public Juego() {

	}

	public Juego(Integer id, String nombre, List<Partida> partidas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.partidas = partidas;
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

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}
}
