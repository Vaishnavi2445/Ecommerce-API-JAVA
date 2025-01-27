package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.OrderItems;
import com.handmadehub.repositories.OrderItemsRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class OrderItemsService {
	
    @Autowired
	private OrderItemsRepository orderItemsRepo;

    public void saveOrderItems (OrderItems vOrderItems) { 
        orderItemsRepo.save(vOrderItems);
    }

    public void deleteByorderItemId (Integer orderItemId) {
		orderItemsRepo.deleteById(orderItemId);
	}

    public OrderItems getOrderItemsById (Integer orderItemId) {
        return orderItemsRepo.findById(orderItemId).get();
    }

    public List<OrderItems> getAllOrderItems () {
        return orderItemsRepo.findAll();
    }

    public List<OrderItems> searchOrderItems(Map<String, Object> searchParams) {
    	
            Specification<OrderItems> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return orderItemsRepo.findAll(spec);       
    }

     
}
