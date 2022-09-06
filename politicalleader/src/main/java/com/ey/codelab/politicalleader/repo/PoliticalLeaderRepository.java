package com.ey.codelab.politicalleader.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ey.codelab.politicalleader.entity.PoliticalLeader;

public interface PoliticalLeaderRepository extends JpaRepository<PoliticalLeader, Integer> {
	List<PoliticalLeader> findByPartyId(int partyId);
}
