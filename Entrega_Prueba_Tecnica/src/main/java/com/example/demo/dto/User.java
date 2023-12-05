package com.example.demo.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "first_name")
    private String firstName;
	@Column(name = "last_name")
    private String lastName;
    @NaturalId(mutable = true)
    private String email;
    private String password;
    private String roles;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Favorito",
        joinColumns = { @JoinColumn(name = "Id_Cliente") },
        inverseJoinColumns = { @JoinColumn(name = "Id_Chollo")}
    )
    @JsonIgnoreProperties("clientesFavoritos")
    private List<Parti> partis;
    
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Favorito",
        joinColumns = { @JoinColumn(name = "Id_Cliente") },
        inverseJoinColumns = { @JoinColumn(name = "Id_Chollo")}
    )
    @JsonIgnoreProperties("clientesFavoritos")
    private List<Parti> chollosFavoritos;
	
	@JsonIgnoreProperties("usuarios")
    private List<Partida> partidas;
    
    
    @OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties("mensaje")
    private List<Mensaje> mensajes;
	
	
	public User(){
		
	}
	
    public User(Long id, String firstName, String lastName, String email, String password, String roles,
			List<Parti> partis, List<Partida> partidas, List<Mensaje> mensajes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.partis = partis;
		this.partidas = partidas;
		this.mensajes = mensajes;
	}


	public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}
}