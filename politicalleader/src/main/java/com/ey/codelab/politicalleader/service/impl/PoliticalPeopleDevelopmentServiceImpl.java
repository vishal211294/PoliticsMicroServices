package com.ey.codelab.politicalleader.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ey.codelab.politicalleader.model.PeopleDeveleopmentDTO;
import com.ey.codelab.politicalleader.service.PoliticalPeopleDevelopmentService;
@Service
public class PoliticalPeopleDevelopmentServiceImpl implements PoliticalPeopleDevelopmentService {

	private static String PEOPLE_DEVELOPMENT_URL = "http://PEOPLE-DEVELOPMENT-SERVICE/people-development/";                         
	private static Logger logger = Logger.getLogger(PoliticalPeopleDevelopmentServiceImpl.class.getName());                               
	                                                                                         
	private final RestTemplate restTemplate;                                                                               
	                                                                                                                       
	public PoliticalPeopleDevelopmentServiceImpl( RestTemplate restTemplate) {                                         
		super();                                                                                                           
		this.restTemplate = restTemplate;                                        
	}                                    
	
	@Override
	public List<PeopleDeveleopmentDTO> getLeaderPeopleDevelopment(int leaderId) {
		return this.restTemplate.getForObject(PEOPLE_DEVELOPMENT_URL+"get-people-development/leader/{leaderId}",List.class,leaderId);
	}

}
