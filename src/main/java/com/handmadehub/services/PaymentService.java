package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.Payment;
import com.handmadehub.repositories.PaymentRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import java.util.Map;

import java.util.List;

@Service
public class PaymentService {
	
    @Autowired
	private PaymentRepository paymentRepo;

    public void savePayment (Payment vPayment) { 
        paymentRepo.save(vPayment);
    }

    public void deleteBypaymentId (Integer paymentId) {
		paymentRepo.deleteById(paymentId);
	}

    public Payment getPaymentById (Integer paymentId) {
        return paymentRepo.findById(paymentId).get();
    }

    public List<Payment> getAllPayment () {
        return paymentRepo.findAll();
    }

    public List<Payment> searchPayment(Map<String, Object> searchParams) {
    	
            Specification<Payment> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return paymentRepo.findAll(spec);       
    }

     
}
