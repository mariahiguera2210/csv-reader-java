package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsService {

    List<Product> productList;
    public ProductsService() {
        productList = new ArrayList<>();
    }

    public void loadProductsFromCSV(String csvFilePath){
        try {
            File file = new File(csvFilePath);
            Scanner fileScanner = new Scanner(file);
            //Saltar el encabezado del CSV
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                if (productInfo.length == 6) {

                    String name = productInfo[0];
                    String description = productInfo[1];
                    String category = productInfo[2];
                    String tags = productInfo[3];
                    float price = productInfo[4].isEmpty() ? (float) 0.0 :Float.parseFloat(productInfo[4]);
                    String imageUrl = productInfo[5];
                    Product product = new Product(name, description, category, tags, price, imageUrl);
                    System.out.println(product);
                    productList.add(product);

                }
                System.out.println(line);
                //TODO implement the logic to transform this code so it can convert the information in each line into a Product objet
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProductList() {
        return productList;
    }
}
