package com.iiht.fse.userservice.service;

import com.iiht.fse.userservice.model.CustomerData;
import com.iiht.fse.userservice.model.Customer;

public interface LoginService {
    public Customer registerCustomer(final Customer customer) throws Exception;

    public Customer login(final CustomerData customerData) throws Exception;

    public Customer chnagePassword(final CustomerData customerData) throws Exception;

}
