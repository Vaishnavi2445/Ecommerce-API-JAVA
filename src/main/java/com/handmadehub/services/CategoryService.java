package com.handmadehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.Category;
import com.handmadehub.repositories.CategoryRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class CategoryService {
	
    @Autowired
	private CategoryRepository categoryRepo;

    public void saveCategory (Category vCategory) { 
        categoryRepo.save(vCategory);
    }

    public void deleteBycategoryId (Integer categoryId) {
		categoryRepo.deleteById(categoryId);
	}

    public Category getCategoryById (Integer categoryId) {
        return categoryRepo.findById(categoryId).get();
    }

    public List<Category> getAllCategory () {
        return categoryRepo.findAll();
    }

    public List<Category> searchCategory(Map<String, Object> searchParams) {
    	
            Specification<Category> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return categoryRepo.findAll(spec);       
    }

     
}
