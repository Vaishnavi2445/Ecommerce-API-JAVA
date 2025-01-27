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

import com.handmadehub.entities.Category;
import com.handmadehub.services.CategoryService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/category")
public class CategoryController {
	
    @Autowired
	private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategorys () {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/saveCategory")
    public ResponseEntity<String> saveCategory(@RequestBody Category vCategory) {
        categoryService.saveCategory(vCategory);
        return ResponseEntity.ok("Category Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") Integer categoryId) {
        categoryService.deleteBycategoryId(categoryId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Category>> searchCategory(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Category> resultCategoryList = categoryService.searchCategory(searchParams);
		return ResponseEntity.ok(resultCategoryList);

	}

     
}
