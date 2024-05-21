package org.example.appecomtech.web;

import org.example.appecomtech.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart/add")
    public ResponseEntity<String> addToCart(@RequestBody Map<String, Long> payload) {
        Long productId = payload.get("id");
        cartService.addProductToCart(productId);
        return ResponseEntity.ok("Product added to cart");
    }
}
