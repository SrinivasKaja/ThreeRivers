package com.ibm.threerivers.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.threerivers.dto.response.BalanceResponse;
import com.ibm.threerivers.dto.response.BaseResponse;
import com.ibm.threerivers.dto.response.TransactionResponse;
import com.ibm.threerivers.entity.entities.BalanceDetails;
import com.ibm.threerivers.entity.entities.TransactionDetails;
import com.ibm.threerivers.enums.StatusCode;
import com.ibm.threerivers.enums.TransactionType;
import com.ibm.threerivers.manager.BalanceManager;
import com.ibm.threerivers.mappers.TransactionResponseMapper;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	private BalanceManager balanceManager;

	@Autowired
	private TransactionResponseMapper transactionResponseMapper;

	@Override
	public BaseResponse<TransactionResponse> getTransactions(String accNum, Timestamp startDate,
			Timestamp endDate, TransactionType type) {
		List<TransactionDetails> transactionDetailsList = this.balanceManager.getTransactions(accNum, endDate, endDate,
				type);
		List<TransactionResponse> transactionsResponse = transactionDetailsList.stream()
				.map(transactionResponseMapper::map).collect(Collectors.toList());
		return new BaseResponse<>(StatusCode.SC_OK.getCode(), StatusCode.SC_OK.getMessage(),
				transactionsResponse);
	}

	@Override
	public BaseResponse<BalanceResponse> getBalance(String accNum) {
		BalanceDetails balanceDetails = this.balanceManager.getBalance(accNum);
		BalanceResponse balanceResponse = BalanceResponse.builder().accountNumber(balanceDetails.getAccNum())
				.balance(balanceDetails.getBalance()).lastUpdated(balanceDetails.getUpdatedTime()).build();
		return new BaseResponse<>(StatusCode.SC_OK.getCode(), StatusCode.SC_OK.getMessage(), balanceResponse);
	}

}
