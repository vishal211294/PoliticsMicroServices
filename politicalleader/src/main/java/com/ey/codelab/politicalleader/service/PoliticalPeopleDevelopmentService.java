package com.ey.codelab.politicalleader.service;

import java.util.List;

import com.ey.codelab.politicalleader.model.PeopleDeveleopmentDTO;

public interface PoliticalPeopleDevelopmentService {

	List<PeopleDeveleopmentDTO> getLeaderPeopleDevelopment(int leaderId);

}
