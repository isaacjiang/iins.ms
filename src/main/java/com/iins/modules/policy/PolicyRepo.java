package com.iins.modules.policy;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepo extends ReactiveMongoRepository<Policy, String> {

}
