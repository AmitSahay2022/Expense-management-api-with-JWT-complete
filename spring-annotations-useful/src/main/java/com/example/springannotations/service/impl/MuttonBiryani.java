package com.example.springannotations.service.impl;

import org.springframework.stereotype.Component;

import com.example.springannotations.service.Biryani;

@Component
public class MuttonBiryani implements Biryani {

	@Override
	public String getBiryani() {
		// TODO Auto-generated method stub

		return "Mutton Biryani 280 RS";
	}

}
