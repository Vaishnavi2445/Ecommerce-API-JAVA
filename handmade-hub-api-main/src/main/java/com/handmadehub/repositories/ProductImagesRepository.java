package com.handmadehub.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.handmadehub.entities.ProductImages;


@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Integer>, JpaSpecificationExecutor<ProductImages> {
	 
         List<ProductImages> findByProductId(String productId);
    List<ProductImages> findByPath(String path);
    List<ProductImages> findByVisible(Byte visible);

}
