package com.wings.wingsofferservice.repository;

import com.wings.wingsofferservice.Models.Demand;
import com.wings.wingsofferservice.Models.EtatDemand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demand, Long> {
	List<Demand> findByUserId(long id);
	List<Demand> findByType(String type);
	List<Demand> findByEtatdemand(EtatDemand etatdemand);
}
