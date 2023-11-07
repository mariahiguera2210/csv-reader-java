import model.Product;
import model.ProductsService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductsService productsService = new ProductsService();
        productsService.loadProductsFromCSV("resources/inventory.csv");
        List<Product> productList = productsService.getProductList();
        long totalProducts = productList.size();
        System.out.println("LISTA DE PRODUCTOS" + productList);
        System.out.println("En total hay " + totalProducts + " en invenatario");

    }
}