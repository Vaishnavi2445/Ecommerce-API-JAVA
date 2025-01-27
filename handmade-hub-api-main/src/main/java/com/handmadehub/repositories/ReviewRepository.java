package com.handmadehub.repositories;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.handmadehub.entities.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>, JpaSpecificationExecutor<Review> {
	 
         List<Review> findByReviewId(Integer reviewId);
    List<Review> findByReviewUniqueId(String reviewUniqueId);
    List<Review> findByLanguageId(Integer languageId);
    List<Review> findByProductId(Integer productId);
    List<Review> findByUserId(Integer userId);
    List<Review> findByUserName(String userName);
    List<Review> findByRating(BigDecimal rating);
    List<Review> findByReviewText(String reviewText);
    List<Review> findByCreatedDate(String createdDate);
    List<Review> findByUpdatedDate(String updatedDate);

}
