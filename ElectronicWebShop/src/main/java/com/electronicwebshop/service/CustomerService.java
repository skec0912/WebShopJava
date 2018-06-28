package com.electronicwebshop.service;

import com.electronicwebshop.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();
}
