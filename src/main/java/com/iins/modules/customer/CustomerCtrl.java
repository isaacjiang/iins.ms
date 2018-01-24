package com.iins.modules.customer;

import com.iins.system.menuitem.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.http.MediaType;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class CustomerCtrl {

    @Autowired
    private final CustomerRepo customerRepo;

    public CustomerCtrl(CustomerRepo repository) {
        this.customerRepo = repository;
    }

    @PostConstruct
    private void initialization() {
        customerRepo.saveAll(Flux.just(
                new Customer("10", "Profile", "cutomer_profile", "F"),
                new Customer("11", "Policy Information", "cutomer_profile", "M")//String id,String itemName,String itemKey,String parentId,String parentMenu
        )).subscribe();

    }

    /**
     * GET ALL Customers
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        Flux<Customer> customers = customerRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(customers, Customer.class);
    }
//
//    /**
//     * GET a TravelInsuranceQuote by ID
//     */
//    public Mono<ServerResponse> getCustomer(ServerRequest request) {
//        // parse path-variable
//        long customerId = Long.valueOf(request.pathVariable("id"));
//
//        // build notFound response
//        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
//
//        // get customer from repository
//        Mono<TravelInsuranceQuote> customerMono = customerRepository.getCustomerById(customerId);
//
//        // build response
//        return customerMono
//                .flatMap(customer -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(customer)))
//                .switchIfEmpty(notFound);
//    }
//
//    /**
//     * POST a TravelInsuranceQuote
//     */
//    public Mono<ServerResponse> postCustomer(ServerRequest request) {
//        Mono<TravelInsuranceQuote> customer = request.bodyToMono(TravelInsuranceQuote.class);
//
//        return customerRepository.saveCustomer(customer)
//                .flatMap(cust -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(cust)));
//    }
//
//    /**
//     * PUT a TravelInsuranceQuote
//     */
//    public Mono<ServerResponse> putCustomer(ServerRequest request) {
//        // parse id from path-variable
//        long customerId = Long.valueOf(request.pathVariable("id"));
//
//        // get customer data from request object
//        Mono<TravelInsuranceQuote> customer = request.bodyToMono(TravelInsuranceQuote.class);
//
//        // get customer from repository
//        Mono<TravelInsuranceQuote> responseMono = customerRepository.putCustomer(customerId, customer);
//
//        // build response
//        return responseMono
//                .flatMap(cust -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(cust)));
//    }
//
//    /**
//     * DELETE a TravelInsuranceQuote
//     */
//    public Mono<ServerResponse> deleteCustomer(ServerRequest request) {
//        // parse id from path-variable
//        long customerId = Long.valueOf(request.pathVariable("id"));
//
//        // build response
//        return ServerResponse.ok().build(customerRepository.deleteCustomer(customerId));
//    }
}
