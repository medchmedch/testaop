package com.women.empowerment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WomenEmpowermentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WomenEmpowermentApplication.class, args);
	}

}
