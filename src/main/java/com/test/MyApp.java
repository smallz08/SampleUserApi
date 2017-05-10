package main.java.com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MyApp {
	
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
}
