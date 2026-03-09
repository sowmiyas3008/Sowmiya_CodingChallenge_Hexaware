package com.hexaware.hms.dto;

public class PlayerResponseDTO {
	
	private int player_id;
	private String player_name;
	private int jersey_no;
	private String Role;
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
	
	

}
