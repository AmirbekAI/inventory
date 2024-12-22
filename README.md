# Inventory Management System

A Spring Boot application for managing inventory, products, and categories.

## API Endpoints

### Categories

Base URL: https://inventory-x6q9.onrender.com/

1. **Create Category**
   - Method: `POST`
   - URL: `/api/categories`
   - Body:
   ```json
   {
       "name": "Electronics",
       "description": "Electronic devices and accessories"
   }
   ```

2. **Get All Categories**
   - Method: `GET`
   - URL: `/api/categories`

3. **Get Category by ID**
   - Method: `GET`
   - URL: `/api/categories/{id}`

4. **Update Category**
   - Method: `PUT`
   - URL: `/api/categories/{id}`
   - Body:
   ```json
   {
       "name": "Updated Electronics",
       "description": "Updated description"
   }
   ```

5. **Delete Category**
   - Method: `DELETE`
   - URL: `/api/categories/{id}`

### Products

1. **Create Product**
   - Method: `POST`
   - URL: `/api/products`
   - Body:
   ```json
   {
       "name": "Laptop",
       "description": "High-performance laptop",
       "price": 999.99,
       "categoryId": 1,
       "quantity": 20
   }
   ```

2. **Search Products by Name**
   - Method: `GET`
   - URL: `/api/products/search?name=laptop`

3. **Get Products by Category**
   - Method: `GET`
   - URL: `/api/products/category/{categoryId}`

### Inventory

1. **Add Stock**
   - Method: `POST`
   - URL: `/api/inventory/{productId}/add?quantity=10`

2. **Deduct Stock**
   - Method: `POST`
   - URL: `/api/inventory/{productId}/deduct?quantity=5`

3. **Check Stock**
   - Method: `GET`
   - URL: `/api/inventory/{productId}/stock`

4. **Get Low Stock Report**
   - Method: `GET`
   - URL: `/api/inventory/low-stock-report`

## Example cURL Commands

### Create a Category