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
import com.handmadehub.entities.Products;
import com.handmadehub.services.ProductServices;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/products")
public class ProductControllers {
	
    @Autowired
	private ProductServices productsService;

    @GetMapping
    public List<Products> getAllProductss () {
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProductsById(@PathVariable("id") Integer productId) {
        return productsService.getProductsById(productId);
    }

    @PostMapping("/saveProducts")
    public ResponseEntity<String> saveProducts(@RequestBody Products vProducts) {
        productsService.saveProducts(vProducts);
        return ResponseEntity.ok("Product Saved Successfull.");
    }

    @DeleteMapping("/{id}")
    public void deleteProductsById(@PathVariable("id") Integer productId) {
        productsService.deleteByproductId(productId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Products>> searchProducts(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Products> resultProductsList = productsService.searchProducts(searchParams);
		return ResponseEntity.ok(resultProductsList);

	}

     
}
