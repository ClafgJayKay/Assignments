package October4;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrList {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        Product product1 = new Product("Fridge", 500.50);
        Product product2 = new Product("Fan", 20.20);
        Product product3 = new Product("Aircon", 600.20);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        productList.sort(Comparator.comparing(Product::getPrice));
        System.out.println(productList);
    }
}
