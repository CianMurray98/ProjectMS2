package ie.atu.orderprocessingservice;

import java.util.List;

public class Order {
    private Long orderId;
    private List<OrderItem> orderItems;
    private double totalPrice;
    private String status;

    public Order() {
        // Default constructor needed for serialization/deserialization
    }

    public Order(Long orderId, List<OrderItem> orderItems, double totalPrice, String status) {
        this.orderId = orderId;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItems=" + orderItems +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }
}