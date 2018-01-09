package com.iins.modules.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class AddressCtrl {

    @Autowired
    private final AddressRepo addressRepo;

    public AddressCtrl(AddressRepo repository) {
        this.addressRepo = repository;
    }

    @PostConstruct
    private void initialization() {
        addressRepo.saveAll(Flux.just(
                new Address("93 Eaglecrest", "", "", "Kitchener","ON.","Canada","N2K 0C4"),
                new Address("7 Willow", "", "", "Waterloo","ON.","Canada","N2K 0C4")//String id,String itemName,String itemKey,String parentId,String parentMenu
        )).subscribe();
    }

    /**
     * GET ALL Customers
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        Flux<Address> customers = addressRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(customers, Address.class);
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
