package com.jayesh.ecommerce.repository;

import com.jayesh.ecommerce.model.Cart;
import com.jayesh.ecommerce.model.CartItem;
import com.jayesh.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    @Query("SELECT c FROM CartItem c WHERE c.cart=:cart And c.product=:product And c.size=:size And c.userId=:userId")
    public CartItem isCartItemExist(@Param("cart") Cart cart, @Param("product") Product product, @Param("size") String size, @Param("userId") Long userId);
}