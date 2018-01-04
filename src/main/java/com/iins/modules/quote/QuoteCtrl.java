package com.iins.modules.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class QuoteCtrl {

    @Autowired
    private final QuoteRepo quoteRepo;

    public QuoteCtrl(QuoteRepo repository) {
        this.quoteRepo = repository;
    }

    @PostConstruct
    private void initialization() {
        quoteRepo.saveAll(Flux.just(
                new Quote("10", "Profile", "cutomer_profile", 69),
                new Quote("11", "Contact Information", "cutomer_profile", 8)//String id,String itemName,String itemKey,String parentId,String parentMenu
        )).subscribe();
        System.out.println("Init Menu ==============================");
    }

    /**
     * GET ALL Customers
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        Flux<Quote> customers = quoteRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(customers, Quote.class);
    }
//
//    /**
//     * GET a Quote by ID
//     */
//    public Mono<ServerResponse> getCustomer(ServerRequest request) {
//        // parse path-variable
//        long customerId = Long.valueOf(request.pathVariable("id"));
//
//        // build notFound response
//        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
//
//        // get customer from repository
//        Mono<Quote> customerMono = customerRepository.getCustomerById(customerId);
//
//        // build response
//        return customerMono
//                .flatMap(customer -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(customer)))
//                .switchIfEmpty(notFound);
//    }
//
//    /**
//     * POST a Quote
//     */
//    public Mono<ServerResponse> postCustomer(ServerRequest request) {
//        Mono<Quote> customer = request.bodyToMono(Quote.class);
//
//        return customerRepository.saveCustomer(customer)
//                .flatMap(cust -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(cust)));
//    }
//
//    /**
//     * PUT a Quote
//     */
//    public Mono<ServerResponse> putCustomer(ServerRequest request) {
//        // parse id from path-variable
//        long customerId = Long.valueOf(request.pathVariable("id"));
//
//        // get customer data from request object
//        Mono<Quote> customer = request.bodyToMono(Quote.class);
//
//        // get customer from repository
//        Mono<Quote> responseMono = customerRepository.putCustomer(customerId, customer);
//
//        // build response
//        return responseMono
//                .flatMap(cust -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(cust)));
//    }
//
//    /**
//     * DELETE a Quote
//     */
//    public Mono<ServerResponse> deleteCustomer(ServerRequest request) {
//        // parse id from path-variable
//        long customerId = Long.valueOf(request.pathVariable("id"));
//
//        // build response
//        return ServerResponse.ok().build(customerRepository.deleteCustomer(customerId));
//    }
}
