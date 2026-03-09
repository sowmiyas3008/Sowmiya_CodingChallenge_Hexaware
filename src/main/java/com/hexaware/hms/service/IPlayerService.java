package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.dto.PlayerRequestDTO;
import com.hexaware.hms.dto.PlayerResponseDTO;
import com.hexaware.hms.entity.Player;

public interface IPlayerService {
	PlayerResponseDTO addPlayer(PlayerRequestDTO dto);
	PlayerResponseDTO updatePlayer(int id, PlayerRequestDTO dto);
	void delPlayer(int id);
	
	List<PlayerResponseDTO> getAllPlayers();
	PlayerResponseDTO getPlayerById(int id);
	
	List<PlayerResponseDTO> getPlayersByTeamName(String teamName);

}
