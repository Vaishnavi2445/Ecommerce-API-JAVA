package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.Orders;
import com.handmadehub.repositories.OrdersRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class OrdersService {
	
    @Autowired
	private OrdersRepository ordersRepo;

    public void saveOrders (Orders vOrders) { 
        ordersRepo.save(vOrders);
    }

    public void deleteByorderId (Integer orderId) {
		ordersRepo.deleteById(orderId);
	}

    public Orders getOrdersById (Integer orderId) {
        return ordersRepo.findById(orderId).get();
    }

    public List<Orders> getAllOrders () {
        return ordersRepo.findAll();
    }

    public List<Orders> searchOrders(Map<String, Object> searchParams) {
    	
            Specification<Orders> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return ordersRepo.findAll(spec);       
    }

     
}
