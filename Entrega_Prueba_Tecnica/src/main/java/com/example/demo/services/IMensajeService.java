package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Mensaje;

public interface IMensajeService {

	public List<Mensaje> listarMensajes(); 
	
	public Mensaje guardarMensaje(Mensaje mensaje);	
	
	public Mensaje buscarMensaje(Integer id); 
	
	public Mensaje actualizarMensaje(Mensaje cajero); 
	
	public void eliminarMensaje(Integer mensaje);
}
