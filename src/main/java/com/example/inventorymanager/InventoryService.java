package com.example.inventorymanager;

import com.example.inventorymanager.Inventory;
import com.example.inventorymanager.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    public void addStock(Long productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for product"));
        
        inventory.setQuantity(inventory.getQuantity() + quantity);
        inventoryRepository.save(inventory);
    }

    public void deductStock(Long productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for product"));
        
        if (inventory.getQuantity() < quantity) {
            throw new InsufficientStockException("Insufficient stock available");
        }
        
        inventory.setQuantity(inventory.getQuantity() - quantity);
        inventoryRepository.save(inventory);
    }

    public Integer checkStock(Long productId) {
        return inventoryRepository.findByProductId(productId)
            .map(Inventory::getQuantity)
            .orElseThrow(() -> new ResourceNotFoundException("Inventory not found for product"));
    }

    public List<String> getLowStockReport() {
        List<Inventory> lowStockItems = inventoryRepository.findByQuantityLessThan(10);
        return lowStockItems.stream()
            .map(inventory -> String.format("Product: %s (ID: %d) - Current Stock: %d",
                inventory.getProduct().getName(),
                inventory.getProduct().getId(),
                inventory.getQuantity()))
            .collect(Collectors.toList());
    }
} 