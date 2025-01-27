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

import com.handmadehub.entities.Payment;
import com.handmadehub.services.PaymentService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	
    @Autowired
	private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments () {
        return paymentService.getAllPayment();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable("id") Integer paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping("/savePayment")
    public ResponseEntity<String> savePayment(@RequestBody Payment vPayment) {
        paymentService.savePayment(vPayment);
        return ResponseEntity.ok("Payment Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deletePaymentById(@PathVariable("id") Integer paymentId) {
        paymentService.deleteBypaymentId(paymentId);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<Payment>> searchPayment(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<Payment> resultPaymentList = paymentService.searchPayment(searchParams);
		return ResponseEntity.ok(resultPaymentList);

	}

     
}
