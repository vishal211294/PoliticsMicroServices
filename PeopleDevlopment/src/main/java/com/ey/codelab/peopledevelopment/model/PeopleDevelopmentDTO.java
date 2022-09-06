package com.ey.codelab.peopledevelopment.model;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class PeopleDevelopmentDTO {
	private Integer developmentId;
	
	@NotNull(message = "Leader id is mandatory.")
	private Integer leaderId;
	
	@NotNull(message = "Party id is mandatory.")
	private Integer partyId;
	
	@NotNull(message = "Development title is mandatory.")
	@Size(min = 5, max = 100, message = "Development title should be in between 5 and 100")
	private String developmentTitle;
	
	@NotNull(message = "Development activity is mandatory.")
	@Size(min = 5, max = 100, message = "Development activity should be in between 5 and 100")
	private String activity;
	
	@NotNull(message = "Development budget is mandatory.")
	@Digits(integer = 100,fraction = 2, message = "Maximum 2 fraction of budget is allowed.")
	private Double budget;
	
	@NotNull(message = "Development state is mandatory.")
	@Size(min = 3, max = 50, message = "Development state should be in between 3 and 50")
	private String state;
	
	@NotNull(message = "Development activity month is mandatory.")
	@Range(min = 1,max = 12)
	private Integer activityMonth;
	
	@NotNull(message = "Development activity year is mandatory.")
	@Range(min = 2022,max = 2027)
	private Integer activityYear;
	
	public Integer getDevelopmentId() {
		return developmentId;
	}
	public void setDevelopmentId(Integer developmentId) {
		this.developmentId = developmentId;
	}
	public Integer getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public String getDevelopmentTitle() {
		return developmentTitle;
	}
	public void setDevelopmentTitle(String developmentTitle) {
		this.developmentTitle = developmentTitle;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getActivityMonth() {
		return activityMonth;
	}
	public void setActivityMonth(Integer activityMonth) {
		this.activityMonth = activityMonth;
	}
	public Integer getActivityYear() {
		return activityYear;
	}
	public void setActivityYear(Integer activityYear) {
		this.activityYear = activityYear;
	}
	@Override
	public String toString() {
		return "PeopleDeveleopmentDTO [developmentId=" + developmentId + ", leaderId=" + leaderId + ", partyId="
				+ partyId + ", developmentTitle=" + developmentTitle + ", activity=" + activity + ", budget=" + budget
				+ ", state=" + state + ", activityMonth=" + activityMonth + ", activityYear=" + activityYear + "]";
	}

	
}
