package com.handmadehub.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.handmadehub.entities.Review;
import com.handmadehub.services.ReviewService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/review")
public class ReviewController {
	
    @Autowired
	private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews () {
        return reviewService.getAllReview();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable("id") Integer reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping("/saveReview")
    public ResponseEntity<String> saveReview(@RequestBody Review vReview) {
        reviewService.saveReview(vReview);
        return ResponseEntity.ok("Review Saved Successfully.");
        
    }

    @DeleteMapping("/{id}")
    public void deleteReviewById(@PathVariable("id") Integer reviewId) {
        reviewService.deleteByreviewId(reviewId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Review>> searchReview(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Review> resultReviewList = reviewService.searchReview(searchParams);
		return ResponseEntity.ok(resultReviewList);

	}

     
}
