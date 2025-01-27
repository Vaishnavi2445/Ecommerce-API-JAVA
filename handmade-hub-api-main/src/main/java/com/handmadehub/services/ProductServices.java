package com.handmadehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.handmadehub.entities.Products;
import com.handmadehub.repositories.ProductRepository;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class ProductServices {
	
    @Autowired
	private ProductRepository productsRepo;

    public void saveProducts (Products vProducts) { 
        productsRepo.save(vProducts);
    }

    public void deleteByproductId (Integer productId) {
		productsRepo.deleteById(productId);
	}

    public Products getProductsById (Integer productId) {
        return productsRepo.findById(productId).get();
    }

    public List<Products> getAllProducts () {
        return productsRepo.findAll();
    }

    public List<Products> searchProducts(Map<String, Object> searchParams) {
    	
            Specification<Products> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return productsRepo.findAll(spec);       
    }

     
}
