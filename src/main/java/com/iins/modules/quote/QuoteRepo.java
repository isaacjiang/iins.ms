package com.iins.modules.quote;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepo extends ReactiveMongoRepository<Quote, String> {
//    public Mono<Quote> getCustomerById(Long id);
//
//    public Flux<Quote> getAllCustomers();
//   public Mono<Quote> saveCustomer(Mono<Quote> customer);
//
//    public Mono<Quote> putCustomer(Long id, Mono<Quote> customer);
//
//    public Mono<Void> deleteCustomer(Long id);
}
