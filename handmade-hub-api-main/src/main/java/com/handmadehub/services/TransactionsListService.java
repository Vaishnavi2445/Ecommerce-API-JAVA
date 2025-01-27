package com.handmadehub.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handmadehub.entities.TransactionsList;
import com.handmadehub.repositories.TransactionsListRepository;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

import java.util.Map;

import java.util.List;

@Service
public class TransactionsListService {
	
    @Autowired
	private TransactionsListRepository transactionsListRepo;

    public void saveTransactionsList (TransactionsList vTransactionsList) { 
        transactionsListRepo.save(vTransactionsList);
    }

    public void deleteByid (Integer id) {
		transactionsListRepo.deleteById(id);
	}

    public TransactionsList getTransactionsListById (Integer id) {
        return transactionsListRepo.findById(id).get();
    }

    public List<TransactionsList> getAllTransactionsList () {
        return transactionsListRepo.findAll();
    }

    public List<TransactionsList> searchTransactionsList(Map<String, Object> searchParams) {
    	
            Specification<TransactionsList> spec = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                searchParams.forEach((key, value) -> {
                    predicates.add(criteriaBuilder.equal(root.get(key), value));
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            return transactionsListRepo.findAll(spec);       
    }

     
}
