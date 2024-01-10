package org.sid.customerservice;

import org.sid.customerservice.entities.customer;
import org.sid.customerservice.repo.customerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
@Bean
	CommandLineRunner start(customerRepository cr){
		return args -> {
		cr.saveAll(List.of(
				customer.builder().name("Aya").email("Aya@gmail.com").build(),
				customer.builder().name("Benzidi").email("Benzidi@gmail.com").build(),
				customer.builder().name("Aicha").email("Aicha@gmail.com").build()

		));
		cr.findAll().forEach(System.out::println);
	};
 }}

