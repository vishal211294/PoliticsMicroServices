package com.ey.codelab.peopledevelopment;

public interface AppConstants {
	String POLITICAL_LEADER_SERVICE = "http://POLITICAL-LEADER-SERVICE/political-leader/";
	String POLITICAL_PARTY_SERVICE = "http://POLITICAL-PARTY-SERVICE/political-party/";
	String GET_POLITICAL_PARTY_SERVICE = POLITICAL_PARTY_SERVICE + "get/party/{partyId}";
	String GET_POLITICAL_LEADER_SERVICE = POLITICAL_LEADER_SERVICE + "get/leader/{leaderId}";
}