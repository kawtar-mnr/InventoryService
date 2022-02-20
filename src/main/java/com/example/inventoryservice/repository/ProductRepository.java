package com.example.inventoryservice.repository;

import com.example.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
