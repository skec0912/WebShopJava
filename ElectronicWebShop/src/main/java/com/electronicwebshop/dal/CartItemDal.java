package com.electronicwebshop.dal;

import com.electronicwebshop.model.Cart;
import com.electronicwebshop.model.CartItem;

public interface CartItemDal {
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProizvodId(int proizvodId);
}
