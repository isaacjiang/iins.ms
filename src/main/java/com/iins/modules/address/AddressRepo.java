package com.iins.modules.address;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ReactiveMongoRepository<Address, String> {

}
