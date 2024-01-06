package Pr_6_B_OrderSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EnhancedOrderFulfillmentSystem {
    private Map<String, Item> inventory;
    private ExecutorService executorService;

    public EnhancedOrderFulfillmentSystem(int numThreads) {
        inventory = new HashMap<>();
        executorService = Executors.newFixedThreadPool(numThreads);
    }

    public synchronized void placeOrder(Order order) {
        // Simulating order processing
        Runnable task = () -> {
            System.out.println("Processing order: " + order.getOrderId());
            for (Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
                String itemName = entry.getKey();
                int quantity = entry.getValue();
                Item item = inventory.get(itemName);
                if (item != null && item.getQuantity() >= quantity) {
                    item.setQuantity(item.getQuantity() - quantity);
                    System.out.println("Item '" + itemName + "' processed for order: " + order.getOrderId());
                } else {
                    System.out.println("Insufficient quantity for item '" + itemName + "' in order: " + order.getOrderId());
                }
            }
        };

        executorService.submit(task);
    }

    public synchronized int checkInventoryAvailability(String itemName) {
        Item item = inventory.get(itemName);
        return item != null ? item.getQuantity() : 0;
    }

    public synchronized void addItemToInventory(String itemName, int quantity) {
        Item item = inventory.getOrDefault(itemName, new Item(itemName, 0));
        item.setQuantity(item.getQuantity() + quantity);
        inventory.put(itemName, item);
    }

    public synchronized void updateInventory(String itemName, int newQuantity) {
        Item item = inventory.get(itemName);
        if (item != null) {
            item.setQuantity(newQuantity);
            inventory.put(itemName, item);
        }
    }

    public synchronized void printInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Item> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getQuantity());
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
