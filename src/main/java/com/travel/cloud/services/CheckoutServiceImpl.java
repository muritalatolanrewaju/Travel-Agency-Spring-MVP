package com.travel.cloud.services;

import com.travel.cloud.dao.CartRepository;
import com.travel.cloud.dto.Purchase;
import com.travel.cloud.dto.PurchaseResponse;
import com.travel.cloud.entities.Cart;
import com.travel.cloud.entities.CartItem;
import com.travel.cloud.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeCart(Purchase purchase) {
        try {
            // Retrieve the cart from the DTO
            Cart cart = purchase.getCart();

            // Generate tracking number
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            // Populate cart with cart items
            Set<CartItem> cartItems = purchase.getCartItems();
            if (cartItems == null || cartItems.isEmpty()) {
                throw new IllegalArgumentException("Cart is empty");
            }
            cartItems.forEach(cart::addCartItem);

            // Populate customer with cart
            Customer customer = purchase.getCustomer();
            if (customer == null) {
                throw new IllegalArgumentException("Customer is null");
            }
            customer.add(cart);

            // Save to the database
            cartRepository.save(cart);

            // Return a response
            return new PurchaseResponse(orderTrackingNumber);
        } catch (IllegalArgumentException e) {
            return new PurchaseResponse("Error: " + e.getMessage());
        }
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
