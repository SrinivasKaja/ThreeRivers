package com.ibm.threerivers.dto.response;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ibm.threerivers.enums.TransactionType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = TransactionResponse.TransactionResponseBuilder.class)
public class TransactionResponse implements Serializable {

	private int id;
	private String accNum;
	private Timestamp transactionTs;
	private TransactionType type;
	private Long amount;
}
