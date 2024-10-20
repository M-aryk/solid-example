package order;

import product.Product;

import java.util.ArrayList;
import java.util.List;


public class ShoppingBasket {
    private List<Product> purchase = new ArrayList<>();
    private int amount;

    public ShoppingBasket() {
    }

    public void addInBasket(Product product, int quantity) {
        purchase.add(product);
        amount = product.getPrice() * quantity;
    }

    public List<Product> getPurchase() {
        return purchase;
    }

    public int getAmount() {
        return amount;
    }
}
