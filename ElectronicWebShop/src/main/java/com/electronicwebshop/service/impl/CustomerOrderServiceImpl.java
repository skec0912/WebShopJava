package com.electronicwebshop.service.impl;

import com.electronicwebshop.dal.CustomerOrderDal;
import com.electronicwebshop.model.Cart;
import com.electronicwebshop.model.CartItem;
import com.electronicwebshop.model.CustomerOrder;
import com.electronicwebshop.service.CartService;
import com.electronicwebshop.service.CustomerOrderService;
import com.electronicwebshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDal customerOrderDal;

    @Autowired
    private CartService cartService;



    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDal.addCustomerOrder(customerOrder);
    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }
        return grandTotal;
    }
}
