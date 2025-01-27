package com.handmadehub.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.handmadehub.entities.Address;
import com.handmadehub.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping
	public List<Address> getAllAddresss() {
		return addressService.getAllAddress();
	}

	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable("id") Integer id) {
		return addressService.getAddressById(id);
	}

	@PostMapping("/saveAddress")
	public ResponseEntity<String> saveAddress(@RequestBody Address vAddress) {
		addressService.saveAddress(vAddress);
		return ResponseEntity.ok("Address Saved Successfully.");
	}

	@DeleteMapping("/{id}")
	public void deleteAddressById(@PathVariable("id") Integer id) {
		addressService.deleteByid(id);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Address>> searchAddress(
			@RequestParam(required = false) String fullName,
			@RequestParam(required = false) String pincode, 
			@RequestParam(required = false) String city) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(fullName != null) searchParams.put("fullName", fullName);
		if(pincode != null) searchParams.put("pincode", pincode);
		if(city != null) searchParams.put("city", city);
		
		List<Address> addressList = addressService.searchAddresses(searchParams);
		return ResponseEntity.ok(addressList);

	}

}
