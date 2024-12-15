// src/main/java/com/example/inventorymanager/repository/CategoryRepository.java
package com.example.inventorymanager.repository;

import com.example.inventorymanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}