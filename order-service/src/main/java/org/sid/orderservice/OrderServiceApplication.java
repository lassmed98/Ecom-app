package org.sid.orderservice;

import org.sid.orderservice.entities.ProductItem;
import org.sid.orderservice.entities.order;
import org.sid.orderservice.enums.OrderStatus;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repo.OrderRepository;
import org.sid.orderservice.repo.ProductItemRepository;
import org.sid.orderservice.services.CustomerRestClientService;
import org.sid.orderservice.services.ProductRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@EnableFeignClients
@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

@Bean
	CommandLineRunner start(ProductItemRepository productItemRepository,
							OrderRepository orderRepository,
							CustomerRestClientService customerRestClientService,
							ProductRestClientService productRestClientService){
		return args -> {
			List<Customer> customers=customerRestClientService.allcustomers().getContent().stream().toList();
			List<Product> products=productRestClientService.allproducts().getContent().stream().toList();
			Random random=new Random();
			for (int i=0 ; i <20 ;i++){
				order ordr=order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random()>0.5? OrderStatus.PENDING:OrderStatus.CREATED)
						.createdAt(new Date())
						.build();
				order saveOrder =orderRepository.save(ordr);
				for(int j=0;j<products.size();j++){
					if(Math.random()>0.70) {
						ProductItem productItem = ProductItem.builder()
								.order(saveOrder)
								.productId(products.get(j).getId())
								.price(products.get(j).getPrice())
								.quantity(1 + random.nextInt(10))
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);
					}
				}
			}
		};
}
}
