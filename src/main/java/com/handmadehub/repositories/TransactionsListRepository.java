package com.handmadehub.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.handmadehub.entities.TransactionsList;


@Repository
public interface TransactionsListRepository extends JpaRepository<TransactionsList, Integer>, JpaSpecificationExecutor<TransactionsList> {
	 
    List<TransactionsList> findByStatus(String status);
    List<TransactionsList> findByBookingId(Integer bookingId);
    List<TransactionsList> findByCreatedAt(String createdAt);
    List<TransactionsList> findByUserId(Integer userId);
    List<TransactionsList> findByAmount(String amount);
    List<TransactionsList> findByAllOrderItems(String allOrderItems);

}
