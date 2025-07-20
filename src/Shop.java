import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products = new ArrayList<>();

    public Shop() {
        products.add(new Product("PR001", "Laptop", 75000, 10));
        products.add(new Product("PR002", "Phone", 25000, 20));
        products.add(new Product("PR004", "Tablet", 40000, 15));
        products.add(new Product("PR005", "Smartwatch", 15000, 25));
        products.add(new Product("PR003", "Headphones", 2000, 30));
        products.add(new Product("PR006",  "TV", 80000, 12));
        products.add(new Product("PR007", "Gaming Console", 60000, 18));
        products.add(new Product("PR008", "Camera", 55000, 18));
    }

    public void displayProduct() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            p.displayProduct();
        }
    }

    public Product findProductById(String id) {
        for (Product p : products) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
