package com.jayesh.ecommerce.service;

import com.jayesh.ecommerce.exception.ProductException;
import com.jayesh.ecommerce.model.Cart;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);
}