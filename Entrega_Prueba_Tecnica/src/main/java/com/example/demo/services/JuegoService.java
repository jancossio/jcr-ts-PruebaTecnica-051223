package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IJuegoDAO;
import com.example.demo.dto.Juego;

@Service
public class JuegoService implements IJuegoService{

	@Autowired
	IJuegoDAO iJuegoDAO;
	
	@Override
	public List<Juego> listarJuegos(){
		return iJuegoDAO.findAll();
	}
	
	@Override
	public Juego guardarJuego(Juego cajero) {
		return iJuegoDAO.save(cajero);
	}
	
	@Override
	public Juego buscarJuego(Integer id) {
		return iJuegoDAO.findById(id).get();
	}
	
	@Override
	public Juego actualizarJuego(Juego cajero) {
		return iJuegoDAO.save(cajero);
	}
	
	@Override
	public void eliminarJuego(Integer id) {
		iJuegoDAO.deleteById(id);
	}
}
