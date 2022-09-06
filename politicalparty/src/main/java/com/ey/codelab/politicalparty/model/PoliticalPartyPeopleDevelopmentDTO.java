package com.ey.codelab.politicalparty.model;

import java.util.List;

public class PoliticalPartyPeopleDevelopmentDTO {
	private PoliticalPartyDTO politicalParty;
	private List<PeopleDeveleopmentDTO> peopleDevelopments;

	public PoliticalPartyDTO getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(PoliticalPartyDTO politicalParty) {
		this.politicalParty = politicalParty;
	}

	public List<PeopleDeveleopmentDTO> getPeopleDevelopments() {
		return peopleDevelopments;
	}

	public void setPeopleDevelopments(List<PeopleDeveleopmentDTO> peopleDevelopments) {
		this.peopleDevelopments = peopleDevelopments;
	}

	@Override
	public String toString() {
		return "PoliticalPartyPeopleDevelopmentDTO [peopleDevelopments=" + peopleDevelopments + "]";
	}

}
