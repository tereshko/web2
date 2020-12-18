package me.tereshko.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(int productId) {
        for (Product product:products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Milk", 5.99));
        products.add(new Product(2, "Cucumber", 1.99));
        products.add(new Product(3, "Whole grains", 0.99));
        products.add(new Product(4, "Salad", 3.99));
        products.add(new Product(5, "Chicken", 9.99));
    }
}
