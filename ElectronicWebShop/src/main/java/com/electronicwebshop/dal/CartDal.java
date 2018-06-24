package com.electronicwebshop.dal;

import com.electronicwebshop.model.Cart;

public interface CartDal {
    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
