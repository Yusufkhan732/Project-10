package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CricketDTO;

public class CricketForm extends BaseForm {

	@NotEmpty(message = "Player Name is required")
	private String playerName;

	@NotEmpty(message = "Team is required")
	private String team;

	@NotEmpty(message = "Role is required")
	private String role;

	@NotNull(message = "Runs is required")
	@Min(value = 0, message = "Runs cannot be negative")
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
	public BaseDTO getDto() {

		CricketDTO dto = initDTO(new CricketDTO());

		dto.setPlayerName(playerName);
		dto.setTeam(team);
		dto.setRole(role);
		dto.setRuns(runs);

		return dto;
	}
}