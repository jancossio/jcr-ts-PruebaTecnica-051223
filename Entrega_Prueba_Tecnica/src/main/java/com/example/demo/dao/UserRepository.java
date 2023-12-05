package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Partida;
import com.example.demo.dto.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    	
	Optional<User> findByEmail(String email);
    	
	void deleteByEmail(String email);
	
	List<Partida> findByJuego(Partida partida);

}