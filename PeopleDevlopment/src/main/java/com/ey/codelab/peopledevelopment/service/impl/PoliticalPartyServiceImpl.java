package com.ey.codelab.peopledevelopment.service.impl;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.codelab.peopledevelopment.AppConstants;
import com.ey.codelab.peopledevelopment.customexception.NoSuchPoliticalPartyFoundException;
import com.ey.codelab.peopledevelopment.model.PoliticalPartyDTO;
import com.ey.codelab.peopledevelopment.service.PoliticalPartyService;

@Service
public class PoliticalPartyServiceImpl implements PoliticalPartyService {
	private static final Logger logger = Logger.getLogger(PoliticalPartyServiceImpl.class.getName());
	private final RestTemplate restTemplate;

	public PoliticalPartyServiceImpl(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public PoliticalPartyDTO getPartyDetail(int partyId) {
		logger.info("going to call party service [" + partyId + "]");
		ResponseEntity<PoliticalPartyDTO> response = this.restTemplate
				.getForEntity(AppConstants.GET_POLITICAL_PARTY_SERVICE, PoliticalPartyDTO.class, partyId);
		if (response.getStatusCode() != HttpStatus.OK) {
			logger.severe("error while call party service api status code ["+response.getStatusCode()+"]");
			throw new NoSuchPoliticalPartyFoundException();
		}
		return response.getBody();
	}

}
