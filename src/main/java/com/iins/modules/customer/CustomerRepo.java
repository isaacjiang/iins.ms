package com.iins.modules.customer;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends ReactiveMongoRepository<Customer, String> {
//    public Mono<Customer> getCustomerById(Long id);
//
//    public Flux<Customer> getAllCustomers();
//   public Mono<Customer> saveCustomer(Mono<Customer> customer);
//
//    public Mono<Customer> putCustomer(Long id, Mono<Customer> customer);
//
//    public Mono<Void> deleteCustomer(Long id);
}
