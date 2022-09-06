package com.ey.codelab.politicalleader.model;

import java.util.List;

public class PoliticalLeaderPeopleDevelopmentDTO {
	private PoliticalLeaderDTO politicalLeader;
	private List<PeopleDeveleopmentDTO> peopleDevelopments;

	
	public PoliticalLeaderDTO getPoliticalLeader() {
		return politicalLeader;
	}

	public void setPoliticalLeader(PoliticalLeaderDTO politicalLeader) {
		this.politicalLeader = politicalLeader;
	}

	public List<PeopleDeveleopmentDTO> getPeopleDevelopments() {
		return peopleDevelopments;
	}

	public void setPeopleDevelopments(List<PeopleDeveleopmentDTO> peopleDevelopments) {
		this.peopleDevelopments = peopleDevelopments;
	}

	@Override
	public String toString() {
		return "PoliticalLeaderPeopleDevelopmentDTO [peopleDevelopments=" + peopleDevelopments + "]";
	}

}
