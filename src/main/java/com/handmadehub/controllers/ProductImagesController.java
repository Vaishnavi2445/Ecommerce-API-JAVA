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

import com.handmadehub.entities.ProductImages;
import com.handmadehub.services.ProductImagesService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/productImages")
public class ProductImagesController {
	
    @Autowired
	private ProductImagesService productImagesService;

    @GetMapping
    public List<ProductImages> getAllProductImagess () {
        return productImagesService.getAllProductImages();
    }

    @GetMapping("/{id}")
    public ProductImages getProductImagesById(@PathVariable("id") Integer id) {
        return productImagesService.getProductImagesById(id);
    }

    @PostMapping("/saveProductImages")
    public ResponseEntity<String> saveProductImages(@RequestBody ProductImages vProductImages) {
        productImagesService.saveProductImages(vProductImages);
        return ResponseEntity.ok("Product Images Saved Successfully");
        
    }

    @DeleteMapping("/{id}")
    public void deleteProductImagesById(@PathVariable("id") Integer id) {
        productImagesService.deleteByid(id);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<ProductImages>> searchProductImages(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<ProductImages> resultProductImagesList = productImagesService.searchProductImages(searchParams);
		return ResponseEntity.ok(resultProductImagesList);

	}

     
}
