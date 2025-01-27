package com.handmadehub.repositories;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.handmadehub.entities.OrderItems;


@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>, JpaSpecificationExecutor<OrderItems> {
	 
         List<OrderItems> findByOrderItemId(Integer orderItemId);
    List<OrderItems> findByOrderId(Integer orderId);
    List<OrderItems> findByProductId(Integer productId);
    List<OrderItems> findByQuantity(Integer quantity);
    List<OrderItems> findByPrice(BigDecimal price);
    List<OrderItems> findByCreatedAt(String createdAt);

}
