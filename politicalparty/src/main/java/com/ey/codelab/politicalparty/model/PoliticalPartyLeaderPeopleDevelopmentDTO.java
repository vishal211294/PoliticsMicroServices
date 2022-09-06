package com.ey.codelab.politicalparty.model;

import java.util.List;

public class PoliticalPartyLeaderPeopleDevelopmentDTO {
	private PoliticalLeaderDTO politicalLeader;
	private PoliticalPartyDTO politicalParty;
	private List<PeopleDeveleopmentDTO> peopleDeveleopmentDTO;

	public PoliticalLeaderDTO getPoliticalLeader() {
		return politicalLeader;
	}

	public void setPoliticalLeader(PoliticalLeaderDTO politicalLeader) {
		this.politicalLeader = politicalLeader;
	}

	public PoliticalPartyDTO getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(PoliticalPartyDTO politicalParty) {
		this.politicalParty = politicalParty;
	}

	public List<PeopleDeveleopmentDTO> getPeopleDeveleopmentDTO() {
		return peopleDeveleopmentDTO;
	}

	public void setPeopleDeveleopmentDTO(List<PeopleDeveleopmentDTO> peopleDeveleopmentDTO) {
		this.peopleDeveleopmentDTO = peopleDeveleopmentDTO;
	}

	@Override
	public String toString() {
		return "PoliticalPartyLeaderPeopleDevelopmentDTO [politicalLeader=" + politicalLeader + ", politicalParty="
				+ politicalParty + ", peopleDeveleopmentDTO=" + peopleDeveleopmentDTO + "]";
	}

}
