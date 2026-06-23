package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_cricket")
public class CricketDTO extends BaseDTO {

	@Column(name = "player_name", length = 50)
	private String playerName;

	@Column(name = "team", length = 50)
	private String team;

	@Column(name = "role", length = 50)
	private String role;

	@Column(name = "runs")
	private Integer runs;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getRuns() {
		return runs;
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	@Override
	public String getUniqueKey() {
		return "playerName";
	}

	@Override
	public String getUniqueValue() {
		return playerName;
	}

	@Override
	public String getLabel() {
		return playerName;
	}

	@Override
	public String getTableName() {
		return "cricket";
	}
}