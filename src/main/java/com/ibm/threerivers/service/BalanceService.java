package com.ibm.threerivers.service;

import java.sql.Timestamp;

import com.ibm.threerivers.dto.response.BalanceResponse;
import com.ibm.threerivers.dto.response.BaseResponse;
import com.ibm.threerivers.dto.response.TransactionResponse;
import com.ibm.threerivers.enums.TransactionType;

public interface BalanceService {

	public BaseResponse<TransactionResponse> getTransactions(String accNum, Timestamp startDate, Timestamp endDate, TransactionType type);

	public BaseResponse<BalanceResponse> getBalance(String accNum);
}
