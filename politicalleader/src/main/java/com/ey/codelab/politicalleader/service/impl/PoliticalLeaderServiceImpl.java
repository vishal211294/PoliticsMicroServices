package com.ey.codelab.politicalleader.service.impl;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.codelab.politicalleader.customexception.NoPoliticalPartyFoundException;
import com.ey.codelab.politicalleader.customexception.NoSuchPoliticalLeaderFoundException;
import com.ey.codelab.politicalleader.entity.PoliticalLeader;
import com.ey.codelab.politicalleader.model.PoliticalLeaderDTO;
import com.ey.codelab.politicalleader.model.PoliticalLeaderPeopleDevelopmentDTO;
import com.ey.codelab.politicalleader.model.PoliticalPartyDTO;
import com.ey.codelab.politicalleader.model.PoliticalPartyLeadersDTO;
import com.ey.codelab.politicalleader.repo.PoliticalLeaderRepository;
import com.ey.codelab.politicalleader.service.PoliticalLeaderService;
import com.ey.codelab.politicalleader.service.PoliticalPeopleDevelopmentService;

@Service
public class PoliticalLeaderServiceImpl implements PoliticalLeaderService {
	private static String POLITICAL_PARTY_URL = "http://POLITICAL-PARTY-SERVICE/political-party/";
	private static Logger logger = Logger.getLogger(PoliticalLeaderService.class.getName());

	private final PoliticalLeaderRepository politicalLeaderRepository;
	private final PoliticalPeopleDevelopmentService politicalPeopleDevelopmentService;
	private final RestTemplate restTemplate;

	public PoliticalLeaderServiceImpl(PoliticalLeaderRepository politicalLeaderRepository, RestTemplate restTemplate,
			PoliticalPeopleDevelopmentService politicalPeopleDevelopmentService) {
		super();
		this.politicalLeaderRepository = politicalLeaderRepository;
		this.restTemplate = restTemplate;
		this.politicalPeopleDevelopmentService = politicalPeopleDevelopmentService;
	}

	@Override
	public PoliticalLeaderDTO registerLeader(PoliticalLeaderDTO politicalLeaderDTO) {
		logger.info("inside political party service. validate political party.");
		getPartyDetail(politicalLeaderDTO.getPartyId());
		logger.info("political party is available. Noiw going to save political leader");
		PoliticalLeader politicalLeader = convertDTOtoEntity(politicalLeaderDTO);
		return convertEntityToDto(politicalLeaderRepository.save(politicalLeader));
	}

	private PoliticalLeader getPoliticalLeaderById(int leaderId) {
		return politicalLeaderRepository.findById(leaderId).orElseThrow(() -> {
			logger.severe("No leader found with id [" + leaderId + "]");
			return new NoSuchPoliticalLeaderFoundException();
		});
	}

	public PoliticalLeaderDTO getPoliticalLeader(int leaderId) {
		return convertEntityToDto(getPoliticalLeaderById(leaderId));
	}

	@Override
	public boolean deleteLeader(int leaderId) {
		logger.finest("going to delete leader from our system.");
		politicalLeaderRepository.deleteById(leaderId);
		logger.info("leader delete from the system.");
		return true;
	}

	@Override
	public PoliticalLeaderPeopleDevelopmentDTO getAllPoliticalLeaderPeopleDevelopment(int leaderId) {
		PoliticalLeaderPeopleDevelopmentDTO politicalLeaderDTO = new PoliticalLeaderPeopleDevelopmentDTO();
		politicalLeaderDTO.setPoliticalLeader(getPoliticalLeader(leaderId));
		politicalLeaderDTO
				.setPeopleDevelopments(politicalPeopleDevelopmentService.getLeaderPeopleDevelopment(leaderId));
		return politicalLeaderDTO;
	}

	@Override
	public PoliticalPartyLeadersDTO getAllPoliticalLeadersByPartyId(int partyId) {
		PoliticalPartyLeadersDTO politicalPartyLeadersDTO = new PoliticalPartyLeadersDTO();
		politicalPartyLeadersDTO.setPoliticalLeaders(
				politicalLeaderRepository.findByPartyId(partyId).stream().map(this::convertEntityToDto).toList());
		return politicalPartyLeadersDTO;
	}

	private PoliticalPartyDTO getPartyDetail(int partyId) throws NoPoliticalPartyFoundException {
		ResponseEntity<PoliticalPartyDTO> responseEntity = restTemplate
				.getForEntity(POLITICAL_PARTY_URL + "get/party/{partyId}", PoliticalPartyDTO.class, partyId);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		}
		logger.info("political party [" + partyId + "] not available.");
		throw new NoPoliticalPartyFoundException("No political party [" + partyId + "] found.");
	}

	private PoliticalLeader convertDTOtoEntity(PoliticalLeaderDTO politicalLeaderDTO) {
		PoliticalLeader politicalLeader = new PoliticalLeader();
		politicalLeader.setLeaderId(politicalLeaderDTO.getLeaderId());
		politicalLeader.setLeaderName(politicalLeaderDTO.getLeaderName());
		politicalLeader.setCreationDate(LocalDateTime.now());
		politicalLeader.setPartyId(politicalLeaderDTO.getPartyId());
		politicalLeader.setLeaderState(politicalLeaderDTO.getLeaderState());
		return politicalLeader;
	}

	private PoliticalLeaderDTO convertEntityToDto(PoliticalLeader politicalLeader) {
		PoliticalLeaderDTO politicalLeaderDTO = new PoliticalLeaderDTO();
		politicalLeaderDTO.setLeaderId(politicalLeader.getLeaderId());
		politicalLeaderDTO.setLeaderName(politicalLeader.getLeaderName());
		politicalLeaderDTO.setPartyId(politicalLeader.getPartyId());
		politicalLeaderDTO.setLeaderState(politicalLeader.getLeaderState());
		return politicalLeaderDTO;
	}
}
