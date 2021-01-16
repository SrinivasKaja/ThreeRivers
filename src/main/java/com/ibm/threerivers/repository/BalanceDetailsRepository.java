package com.ibm.threerivers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.threerivers.entity.entities.BalanceDetails;

@Repository
public interface BalanceDetailsRepository extends JpaRepository<BalanceDetails, Long> {
	BalanceDetails findByAccNum(String accNum);
}
