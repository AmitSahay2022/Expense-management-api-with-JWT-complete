package com.example.springannotations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.springannotations.service.Biryani;
import com.example.springannotations.service.HotDrink;
import com.example.springannotations.service.Pizza;

@Component
public class HotelController {
	@Autowired
	private @Qualifier("nonvegPizza") Pizza pizza;
	@Autowired
	private Biryani biryani;
	@Autowired
	private HotDrink hotDrink;

	public String getPizza() {
		return pizza.getPizza();
	}
	
	public String getBiryani() {
		return biryani.getBiryani();
	}
	
	public String drink() {
		return hotDrink.hot();
	}
}
