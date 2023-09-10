package com.example.springannotations.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.example.springannotations.service.HotDrink;

public class Tea implements HotDrink {
	//Reading value from properties file
	
    @Value("${creater}")
	private String createdBy;
	@Override
	public String hot() {
		// TODO Auto-generated method stub
		return "Tea with added milk created By "+createdBy;
	}

}
