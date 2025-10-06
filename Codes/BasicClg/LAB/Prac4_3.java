// Prac4_3.java
import java.util.*;

// Custom Checked Exception
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

// Custom Unchecked Exception
class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class Product {
    int id;
    String name;
    int quantity;

    Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void purchaseProduct(int productId, int quantityToPurchase)
            throws ProductNotFoundException {
        for (Product p : products) {
            if (p.id == productId) {
                if (quantityToPurchase > p.quantity)
                    throw new InsufficientStockException("Not enough stock for " + p.name);
                p.quantity -= quantityToPurchase;
                System.out.println("Purchased " + quantityToPurchase + " of " + p.name);
                return;
            }
        }
        throw new ProductNotFoundException("Product ID " + productId + " not found in inventory.");
    }
}

public class Prac4_3 {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product(1, "Keyboard", 10));
        inv.addProduct(new Product(2, "Mouse", 5));

        try {
            inv.purchaseProduct(1, 3); // valid
            inv.purchaseProduct(2, 10); // insufficient stock
            inv.purchaseProduct(5, 2);  // product not found
        } catch (ProductNotFoundException e) {
            System.out.println("Inventory Error: " + e.getMessage());
        }

        System.out.println("24CE055<-->Urval Kheni");
    }
}
