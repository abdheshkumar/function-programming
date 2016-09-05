package parkar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdhesh.Kumar on 01-09-2016.
 */
public class Order {
    private int id;
    private List<Product> products;

    public Order() {
        products = new ArrayList<Product>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
