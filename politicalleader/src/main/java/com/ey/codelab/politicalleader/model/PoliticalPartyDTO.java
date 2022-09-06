package com.ey.codelab.politicalleader.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PoliticalPartyDTO {
	
	private Integer partyId;
	
	@NotNull(message = "Party name can't be null.")
	@NotBlank(message = "Party name can't be empty.")
	@Size(min = 5,max = 100 ,message = "minimum 5 and maximum 100 characters are allowed in party name.")
	private String partyName;
	
	@NotNull(message = "Founder name can't be null.")
	@NotBlank(message = "Founder name can't be empty.")
	@Size(min = 5,max = 100 ,message = "Minimum 5 and Maximum 100 characters are allowed in founder name.")
	private String founderName;
	
	@NotNull(message = "Founder Year can't be null.")
	private Integer foundationYear;

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

	@Override
	public String toString() {
		return "PoliticalParty [partyId=" + partyId + ", partyName=" + partyName + ", founderName=" + founderName
				+ ", foundationYear=" + foundationYear + "]";
	}	
}
