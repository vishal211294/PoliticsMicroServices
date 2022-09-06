package com.ey.codelab.politicalparty.model;

import java.util.List;

public class PoliticalPartyAndLeaderDTO {
	private PoliticalPartyDTO politicalParty;
	private List<PoliticalLeaderDTO> politicalLeaders;

	
	public PoliticalPartyDTO getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(PoliticalPartyDTO politicalParty) {
		this.politicalParty = politicalParty;
	}

	public List<PoliticalLeaderDTO> getPoliticalLeaders() {
		return politicalLeaders;
	}

	public void setPoliticalLeaders(List<PoliticalLeaderDTO> politicalLeaders) {
		this.politicalLeaders = politicalLeaders;
	}

	@Override
	public String toString() {
		return "PoliticalPartyAndLeaderDetail [politicalLeaders=" + politicalLeaders + "]";
	}
}
