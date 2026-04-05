package com.jayesh.ecommerce.controller;


import com.jayesh.ecommerce.exception.ProductException;
import com.jayesh.ecommerce.exception.UserException;
import com.jayesh.ecommerce.model.Rating;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.request.RatingRequest;
import com.jayesh.ecommerce.service.RatingService;
import com.jayesh.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {


    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> creatingrating (@RequestBody RatingRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt( jwt );
        Rating rating = ratingService.createRating( req , user);

        return new ResponseEntity<Rating>( rating, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating (@PathVariable Long productId,
                                                             @RequestHeader("Authorization") String jwt) throws UserException, ProductException {

        User user = userService.findUserProfileByJwt( jwt);

        List<Rating> ratings = ratingService.getProductsRating( productId);

        return new ResponseEntity<>(ratings, HttpStatus.CREATED);

    }
}
