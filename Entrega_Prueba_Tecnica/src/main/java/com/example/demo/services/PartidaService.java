package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMensajeDAO;
import com.example.demo.dao.IPartidaDAO;
import com.example.demo.dto.Mensaje;
import com.example.demo.dto.Partida;

@Service
public class PartidaService implements IPartidaService{

	@Autowired
	IPartidaDAO iPartidaDAO;
	
	@Override
	public List<Partida> listarPartidas(){
		return iPartidaDAO.findAll();
	}
	
	@Override
	public Partida guardarPartida(Partida partida) {
		return iPartidaDAO.save(partida);
	}
	
	@Override
	public Partida buscarPartida(Integer id) {
		return iPartidaDAO.findById(id).get();
	}
	
	@Override
	public Partida actualizarPartida(Partida partida) {
		return iPartidaDAO.save(partida);
	}
	
	@Override
	public void eliminarPartida(Integer id) {
		iPartidaDAO.deleteById(id);
	}
}
