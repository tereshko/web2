package me.tereshko.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> products;
    @Autowired
    private ProductRepository productRepository;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProductById(int id) {
        Product product = productRepository.getProductById(id);
        products.add(product);
    }

    public void removeProductById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                products.remove(i);
            }
        }
    }

    public List<Product> getCart() {
        return products;
    }

    public void newCart() {
        this.products = new ArrayList<>();
    }
}
