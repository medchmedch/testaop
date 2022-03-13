package com.women.empowerment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.women.empowerment.services.EmailSenderService;




@SpringBootApplication
@EnableScheduling
public class WomenApplication {
	
	
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(WomenApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
		
		senderService.sendEmail( "mouhamedamine.hasnaoui@esprit.tn",
				                "This is subject : Women Empowerment ",
				                "body of mail : Bonjour Madame il faut contacter le psy    ");
	}
}
