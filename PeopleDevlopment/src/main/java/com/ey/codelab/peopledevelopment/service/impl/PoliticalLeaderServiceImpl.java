package com.ey.codelab.peopledevelopment.service.impl;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.codelab.peopledevelopment.AppConstants;
import com.ey.codelab.peopledevelopment.customexception.NoSuchPoliticalLeaderFoundException;
import com.ey.codelab.peopledevelopment.model.PoliticalLeaderDTO;
import com.ey.codelab.peopledevelopment.service.PoliticalLeaderService;

@Service
public class PoliticalLeaderServiceImpl implements PoliticalLeaderService {
	private static final Logger logger = Logger.getLogger(PoliticalPartyServiceImpl.class.getName());
	
	private final RestTemplate restTemplate;
	
	public PoliticalLeaderServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public PoliticalLeaderDTO getLeaderDetail(Integer leaderId) {
		logger.info("going to call leader service ["+leaderId+"]");
		ResponseEntity<PoliticalLeaderDTO> response = this.restTemplate.getForEntity(AppConstants.GET_POLITICAL_LEADER_SERVICE, PoliticalLeaderDTO.class,leaderId);
		if(response.getStatusCode() != HttpStatus.OK) {
			logger.severe("error while extracting leader data from api's. code - "+response.getStatusCode());
			throw new NoSuchPoliticalLeaderFoundException();
		}
		return response.getBody();
	}

}
