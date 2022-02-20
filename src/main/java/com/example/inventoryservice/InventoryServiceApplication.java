package com.example.inventoryservice;

import com.example.inventoryservice.entity.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Product.class);
        productRepository.save(new Product(null, "produit1", 100, 20));
        productRepository.save(new Product(null, "produit2", 200, 30));
        productRepository.save(new Product(null, "produit3", 500, 10));
        productRepository.save(new Product(null, "produit4", 400, 40));
        productRepository.save(new Product(null, "produit5", 800, 25));
    }
}
