package com.kutayyaman.issuemanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IssueManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(IssueManagementApplication.class, args);

	}

	@Bean//ModelMapper nesnesinden 1 tane olustur ve springin IoC containerina koy demis oluyoruz ve boylelikle dependency injection ile direkt alip kullanabilcez.
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
