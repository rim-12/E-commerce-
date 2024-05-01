package com.example.OrderServices.Controller;

import com.example.OrderServices.Entities.Dtos.OrderItemRequest;
import com.example.OrderServices.Services.OrderItemService;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/order/api/v1/orderItems")
public class OrderItemController {
    @Autowired
    private final OrderItemService orderItemService;

    @GetMapping("/")
    public ResponseEntity<?> getAllOrderItems() {
        try {
            return new ResponseEntity<>(orderItemService.getAllOrderItems(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch OrderItems", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> createOrderItem(@RequestBody OrderItemRequest orderItemRequest) {
//        try {
//            return new ResponseEntity<>(categoryService.createCategory(categoryRequestDto), HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to create category", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        try{
            return new ResponseEntity<>(orderItemService.createOrderItem(orderItemRequest), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to create orderItem", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderItemById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(orderItemService.getOrderItemById(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch orderItem", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemRequest orderItemRequest) {
        try {
            return new ResponseEntity<>(orderItemService.updateOrderItem(id,orderItemRequest),HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update orderItem", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable Long id) {
        try {
            orderItemService.deleteOrderItem(id);
            return ResponseEntity.ok("OrderItem with ID " + id + " deleted successfully");
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete OrderItem", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
