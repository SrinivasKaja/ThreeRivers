package com.ibm.threerivers.manager;

import java.sql.Timestamp;
import java.util.List;

import com.ibm.threerivers.entity.entities.BalanceDetails;
import com.ibm.threerivers.entity.entities.TransactionDetails;
import com.ibm.threerivers.enums.TransactionType;

public interface BalanceManager {
	
	public List<TransactionDetails> getTransactions(String accNum, Timestamp startDate, Timestamp endDate,
			TransactionType type);

	public BalanceDetails getBalance(String accNum);
}
