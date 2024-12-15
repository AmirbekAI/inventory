// src/main/java/com/example/inventorymanager/repository/ProductRepository.java
package com.example.inventorymanager.repository;

import com.example.inventorymanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByNameContainingIgnoreCase(String name);
}