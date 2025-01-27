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

import com.handmadehub.entities.Booking;
import com.handmadehub.services.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
    @Autowired
	private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings () {
        return bookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable("id") Integer id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/saveBooking")
    public ResponseEntity<String> saveBooking(@RequestBody Booking vBooking) {
        bookingService.saveBooking(vBooking);
        return ResponseEntity.ok("Booking Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteBookingById(@PathVariable("id") Integer id) {
        bookingService.deleteByid(id);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Booking>> searchBooking(
			@RequestParam(required = false) String varA 
			//add more fileds like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Booking> resultBookingList = bookingService.searchBooking(searchParams);
		return ResponseEntity.ok(resultBookingList);

	}    
}
