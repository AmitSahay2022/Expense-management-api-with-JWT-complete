package com.example.springannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springannotations.controller.HotelController;
import com.example.springannotations.controller.RestaurantController;

//NOTE: @Component,@Controller,@Service,@Repository (@Primary,@Qualifier)
//These annotations are used in Annotation Based Configuration

@SpringBootApplication
public class SpringAnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringAnnotationsApplication.class, args);
	
	    HotelController bean = context.getBean(HotelController.class);
	    System.out.println(bean.getPizza());
	    
	    System.out.println(bean.getBiryani());
	    
	    System.out.println(bean.drink());
	    
	    RestaurantController bean2 = context.getBean(RestaurantController.class);
	    
	    System.out.println(bean2.getBreakFast());
	    
	   
	    
	}

}
