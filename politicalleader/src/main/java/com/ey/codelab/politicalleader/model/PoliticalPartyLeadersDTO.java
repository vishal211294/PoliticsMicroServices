package com.ey.codelab.politicalleader.model;

import java.util.List;

public class PoliticalPartyLeadersDTO {
	private List<PoliticalLeaderDTO> politicalLeaders;

	public List<PoliticalLeaderDTO> getPoliticalLeaders() {
		return politicalLeaders;
	}

	public void setPoliticalLeaders(List<PoliticalLeaderDTO> politicalLeaders) {
		this.politicalLeaders = politicalLeaders;
	}

	@Override
	public String toString() {
		return "PoliticalPartyLeadersDTO [politicalLeaders=" + politicalLeaders + "]";
	}

}
