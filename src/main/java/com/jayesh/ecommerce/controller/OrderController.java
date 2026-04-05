package com.jayesh.ecommerce.controller;

import com.jayesh.ecommerce.exception.OrderException;
import com.jayesh.ecommerce.exception.UserException;
import com.jayesh.ecommerce.model.Address;
import com.jayesh.ecommerce.model.Order;
import com.jayesh.ecommerce.model.User;
import com.jayesh.ecommerce.service.OrderService;
import com.jayesh.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order> createdOrder(@RequestBody Address shippingAddress, @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);

        Order order = orderService.createOrder(user, shippingAddress);
        System.out.println("order" + order);

        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>> userOrderHistory(
            @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);

        List<Order> orders = orderService.userOrderHistory(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findOrderById(
            @PathVariable("id") Long orderId,
            @RequestHeader("Authorization") String jwt) throws UserException, OrderException {

        User user = userService.findUserProfileByJwt( jwt);

        Order order = orderService.findOrderById( orderId);

        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }
}

