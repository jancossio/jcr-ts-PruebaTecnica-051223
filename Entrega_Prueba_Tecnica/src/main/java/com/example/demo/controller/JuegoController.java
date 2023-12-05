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
import com.example.demo.services.JuegoService;

@RestController
@RequestMapping("/juego")
public class JuegoController {

	@Autowired
	JuegoService juegoService;
	
	@GetMapping("/all")
	public List<Juego> listarCajeros(){
		return juegoService.listarJuegos();
	}
	
	
	@PostMapping("/add")
	public Juego salvarCajero(@RequestBody Juego juego) {
		
		return juegoService.guardarJuego(juego);
	}
	
	
	@GetMapping("/{codigo}")
	public Juego buscarJuego(@PathVariable(name="codigo") Integer id) {
		
		Juego Juego_xid= new Juego();
		
		Juego_xid=juegoService.buscarJuego(id);
		
		return Juego_xid;
	}
	
	@PutMapping("/{codigo}")
	public Juego actualizarCajero(@PathVariable(name="codigo")Integer id,@RequestBody Juego juego) {
		
		Juego Juego_seleccionado= new Juego();
		Juego Juego_actualizado= new Juego();
		
		Juego_seleccionado= juegoService.buscarJuego(id);
		
		Juego_seleccionado.setNombre(juego.getNombre());
		
		Juego_actualizado = juegoService.actualizarJuego(Juego_seleccionado);
				
		return Juego_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarCajero(@PathVariable(name="codigo")Integer id) {
		juegoService.eliminarJuego(id);
	}
}
