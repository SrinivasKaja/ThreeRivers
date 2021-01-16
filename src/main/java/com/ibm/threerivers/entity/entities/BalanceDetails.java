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
@Table(name = "balance_details")
@SequenceGenerator(name = "balance_details_id_seq", allocationSize = 1)
@Getter
@Setter
public class BalanceDetails implements Serializable {

	private static final long serialVersionUID = 3857351561047240529L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "balance_details_id_seq")
	private Long id;

	@Column(name = "acc_num")
	private String accNum;
	
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	
	@Column(name = "balance")
	private Long balance;

}
