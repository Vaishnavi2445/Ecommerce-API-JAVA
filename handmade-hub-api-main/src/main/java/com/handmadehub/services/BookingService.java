package com.handmadehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.Booking;
import com.handmadehub.repositories.BookingRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import java.util.Map;

import java.util.List;

@Service
public class BookingService {
	
    @Autowired
	private BookingRepository bookingRepo;

    public void saveBooking (Booking vBooking) { 
        bookingRepo.save(vBooking);
    }

    public void deleteByid (Integer id) {
		bookingRepo.deleteById(id);
	}

    public Booking getBookingById (Integer id) {
        return bookingRepo.findById(id).get();
    }

    public List<Booking> getAllBooking () {
        return bookingRepo.findAll();
    }

    public List<Booking> searchBooking(Map<String, Object> searchParams) {
    	
            Specification<Booking> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return bookingRepo.findAll(spec);       
    }

}
