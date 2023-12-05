package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="partis")
public class Parti {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	
    @ManyToMany(mappedBy = "partidas")
	@JsonIgnore
	private List<User> usuarios;
    
    @OneToMany(mappedBy = "parti")
	@JsonIgnoreProperties("mensaje")
    private List<Mensaje> mensajes;
	
	//Constructores
	
    
    public Parti() {
		
	}

	public Parti(Integer id, String nombre, Integer precio, List<User> usuarios) {
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
