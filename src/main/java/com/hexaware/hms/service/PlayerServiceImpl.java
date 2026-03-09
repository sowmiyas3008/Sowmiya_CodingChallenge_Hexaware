package com.hexaware.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hexaware.hms.dto.PlayerRequestDTO;
import com.hexaware.hms.dto.PlayerResponseDTO;
import com.hexaware.hms.entity.Player;
import com.hexaware.hms.exception.PlayerNotFoundException;
import com.hexaware.hms.repo.IPlayerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private IPlayerRepo repo;

    // Convert Entity -> Response DTO
    private PlayerResponseDTO convertToDTO(Player player) {

        PlayerResponseDTO dto = new PlayerResponseDTO();

        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNo(player.getJerseyNo());
        dto.setRole(player.getRole());

        return dto;
    }

    // Add Player
    @Override
    public PlayerResponseDTO addPlayer(PlayerRequestDTO dto) {

        Player player = new Player();

        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNo(dto.getJerseyNo());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryStateName(dto.getCountryStateName());
        player.setDescription(dto.getDescription());

        Player saved = repo.save(player);

        return convertToDTO(saved);
    }

    // Update Player
    @Override
    public PlayerResponseDTO updatePlayer(int id, PlayerRequestDTO dto) {

        Player player = repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));

        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNo(dto.getJerseyNo());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryStateName(dto.getCountryStateName());
        player.setDescription(dto.getDescription());

        Player updated = repo.save(player);

        return convertToDTO(updated);
    }

    // Delete Player
    @Override
    public void delPlayer(int id) {

        Player player = repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));

        repo.delete(player);
    }

    // Get All Players
    @Override
    public List<PlayerResponseDTO> getAllPlayers() {

        List<Player> players = repo.findAll();

        List<PlayerResponseDTO> response = new ArrayList<>();

        for (Player p : players) {

            PlayerResponseDTO dto = convertToDTO(p);
            response.add(dto);
        }

        return response;
    }

    // Get Player By ID
    @Override
    public PlayerResponseDTO getPlayerById(int id) {

        Player player = repo.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));

        return convertToDTO(player);
    }
    
    @Override
    public List<PlayerResponseDTO> getPlayersByTeamName(String teamName) {

        List<Player> players = repo.getPlayersByTeamName(teamName);

        return players.stream().map(player -> {

            PlayerResponseDTO dto = new PlayerResponseDTO();
            dto.setPlayerId(player.getPlayerId());
            dto.setPlayerName(player.getPlayerName());
            dto.setJerseyNo(player.getJerseyNo());
            dto.setRole(player.getRole());

            return dto;

        }).collect(Collectors.toList());
    }
}