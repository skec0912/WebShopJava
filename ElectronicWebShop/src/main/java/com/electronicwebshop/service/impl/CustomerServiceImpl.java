package com.electronicwebshop.service.impl;

import com.electronicwebshop.dal.CustomerDal;
import com.electronicwebshop.model.Customer;
import com.electronicwebshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDal customerDal;

    public void addCustomer(Customer customer) {
        customerDal.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDal.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDal.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username) {
        return customerDal.getCustomerByUsername(username);
    }
}

