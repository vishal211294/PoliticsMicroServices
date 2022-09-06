package com.ey.codelab.politicalparty;

public interface PoliticalPartyConstants {
	String POLITICAL_LEADER_SERVICE = "http://POLITICAL-LEADER-SERVICE/political-leader/";
	String POLITICAL_PEOPLE_DEVELOPMENT_SERVICE = "http://PEOPLE-DEVELOPMENT-SERVICE/people-development/";
	
	String GET_POLITICAL_LEADER_SERVICE = POLITICAL_LEADER_SERVICE+"get/leader/{leaderId}";
	String DELETE_POLITICAL_LEADER_SERVICE = POLITICAL_LEADER_SERVICE+"delete/{leaderId}";
	String GET_POLITICAL_LEADERS_SERVICE_BY_PARTY_ID = POLITICAL_LEADER_SERVICE+"get-party-leaders/{partyId}";
	
	String GET_PARTY_PEOPLE_DEVELOPMENT = POLITICAL_PEOPLE_DEVELOPMENT_SERVICE+"get-people-development/party/{partyId}";
	String GET_PARTY_LEADER_PEOPLE_DEVELOPMENT = POLITICAL_PEOPLE_DEVELOPMENT_SERVICE+"get-people-development/leader/{leaderId}";
	String ASSIGN_PEOPLE_DEVELOPMENT_TO_LEADER = POLITICAL_PEOPLE_DEVELOPMENT_SERVICE+"assign";
}
