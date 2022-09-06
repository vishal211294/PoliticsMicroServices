package com.ey.codelab.politicalparty.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ey.codelab.politicalparty.entity.PoliticalParty;

@Repository
public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Integer>{
	
}
