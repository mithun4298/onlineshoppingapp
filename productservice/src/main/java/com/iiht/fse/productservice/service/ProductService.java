package com.iiht.fse.productservice.service;


import com.iiht.fse.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductByName(final String name) throws Exception;

    public Product addProduct(final Product product) throws Exception;

    public Product updateProductStatus(String name, Product product) throws Exception;

    public List<Product> deleteProduct(String name);


}
