package AmazonSystem;
import AmazonSystem.Customer.*;
import AmazonSystem.Product.*;
import AmazonSystem.Order.*;
import java.util.Scanner;
import java.util.*;


public class AmazonMain {
    public static void main(String[] args){
        System.out.println("Amazon System!!!!!");

        //System.out.println("");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        TreeSet<Customer> activeCustomers = new TreeSet<>(Comparator.comparing(Customer::getCustomerId));

        ArrayList<Product> products = new ArrayList<>();

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Product Catalog");
            System.out.println("2. Customer Management");
            System.out.println("3. Order Details");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Product Catalog
                    System.out.println("Product Catalog:");
                    System.out.println("Product ID | Product Name | Quantity | Price ");
                    for (Product product : products) {
                        System.out.println(product.getProductId() + " | " + product.getProductName() + " | "
                                + product.getQuantity() + " | $" + product.getPrice() );
                    }
                    System.out.println("Options:");
                    System.out.println("1. Edit Product Details");
                    System.out.println("2. See Product Quantity");
                    System.out.println("3. Search Product Quantity");
                    System.out.println("4. Add Product");

                    int productOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (productOption) {
                        case 1:
                            // Edit Product Details
                            System.out.println("Enter Product ID to edit:");
                            int editProductId = scanner.nextInt();
                            scanner.nextLine();


                            for (Product product : products) {
                                if (product.getProductId() == editProductId) {
                                    System.out.println("Enter new quantity:");
                                    int newQuantity = scanner.nextInt();
                                    product.setQuantity(newQuantity);
                                    System.out.println("Product quantity updated successfully!");
                                    break;
                                }
                            }
                            break;

                        case 2:
                            // See Product Quantity
                            System.out.println("Enter Product ID to see quantity:");
                            int seeQuantityId = scanner.nextInt();
                            scanner.nextLine();

                            for (Product product : products) {
                                if (product.getProductId() == seeQuantityId) {
                                    System.out.println("Product Quantity: " + product.getQuantity());
                                    break;
                                }
                            }
                            break;

                        case 3:
                            // Search Product Quantity
                            System.out.println("Enter Product Name to search quantity:");
                            String searchProductName = scanner.nextLine();

                            boolean productFound = false;
                            for (Product product : products) {
                                if (product.getProductName().equalsIgnoreCase(searchProductName)) {
                                    System.out.println("Product Quantity: " + product.getQuantity());
                                    productFound = true;
                                }
                            }
                            if (!productFound) {
                                System.out.println("Product not found.");
                            }
                            break;

                        case 4:
                            // Add Product
                            System.out.println("Enter Product ID:");
                            int newProductId = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter Product Name:");
                            String newProductName = scanner.nextLine();

                            System.out.println("Enter Product Quantity:");
                            int newProductQuantity = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter Product Price:");
                            double newProductPrice = scanner.nextDouble();
                            scanner.nextLine();

                            Product newProduct = new Product(newProductId, newProductName, newProductPrice);
                            newProduct.setQuantity(newProductQuantity);

                            boolean productExists = false;
                            for (Product product : products) {
                                if (product.getProductId() == newProductId) {
                                    productExists = true;
                                    break;
                                }
                            }

                            if (!productExists) {
                                products.add(newProduct);
                                System.out.println("Product added successfully!");
                            } else {
                                System.out.println("Product ID already exists. Product not added.");
                            }
                            break;


                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;


                case 2:
                    // Customer Management
                    System.out.println("Customer Management:");
                    System.out.println("Options:");
                    System.out.println("1. Add Customer");
                    System.out.println("2. See Active Customers");
                    System.out.println("3. Customer Details (By Customer ID)");
                    System.out.println("4. Delete Customer");

                    int customerOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (customerOption) {
                        case 1:
                            // Add Customer
                            System.out.println("Enter Customer ID:");
                            int customerId = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter Customer Name:");
                            String customerName = scanner.nextLine();

                            System.out.println("Enter Customer Email:");
                            String customerEmail = scanner.nextLine();

                            Customer newCustomer = new Customer(customerId, customerName, customerEmail);
                            activeCustomers.add(newCustomer);
                            System.out.println("Customer added successfully!");
                            break;

                        case 2:
                            // See Active Customers
                            if (activeCustomers.isEmpty()) {
                                System.out.println("No active customers.");
                            } else {
                                System.out.println("Active Customers:");
                                for (Customer customer : activeCustomers) {
                                    System.out.println("ID: " + customer.getCustomerId() + " | Name: " + customer.getName() + " | Email: " + customer.getEmail());
                                }
                            }
                            break;

                        case 3:
                            // Customer Details (By Customer ID)
                            System.out.println("Enter Customer ID:");
                            int searchCustomerId = scanner.nextInt();
                            scanner.nextLine();

                            Customer foundCustomer = null;
                            for (Customer customer : activeCustomers) {
                                if (customer.getCustomerId() == searchCustomerId) {
                                    foundCustomer = customer;
                                    break;
                                }
                            }

                            if (foundCustomer != null) {
                                System.out.println("Customer Details:");
                                System.out.println("ID: " + foundCustomer.getCustomerId() + " | Name: " + foundCustomer.getName() + " | Email: " + foundCustomer.getEmail());
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;

                        case 4:
                            // Delete Customer
                            System.out.println("Enter Customer ID to delete:");
                            int deleteCustomerId = scanner.nextInt();
                            scanner.nextLine();

                            Customer deleteCustomer = null;
                            for (Customer customer : activeCustomers) {
                                if (customer.getCustomerId() == deleteCustomerId) {
                                    deleteCustomer = customer;
                                    break;
                                }
                            }

                            if (deleteCustomer != null) {
                                activeCustomers.remove(deleteCustomer);
                                System.out.println("Customer deleted successfully.");
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;


                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;

                case 3:
                    // Order Details
                    System.out.println("Order Details:");
                    System.out.println("Options:");
                    System.out.println("1. Add Order (By Order ID)");
                    System.out.println("2. Update Order Status (Order Processing)");
                    System.out.println("3. Finish Order");
                    System.out.println("4. Order Tracking");
                    System.out.println("5. Order Status");

                    int orderOption = scanner.nextInt();
                    scanner.nextLine();

                    HashMap<Integer, Order> orderHashMap = new HashMap<>();

                    switch (orderOption) {
                        case 1:

                            System.out.println("Enter Order ID:");
                            int newOrderId = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter Customer ID:");
                            int customerId = scanner.nextInt();
                            scanner.nextLine();
                            Customer orderCustomer = null;
                            for (Customer customer : activeCustomers) {
                                if (customer.getCustomerId() == customerId) {
                                    orderCustomer = customer;
                                    break;
                                }
                            }

                            if (orderCustomer != null) {
                                Order newOrder = new Order(newOrderId, orderCustomer);
                                orderHashMap.put(newOrderId, newOrder);
                                System.out.println("Order added successfully!");
                            } else {
                                System.out.println("Customer not found.");
                            }
                            break;


                        case 2:
                            // Update Order Status (Order Processing)
                            System.out.println("All orders status with OrderID:");
                            for (int key : orderHashMap.keySet()) {
                                System.out.println("Order ID: " + key + " | Status: " + orderHashMap.get(key).getOrderStatus(key));
                            }

                            System.out.println("Enter Order ID to update status:");
                            int updateOrderId = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter new status (transit, out for delivery, delivered):");
                            String newStatus = scanner.nextLine();

                            if (orderHashMap.containsKey(updateOrderId)) {
                                orderHashMap.get(updateOrderId).updateOrderStatus(updateOrderId, newStatus);
                                System.out.println("Status updated successfully!");
                            } else {
                                System.out.println("Order not found.");
                            }
                            break;

                        case 3:
                            System.out.println("Finished Orders (Delivered):");
                            for (int key : orderHashMap.keySet()) {
                                if (orderHashMap.get(key).getOrderStatus(key).equalsIgnoreCase("Delivered")) {
                                    System.out.println("Order ID: " + key + " | Status: " + orderHashMap.get(key).getOrderStatus(key));
                                }
                            }
                            break;

                        case 4:
                            System.out.println("Enter Order ID for tracking:");
                            int trackOrderId = scanner.nextInt();
                            scanner.nextLine();

                            if (orderHashMap.containsKey(trackOrderId)) {
                                System.out.println(orderHashMap.get(trackOrderId).getOrderTracking(trackOrderId));
                            } else {
                                System.out.println("Order not found.");
                            }
                            break;

                        case 5:
                            System.out.println("Enter Customer ID:");
                            int searchCustomerId = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println(orderHashMap.getOrDefault(searchCustomerId, new Order(0, null)).getOrderStatusByCustomerId(searchCustomerId));
                            break;

                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;


                case 4:
                    // Exit the program
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

    }
}