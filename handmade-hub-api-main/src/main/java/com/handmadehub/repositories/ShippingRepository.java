package com.handmadehub.repositories;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.handmadehub.entities.Shipping;


@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer>, JpaSpecificationExecutor<Shipping> {
	 
         List<Shipping> findByShippingId(Integer shippingId);
    List<Shipping> findByOrderId(Integer orderId);
    List<Shipping> findByProductId(Integer productId);
    List<Shipping> findByShippingMethod(String shippingMethod);
    List<Shipping> findByShippingCost(BigDecimal shippingCost);
    List<Shipping> findByTrackingNumber(String trackingNumber);
    List<Shipping> findByShippingStatus(String shippingStatus);
    List<Shipping> findByEstimatedDeliveryDate(String estimatedDeliveryDate);
    List<Shipping> findByCreatedAt(String createdAt);
    List<Shipping> findByUpdatedAt(String updatedAt);

}
