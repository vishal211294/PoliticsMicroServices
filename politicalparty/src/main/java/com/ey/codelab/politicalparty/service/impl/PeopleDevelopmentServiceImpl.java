package com.ey.codelab.politicalparty.service.impl;

import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.codelab.politicalparty.PoliticalPartyConstants;
import com.ey.codelab.politicalparty.model.PeopleDeveleopmentDTO;
import com.ey.codelab.politicalparty.service.PeopleDevelopmentService;
@Service
public class PeopleDevelopmentServiceImpl implements PeopleDevelopmentService {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public List<PeopleDeveleopmentDTO> getPartyPeopleDevelopment(int partyId) {
		return this.restTemplate.getForObject(PoliticalPartyConstants.GET_PARTY_PEOPLE_DEVELOPMENT, List.class,partyId);
	}
	
	
	@Override
	public PeopleDeveleopmentDTO assignPeopleDevelopment(PeopleDeveleopmentDTO peopleDeveleopmentDTO) {
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PeopleDeveleopmentDTO> entity = new HttpEntity<PeopleDeveleopmentDTO>(peopleDeveleopmentDTO,httpHeaders);
		return this.restTemplate.postForObject(PoliticalPartyConstants.ASSIGN_PEOPLE_DEVELOPMENT_TO_LEADER, entity,PeopleDeveleopmentDTO.class);
	}
	
	@Override
	public List<PeopleDeveleopmentDTO> getPeopleDevelopment(int leaderId) {
		return this.restTemplate.getForObject(PoliticalPartyConstants.GET_PARTY_LEADER_PEOPLE_DEVELOPMENT, List.class,leaderId);
	}

}
