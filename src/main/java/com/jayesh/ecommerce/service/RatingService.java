package com.jayesh.ecommerce.service;

import com.jayesh.ecommerce.exception.ProductException;
import com.jayesh.ecommerce.model.Rating;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.request.RatingRequest;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;

    public List<Rating> getProductsRating(Long productId);
}