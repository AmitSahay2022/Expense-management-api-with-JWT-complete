package com.example.springannotations.service.impl;

import org.springframework.stereotype.Component;

import com.example.springannotations.service.Pizza;
@Component
public class VegPizza implements Pizza {

	@Override
	public String getPizza() {
		// TODO Auto-generated method stub
		return "Veg Paneer Pizza is ready";
	}

}
