package Pr_6_B_OrderSystem;

import java.util.Map;
import java.util.UUID;

public class Order {
    private String orderId;
    private Map<String, Integer> items;

    public Order(Map<String, Integer> items) {
        this.orderId = UUID.randomUUID().toString();
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}
