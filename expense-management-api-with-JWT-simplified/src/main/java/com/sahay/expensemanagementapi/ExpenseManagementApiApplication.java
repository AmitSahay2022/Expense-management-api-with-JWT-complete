package com.sahay.expensemanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementApiApplication.class, args);
	}
	
    
}



/*
Step 1: <!-- ADD JWT Dependency Step 1/5 -->

Step 2: Step 2/5 create class  for Generating JWT Token and validating JWT Token

Step 3: Step 3/5 THIS CLASS IS JWT Custom filter

Step 4: Step 4/5
 *          Adding the JWT filter before the Spring basic security filter
 *          and DaoAuthenticationProvider to get the database support for JWT 
 *          

Step 5: Step:5/5    Create Login method in AuthController to return JWT Token to the user as response to
                  Successful login
*/