package com.example.springannotations.controller;

import com.example.springannotations.service.HotDrink;



public class RestaurantController {
   private HotDrink hotDrink;
   
   public RestaurantController(HotDrink hotDrink) {
	   this.hotDrink=hotDrink;
   }
   
   public String getBreakFast() {
	   String food="Idly and Dosa";
	   return hotDrink.hot()+" !! "+ food;
   }
}
