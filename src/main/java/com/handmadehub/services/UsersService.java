package com.handmadehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.handmadehub.entities.Users;
import com.handmadehub.repositories.UserRepository;
import com.handmadehub.utils.PasswordUtil;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UsersService {

    @Autowired
    private UserRepository usersRepo;
     
    public void deleteUserById(Integer id) {
        usersRepo.deleteById(id);
    }
 
    public Users getUserById(Integer id) {
        return usersRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }
    
    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }
    
    public Page<Users> getAllUsers(Pageable pageable) {
        return usersRepo.findAll(pageable);
    }
     
    public List<Users> searchUsers(Map<String, Object> searchParams) {
        Specification<Users> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            searchParams.forEach((key, value) -> {
                predicates.add(criteriaBuilder.equal(root.get(key), value));
            });
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return usersRepo.findAll(spec);
    }
    
    public boolean isEmailRegistered (String emailId) {
    	return usersRepo.existsByEmailId(emailId);
    }
    
    public void saveUser(Users user) {
    	String hashedPassword = PasswordUtil.hashPassword(user.getPassword());
    	user.setPassword(hashedPassword);
    
        usersRepo.save(user);
    }
    
    public boolean loginUser(String email, String password) {
    	
    	Users users = usersRepo.findByEmailId(email);
    	
    	if(users == null) {
    		return false; //user not found
    	}
    	

    	return PasswordUtil.verifyPassword(password, users.getPassword());
//    	return false;
    }
}
