package com.ey.codelab.peopledevelopment.service;

import java.util.List;

import com.ey.codelab.peopledevelopment.model.PeopleDevelopmentDTO;

public interface PeopleDevelopmentService {

	PeopleDevelopmentDTO assignDevelopmentTask(PeopleDevelopmentDTO peopleDevelopmentDTO);
	List<PeopleDevelopmentDTO> getLeaderDevelopmentTask(int leaderId);
	List<PeopleDevelopmentDTO> getpartyDevelopmentTask(int partyId);

}
