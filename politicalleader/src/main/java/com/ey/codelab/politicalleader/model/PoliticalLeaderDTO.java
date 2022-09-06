package com.ey.codelab.politicalleader.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PoliticalLeaderDTO {
	
	private Integer leaderId;
	
	@NotNull(message = "Leader name can't be empty.")
	@Size(min = 5,max = 100,message = "Minimum 5 and Maximum 100 characters are allowed for leader name.")
	private String leaderName;
	
	@NotNull(message = "Party id is required for party leader.")
	private Integer partyId;

	@NotNull(message = "Leader state can't be empty.")
	@Size(min = 5,max = 100,message = "Minimum 5 and Maximum 100 characters are allowed for leader state.")
	private String leaderState;
	
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public String getLeaderState() {
		return leaderState;
	}
	public void setLeaderState(String leaderState) {
		this.leaderState = leaderState;
	}
	
	@Override
	public String toString() {
		return "PoliticalLeaderDTO [leaderId=" + leaderId + ", leaderName=" + leaderName + ", partyId=" + partyId
				+ ", leaderState=" + leaderState + "]";
	}
}
