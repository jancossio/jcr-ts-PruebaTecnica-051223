package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.IPartiDAO;
import com.example.demo.dto.Parti;

public class PartiService implements IPartiService{

	@Autowired
	IPartiDAO iPartiDAO;
	
	@Override
	public List<Parti> listarPartis(){
		return iPartiDAO.findAll();
	}
	
	@Override
	public Parti guardarParti(Parti partida) {
		return iPartiDAO.save(partida);
	}
	
	@Override
	public Parti buscarParti(Integer id) {
		return iPartiDAO.findById(id).get();
	}
	
	@Override
	public Parti actualizarParti(Parti partida) {
		return iPartiDAO.save(partida);
	}
	
	@Override
	public void eliminarParti(Integer id) {
		iPartiDAO.deleteById(id);
	}
}
