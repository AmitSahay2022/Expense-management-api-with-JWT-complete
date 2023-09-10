package com.youtube.springbasicsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
   @GetMapping("/contact")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<>("Contact Page !!!",HttpStatus.OK);
	}
   @GetMapping("/home")
	public ResponseEntity<String> getMessage2(){
		return new ResponseEntity<>("Home Page !!!",HttpStatus.OK);
	}
   
   @GetMapping("/allemp")
	public ResponseEntity<String> getMessage5(){
		return new ResponseEntity<>("Hello Every authenticated One !!!",HttpStatus.OK);
	}
   //------------These two below API is ROLE BASED AUTHENTICATION----------------
  
   //----------FOR NOW I HAVE NOT SAVED ROLES IN DB AND NOT UPDATED CustomUserDetailsService to read ROLE------
   @GetMapping("/normaluser")
	public ResponseEntity<String> getMessage3(){
		return new ResponseEntity<>("Hello Normal User !!!",HttpStatus.OK);
	}
   @GetMapping("/admin")
	public ResponseEntity<String> getMessage4(){
		return new ResponseEntity<>("Hello Admin User !!!",HttpStatus.OK);
	}
}
