package com.jayesh.ecommerce.service;

import com.jayesh.ecommerce.exception.UserException;
import com.jayesh.ecommerce.model.User;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}