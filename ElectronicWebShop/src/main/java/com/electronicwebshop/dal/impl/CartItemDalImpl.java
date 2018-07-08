package com.electronicwebshop.dal.impl;

import com.electronicwebshop.dal.CartItemDal;
import com.electronicwebshop.model.Cart;
import com.electronicwebshop.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDalImpl implements CartItemDal {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems){
            removeCartItem(item);
        }
    }

    @Override
    public CartItem getCartItemByProizvodId(int proizvodId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where proizvodId = ?");
        query.setInteger(0,proizvodId);
        session.flush();

        return (CartItem) query.uniqueResult();

    }
}
