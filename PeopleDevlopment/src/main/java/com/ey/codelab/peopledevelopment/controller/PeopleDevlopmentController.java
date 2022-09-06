package com.ey.codelab.peopledevelopment.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.codelab.peopledevelopment.model.PeopleDevelopmentDTO;
import com.ey.codelab.peopledevelopment.service.PeopleDevelopmentService;

@RestController
@RequestMapping("people-development")
public class PeopleDevlopmentController {
	
	private static final Logger logger = Logger.getLogger(PeopleDevlopmentController.class.getName());
	
	@Autowired
	PeopleDevelopmentService peopleDevelopmentService;
	
	@PostMapping(value = "assign")
	public PeopleDevelopmentDTO assignDevelopmentWork(@Valid @RequestBody PeopleDevelopmentDTO peopleDevelopmentDTO) {
		logger.info("get request to assign some people development to party and leader");
		return peopleDevelopmentService.assignDevelopmentTask(peopleDevelopmentDTO);		
	}
	
	@GetMapping(value = "get-people-development/leader/{leaderId}",produces = "application/json")
	public List<PeopleDevelopmentDTO> getLeaderDevelopmentWork(@PathVariable Integer leaderId) {
		logger.info("get request to get all people development from leader id");
		return peopleDevelopmentService.getLeaderDevelopmentTask(leaderId);
	}
	
	@GetMapping(value = "get-people-development/party/{partyId}",produces = "application/json")
	public List<PeopleDevelopmentDTO> getPartyDevelopmentWork(@PathVariable Integer partyId) {
		logger.info("get request to get all people development from party id");
		return peopleDevelopmentService.getpartyDevelopmentTask(partyId);
	}
}
