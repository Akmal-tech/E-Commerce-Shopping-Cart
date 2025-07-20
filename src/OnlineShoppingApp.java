import java.util.Scanner;

public class OnlineShoppingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        User user = new User("Akmal", shop);

        System.out.println("Welcome, " + user.getUsername());

        boolean shopping = true;
        while (shopping) {
            shop.displayProduct();

            System.out.println("\n1. Add to Cart\n2. Remove from Cart\n3. View Cart\n4. Checkout\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID to add: ");
                    String addId = scanner.nextLine();
                    Product prodToAdd = shop.findProductById(addId);
                    if (prodToAdd != null) {
                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();
                        user.getCart().addProduct(prodToAdd, qty);
                        System.out.println("Product added.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    String removeId = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int removeQty = scanner.nextInt();
                    scanner.nextLine();
                    user.getCart().removeProduct(removeId, removeQty);
                    break;

                case 3:
                    user.getCart().displayCart();
                    break;

                case 4:
                    double total = user.getCart().calculateTotalCost();
                    System.out.println("Total Amount: Rs. " + total);
                    System.out.println("Thank you for shopping!");
                    shopping = false;
                    break;

                case 5:
                    shopping = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
