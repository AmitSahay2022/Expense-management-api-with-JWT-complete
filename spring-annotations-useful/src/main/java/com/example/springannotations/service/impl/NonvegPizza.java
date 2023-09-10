package com.example.springannotations.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.springannotations.service.Pizza;

@Component
public class NonvegPizza implements Pizza {
	@Value("${host.email}")
	private String email;

	@Override
	public String getPizza() {
		// TODO Auto-generated method stub
		System.out.println(email);
		return "Chicken Pizza is hot and testy";
	}

}
