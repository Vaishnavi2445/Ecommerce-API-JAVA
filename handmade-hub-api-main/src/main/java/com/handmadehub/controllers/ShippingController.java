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

import com.handmadehub.entities.Shipping;
import com.handmadehub.services.ShippingService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/shipping")
public class ShippingController {
	
    @Autowired
	private ShippingService shippingService;

    @GetMapping
    public List<Shipping> getAllShippings () {
        return shippingService.getAllShipping();
    }

    @GetMapping("/{id}")
    public Shipping getShippingById(@PathVariable("id") Integer shippingId) {
        return shippingService.getShippingById(shippingId);
    }

    @PostMapping("/saveShipping")
    public ResponseEntity<String> saveShipping(@RequestBody Shipping vShipping) {
        shippingService.saveShipping(vShipping);
        return ResponseEntity.ok("Shipping Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteShippingById(@PathVariable("id") Integer shippingId) {
        shippingService.deleteByshippingId(shippingId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Shipping>> searchShipping(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Shipping> resultShippingList = shippingService.searchShipping(searchParams);
		return ResponseEntity.ok(resultShippingList);

	}

     
}
