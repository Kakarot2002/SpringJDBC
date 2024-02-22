package com.prabhat.SpringJDBCDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.prabhat.SpringJDBCDemo.model.Alien;
import com.prabhat.SpringJDBCDemo.repo.AlienRepo;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);

		alien1.setId(111);
		alien1.setName("Prabhat");
		alien1.setTech("Java");

		AlienRepo repo = context.getBean(AlienRepo.class);

		repo.save(alien1);


		//returning the list of alien

		System.out.println(repo.findAll());
	}

}
