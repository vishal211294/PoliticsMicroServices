package com.ey.codelab.politicalleader.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.codelab.politicalleader.model.PoliticalLeaderDTO;
import com.ey.codelab.politicalleader.model.PoliticalLeaderPeopleDevelopmentDTO;
import com.ey.codelab.politicalleader.model.PoliticalPartyLeadersDTO;
import com.ey.codelab.politicalleader.service.PoliticalLeaderService;

@RestController
@RequestMapping("political-leader")
public class PoliticalLeaderController {
	private static final Logger logger = Logger.getLogger(PoliticalLeaderController.class.getName());
	
	private final PoliticalLeaderService politicalLeaderService;
	
	public PoliticalLeaderController(PoliticalLeaderService politicalLeaderService) {
		super();
		this.politicalLeaderService = politicalLeaderService;
	}



	@PostMapping(value = "register",consumes ="application/json",produces = "application/json")
	public PoliticalLeaderDTO register(@RequestBody @Valid PoliticalLeaderDTO politicalLeaderDTO) {
		logger.info("get request to register political leader");
		return politicalLeaderService.registerLeader(politicalLeaderDTO);
	}
	
	@GetMapping(value = "get/leader/{leaderId}",produces = "application/json")
	public PoliticalLeaderDTO register(@PathVariable int leaderId) {
		logger.info("get detail of political leader");
		return politicalLeaderService.getPoliticalLeader(leaderId);
	}
	
	@DeleteMapping(value = "delete/{leaderId}")
	public boolean deletePoliticalLeader(@PathVariable int leaderId) {
		logger.info("get request to delete the political leader ["+leaderId+"] ");
		return politicalLeaderService.deleteLeader(leaderId);
	}
	
	@GetMapping(value = "get-party-leaders/{partyId}",produces = "application/json")
	public PoliticalPartyLeadersDTO getPoliticalPartyLeaders(@PathVariable int partyId) {
		logger.info("request to get all party leaders of the political party ["+partyId+"] ");
		return politicalLeaderService.getAllPoliticalLeadersByPartyId(partyId);
	}
	
	@GetMapping(value = "get-leader-people-development/{leaderId}",produces = "application/json")
	public PoliticalLeaderPeopleDevelopmentDTO getAssignedPoliticalPartyDevelopment(@PathVariable int leaderId) {
		logger.info("request to get all party leaders people development ["+leaderId+"] ");
		return politicalLeaderService.getAllPoliticalLeaderPeopleDevelopment(leaderId);
	}
	
}
