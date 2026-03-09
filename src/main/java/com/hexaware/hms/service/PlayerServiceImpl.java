package com.hexaware.hms.service;

import java.util.ArrayList;
import java.util.List;

import com.hexaware.hms.dto.PlayerRequestDTO;
import com.hexaware.hms.dto.PlayerResponseDTO;
import com.hexaware.hms.entity.Player;
import com.hexaware.hms.exception.PlayerNotFoundException;
import com.hexaware.hms.repo.IPlayerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlayerServiceImpl implements IPlayerService{

	
	@Autowired
	private IPlayerRepo repo;
	
	private PlayerResponseDTO convertToDTO(Player player) {
		PlayerResponseDTO dto = new PlayerResponseDTO();
		dto.setPlayer_id(player.getPlayer_id());
		dto.setPlayer_name(player.getPlayer_name());
		dto.setJersey_no(player.getJersey_no());
		dto.setRole(player.getRole());
		
		return dto;
	}
	@Override
	public PlayerResponseDTO addPlayer(PlayerRequestDTO dto) {
		Player player = new Player();
		
		player.setPlayer_name(dto.getPlayer_name());
		player.setJersey_no(dto.getJersey_no());
		player.setRole(dto.getRole());
		player.setTotal_matches(dto.getTotal_matches());
		player.setTeam_name(dto.getTeam_name());
		player.setCountry_state_name(dto.getCountry_state_name());
		player.setDescription(dto.getDescription());
		
		Player saved = repo.save(player);
		return convertToDTO(saved);
	}

	@Override
	public PlayerResponseDTO updatePlayer(int id, PlayerRequestDTO dto) {
		Player player = repo.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
		
		player.setPlayer_name(dto.getPlayer_name());
		player.setJersey_no(dto.getJersey_no());
		player.setRole(dto.getRole());
		player.setTotal_matches(dto.getTotal_matches());
		player.setTeam_name(dto.getTeam_name());
		player.setCountry_state_name(dto.getCountry_state_name());
		player.setDescription(dto.getDescription());
		
		Player updated = repo.save(player);
		
		return convertToDTO(updated);
	}

	@Override
	public void delPlayer(int id) {
        Player player = repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));

        repo.delete(player);
	}

	@Override
	public List<PlayerResponseDTO> getAllPlayers() {
		
		List<Player> players = repo.findAll();
		List<PlayerResponseDTO> res = new ArrayList<>();
		
		for(Player p : players) {
			PlayerResponseDTO dto = convertToDTO(p);
			res.add(dto);
		}
		return res;
	}

	@Override
	public PlayerResponseDTO getPlayerById(int id) {
        Player player = repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));

        PlayerResponseDTO dto = convertToDTO(player);

        return dto;

	}

	
	
	

}
