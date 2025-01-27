package com.handmadehub.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.handmadehub.entities.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart> {
	 
         List<Cart> findByCartId(Integer cartId);
    List<Cart> findByUserId(Integer userId);
    List<Cart> findByProductUniqueId(String productUniqueId);
    List<Cart> findByQuantity(Integer quantity);
    List<Cart> findByCreatedTime(String createdTime);
    List<Cart> findByUpdatedTime(String updatedTime);

}
