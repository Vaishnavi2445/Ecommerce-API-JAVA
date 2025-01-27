package com.handmadehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.handmadehub.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>, JpaSpecificationExecutor<Products> {

}
