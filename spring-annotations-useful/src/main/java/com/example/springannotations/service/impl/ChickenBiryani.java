package com.example.springannotations.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.springannotations.service.Biryani;
@Component
@Primary
public class ChickenBiryani implements Biryani {
    @Value("${java.home}")
	private String javaHome;
	@Override
	public String getBiryani() {
		// TODO Auto-generated method stub
		System.out.println(javaHome);
		return "Chicken Biryani 200 RS" ;
	}

}

//------@Value can read value from System variable as well as from Properties file
