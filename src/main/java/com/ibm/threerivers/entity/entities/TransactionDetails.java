package com.ibm.threerivers.entity.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transaction_details")
@SequenceGenerator(name = "transaction_details_id_seq", allocationSize = 1)
@Getter
@Setter
public class TransactionDetails implements Serializable {

	private static final long serialVersionUID = 2883651039990098981L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_details_id_seq")
	private Long id;

	@Column(name = "acc_num")
	private String accNum;

	@Column(name = "transaction_time_stamp")
	private Timestamp transactionTimeStamp;

	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "type")
	private String type;

}
