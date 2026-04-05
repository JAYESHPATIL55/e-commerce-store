package com.jayesh.ecommerce.service;

import com.jayesh.ecommerce.exception.ProductException;
import com.jayesh.ecommerce.model.Review;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);
}