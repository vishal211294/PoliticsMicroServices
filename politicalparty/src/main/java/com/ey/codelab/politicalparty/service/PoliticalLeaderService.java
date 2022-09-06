package com.ey.codelab.politicalparty.service;

import java.util.List;

import com.ey.codelab.politicalparty.model.PoliticalLeaderDTO;

public interface PoliticalLeaderService {
	boolean deletePoliticalPartyLeader(int leaderId,int partyId);

	List<PoliticalLeaderDTO> getPoliticalLeadersByPartyId(int partyId);

	PoliticalLeaderDTO getPartyLeaderDetail(int leaderId);
}
