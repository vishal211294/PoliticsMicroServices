package com.ey.codelab.politicalleader.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POLITICAL_LEADER")
public class PoliticalLeader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEADER_ID", nullable = false, length = 5)
	private Integer leaderId;
	
	@Column(name = "LEADER_NAME", nullable = false, length = 100)
	private String leaderName;
	
	@Column(name = "PARTY_ID", nullable = false, length = 5)
	private Integer partyId;

	@Column(name = "LEADER_STATE", nullable = false, length = 100)
	private String leaderState;
	
	@Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP")
	private LocalDateTime creationDate;

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

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "PoliticalLeader [leaderId=" + leaderId + ", leaderName=" + leaderName + ", partyId=" + partyId
				+ ", leaderState=" + leaderState + ", creationDate=" + creationDate + "]";
	}	
}
