package ie.atu.orderprocessingservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderService {

    private List<Order> orderList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        order.setStatus("Pending"); // Set initial status
        orderList.add(order);
        return ResponseEntity.ok("Order placed successfully");
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                return ResponseEntity.ok(order);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/{orderId}/confirm")
    public ResponseEntity<String> confirmOrder(@PathVariable Long orderId) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                order.setStatus("Confirmed");
                return ResponseEntity.ok("Order confirmed successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<String> cancelOrder(@PathVariable Long orderId) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                order.setStatus("Cancelled");
                return ResponseEntity.ok("Order cancelled successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
    }
}
