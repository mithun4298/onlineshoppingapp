package com.iiht.fse.userservice.repositories;

import com.iiht.fse.userservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    public List<Customer> findByLoginId(String longId);

}
