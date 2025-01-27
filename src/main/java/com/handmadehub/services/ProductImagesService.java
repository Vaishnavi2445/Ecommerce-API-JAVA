package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.ProductImages;
import com.handmadehub.repositories.ProductImagesRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import java.util.Map;

import java.util.List;

@Service
public class ProductImagesService {
	
    @Autowired
	private ProductImagesRepository productImagesRepo;

    public void saveProductImages (ProductImages vProductImages) { 
        productImagesRepo.save(vProductImages);
    }

    public void deleteByid (Integer id) {
		productImagesRepo.deleteById(id);
	}

    public ProductImages getProductImagesById (Integer id) {
        return productImagesRepo.findById(id).get();
    }

    public List<ProductImages> getAllProductImages () {
        return productImagesRepo.findAll();
    }

    public List<ProductImages> searchProductImages(Map<String, Object> searchParams) {
    	
            Specification<ProductImages> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return productImagesRepo.findAll(spec);       
    }

     
}
