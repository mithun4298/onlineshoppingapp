package com.iiht.fse.userservice.repositories;



import com.iiht.fse.userservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

    public List<Product> findByName(String name);
    public Integer deleteByName(String name);
}
