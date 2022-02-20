package com.example.inventoryservice.web;

import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProductController {


    private final String PRODUCT_TOPIC = "PRODUCT_TOPIC";
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StreamBridge streamBridge;


    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        Product productS = productRepository.save(product);
        streamBridge.send(PRODUCT_TOPIC, productS);
        return productS;
    }

}
