package com.hexaware.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.hms.dto.PlayerRequestDTO;
import com.hexaware.hms.dto.PlayerResponseDTO;
import com.hexaware.hms.service.IPlayerService;

@RestController
@RequestMapping("api/players")
public class PlayerController {
	@Autowired 
	private IPlayerService service;
	
	@PostMapping
	public PlayerResponseDTO addPlayer(@RequestBody PlayerRequestDTO dto) {
		return service.addPlayer(dto);
	}
	
	@PutMapping("/{id}")
	public PlayerResponseDTO updatePlayer(@PathVariable int id,@RequestBody PlayerRequestDTO dto) {
		return service.updatePlayer(id,dto);
	}
	
	@DeleteMapping("/{id}")
	public void delPlayer(@PathVariable int id) {
		service.delPlayer(id);
	}
	
	@GetMapping
	public List<PlayerResponseDTO> getAllPlayers(){
		return service.getAllPlayers();
	}
	
	@GetMapping("/{id}")
	public PlayerResponseDTO getPlayerById(@PathVariable int id) {
		return service.getPlayerById(id);
		
	}

}
