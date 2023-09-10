package com.sahay.expensemanagementapi.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sahay.expensemanagementapi.entity.User;
import com.sahay.expensemanagementapi.exception.EmailAllreadyExistException;
import com.sahay.expensemanagementapi.exception.UserNotFoundException;
import com.sahay.expensemanagementapi.repository.UserRepository;
import com.sahay.expensemanagementapi.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    
/*
 * ----------------- Before saving the USER we are checking if Email already exist,--- if not than
 *   encoding Password and than Save it to DB
 * 
 * */
     

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new EmailAllreadyExistException("Email allready registered");
		}
		//Before saving the userPassword it should be encrypted
		String encodedPassword=passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

/*
 * Get the LoggedInUser object and delete it
 * 
 * */
	
	@Override
	public String deleteUser() {
		// TODO Auto-generated method stub
		User user = findById();
		
		userRepository.delete(user);
		return "User Deleted Successfully";
	}
/*
 * This method is internally using getLoggedInUser()--->SecurityContextHolder.getContext().getAuthentication();
 * 
 * from Authentication object get the email by calling authentication.getName();
 * extracting User object from DB and 
 *          than setting new info to to User object, 
 *          encoding the received password from POSTMAN and than save it
 * */
	
	@Override
	public User updateUser(User usr) {
		// TODO Auto-generated method stub
		User user = findById();
		user.setAge(usr.getAge());
		user.setEmail(usr.getEmail());
		user.setName(usr.getName());
		
		String encodedPassword=passwordEncoder.encode(usr.getPassword());
		user.setPassword(encodedPassword);
		
		return userRepository.save(user);
	}

/*
 * This method is calling getLoggedInUser(), it will return User object.
 * From that object, get the id and extract User from DB. 
 * --------------------------I feel this method is not important---------------------
 * */
	
	@Override
	public User findById() {
		// TODO Auto-generated method stub
		long id = getLoggedInUser().getId();
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found with id: "+id));
	}

/*---------------This is the most important method.---------------------------------------------
 *  (1)get Authentication object from SecurityContextHolder.
 * Then extract email from that Authentication Object
 * Then find user by email from database
 *     and return the User object
 * */ 
	
	@Override
	public User getLoggedInUser() {
		// To return the logged in user object 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		
		User user = userRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("No User Found with email: "+email));
		return user;
	}

}
