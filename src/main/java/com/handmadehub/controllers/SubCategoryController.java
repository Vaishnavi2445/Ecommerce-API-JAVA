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

import com.handmadehub.entities.SubCategory;
import com.handmadehub.services.SubCategoryService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {
	
    @Autowired
	private SubCategoryService subCategoryService;

    @GetMapping
    public List<SubCategory> getAllSubCategorys () {
        return subCategoryService.getAllSubCategory();
    }

    @GetMapping("/{id}")
    public SubCategory getSubCategoryById(@PathVariable("id") Integer subCategoryId) {
        return subCategoryService.getSubCategoryById(subCategoryId);
    }

    @PostMapping("/saveSubCategory")
    public ResponseEntity<String> saveSubCategory(@RequestBody SubCategory vSubCategory) {
        subCategoryService.saveSubCategory(vSubCategory);
        return ResponseEntity.ok("Sub Category saved successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteSubCategoryById(@PathVariable("id") Integer subCategoryId) {
        subCategoryService.deleteBysubCategoryId(subCategoryId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<SubCategory>> searchSubCategory(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<SubCategory> resultSubCategoryList = subCategoryService.searchSubCategory(searchParams);
		return ResponseEntity.ok(resultSubCategoryList);

	}

     
}
