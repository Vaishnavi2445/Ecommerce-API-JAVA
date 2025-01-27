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

import com.handmadehub.entities.TransactionsList;
import com.handmadehub.services.TransactionsListService;

import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/transactionsList")
public class TransactionsListController {
	
    @Autowired
	private TransactionsListService transactionsListService;

    @GetMapping
    public List<TransactionsList> getAllTransactionsLists () {
        return transactionsListService.getAllTransactionsList();
    }

    @GetMapping("/{id}")
    public TransactionsList getTransactionsListById(@PathVariable("id") Integer id) {
        return transactionsListService.getTransactionsListById(id);
    }

    @PostMapping("/saveTransactionsList")
    public ResponseEntity<String> saveTransactionsList(@RequestBody TransactionsList vTransactionsList) {
        transactionsListService.saveTransactionsList(vTransactionsList);
        return ResponseEntity.ok("Transaction Saved Successfully.");
    }

    @DeleteMapping("/{id}")
    public void deleteTransactionsListById(@PathVariable("id") Integer id) {
        transactionsListService.deleteByid(id);
    }
    
    @GetMapping("/search")
	public ResponseEntity<List<TransactionsList>> searchTransactionsList(
			@RequestParam(required = false) String varA 
			//add more fields like above
			) {

		Map<String, Object> searchParams = new HashMap<>();
		
		if(varA != null) searchParams.put("varA", varA);
		// put more like above in map
		
		List<TransactionsList> resultTransactionsListList = transactionsListService.searchTransactionsList(searchParams);
		return ResponseEntity.ok(resultTransactionsListList);

	}

     
}
