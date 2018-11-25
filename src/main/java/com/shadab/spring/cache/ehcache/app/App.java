package com.shadab.spring.cache.ehcache.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.shadab.spring.cache.ehcache.configuration.ApplicationConfig;
import com.shadab.spring.cache.ehcache.services.StudentService;
import com.shadab.spring.cache.ehcache.services.StudentServices;


public class App {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		StudentService studentServices = (StudentService) context.getBean("studentServices");
		
		System.out.println("Making First call to get Student :"+studentServices.getByRoll("123"));
		System.out.println("Making Second call to get Student :"+studentServices.getByRoll("123"));
		System.out.println("Making Third call to get Student :"+studentServices.getByRoll("123"));
		
		studentServices.evictStudents();
		
		System.out.println("Making First call to get Student :"+studentServices.getByRoll("123"));
		System.out.println("Making Second call to get Student :"+studentServices.getByRoll("123"));
		System.out.println("Making Third call to get Student :"+studentServices.getByRoll("123"));
		
		
studentServices.evictStudents();
		
		System.out.println("Making First call to get Student :"+studentServices.getByRoll("125"));
		System.out.println("Making Second call to get Student :"+studentServices.getByRoll("125"));
		System.out.println("Making Third call to get Student :"+studentServices.getByRoll("125"));
		
		System.out.println("Making First call to get Student :"+studentServices.getByRoll("128"));
		System.out.println("Making Second call to get Student :"+studentServices.getByRoll("128"));
		System.out.println("Making Third call to get Student :"+studentServices.getByRoll("128"));
		
		((AbstractApplicationContext) context).close();
	}

}
