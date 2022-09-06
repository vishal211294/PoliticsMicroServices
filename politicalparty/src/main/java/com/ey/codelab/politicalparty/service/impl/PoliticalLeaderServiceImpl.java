package com.ey.codelab.politicalparty.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.codelab.politicalparty.PoliticalPartyConstants;
import com.ey.codelab.politicalparty.model.PoliticalLeaderDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyAndLeaderDTO;
import com.ey.codelab.politicalparty.service.PoliticalLeaderService;
import com.ey.codelab.politicalparty.service.PoliticalPartyService;
import com.ey.codelab.politicalparty.service.exceptions.InvalidPartyAndLeaderDetailException;
import com.ey.codelab.politicalparty.service.exceptions.NoSuchPoliticalLeaderFoundException;

@Service
public class PoliticalLeaderServiceImpl implements PoliticalLeaderService {

	private final PoliticalPartyService politicalPartyService;

	private final RestTemplate restTemplate;

	public PoliticalLeaderServiceImpl(PoliticalPartyService politicalPartyService, RestTemplate restTemplate) {
		super();
		this.politicalPartyService = politicalPartyService;
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean deletePoliticalPartyLeader(int leaderId, int partyId) {
		politicalPartyService.getPoliticalParty(partyId);
		PoliticalLeaderDTO leader = getPartyLeaderDetail(leaderId);
		if (leader.getPartyId() != partyId) {
			throw new InvalidPartyAndLeaderDetailException();
		}
		deletePartyLeaderDetail(leaderId);
		return true;
	}

	@Override
	public PoliticalLeaderDTO getPartyLeaderDetail(int leaderId) {
		ResponseEntity<PoliticalLeaderDTO> response = restTemplate
				.getForEntity(PoliticalPartyConstants.GET_POLITICAL_LEADER_SERVICE, PoliticalLeaderDTO.class, leaderId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		throw new NoSuchPoliticalLeaderFoundException();
	}

	private void deletePartyLeaderDetail(int leaderId) {
		restTemplate.delete(PoliticalPartyConstants.DELETE_POLITICAL_LEADER_SERVICE, leaderId);
	}

	@Override
	public List<PoliticalLeaderDTO> getPoliticalLeadersByPartyId(int partyId) {
		ResponseEntity<PoliticalPartyAndLeaderDTO> response = restTemplate.getForEntity(
				PoliticalPartyConstants.GET_POLITICAL_LEADERS_SERVICE_BY_PARTY_ID, PoliticalPartyAndLeaderDTO.class,
				partyId);
		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody().getPoliticalLeaders();
		}
		throw new NoSuchPoliticalLeaderFoundException();
	}

}
