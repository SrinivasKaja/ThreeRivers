package com.ibm.threerivers.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.threerivers.entity.entities.TransactionDetails;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
	@Query(nativeQuery = true, value = "select td.* from transaction_details td where td.acc_num=:acc_num")
	List<TransactionDetails> queryAllTsByAccNum(@Param("acc_num") String accNum);
	
	@Query(nativeQuery = true, value = "select td.* from transaction_details td where td.transaction_time_stamp>=:startDate AND td.transaction_time_stamp<=:endDate")
	List<TransactionDetails> queryAllTsByDate(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate);
	
	@Query(nativeQuery = true, value = "select td.* from transaction_details td where td.type = :type")
	List<TransactionDetails> queryAllTsByType(@Param("type") String type);
	
	@Query(nativeQuery = true, value = "select td.* from transaction_details td where td.acc_num=:acc_num AND td.transaction_time_stamp>=:startDate AND td.transaction_time_stamp<=:endDate")
	List<TransactionDetails> queryAllTsByAccNumAndDate(@Param("acc_num") String accNum,@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate);
	
	@Query(nativeQuery = true, value = "select td.* from transaction_details td where td.acc_num=:acc_num AND td.type=:type")
	List<TransactionDetails> queryAllTsByAccNumAndType(@Param("acc_num") String accNum,@Param("type") String type);
	
	@Query(nativeQuery = true, value = "select td.* from transaction_details td where td.transaction_time_stamp>=:startDate AND td.transaction_time_stamp<=:endDate AND td.type=:type")
	List<TransactionDetails> queryAllTsByDateAndType(@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("type") String type);
	
	@Query(nativeQuery = true, value = "select td.* from transaction_details td where td.acc_num=:acc_num AND td.transaction_time_stamp>=:startDate AND td.transaction_time_stamp<=:endDate AND td.type=:type")
	List<TransactionDetails> queryAllTsByAllParams(@Param("acc_num") String accNum,@Param("startDate") Timestamp startDate,
			@Param("endDate") Timestamp endDate, @Param("type") String type);

}
