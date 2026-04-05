package com.jayesh.ecommerce.service;

import com.jayesh.ecommerce.exception.ProductException;
import com.jayesh.ecommerce.model.Product;
import com.jayesh.ecommerce.model.Review;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.repository.ProductRepository;
import com.jayesh.ecommerce.repository.ReviewRepository;
import com.jayesh.ecommerce.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService{

    private ReviewRepository reviewRepository;
    private ProductService productService;
    private ProductRepository productRepository;


    public ReviewServiceImplementation(ReviewRepository reviewRepository, ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}