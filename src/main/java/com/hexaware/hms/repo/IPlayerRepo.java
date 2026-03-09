package com.hexaware.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.hms.entity.Player;

public interface IPlayerRepo extends JpaRepository<Player,Integer>{

}
