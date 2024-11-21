package controller;



import java.util.List;


//import com.example.test.model.OrderItem;
//import com.example.test.service.impl.OrderItemService;
import impl.OrderItemService;
import model.OrderItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {




    private final OrderItemService orderItemService;




    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }




    @GetMapping
    @Operation(summary = "Get a list of all order items", tags = {"Order-Items-Controller"})
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }




    @GetMapping("/{id}")
    @Operation(summary = "Get an order item by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Found the order item",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = OrderItem.class))),
                    @ApiResponse(responseCode = "404", description = "Order item not found")
            }, tags = {"Order-Items-Controller"})
    public ResponseEntity<OrderItem> getOrderItemById(@Parameter(description = "ID of the order item to be obtained")
                                                      @PathVariable Long id) {
        OrderItem orderItem = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(orderItem);
    }




    @PostMapping
    @Operation(summary = "Create a new order item",
            responses = @ApiResponse(responseCode = "201", description = "Order item created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderItem.class))), tags = {"Order-Items-Controller"})
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem newOrderItem = orderItemService.saveOrderItem(orderItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderItem);
    }




    @PutMapping("/{id}")
    @Operation(summary = "Update an existing order item",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order item updated",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = OrderItem.class))),
                    @ApiResponse(responseCode = "404", description = "Order item not found")
            }, tags = {"Order-Items-Controller"})
    public ResponseEntity<OrderItem> updateOrderItem(@Parameter(description = "ID of the order item to be updated")
                                                     @PathVariable Long id, @RequestBody OrderItem orderItemDetails) {
        OrderItem updatedOrderItem = orderItemService.updateOrderItem(id, orderItemDetails);
        return ResponseEntity.ok(updatedOrderItem);
    }




    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an order item by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order item deleted"),
                    @ApiResponse(responseCode = "404", description = "Order item not found")
            }, tags = {"Order-Items-Controller"})
    public ResponseEntity<Void> deleteOrderItem(@Parameter(description = "ID of the order item to be deleted")
                                                @PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.ok().build();
    }
}














