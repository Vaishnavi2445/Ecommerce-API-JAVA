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
import com.handmadehub.entities.Users;
import com.handmadehub.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUsersById(@PathVariable("id") Integer id) {
        return usersService.getUserById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {
        usersService.deleteUserById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Users>> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String mobile,
            @RequestParam(required = false) String email) {

        Map<String, Object> searchParams = new HashMap<>();

        // Add parameters to the search map if they are provided
        if (name != null) searchParams.put("name", name);
        if (mobile != null) searchParams.put("mobileNo", mobile);
        if (email != null) searchParams.put("emailId", email);

        List<Users> users = usersService.searchUsers(searchParams);
        return ResponseEntity.ok(users);
    }
    
    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody Users vUsers) {
    	System.out.print("in save user method");
    	usersService.saveUser(vUsers);
        return ResponseEntity.ok("User Registered Successfully.");
    }
    
    @GetMapping("/checkEmail")
    public ResponseEntity<String> checkEmailAvailability(@RequestParam String emailId) {
        boolean isEmailRegistered = usersService.isEmailRegistered(emailId);
        
        if(isEmailRegistered) {
        	return ResponseEntity.ok("Email Id Already Registered!");
        } else {
            return ResponseEntity.ok("Email ID is available");
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Users user){
    	boolean isPasswordMatched = usersService.loginUser(user.getEmailId(), user.getPassword());
    	
    	if(isPasswordMatched) {
    		return ResponseEntity.ok("Password Verified Successfully.");
    	} else {
            return ResponseEntity.status(401).body("Invalid email or password");
    	}
    }
}


