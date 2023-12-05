package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Parti;

public interface IPartiService {

	public List<Parti> listarPartis(); 
	
	public Parti guardarParti(Parti mensaje);	
	
	public Parti buscarParti(Integer id); 
	
	public Parti actualizarParti(Parti cajero); 
	
	public void eliminarParti(Integer mensaje);
}
