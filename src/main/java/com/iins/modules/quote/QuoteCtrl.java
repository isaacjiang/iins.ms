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
    private final TravelInsuranceQuoteRepo travelInsuranceQuoteRepo;

    public QuoteCtrl(TravelInsuranceQuoteRepo repository) {
        this.travelInsuranceQuoteRepo = repository;
    }

    @PostConstruct
    private void initialization() {
        travelInsuranceQuoteRepo.saveAll(Flux.just(
                new TravelInsuranceQuote("SingleTrip", "Canada", "2017-12-01", "2019-02-13","Family"),
                new TravelInsuranceQuote("MultipleTrip", "America", "2018-02-01", "2018-04-13","Self")
        )).subscribe();
            System.out.println("Init Quote ==============================");
    }

    /**
     * GET ALL Customers
     */
    public Mono<ServerResponse> getAllTravelInsuranceQuote(ServerRequest request) {
        // fetch all from repository

        Flux<TravelInsuranceQuote> travelInsuranceQuoteFlux = travelInsuranceQuoteRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(travelInsuranceQuoteFlux, TravelInsuranceQuote.class);
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
