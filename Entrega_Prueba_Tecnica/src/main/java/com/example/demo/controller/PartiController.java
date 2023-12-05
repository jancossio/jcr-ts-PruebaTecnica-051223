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

import com.example.demo.dto.Parti;
import com.example.demo.services.PartiService;

@RestController
@RequestMapping("/parti")
public class PartiController {

	@Autowired
	PartiService partiService;
	
	@GetMapping("/all")
	public List<Parti> listarPartis(){
		return partiService.listarPartis();
	}
	
	
	@PostMapping("/add")
	public Parti salvarParti(@RequestBody Parti parti) {
		
		return partiService.guardarParti(parti);
	}
	
	
	@GetMapping("/{codigo}")
	public Parti buscarParti(@PathVariable(name="codigo") Integer id) {
		
		Parti Mensaje_xid= new Parti();
		
		Mensaje_xid=partiService.buscarParti(id);
		
		return Mensaje_xid;
	}
	
	@PutMapping("/{codigo}")
	public Parti actualizarParti(@PathVariable(name="codigo")Integer id,@RequestBody Parti parti) {
		
		Parti Parti_seleccionado= new Parti();
		Parti Parti_actualizado= new Parti();
		
		Parti_seleccionado= partiService.buscarParti(id);
		
		Parti_seleccionado.setNombre(parti.getNombre());
		
		Parti_actualizado = partiService.actualizarParti(Parti_seleccionado);
				
		return Parti_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eleiminarParti(@PathVariable(name="codigo")Integer id) {
		partiService.eliminarParti(id);
	}
}
