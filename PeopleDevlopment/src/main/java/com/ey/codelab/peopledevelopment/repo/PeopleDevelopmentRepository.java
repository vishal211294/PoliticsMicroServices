package com.ey.codelab.peopledevelopment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.ey.codelab.peopledevelopment.entity.PeopleDevelopment;

@Repository
public interface PeopleDevelopmentRepository extends JpaRepository<PeopleDevelopment, Integer> {
     List<PeopleDevelopment> findByLeaderIdOrderByActivityYearDescActivityMonthDesc(int leaderId);
     List<PeopleDevelopment> findByPartyIdOrderByActivityYearDescActivityMonthDesc(int partyId);
}
