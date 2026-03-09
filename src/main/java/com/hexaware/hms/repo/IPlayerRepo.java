package com.hexaware.hms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.hms.entity.Player;

public interface IPlayerRepo extends JpaRepository<Player,Integer>{

    @Query("SELECT p FROM Player p WHERE p.teamName = :teamName")
    List<Player> getPlayersByTeamName(String teamName);

}
