package com.ey.codelab.peopledevelopment.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PEOPLE_DEVELOPMENT")
public class PeopleDevelopment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 8, nullable = false, name = "DEVELOPMENT_ID")
	private Integer developmentId;

	@Column(length = 8, nullable = false, name = "PARTY_ID")
	private Integer partyId;

	@Column(length = 8, nullable = false, name = "LEADER_ID")
	private Integer leaderId;

	@Column(length = 100, nullable = false, name = "ACTIVITY")
	private String activity;

	@Column(length = 100, nullable = false, name = "DEVELOPMENT_TITLE")
	private String developmentTitle;

	@Column(length = 50, nullable = false, name = "STATE")
	private String state;

	@Column(length = 15, nullable = false, name = "BUDGET", precision = 2)
	private Double budget;

	@Column(length = 4, nullable = false, name = "ACTIVITY_YEAR")
	private Integer activityYear;

	@Column(length = 2, nullable = false, name = "ACTIVITY_MONTH")
	private Integer activityMonth;

	@Column(nullable = false, name = "CREATION_DATE", columnDefinition = "TIMESTAMP")
	private LocalDateTime creationDate;

	public Integer getDevelopmentId() {
		return developmentId;
	}

	public void setDevelopmentId(Integer developmentId) {
		this.developmentId = developmentId;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public Integer getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getDevelopmentTitle() {
		return developmentTitle;
	}

	public void setDevelopmentTitle(String developmentTitle) {
		this.developmentTitle = developmentTitle;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Integer getActivityYear() {
		return activityYear;
	}

	public void setActivityYear(Integer activityYear) {
		this.activityYear = activityYear;
	}

	public Integer getActivityMonth() {
		return activityMonth;
	}

	public void setActivityMonth(Integer activityMonth) {
		this.activityMonth = activityMonth;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "PeopleDevelopment [developmentId=" + developmentId + ", partyId=" + partyId + ", leaderId=" + leaderId
				+ ", activity=" + activity + ", developmentTitle=" + developmentTitle + ", state=" + state + ", budget="
				+ budget + ", activityYear=" + activityYear + ", activityMonth=" + activityMonth + ", creationDate="
				+ creationDate + "]";
	}

}
