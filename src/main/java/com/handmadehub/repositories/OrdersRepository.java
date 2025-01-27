package com.handmadehub.repositories;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.handmadehub.entities.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>, JpaSpecificationExecutor<Orders> {
	 
         List<Orders> findByOrderId(Integer orderId);
    List<Orders> findByUserId(Integer userId);
    List<Orders> findByBookingId(Integer bookingId);
    List<Orders> findByOrderDate(String orderDate);
    List<Orders> findByTotalAmount(BigDecimal totalAmount);
    List<Orders> findByShippingAddress(String shippingAddress);
    List<Orders> findByOrderStatus(String orderStatus);
    List<Orders> findByCreatedAt(String createdAt);
    List<Orders> findByUpdatedAt(String updatedAt);

}
