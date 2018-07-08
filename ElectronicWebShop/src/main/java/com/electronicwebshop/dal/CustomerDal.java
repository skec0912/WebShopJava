package com.electronicwebshop.dal;

import com.electronicwebshop.model.Customer;

import java.util.List;

public interface CustomerDal {
    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}
