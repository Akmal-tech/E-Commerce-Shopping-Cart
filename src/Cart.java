import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> cartItems = new HashMap<>();
    private Shop shop;

    public Cart(Shop shop) {
        this.shop = shop;
    }

    public void addProduct(Product product, int quantity) {
        String id = product.getId();
        cartItems.put(id, cartItems.getOrDefault(id, 0) + quantity);
    }

    public void removeProduct(String productId, int quantity) {
        if (cartItems.containsKey(productId)) {
            int currentQty = cartItems.get(productId);
            if (quantity >= currentQty) {
                cartItems.remove(productId);
            } else {
                cartItems.put(productId, currentQty - quantity);
            }
        } else {
            System.out.println("Product not found in cart.");
        }
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("Your Cart:");
        for (String id : cartItems.keySet()) {
            Product p = shop.findProductById(id);
            int qty = cartItems.get(id);
            System.out.println("- " + p.getName() + " | Price: Rs. " + p.getPrice() + " | Quantity: " + qty);
        }
    }

    public double calculateTotalCost() {
        double total = 0;
        for (String id : cartItems.keySet()) {
            Product p = shop.findProductById(id);
            total += p.getPrice() * cartItems.get(id);
        }
        return total;
    }
}
