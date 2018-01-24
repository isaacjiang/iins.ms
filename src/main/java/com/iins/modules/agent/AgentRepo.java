package com.iins.modules.agent;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends ReactiveMongoRepository<Agent, String> {
//    public Mono<TravelInsuranceQuote> getCustomerById(Long id);
//
//    public Flux<TravelInsuranceQuote> getAllCustomers();
//   public Mono<TravelInsuranceQuote> saveCustomer(Mono<TravelInsuranceQuote> customer);
//
//    public Mono<TravelInsuranceQuote> putCustomer(Long id, Mono<TravelInsuranceQuote> customer);
//
//    public Mono<Void> deleteCustomer(Long id);
}
