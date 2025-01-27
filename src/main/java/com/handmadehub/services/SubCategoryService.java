package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.SubCategory;
import com.handmadehub.repositories.SubCategoryRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import java.util.Map;

import java.util.List;

@Service
public class SubCategoryService {
	
    @Autowired
	private SubCategoryRepository subCategoryRepo;

    public void saveSubCategory (SubCategory vSubCategory) { 
        subCategoryRepo.save(vSubCategory);
    }

    public void deleteBysubCategoryId (Integer subCategoryId) {
		subCategoryRepo.deleteById(subCategoryId);
	}

    public SubCategory getSubCategoryById (Integer subCategoryId) {
        return subCategoryRepo.findById(subCategoryId).get();
    }

    public List<SubCategory> getAllSubCategory () {
        return subCategoryRepo.findAll();
    }

    public List<SubCategory> searchSubCategory(Map<String, Object> searchParams) {
    	
            Specification<SubCategory> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return subCategoryRepo.findAll(spec);       
    }

     
}
