package com.electronicwebshop.service;

import com.electronicwebshop.model.Cart;

public interface CartService {
    Cart getCartById(int cartId);

    void update(Cart cart);
}
