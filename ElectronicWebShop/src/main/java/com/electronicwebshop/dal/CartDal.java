package com.electronicwebshop.dal;

import com.electronicwebshop.model.Cart;

public interface CartDal {
    Cart getCartById(int cartId);

    void update(Cart cart);
}
