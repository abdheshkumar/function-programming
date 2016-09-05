package parkar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdhesh.Kumar on 01-09-2016.
 */
public class User {
    private String name;
    private List<Order> orders;

    public User() {
        orders = new ArrayList<Order>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        for (Order order : orders) {
            products.addAll(order.getProducts());
        }
        return products;
    }
}