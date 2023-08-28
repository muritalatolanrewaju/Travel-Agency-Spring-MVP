package com.travel.cloud.dto;

import com.travel.cloud.entities.Cart;
import com.travel.cloud.entities.CartItem;
import com.travel.cloud.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

    public Cart getCart() {
        return cart;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }
}
