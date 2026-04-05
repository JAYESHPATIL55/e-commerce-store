package com.jayesh.ecommerce.controller;

import com.jayesh.ecommerce.exception.UserException;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler(
            @RequestHeader ("Authorization") String jwt) throws UserException{

        User user = userService.findUserProfileByJwt( jwt);

        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }

}
