package com.ibm.threerivers.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.threerivers.dto.response.BalanceResponse;
import com.ibm.threerivers.dto.response.BaseResponse;
import com.ibm.threerivers.dto.response.TransactionResponse;
import com.ibm.threerivers.enums.TransactionType;
import com.ibm.threerivers.service.BalanceService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/admin")
@Slf4j
public class BalanceController {

	@Autowired
	public BalanceService balanceService;

	@GetMapping("/getTransactions")
	public BaseResponse<TransactionResponse> getTransactions(@RequestParam(value = "accNum") final String accNum,
			@RequestParam(value = "startDate", required = false) final Timestamp startDate,
			@RequestParam(value = "endDate", required = false) final Timestamp endDate,
			@RequestParam(value = "type", required = false) final TransactionType type,
			@RequestParam(value = "offset", defaultValue = "0", required = false) final Integer pgNo,
			@RequestParam(value = "limit", defaultValue = "100", required = false) final Integer limit) {
		//System.out.println("type" + type.getValue());
		System.out.println("type" + type);
		//log.info("type value {}", type.getValue());
		log.info("type {}", type);
		return balanceService.getTransactions(accNum, startDate, endDate, type);
	}

	@GetMapping("/getBalance")
	public BaseResponse<BalanceResponse> getBalance(@RequestParam("accNum") final String accNum) {
		return balanceService.getBalance(accNum);
	}

}
