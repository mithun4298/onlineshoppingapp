package com.iiht.fse.userservice.serviceimpl;


import com.iiht.fse.userservice.model.Customer;
import com.iiht.fse.userservice.model.CustomerData;
import com.iiht.fse.userservice.repositories.CustomerRepository;
import com.iiht.fse.userservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    CustomerRepository customerRepo;


    @Override
    public Customer registerCustomer(Customer customer) throws Exception {
        Optional<Customer> customerList = customerRepo.findById(customer.getEmail());

        if (!customerList.isPresent()){
            System.out.println(customer.getLoginId());
           List<Customer> customers = customerRepo.findByLoginId((customer.getLoginId()));
           if(customers.isEmpty()){
               return customerRepo.save(customer);
           }
           else{
               throw new Exception("User loginid is alreday taken please try with different login id{}customer.getEmail()");
           }}
           else {
               throw new Exception("please use another email, this email already taken");

        }
    }

    @Override
    public Customer login(CustomerData customerData) throws Exception {
        Optional<Customer> repoCustomerList = customerRepo.findById(customerData.getEmail());
        if (repoCustomerList.isPresent()) {
            Customer repoCustomer = repoCustomerList.get();
            if (repoCustomer.getPassword().equals(customerData.getPassword())) {
                return repoCustomer;
            } else {
                throw new Exception("Password is incorrect");
            }
        } else {
            throw new Exception("No user is found with provided email");
        }


    }

    @Override
    public Customer chnagePassword(CustomerData customerData) throws Exception {
        Optional<Customer> repoCustomerList= customerRepo.findById(customerData.getEmail());
        if(repoCustomerList.isPresent()){
            Customer customerNewPass=repoCustomerList.get();
            if(!customerData.getPassword().equals(customerNewPass.getPassword())){

            customerNewPass.setPassword(customerData.getPassword());
            return customerRepo.save(customerNewPass);
            }
            else {
                throw new Exception("please provide new password , ssems its like older password ");
            }}
        else{
            throw new Exception("no User find with provided email id ");
        }
    }
}
