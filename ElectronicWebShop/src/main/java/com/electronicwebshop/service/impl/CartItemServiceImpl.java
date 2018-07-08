package com.electronicwebshop.service.impl;

import com.electronicwebshop.dal.CartItemDal;
import com.electronicwebshop.model.Cart;
import com.electronicwebshop.model.CartItem;
import com.electronicwebshop.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDal cartItemDal;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDal.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDal.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDal.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProizvodId( int proizvodId){
        return cartItemDal.getCartItemByProizvodId(proizvodId);
    }
}
