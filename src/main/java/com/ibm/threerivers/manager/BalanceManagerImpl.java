package com.ibm.threerivers.manager;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.threerivers.entity.entities.BalanceDetails;
import com.ibm.threerivers.entity.entities.TransactionDetails;
import com.ibm.threerivers.enums.TransactionType;
import com.ibm.threerivers.repository.BalanceDetailsRepository;
import com.ibm.threerivers.repository.TransactionDetailsRepository;

@Component
public class BalanceManagerImpl implements BalanceManager {

	@Autowired
	private TransactionDetailsRepository transactionDetailsRepository;

	@Autowired
	private BalanceDetailsRepository balanceDetailsRepository;

	@Override
	@Transactional
	public List<TransactionDetails> getTransactions(String accNum, Timestamp startDate, Timestamp endDate,
			TransactionType type) {
		if (null != accNum && null == startDate && null == endDate && null == type) {
			return this.transactionDetailsRepository.queryAllTsByAccNum(accNum);
		} else if (null != accNum && null == startDate && null == endDate && null != type) {
			return this.transactionDetailsRepository.queryAllTsByAccNumAndType(accNum, type.toString());
		} else if (null == accNum && null != startDate && null != endDate && null == type) {
			return this.transactionDetailsRepository.queryAllTsByDate(startDate, endDate);
		} else if (null == accNum && null == startDate && null == endDate && null != type) {
			return this.transactionDetailsRepository.queryAllTsByType(type.toString());
		} else if (null != accNum && null != startDate && null != endDate && null == type) {
			return this.transactionDetailsRepository.queryAllTsByAccNumAndDate(accNum, startDate, endDate);
		} else if (null == accNum && null != startDate && null != endDate && null != type) {
			return this.transactionDetailsRepository.queryAllTsByDateAndType(startDate, endDate, type.toString());
		}
		else if (null != accNum && null != startDate && null != endDate && null != type) {
			return this.transactionDetailsRepository.queryAllTsByAllParams(accNum, startDate, endDate, type.toString());
		}
		else {
			return this.transactionDetailsRepository.findAll();
		}

	}

	@Override
	@Transactional
	public BalanceDetails getBalance(String accNum) {
		return this.balanceDetailsRepository.findByAccNum(accNum);
	}
}
