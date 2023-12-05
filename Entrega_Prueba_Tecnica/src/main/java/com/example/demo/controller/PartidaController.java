package com.example.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Partida;
import com.example.demo.services.JuegoService;
import com.example.demo.services.PartiService;
import com.example.demo.services.PartidaService;

@RestController
@RequestMapping("/partida")
public class PartidaController {

	@Autowired
	PartidaService partidaService;
	@Autowired
	JuegoService juegoService;
	@Autowired
	PartiService partiService;
	
	@GetMapping("/all")
	public List<Partida> listarPartidas(){
		return partidaService.listarPartidas();
	}
	
	
	@PostMapping("/add")
	public Partida salvarPartida(@RequestBody Partida partida) {
		
		return partidaService.guardarPartida(partida);
	}
	
	
	@GetMapping("/{codigo}")
	public Partida buscarPartida(@PathVariable(name="codigo") Integer id) {
		
		Partida Partida_xid= new Partida();
		
		Partida_xid=partidaService.buscarPartida(id);
		
		return Partida_xid;
	}
	
	@PutMapping("/{codigo}")
	public Partida actualizarPartida(@PathVariable(name="codigo")Integer id,@RequestBody Partida partida) {
		
		Partida Parti_seleccionado= new Partida();
		Partida Parti_actualizado= new Partida();
		
		Parti_seleccionado= partidaService.buscarPartida(id);
		
		Parti_seleccionado.setNombre(partida.getNombre());
		
		Parti_actualizado = partidaService.actualizarPartida(Parti_seleccionado);
				
		return Parti_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarPartida(@PathVariable(name="codigo")Integer id) {
		partidaService.eliminarPartida(id);
	}
}
