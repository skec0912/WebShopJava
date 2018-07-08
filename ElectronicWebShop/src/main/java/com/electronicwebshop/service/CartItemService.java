package com.electronicwebshop.service;

import com.electronicwebshop.model.Cart;
import com.electronicwebshop.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByProizvodId(int proizvodId);
}
