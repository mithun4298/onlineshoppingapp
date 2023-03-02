package com.iiht.fse.productservice.serviceimpl;


import com.iiht.fse.productservice.model.Product;
import com.iiht.fse.productservice.repository.ProductRepository;
import com.iiht.fse.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByName(String name) throws Exception {
        List<Product> product = productRepository.findByName(name);
        if(product.isEmpty()){
            throw new Exception("No products found with provided name");

        }
        else{
            return product.get(0);
        }
    }

    @Override
    public Product addProduct(Product product) throws Exception{
        List<Product> repoProduct = productRepository.findByName(product.getName());
        if(repoProduct.isEmpty()){
            return productRepository.save(product);
        }
        else{
            throw new Exception("Product already exists with provided name");


        }
    }

    @Override
    public List<Product> deleteProduct(String name) {
        productRepository.deleteByName(name);
        return productRepository.findAll();
    }

    @Override
    public Product updateProductStatus(String name, Product product) throws Exception {
        List<Product> optionalProduct = productRepository.findByName(name);
        if(!optionalProduct.isEmpty()){
            Product repoProduct = optionalProduct.get(0);
            repoProduct.setName(product.getName());
            repoProduct.setDescription(product.getDescription());
            repoProduct.setPrice(product.getPrice());
            repoProduct.setQuantity(product.getQuantity());
            repoProduct.setStatus(product.getStatus());
            repoProduct.setFeatures(product.getFeatures());
            return productRepository.save(repoProduct);
        }
        else{
            throw new Exception("No product found with provided name");
        }

    }

}
