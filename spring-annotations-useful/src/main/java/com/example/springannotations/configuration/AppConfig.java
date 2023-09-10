package com.example.springannotations.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springannotations.controller.RestaurantController;
import com.example.springannotations.service.HotDrink;
import com.example.springannotations.service.impl.Tea;

//----------------------JAVA BASED CONFIGURATION-------------------

// ----------------@Configuration at the top of a class and inside it methods with @Bean-------------------
//here we use new keyword to create object and then hand over these objects to Spring container, so it can be
//injected in any class using @Autowired

@Configuration
public class AppConfig {
	@Bean
	public HotDrink hotDrink() {
		return new Tea();
	}
	
	@Bean
	public RestaurantController restaurantController() {
		return new RestaurantController(hotDrink());
	}
}
