package com.example.inventorymanager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/{productId}/add")
    public ResponseEntity<Void> addStock(
            @PathVariable Long productId,
            @RequestParam @Min(1) Integer quantity) {
        inventoryService.addStock(productId, quantity);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{productId}/deduct")
    public ResponseEntity<Void> deductStock(
            @PathVariable Long productId,
            @RequestParam @Min(1) Integer quantity) {
        inventoryService.deductStock(productId, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{productId}/stock")
    public ResponseEntity<Integer> checkStock(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.checkStock(productId));
    }

    @GetMapping("/low-stock-report")
    public ResponseEntity<List<String>> getLowStockReport() {
        return ResponseEntity.ok(inventoryService.getLowStockReport());
    }
} 