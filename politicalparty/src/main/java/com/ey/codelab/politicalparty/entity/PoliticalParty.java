package com.ey.codelab.politicalparty.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POLITICAL_PARTY")
public class PoliticalParty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARTY_ID")
	private Integer partyId;
	
	@Column(name = "PARTY_NAME")
	private String partyName;
	
	@Column(name = "FOUNDER_NAME")
	private String founderName;
	
	@Column(name = "FOUNDATION_YEAR")
	private Integer foundationYear;
	
	@Column(columnDefinition = "TIMESTAMP", name = "CREATION_DATE")
	private LocalDateTime creationDate;

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	public Integer getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(Integer foundationYear) {
		this.foundationYear = foundationYear;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "PoliticalParty [partyId=" + partyId + ", partyName=" + partyName + ", founderName=" + founderName
				+ ", foundationYear=" + foundationYear + ", creationDate=" + creationDate + "]";
	}
}