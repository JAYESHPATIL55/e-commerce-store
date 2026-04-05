package com.jayesh.ecommerce.controller;

import com.jayesh.ecommerce.exception.ProductException;
import com.jayesh.ecommerce.exception.UserException;
import com.jayesh.ecommerce.model.Review;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.request.ReviewRequest;
import com.jayesh.ecommerce.service.ReviewService;
import com.jayesh.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {


    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
        public ResponseEntity<Review> createReviewReview (@RequestBody ReviewRequest req,
                                                          @RequestHeader("Authorization") String jwt) throws UserException, ProductException {

        User user = userService.findUserProfileByJwt(jwt);

        Review review = reviewService.createReview(req, user);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable Long productId) throws UserException, ProductException {
        List<Review> reviews = reviewService.getAllReview(productId);

        return new ResponseEntity<>( reviews, HttpStatus.ACCEPTED);
    }




}
