package me.tereshko.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        Cart cart = context.getBean("cart", Cart.class);


        boolean isExit = false;

        while (!isExit) {
            System.out.println("Select the option: ");
            System.out.println("1. Get Cart");
            System.out.println("2. Add item to Cart");
            System.out.println("3. Remove item from Cart");
            System.out.println("4. Show Cart");
            System.out.println("5. Exit");
            System.out.print("what you want to do: ");

            Scanner scanner = new Scanner(System.in);
            int userSelect = 0;
            try{
                userSelect = scanner.nextInt();
            } catch (InputMismatchException e) {

            }
            switch (userSelect){
                case 1:
                    cart.newCart();
                    break;
                case 2:
                    System.out.println("We have those items:");
                    System.out.println(productRepository.getProducts());
                    System.out.println("please select the product id: ");
                    userSelect = scanner.nextInt();
                    cart.addProductById(userSelect);
                    break;
                case 3:
                    System.out.println("We have those items in the cart:");
                    System.out.println(cart.getCart());
                    System.out.println("please select the product id which you want to delete: ");
                    userSelect = scanner.nextInt();
                    System.out.println(userSelect);
                    cart.removeProductById(userSelect);
                    break;
                case 4:
                    System.out.println(cart.getCart());
                    break;
                case 5:
                    isExit = true;
                    System.out.println("The program has ended");
                    break;
                default:
                    System.out.println("Wrong select. You'r choice should be in the range 1...4");
                    break;
            }

        }


        context.close();

    }
}
