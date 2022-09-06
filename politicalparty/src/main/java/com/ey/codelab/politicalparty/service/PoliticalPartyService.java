package com.ey.codelab.politicalparty.service;

import com.ey.codelab.politicalparty.model.PoliticalPartyAndLeaderDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyLeaderPeopleDevelopmentDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyPeopleDevelopmentDTO;

public interface PoliticalPartyService {
	PoliticalPartyDTO registerPoliticalParty(PoliticalPartyDTO politicalPartyDTO);
	PoliticalPartyDTO getPoliticalParty(int partyId);
	PoliticalPartyAndLeaderDTO getPoliticalPartyAndLeaders(int partyId);
	PoliticalPartyPeopleDevelopmentDTO getPoliticalPartyAndDevelopments(int partyId);
	PoliticalPartyLeaderPeopleDevelopmentDTO getPartyLeaderPeopleDevelopment(int partyId, int leaderId);
}
