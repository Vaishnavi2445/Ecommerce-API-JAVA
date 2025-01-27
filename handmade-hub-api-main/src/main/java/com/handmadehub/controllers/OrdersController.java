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

import com.handmadehub.entities.Orders;
import com.handmadehub.services.OrdersService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/orders")
public class OrdersController {
	
    @Autowired
	private OrdersService ordersService;

    @GetMapping
    public List<Orders> getAllOrderss () {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrdersById(@PathVariable("id") Integer orderId) {
        return ordersService.getOrdersById(orderId);
    }

    @PostMapping("/saveOrders")
    public ResponseEntity<String> saveOrders(@RequestBody Orders vOrders) {
        ordersService.saveOrders(vOrders);
        return ResponseEntity.ok("Orders Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteOrdersById(@PathVariable("id") Integer orderId) {
        ordersService.deleteByorderId(orderId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Orders>> searchOrders(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Orders> resultOrdersList = ordersService.searchOrders(searchParams);
		return ResponseEntity.ok(resultOrdersList);

	}

     
}
