package com.electronicwebshop.controller;

import com.electronicwebshop.dal.CartDal;
import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Cart;
import com.electronicwebshop.model.CartItem;
import com.electronicwebshop.model.Proizvod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
    @Autowired
    private CartDal cartDal;

    @Autowired
    private ProizvodDal proizvodDal;


    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartDal.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartDal.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartDal.delete(cartId);
    }

    @RequestMapping(value = "/add/{proizvodId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable String proizvodId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDal.read(sessionId);

        if (cart == null) {
            cart = cartDal.create(new Cart(sessionId));
        }

        Proizvod proizvod = proizvodDal.getProizvodById(proizvodId);

        if (proizvod == null) {
            throw new IllegalArgumentException(new Exception());
        }
        cart.addCartItem(new CartItem(proizvod));

        cartDal.update(sessionId, cart);
    }

    @RequestMapping(value = "remove/{proizvodId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable String proizvodId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDal.read(sessionId);

        if (cart == null) {
            cart = cartDal.create(new Cart(sessionId));
        }
        Proizvod proizvod = proizvodDal.getProizvodById(proizvodId);
        if (proizvod == null) {
            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(proizvod));

        cartDal.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload!")
    public void handleClientErrors(Exception e) {
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handleSerrverError(Exception e) {
    }
}
