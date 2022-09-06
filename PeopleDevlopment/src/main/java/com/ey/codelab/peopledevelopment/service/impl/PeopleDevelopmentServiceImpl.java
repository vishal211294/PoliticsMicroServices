package com.ey.codelab.peopledevelopment.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.ey.codelab.peopledevelopment.controller.PeopleDevlopmentController;
import com.ey.codelab.peopledevelopment.customexception.InvalidPartyAndLeaderDetailException;
import com.ey.codelab.peopledevelopment.entity.PeopleDevelopment;
import com.ey.codelab.peopledevelopment.model.PeopleDevelopmentDTO;
import com.ey.codelab.peopledevelopment.model.PoliticalLeaderDTO;
import com.ey.codelab.peopledevelopment.model.PoliticalPartyDTO;
import com.ey.codelab.peopledevelopment.repo.PeopleDevelopmentRepository;
import com.ey.codelab.peopledevelopment.service.PeopleDevelopmentService;
import com.ey.codelab.peopledevelopment.service.PoliticalLeaderService;
import com.ey.codelab.peopledevelopment.service.PoliticalPartyService;

@Service
public class PeopleDevelopmentServiceImpl implements PeopleDevelopmentService {
	private final PoliticalLeaderService politicalLeaderService;
	private final PoliticalPartyService politicalPartyService;
	private final PeopleDevelopmentRepository peopleDevelopmentRepository;

	private static final Logger logger = Logger.getLogger(PeopleDevlopmentController.class.getName());

	public PeopleDevelopmentServiceImpl(PoliticalLeaderService politicalLeaderService,
			PoliticalPartyService politicalPartyService, PeopleDevelopmentRepository peopleDevelopmentRepository) {
		super();
		this.politicalLeaderService = politicalLeaderService;
		this.politicalPartyService = politicalPartyService;
		this.peopleDevelopmentRepository = peopleDevelopmentRepository;
	}

	@Override
	public PeopleDevelopmentDTO assignDevelopmentTask(PeopleDevelopmentDTO peopleDevelopmentDTO) {
		logger.info("for assign development work, going to validate party id -> leader id.");
		politicalPartyService.getPartyDetail(peopleDevelopmentDTO.getPartyId());
		logger.finest("party id found, going to check leader id.");
		PoliticalLeaderDTO leaderDto = politicalLeaderService.getLeaderDetail(peopleDevelopmentDTO.getLeaderId());
		logger.finest("party id found, validate leader associated with correct party.");
		if (leaderDto.getPartyId() != peopleDevelopmentDTO.getPartyId()) {
			throw new InvalidPartyAndLeaderDetailException();
		}
		logger.finest("request validated, now going to save people development.");
		peopleDevelopmentDTO = convertEntityToDTO(
				peopleDevelopmentRepository.save(convertDTOtoEntity(peopleDevelopmentDTO)));
		logger.info("assigned development work to party and leader.");
		return peopleDevelopmentDTO;
	}

	@Override
	public List<PeopleDevelopmentDTO> getLeaderDevelopmentTask(int leaderId) {
		logger.info("get all assigned development work to leader.");
		return peopleDevelopmentRepository.findByLeaderIdOrderByActivityYearDescActivityMonthDesc(leaderId).stream()
				.map(this::convertEntityToDTO).toList();
	}

	@Override
	public List<PeopleDevelopmentDTO> getpartyDevelopmentTask(int partyId) {
		logger.info("get all assigned development work to party.");
		return peopleDevelopmentRepository.findByPartyIdOrderByActivityYearDescActivityMonthDesc(partyId).stream()
				.map(this::convertEntityToDTO).toList();
	}

	private PeopleDevelopmentDTO convertEntityToDTO(PeopleDevelopment peopleDevelopment) {
		PeopleDevelopmentDTO peopleDevelopmentDTO = new PeopleDevelopmentDTO();
		peopleDevelopmentDTO.setActivity(peopleDevelopment.getActivity());
		peopleDevelopmentDTO.setActivityMonth(peopleDevelopment.getActivityMonth());
		peopleDevelopmentDTO.setActivityYear(peopleDevelopment.getActivityYear());
		peopleDevelopmentDTO.setBudget(peopleDevelopment.getBudget());
		peopleDevelopmentDTO.setDevelopmentId(peopleDevelopment.getDevelopmentId());
		peopleDevelopmentDTO.setDevelopmentTitle(peopleDevelopment.getDevelopmentTitle());
		peopleDevelopmentDTO.setLeaderId(peopleDevelopment.getLeaderId());
		peopleDevelopmentDTO.setPartyId(peopleDevelopment.getPartyId());
		peopleDevelopmentDTO.setState(peopleDevelopment.getState());
		return peopleDevelopmentDTO;
	}

	private PeopleDevelopment convertDTOtoEntity(PeopleDevelopmentDTO peopleDevelopmentDTO) {
		PeopleDevelopment peopleDevelopment = new PeopleDevelopment();
		peopleDevelopment.setActivity(peopleDevelopmentDTO.getActivity());
		peopleDevelopment.setActivityMonth(peopleDevelopmentDTO.getActivityMonth());
		peopleDevelopment.setActivityYear(peopleDevelopmentDTO.getActivityYear());
		peopleDevelopment.setBudget(peopleDevelopmentDTO.getBudget());
		peopleDevelopment.setDevelopmentId(peopleDevelopmentDTO.getDevelopmentId());
		peopleDevelopment.setDevelopmentTitle(peopleDevelopmentDTO.getDevelopmentTitle());
		peopleDevelopment.setLeaderId(peopleDevelopmentDTO.getLeaderId());
		peopleDevelopment.setPartyId(peopleDevelopmentDTO.getPartyId());
		peopleDevelopment.setState(peopleDevelopmentDTO.getState());
		peopleDevelopment.setCreationDate(LocalDateTime.now());
		return peopleDevelopment;
	}
}
