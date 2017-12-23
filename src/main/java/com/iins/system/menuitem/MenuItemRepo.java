package com.iins.system.menuitem;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepo extends ReactiveMongoRepository<MenuItem, String> {

}
