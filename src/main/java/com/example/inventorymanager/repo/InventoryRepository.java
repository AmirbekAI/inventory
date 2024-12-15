package com.example.inventorymanager.repository;

import com.example.inventorymanager.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query("SELECT i FROM Inventory i WHERE i.quantity < i.minimumStockLevel")
    List<Inventory> findLowStockProducts();
}
