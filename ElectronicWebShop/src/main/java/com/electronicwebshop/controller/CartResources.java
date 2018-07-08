package com.electronicwebshop.controller;

import com.electronicwebshop.model.Cart;
import com.electronicwebshop.model.CartItem;
import com.electronicwebshop.model.Customer;
import com.electronicwebshop.model.Proizvod;
import com.electronicwebshop.service.CartItemService;
import com.electronicwebshop.service.CartService;
import com.electronicwebshop.service.CustomerService;
import com.electronicwebshop.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProizvodService proizvodService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById(@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{proizvodId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "proizvodId") int proizvodId, @AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Proizvod proizvod = proizvodService.getProizvodById(proizvodId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i = 0; i < cartItems.size(); i++) {
            if (proizvod.getProizvodId() == cartItems.get(i).getProizvod().getProizvodId()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(proizvod.getCijena() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setProizvod(proizvod);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(proizvod.getCijena() * cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{proizvodId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int proizvodId){
        CartItem cartItem = cartItemService.getCartItemByProizvodId(proizvodId);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") int cartId){
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Illeagl request, please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}
}
