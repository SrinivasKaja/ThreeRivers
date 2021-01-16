package com.ibm.threerivers.dto.response;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = BalanceResponse.BalanceResponseBuilder.class)
public class BalanceResponse implements Serializable {
	private int id;
	private String accountNumber;
	private Timestamp lastUpdated;
	private Long balance;
	

}
