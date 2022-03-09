package com.women.empowerment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableSwagger2
@EnableScheduling
public class WomenEmpowermentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WomenEmpowermentApplication.class, args);
	}

}
