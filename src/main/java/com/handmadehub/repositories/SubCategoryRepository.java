package com.handmadehub.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.handmadehub.entities.SubCategory;


@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer>, JpaSpecificationExecutor<SubCategory> {
	 
         List<SubCategory> findBySubCategoryId(Integer subCategoryId);
    List<SubCategory> findBySubCategoryUniqueId(String subCategoryUniqueId);
    List<SubCategory> findByLanguageId(Integer languageId);
    List<SubCategory> findBySubCategoryName(String subCategoryName);
    List<SubCategory> findByDescription(String description);
    List<SubCategory> findByParentCategoryId(Integer parentCategoryId);
    List<SubCategory> findByCreatedDate(String createdDate);
    List<SubCategory> findByUpdatedDate(String updatedDate);
    List<SubCategory> findByCreatedBy(String createdBy);
    List<SubCategory> findByUpdatedBy(String updatedBy);

}
