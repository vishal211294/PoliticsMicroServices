package com.ey.codelab.politicalparty.service;

import java.util.List;

import com.ey.codelab.politicalparty.model.PeopleDeveleopmentDTO;

public interface PeopleDevelopmentService {

	List<PeopleDeveleopmentDTO> getPartyPeopleDevelopment(int partyId);

	PeopleDeveleopmentDTO assignPeopleDevelopment(PeopleDeveleopmentDTO peopleDeveleopmentDTO);

	List<PeopleDeveleopmentDTO> getPeopleDevelopment(int leaderId);

}
