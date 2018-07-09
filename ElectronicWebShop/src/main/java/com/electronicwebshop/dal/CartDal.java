package com.electronicwebshop.dal;

import com.electronicwebshop.model.Cart;

import java.io.IOException;

public interface CartDal {
    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;
    void update(Cart cart);
}
