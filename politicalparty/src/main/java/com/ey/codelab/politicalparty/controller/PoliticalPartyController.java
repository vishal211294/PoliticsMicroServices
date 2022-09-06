package com.ey.codelab.politicalparty.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.codelab.politicalparty.model.PeopleDeveleopmentDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyAndLeaderDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyLeaderPeopleDevelopmentDTO;
import com.ey.codelab.politicalparty.model.PoliticalPartyPeopleDevelopmentDTO;
import com.ey.codelab.politicalparty.service.PeopleDevelopmentService;
import com.ey.codelab.politicalparty.service.PoliticalLeaderService;
import com.ey.codelab.politicalparty.service.PoliticalPartyService;

@RequestMapping("political-party")
@RestController
public class PoliticalPartyController {
	private static Logger logger = Logger.getLogger(PoliticalPartyController.class.getName());

	private final PoliticalPartyService politicalPartyService;
	private final PoliticalLeaderService politicalLeaderService;
	private final PeopleDevelopmentService peopleDevelopmentService;

	public PoliticalPartyController(PoliticalPartyService politicalPartyService,
			PoliticalLeaderService politicalLeaderService, PeopleDevelopmentService peopleDevelopmentService) {
		this.politicalPartyService = politicalPartyService;
		this.politicalLeaderService = politicalLeaderService;
		this.peopleDevelopmentService = peopleDevelopmentService;
	}

	@GetMapping("welcome")
	public String welcome() {
		logger.info("Welcome to log factory of political party logger.");
		return "welcome to political party controller.";
	}

	@PostMapping(value = "register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PoliticalPartyDTO> register(@RequestBody @Valid PoliticalPartyDTO politicalPartyDTO) {
		logger.info("get request for register the political party");
		politicalPartyDTO = politicalPartyService.registerPoliticalParty(politicalPartyDTO);
		return new ResponseEntity<PoliticalPartyDTO>(politicalPartyDTO, HttpStatus.OK);
	}

	@GetMapping(value = "get/party/{partyId}", produces = "application/json")
	public ResponseEntity<PoliticalPartyDTO> getPoliticalParty(@PathVariable int partyId) {
		logger.info("get request for deltail of the political party");
		PoliticalPartyDTO politicalPartyDTO = politicalPartyService.getPoliticalParty(partyId);
		return new ResponseEntity<PoliticalPartyDTO>(politicalPartyDTO, HttpStatus.OK);
	}

	@DeleteMapping(value = "delete/party/{partyId}/leader/{leaderId}")
	public ResponseEntity<Boolean> deletePoliticalPartyLeader(@PathVariable int partyId, @PathVariable int leaderId) {
		logger.info("get request to delete political party leader");
		boolean status = politicalLeaderService.deletePoliticalPartyLeader(leaderId, partyId);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping(value = "get-party-leaders/{partyId}", produces = "application/json")
	public ResponseEntity<PoliticalPartyAndLeaderDTO> getPoliticalPartyLeaders(@PathVariable int partyId) {
		logger.info("get request for get all detail of the political party leaders.");
		PoliticalPartyAndLeaderDTO politicalPartyAndLeaders = politicalPartyService
				.getPoliticalPartyAndLeaders(partyId);
		return new ResponseEntity<PoliticalPartyAndLeaderDTO>(politicalPartyAndLeaders, HttpStatus.OK);
	}

	@GetMapping(value = "get-party-people-development/{partyId}", produces = "application/json")
	public ResponseEntity<PoliticalPartyPeopleDevelopmentDTO> getPoliticalPartyDevelopments(@PathVariable int partyId) {
		logger.info("get request for get all detail of the political party [" + partyId + "] people development.");
		PoliticalPartyPeopleDevelopmentDTO politicalPartyAndDev = politicalPartyService
				.getPoliticalPartyAndDevelopments(partyId);
		return new ResponseEntity<PoliticalPartyPeopleDevelopmentDTO>(politicalPartyAndDev, HttpStatus.OK);
	}

	@PostMapping(value = "assign-people-development",consumes = "application/json",produces = "application/json")
	public ResponseEntity<PeopleDeveleopmentDTO> assignPeopleDevelopmentWork(@Valid @RequestBody PeopleDeveleopmentDTO peopleDeveleopmentDTO){
		return new ResponseEntity<>(peopleDevelopmentService.assignPeopleDevelopment(peopleDeveleopmentDTO),HttpStatus.OK);
	}
	
	@GetMapping(value = "get-people-development/party/{partyId}/leader/{leaderId}",produces = "application/json")
	public ResponseEntity<PoliticalPartyLeaderPeopleDevelopmentDTO> getPeopleDevelopmentWork(@PathVariable int partyId,@PathVariable int leaderId){
		return new ResponseEntity<>(politicalPartyService.getPartyLeaderPeopleDevelopment(partyId,leaderId),HttpStatus.OK);
	}
}
