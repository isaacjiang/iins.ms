package com.iins.modules.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class PolicyCtrl {

    @Autowired
    private final PolicyRepo addressRepo;

    public PolicyCtrl(PolicyRepo repository) {
        this.addressRepo = repository;
    }

    @PostConstruct
    private void initialization() {
        addressRepo.saveAll(Flux.just(
                new Policy("10001","93 Eaglecrest", "", "", "Kitchener","ON.","Canada"),
                new Policy("10002","7 Willow", "", "", "Waterloo","ON.","Canada")//String id,String itemName,String itemKey,String parentId,String parentMenu
        )).subscribe();
    }

    /**
     * GET ALL Customers
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        Flux<Policy> customers = addressRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(customers, Policy.class);
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
