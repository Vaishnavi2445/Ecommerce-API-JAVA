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

import com.handmadehub.entities.Cart;
import com.handmadehub.services.CartService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/cart")
public class CartController {
	
    @Autowired
	private CartService cartService;

    @GetMapping
    public List<Cart> getAllCarts () {
        return cartService.getAllCart();
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable("id") Integer cartId) {
        return cartService.getCartById(cartId);
    }

    @PostMapping("/saveCart")
    public ResponseEntity<String> saveCart(@RequestBody Cart vCart) {
        cartService.saveCart(vCart);
        return ResponseEntity.ok("Cart Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteCartById(@PathVariable("id") Integer cartId) {
        cartService.deleteBycartId(cartId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Cart>> searchCart(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Cart> resultCartList = cartService.searchCart(searchParams);
		return ResponseEntity.ok(resultCartList);

	}

     
}
