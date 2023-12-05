package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Juego;
import com.example.demo.dto.Mensaje;
import com.example.demo.services.JuegoService;
import com.example.demo.services.MensajeService;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {

	@Autowired
	MensajeService mensajeService;
	
	@GetMapping("/all")
	public List<Mensaje> listarMensajes(){
		return mensajeService.listarMensajes();
	}
	
	
	@PostMapping("/add")
	public Mensaje salvarMensaje(@RequestBody Mensaje mensaje) {
		
		return mensajeService.guardarMensaje(mensaje);
	}
	
	
	@GetMapping("/{codigo}")
	public Mensaje buscarMensaje(@PathVariable(name="codigo") Integer id) {
		
		Mensaje Mensaje_xid= new Mensaje();
		
		Mensaje_xid=mensajeService.buscarMensaje(id);
		
		return Mensaje_xid;
	}
	
	@PutMapping("/{codigo}")
	public Mensaje actualizarMensaje(@PathVariable(name="codigo")Integer id,@RequestBody Mensaje mensaje) {
		
		Mensaje Mensaje_seleccionado= new Mensaje();
		Mensaje Mensaje_actualizado= new Mensaje();
		
		Mensaje_seleccionado= mensajeService.buscarMensaje(id);
		
		Mensaje_seleccionado.setTexto(mensaje.getTexto());
		
		Mensaje_actualizado = mensajeService.actualizarMensaje(Mensaje_seleccionado);
				
		return Mensaje_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarMensaje(@PathVariable(name="codigo")Integer id) {
		mensajeService.eliminarMensaje(id);
	}
}
