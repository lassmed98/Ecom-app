package org.sid.orderservice.web;

import org.sid.customerservice.entities.customer;
import org.sid.orderservice.entities.order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repo.OrderRepository;
import org.sid.orderservice.repo.ProductItemRepository;
import org.sid.orderservice.services.CustomerRestClientService;
import org.sid.orderservice.services.ProductRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private ProductRestClientService productRestClientService;

    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, ProductRestClientService productRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.productRestClientService = productRestClientService;
    }
@GetMapping("/fullOrder/{id}")
    public order getOrder(@PathVariable Long id){
        order ordr=orderRepository.findById(id).get();
    Customer customer=customerRestClientService.customerById(ordr.getCustomerId());
    ordr.setCustomer(customer);
        ordr.getProductItemList().forEach(pi->{
            Product product=productRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return ordr;
    }
}
