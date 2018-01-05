package com.iins.modules.insurance_company;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceCompanyRepo extends ReactiveMongoRepository<InsuranceCompany, String> {

}
