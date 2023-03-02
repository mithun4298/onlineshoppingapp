package com.iiht.fse.userservice.authorization;

import com.iiht.fse.userservice.model.Customer;
import com.iiht.fse.userservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    CustomerRepository customerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Customer> customer = customerRepo.findById(username);
        if (customer.isPresent()) {
            return new User(customer.get().getEmail(), customer.get().getPassword(),
                    new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("user not found with username");
    }
    }
}
