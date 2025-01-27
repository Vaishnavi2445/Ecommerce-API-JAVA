package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.Review;
import com.handmadehub.repositories.ReviewRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import java.util.Map;

import java.util.List;

@Service
public class ReviewService {
	
    @Autowired
	private ReviewRepository reviewRepo;

    public void saveReview (Review vReview) { 
        reviewRepo.save(vReview);
    }

    public void deleteByreviewId (Integer reviewId) {
		reviewRepo.deleteById(reviewId);
	}

    public Review getReviewById (Integer reviewId) {
        return reviewRepo.findById(reviewId).get();
    }

    public List<Review> getAllReview () {
        return reviewRepo.findAll();
    }

    public List<Review> searchReview(Map<String, Object> searchParams) {
    	
            Specification<Review> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return reviewRepo.findAll(spec);       
    }

     
}
