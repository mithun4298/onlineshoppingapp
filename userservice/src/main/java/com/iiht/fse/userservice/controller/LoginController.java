package com.iiht.fse.userservice.controller;

import com.iiht.fse.userservice.authorization.JwtTokenUtil;
import com.iiht.fse.userservice.model.Customer;
import com.iiht.fse.userservice.model.CustomerData;
import com.iiht.fse.userservice.model.LoginResponse;
import com.iiht.fse.userservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer) throws Exception {

     Customer response=   loginService.registerCustomer(customer);

        return new ResponseEntity<Customer>(response,HttpStatus.OK);


    }
    @GetMapping("/hii")
    public String login(){
        return "hii";
    }

    @PostMapping("/loginUser")
    public ResponseEntity<LoginResponse> login (@RequestBody CustomerData customerData) throws Exception{
        Customer response = loginService.login(customerData);
        final String token =jwtTokenUtil.generateToken(customerData.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCustomer(response);
        loginResponse.setToken(token);
        return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);

    }
    @PostMapping("/forgetPassword")
    public ResponseEntity<Customer> changePassword(@RequestBody  CustomerData customerData) throws Exception {
        Customer response = loginService.chnagePassword(customerData);
        return new ResponseEntity<Customer>(response,HttpStatus.OK);
    }

}
