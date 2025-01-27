package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.Shipping;
import com.handmadehub.repositories.ShippingRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import java.util.Map;

import java.util.List;

@Service
public class ShippingService {
	
    @Autowired
	private ShippingRepository shippingRepo;

    public void saveShipping (Shipping vShipping) { 
        shippingRepo.save(vShipping);
    }

    public void deleteByshippingId (Integer shippingId) {
		shippingRepo.deleteById(shippingId);
	}

    public Shipping getShippingById (Integer shippingId) {
        return shippingRepo.findById(shippingId).get();
    }

    public List<Shipping> getAllShipping () {
        return shippingRepo.findAll();
    }

    public List<Shipping> searchShipping(Map<String, Object> searchParams) {
    	
            Specification<Shipping> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return shippingRepo.findAll(spec);       
    }

     
}
