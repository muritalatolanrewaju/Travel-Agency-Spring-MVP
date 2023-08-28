package com.travel.cloud.controllers;

import com.travel.cloud.dto.Purchase;
import com.travel.cloud.dto.PurchaseResponse;
import com.travel.cloud.services.CheckoutService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeCart(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeCart(purchase);

        return purchaseResponse;
    }
}
