package com.iiht.fse.productservice.controller;

import com.iiht.fse.productservice.authorization.JwtTokenUtil;
import com.iiht.fse.productservice.model.Product;
import com.iiht.fse.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/token")
    public ResponseEntity<String> addToken(){
        return new ResponseEntity<>(jwtTokenUtil.generateToken("tharun@gmail.com"), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) throws Exception{
        return new ResponseEntity<>(productService.getProductByName(name),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws Exception{
        return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
    }

    @PostMapping("/update/{name}")
    public ResponseEntity<Product> updateProductStatus(@RequestBody Product product,@PathVariable String name) throws Exception{
        return new ResponseEntity<>(productService.updateProductStatus(name,product),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable String name){
        return new ResponseEntity<>(productService.deleteProduct(name),HttpStatus.OK);
    }
}
