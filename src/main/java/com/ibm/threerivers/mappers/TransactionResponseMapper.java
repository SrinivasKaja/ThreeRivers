package com.ibm.threerivers.mappers;

import org.springframework.stereotype.Service;

import com.ibm.threerivers.dto.response.TransactionResponse;
import com.ibm.threerivers.enums.TransactionType;

@Service
public class TransactionResponseMapper implements Mapper<com.ibm.threerivers.entity.entities.TransactionDetails, TransactionResponse> {

	@Override
	public TransactionResponse map(com.ibm.threerivers.entity.entities.TransactionDetails details) {

		return TransactionResponse.builder().amount(details.getAmount())
				.transactionTs(details.getTransactionTimeStamp()).type(TransactionType.valueOf(details.getType()))
				.accNum(details.getAccNum()).build();
	}

}
