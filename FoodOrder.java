package mycode;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private FoodItem foodItem;
    private int quantity;

    public OrderItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return foodItem.getPrice() * quantity;
    }
}

class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}

class Menu {
    private List<FoodItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return items;
    }
}

public class FoodOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu m = new Menu();
        m.addItem(new FoodItem("Burger", 140));
        m.addItem(new FoodItem("Pizza", 300));
        m.addItem(new FoodItem("Pasta", 249));
        m.addItem(new FoodItem("Biryani", 400));

        Order order = new Order();

        while (true) {
            System.out.println("Menu:");
            List<FoodItem> items = m.getItems();
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + 1 + ". " + items.get(i).getName() + " - ₹" + items.get(i).getPrice());
            }

            System.out.print("Enter item number to add to order: ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > items.size()) {
                System.out.println("Invalid choice. Please select a valid item.");
            } else {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                if (quantity < 1) {
                    System.out.println("Quantity must be at least 1.");
                } else {
                    FoodItem selectedFoodItem = items.get(choice - 1);
                    OrderItem orderItem = new OrderItem(selectedFoodItem, quantity);
                    order.addItem(orderItem);
                    System.out.println("Added " + quantity + " " + selectedFoodItem.getName() + " to your order.");
                }
            }
        }

        System.out.println("\nOrder Summary:");
        List<OrderItem> orderItems = order.getItems();
        for (OrderItem item : orderItems) {
            System.out.println(item.getQuantity() + " " + item.getFoodItem().getName() + " - Rs" + item.getTotalPrice());
        }
        System.out.println("Total Price: Rs" + order.getTotalPrice());

    }
}

