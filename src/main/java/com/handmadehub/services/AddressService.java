package com.handmadehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.handmadehub.entities.Address;
import com.handmadehub.repositories.AddressRepository;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AddressService {
	
    @Autowired
	private AddressRepository addressRepo;

    public void saveAddress (Address vAddress) { 
        addressRepo.save(vAddress);
    }

    public void deleteByid (Integer id) {
		addressRepo.deleteById(id);
	}

    public List<Address> getAllAddress () {
        return addressRepo.findAll();
    }

    public Address getAddressById (Integer id) {
        return addressRepo.findById(id)
        		.orElseThrow(() -> new IllegalArgumentException("Address not found with id: " + id));
    }
    
    public List<Address> searchAddresses(Map<String, Object> searchParams) {
    	
            Specification<Address> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return addressRepo.findAll(spec);       
    }
    
}
