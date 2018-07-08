package com.electronicwebshop.service;

import com.electronicwebshop.model.CustomerOrder;

public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
