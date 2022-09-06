package com.ey.codelab.politicalparty.service.impl;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ey.codelab.politicalparty.dao.PoliticalPartyRepository;
import com.ey.codelab.politicalparty.entity.PoliticalParty;
import com.ey.codelab.politicalparty.model.PoliticalLeaderDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyAndLeaderDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyLeaderPeopleDevelopmentDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyPeopleDevelopmentDTO;
import com.ey.codelab.politicalparty.service.PeopleDevelopmentService;
import com.ey.codelab.politicalparty.service.PoliticalLeaderService;
import com.ey.codelab.politicalparty.service.PoliticalPartyService;
import com.ey.codelab.politicalparty.service.exceptions.InvalidPartyAndLeaderDetailException;
import com.ey.codelab.politicalparty.service.exceptions.NoSuchPoliticalPartyFoundException;

@Service
public class PoliticalPartyServiceImpl implements PoliticalPartyService {

	private static Logger logger = Logger.getLogger(PoliticalPartyService.class.getName());

	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;
	
	@Autowired
	@Lazy
	private PoliticalLeaderService politicalLeaderService;

	
	@Autowired
	private PeopleDevelopmentService peopleDevelopmentService;
	
	@Override
	public PoliticalPartyDTO registerPoliticalParty(PoliticalPartyDTO politicalPartyDTO) {
		PoliticalParty politicalParty = convertDTOtoEntity(politicalPartyDTO);
		return convertEntityToDTO(politicalPartyRepository.saveAndFlush(politicalParty));
	}

	@Override
	public PoliticalPartyDTO getPoliticalParty(int partyId) {
		logger.info("Going to find political party for id [" + partyId + "]");
		
		return convertEntityToDTO(politicalPartyRepository.findById(partyId).orElseThrow(() -> {
			logger.warning("No such political party found, going to raise error.");
			return new NoSuchPoliticalPartyFoundException();
		}));
	}

	
	@Override
	public PoliticalPartyAndLeaderDTO getPoliticalPartyAndLeaders(int partyId) {
		 PoliticalPartyAndLeaderDTO politicalPartyAndLeaderDTO = new PoliticalPartyAndLeaderDTO();
		 PoliticalPartyDTO politicalPartyDTO = this.getPoliticalParty(partyId);
		 politicalPartyAndLeaderDTO = new PoliticalPartyAndLeaderDTO();
		 politicalPartyAndLeaderDTO.setPoliticalParty(politicalPartyDTO);
		 politicalPartyAndLeaderDTO.setPoliticalLeaders(politicalLeaderService.getPoliticalLeadersByPartyId(partyId));
		 return politicalPartyAndLeaderDTO;
	}
	
	@Override
	public PoliticalPartyPeopleDevelopmentDTO getPoliticalPartyAndDevelopments(int partyId) {
		PoliticalPartyPeopleDevelopmentDTO politicalPartyPeopleDevelopmentDTO = new PoliticalPartyPeopleDevelopmentDTO();
		politicalPartyPeopleDevelopmentDTO.setPoliticalParty(getPoliticalParty(partyId));
		politicalPartyPeopleDevelopmentDTO.setPeopleDevelopments(peopleDevelopmentService.getPartyPeopleDevelopment(partyId));
		return politicalPartyPeopleDevelopmentDTO;
	}
	
	@Override
	public PoliticalPartyLeaderPeopleDevelopmentDTO getPartyLeaderPeopleDevelopment(int partyId,int leaderId) {
		PoliticalPartyDTO politicalPartyDTO = this.getPoliticalParty(partyId);
		PoliticalLeaderDTO politicalLeaderDTO = this.politicalLeaderService.getPartyLeaderDetail(leaderId);
		if(politicalLeaderDTO.getPartyId()!=partyId) {
			throw new InvalidPartyAndLeaderDetailException();
		}
		PoliticalPartyLeaderPeopleDevelopmentDTO politicalPartyLeaderPeopleDevelopmentDTO = new PoliticalPartyLeaderPeopleDevelopmentDTO();
		politicalPartyLeaderPeopleDevelopmentDTO.setPoliticalLeader(politicalLeaderDTO);
		politicalPartyLeaderPeopleDevelopmentDTO.setPoliticalParty(politicalPartyDTO);
		politicalPartyLeaderPeopleDevelopmentDTO.setPeopleDeveleopmentDTO(peopleDevelopmentService.getPeopleDevelopment(leaderId));
		return politicalPartyLeaderPeopleDevelopmentDTO;
	}

	private PoliticalParty convertDTOtoEntity(PoliticalPartyDTO politicalPartyDTO) {
		PoliticalParty politicalParty = new PoliticalParty();
		politicalParty.setPartyId(politicalPartyDTO.getPartyId());
		politicalParty.setPartyName(politicalPartyDTO.getPartyName());
		politicalParty.setCreationDate(LocalDateTime.now());
		politicalParty.setFoundationYear(politicalPartyDTO.getFoundationYear());
		politicalParty.setFounderName(politicalPartyDTO.getFounderName());
		return politicalParty;
	}

	private PoliticalPartyDTO convertEntityToDTO(PoliticalParty politicalParty) {
		PoliticalPartyDTO politicalPartyDTO = new PoliticalPartyDTO();
		politicalPartyDTO.setPartyName(politicalParty.getPartyName());
		politicalPartyDTO.setFoundationYear(politicalParty.getFoundationYear());
		politicalPartyDTO.setFounderName(politicalParty.getFounderName());
		politicalPartyDTO.setPartyId(politicalParty.getPartyId());
		return politicalPartyDTO;
	}

}
