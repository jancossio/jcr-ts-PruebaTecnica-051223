package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Juego;

public interface IJuegoService {

	public List<Juego> listarJuegos(); 
	
	public Juego guardarJuego(Juego juego);	
	
	public Juego buscarJuego(Integer id); 
	
	public Juego actualizarJuego(Juego cajero); 
	
	public void eliminarJuego(Integer juego);
}
