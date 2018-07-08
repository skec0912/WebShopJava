package com.electronicwebshop.service.impl;

import com.electronicwebshop.dal.CartDal;
import com.electronicwebshop.service.CartService;
import com.electronicwebshop.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDal cartDal;

    public Cart getCartById(int cartId){
        return cartDal.getCartById(cartId);
    }
    public void update(Cart cart){
        cartDal.update(cart);
    }
}
