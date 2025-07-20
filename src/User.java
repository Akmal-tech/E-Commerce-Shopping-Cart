public class User {
    private String username;
    private Cart cart;

    public User(String username, Shop shop) {
        this.username = username;
        this.cart = new Cart(shop);
    }

    public String getUsername() {
        return username;
    }

    public Cart getCart() {
        return cart;
    }
}
