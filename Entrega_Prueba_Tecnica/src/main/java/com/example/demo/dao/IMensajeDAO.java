package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Mensaje;
import com.example.demo.dto.Parti;

public interface IMensajeDAO extends JpaRepository<Mensaje, Integer>{
	
	public List<Parti> findAllByParti (Parti parti);
}
