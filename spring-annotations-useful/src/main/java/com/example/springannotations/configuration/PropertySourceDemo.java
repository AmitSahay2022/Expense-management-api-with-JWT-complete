package com.example.springannotations.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mail.properties")
public class PropertySourceDemo {

}


/*
 * IF WE HAVE MORE THEN ONE PROPERTIES FILE AND WE ARE READING DATA FROM IT THAN WE SHOULD USE
 *            @PropertySource
 *  THIS ANNOTATION IS ALWAYS USED WITH  @Configuration
 *  MEANS IN JAVA BASED CONFIGURATION
 */