package com.example.inventorymanager.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private Long productId;
    
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;
    
    @Min(value = 0, message = "Minimum stock level cannot be negative")
    private Integer minimumStockLevel;
}
