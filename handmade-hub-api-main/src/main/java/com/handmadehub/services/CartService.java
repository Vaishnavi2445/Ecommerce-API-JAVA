package com.handmadehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.Cart;
import com.handmadehub.repositories.CartRepository;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class CartService {
	
    @Autowired
	private CartRepository cartRepo;

    public void saveCart (Cart vCart) { 
        cartRepo.save(vCart);
    }

    public void deleteBycartId (Integer cartId) {
		cartRepo.deleteById(cartId);
	}

    public Cart getCartById (Integer cartId) {
        return cartRepo.findById(cartId).get();
    }

    public List<Cart> getAllCart () {
        return cartRepo.findAll();
    }

    public List<Cart> searchCart(Map<String, Object> searchParams) {
    	
            Specification<Cart> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return cartRepo.findAll(spec);       
    }

     
}
