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

import com.handmadehub.entities.OrderItems;
import com.handmadehub.services.OrderItemsService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/orderItems")
public class OrderItemsController {
	
    @Autowired
	private OrderItemsService orderItemsService;

    @GetMapping
    public List<OrderItems> getAllOrderItemss () {
        return orderItemsService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public OrderItems getOrderItemsById(@PathVariable("id") Integer orderItemId) {
        return orderItemsService.getOrderItemsById(orderItemId);
    }

    @PostMapping("/saveOrderItems")
    public ResponseEntity<String> saveOrderItems(@RequestBody OrderItems vOrderItems) {
        orderItemsService.saveOrderItems(vOrderItems);
        return ResponseEntity.ok("OrderItems Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItemsById(@PathVariable("id") Integer orderItemId) {
        orderItemsService.deleteByorderItemId(orderItemId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<OrderItems>> searchOrderItems(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<OrderItems> resultOrderItemsList = orderItemsService.searchOrderItems(searchParams);
		return ResponseEntity.ok(resultOrderItemsList);

	}

     
}
