package com.hexaware.hms.entity;

import jakarta.persistence.*;

@Entity
@Table(name="players")
public class Player {
	
	@Id
	private int player_id;
	
	private String player_name;
	private int jersey_no;
	private String Role;
	private int total_matches;
	private String team_name;
	private String country_state_name;
	private String description;
	
	public Player() {}
	
	public Player(int player_id, String player_name, int jersey_no, String role, int total_matches, String team_name,
			String country_state_name, String description) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.jersey_no = jersey_no;
		Role = role;
		this.total_matches = total_matches;
		this.team_name = team_name;
		this.country_state_name = country_state_name;
		this.description = description;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}

	public int getJersey_no() {
		return jersey_no;
	}

	public void setJersey_no(int jersey_no) {
		this.jersey_no = jersey_no;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public int getTotal_matches() {
		return total_matches;
	}

	public void setTotal_matches(int total_matches) {
		this.total_matches = total_matches;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getCountry_state_name() {
		return country_state_name;
	}

	public void setCountry_state_name(String country_state_name) {
		this.country_state_name = country_state_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	

}
