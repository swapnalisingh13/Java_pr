package AmazonSystem.Order;
import AmazonSystem.Product.*;
import AmazonSystem.Customer.*;

import java.util.HashMap;

public class Order {
    private int orderId;
    private Customer customer;
    private HashMap<Integer, String> orderStatus;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderStatus = new HashMap<>();
    }

    public void updateOrderStatus(int statusId, String status) {
        orderStatus.put(statusId, status);
    }


    public String getOrderStatus(int orderId) {
        return orderStatus.getOrDefault(orderId, "Order not found.");
    }

    public String getOrderStatusByCustomerId(int customerId) {
        StringBuilder sb = new StringBuilder();
        for (int key : orderStatus.keySet()) {
            if (key / 1000 == customerId) {
                sb.append("Order ID: ").append(key).append(" | Status: ").append(orderStatus.get(key)).append("\n");
            }
        }
        return sb.toString();
    }

    public String getOrderTracking(int orderId) {
        String status = orderStatus.getOrDefault(orderId, "Order not found.");
        if (!status.equals("Order not found.")) {
            return "Order ID: " + orderId + " | Status: " + status;
        }
        return "Order not found.";
    }

}

