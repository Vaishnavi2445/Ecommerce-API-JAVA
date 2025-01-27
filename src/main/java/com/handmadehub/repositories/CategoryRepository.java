package com.handmadehub.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.handmadehub.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
	 
         List<Category> findByCategoryId(Integer categoryId);
    List<Category> findByCategoryUniqueId(String categoryUniqueId);
    List<Category> findByLanguageId(Integer languageId);
    List<Category> findByCategoryName(String categoryName);
    List<Category> findByDescription(String description);
    List<Category> findByParentCategoryId(Integer parentCategoryId);
    List<Category> findByCreatedDate(String createdDate);
    List<Category> findByUpdatedDate(String updatedDate);
    List<Category> findByCreatedBy(String createdBy);
    List<Category> findByUpdatedBy(String updatedBy);

}
