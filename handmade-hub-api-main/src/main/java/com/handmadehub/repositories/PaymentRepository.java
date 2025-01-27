package com.handmadehub.repositories;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.handmadehub.entities.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>, JpaSpecificationExecutor<Payment> {
	 
         List<Payment> findByPaymentId(Integer paymentId);
    List<Payment> findByOrderId(Integer orderId);
    List<Payment> findByPaymentMethod(String paymentMethod);
    List<Payment> findByPaymentStatus(String paymentStatus);
    List<Payment> findByAmount(BigDecimal amount);
    List<Payment> findByTransactionId(String transactionId);
    List<Payment> findByCreatedTime(String createdTime);
    List<Payment> findByUpdatedTime(String updatedTime);

}
