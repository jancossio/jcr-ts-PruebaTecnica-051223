package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Partida;

public interface IPartidaService {

	public List<Partida> listarPartidas(); 
	
	public Partida guardarPartida(Partida mensaje);	
	
	public Partida buscarPartida(Integer id); 
	
	public Partida actualizarPartida(Partida cajero); 
	
	public void eliminarPartida(Integer mensaje);
}
