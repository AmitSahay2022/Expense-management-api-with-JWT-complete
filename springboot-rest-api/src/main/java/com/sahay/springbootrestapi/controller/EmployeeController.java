package com.sahay.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@GetMapping
	public ResponseEntity<String> getEmployees(){
		return new ResponseEntity<>("List Of All Employees",HttpStatus.OK);
	}
}
