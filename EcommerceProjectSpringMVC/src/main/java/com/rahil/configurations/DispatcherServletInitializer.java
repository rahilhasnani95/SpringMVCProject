package com.rahil.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com.rahil.controllers", "com.rahil.dao", "com.rahil.service", "com.rahil.entities"})
@ComponentScan({"com.rahil"})
public class DispatcherServletInitializer {

	/*
	 * @Bean public ModelAndView getmodelview() { return new ModelAndView(); }
	 */
	
	/*
	 * @Bean public InternalResourceViewResolver getViewResolver() {
	 * InternalResourceViewResolver vr = new InternalResourceViewResolver();
	 * 
	 * vr.setSuffix(".jsp");
	 * 
	 * return vr; }
	 */
	 
}
