package com.youtube.springbasicsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.springbasicsecurity.entity.LoginModel;
import com.youtube.springbasicsecurity.entity.User;
import com.youtube.springbasicsecurity.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;
	private AuthenticationManager authenticationManager;
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@RequestBody User user ){
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> test(@RequestBody LoginModel loginModel){
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginModel.getUsernameOrEmail(), 
				loginModel.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		return new ResponseEntity<String>("Login Successful",HttpStatus.OK);
	}
}
