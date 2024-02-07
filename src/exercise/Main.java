package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Product {
  private String name;
  private double price;
  private String catagory;

  public Product(String name, double price, String catagory) {
    this.name = name;
    this.price = price;
    this.catagory = catagory;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getCatagory() {
    return catagory;
  }
  @Override
  public String toString() {
    return "Product name=" + name + ", price=" + price + "\u20ac , catagory=" + catagory;
  }
  

}

public class Main {

  public static void main(String[] args) {
    
      List<Product> products = new ArrayList<>(List.of(new Product("Record Player", 199, "Music"),
          new Product("Audio Player", 141, "Music")));
      
      
      System.out.println("Oreginal product:");
      products.forEach(System.out::println);
      System.out.println();
      
      
      List<String> transformation = transform(products, p -> p.getName().toUpperCase());
      List<Product> filterProduct = filterOurProduct(products, p -> p.getPrice() < 150);
      System.out.println("Filtered product:");
      filterProduct.forEach(System.out::println);
      
      System.out.println("\nTransformed name");
      transformation.forEach(System.out::println);
      
      
      
  }

  public static List<String> transform(List<Product> products, Function<Product, String> transformation) {
    List<String> transformProduct = new ArrayList<>();
    for (Product product : products) {
      String transformProduc = transformation.apply(product);
      transformProduct.add(transformProduc);
    }

    return transformProduct;

  }

  public static List<Product> filterOurProduct(List<Product> products, Predicate<Product> prediction) {
    List<Product> filtered = new ArrayList<>();
    for (Product product : products) {
      if (prediction.test(product)) {
        filtered.add(product);
      }
    }
    return filtered;

  }

}
