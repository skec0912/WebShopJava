package com.electronicwebshop.dal.impl;

import com.electronicwebshop.dal.CartDal;
import com.electronicwebshop.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartDalImpl implements CartDal {

    private Map<String, Cart> listOfCarts = new HashMap<String, Cart>();


    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Već postoji kosarica sa tim id-em."));
        }
        listOfCarts.put(cart.getCartId(), cart);

        return cart;
    }

    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    public void update(String cartId, Cart cart){
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Ne postoji kosarica sa tim id-em."));
        }
        listOfCarts.put(cartId,cart);
    }

    public void delete(String cartId){
        if(!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Ne postoji kosarica sa tim id-em."));
        }
        listOfCarts.remove(cartId);
    }
}
