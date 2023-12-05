package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMensajeDAO;
import com.example.demo.dto.Mensaje;
import com.example.demo.dto.Parti;

@Service
public class MensajeService implements IMensajeService{

	@Autowired
	IMensajeDAO iMensajeDAO;
	
	@Override
	public List<Mensaje> listarMensajes(){
		return iMensajeDAO.findAll();
	}
	
	@Override
	public Mensaje guardarMensaje(Mensaje mensaje) {
		return iMensajeDAO.save(mensaje);
	}
	
	@Override
	public Mensaje buscarMensaje(Integer id) {
		return iMensajeDAO.findById(id).get();
	}
	
	@Override
	public Mensaje actualizarMensaje(Mensaje mensaje) {
		return iMensajeDAO.save(mensaje);
	}
	
	@Override
	public void eliminarMensaje(Integer id) {
		iMensajeDAO.deleteById(id);
	}
	
	@Override
	public List<Parti> findLocalidadByNombre(Parti parti) {
		// TODO Auto-generated method stub
		return iMensajeDAO.findAllByParti(parti);
	}
}
