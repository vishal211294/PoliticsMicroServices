package com.ey.codelab.politicalleader.service;

import com.ey.codelab.politicalleader.model.PoliticalLeaderDTO;
import com.ey.codelab.politicalleader.model.PoliticalLeaderPeopleDevelopmentDTO;
import com.ey.codelab.politicalleader.model.PoliticalPartyLeadersDTO;

public interface PoliticalLeaderService {
	PoliticalLeaderDTO registerLeader(PoliticalLeaderDTO politicalLeaderDTO);
	boolean deleteLeader(int leaderId);
	PoliticalLeaderDTO getPoliticalLeader(int leaderId);
	PoliticalPartyLeadersDTO getAllPoliticalLeadersByPartyId(int partyId);
	PoliticalLeaderPeopleDevelopmentDTO getAllPoliticalLeaderPeopleDevelopment(int leaderId);
}
