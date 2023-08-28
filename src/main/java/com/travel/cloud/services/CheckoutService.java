package com.travel.cloud.services;

import com.travel.cloud.dto.Purchase;
import com.travel.cloud.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeCart(Purchase purchase);
}

