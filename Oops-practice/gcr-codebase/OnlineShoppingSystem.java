import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

abstract class Person {
  private int id;
  private String name;
  private String email;

  public Person(int id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}

class Customer extends Person {
  private String city;
  private boolean primeMember;

  public Customer(int id, String name, String email, String city, boolean primeMember) {
    super(id, name, email);
    this.city = city;
    this.primeMember = primeMember;
  }

  public String getCity() {
    return city;
  }

  public boolean isPrimeMember() {
    return primeMember;
  }

  @Override
  public String toString() {
    return "Customer{id=" + getId() + ", name='" + getName() + "', email='" + getEmail() + "', city='" + city
        + "', primeMember=" + primeMember + "}";
  }
}

class Seller extends Person {
  private String companyName;
  private double sellerRating;

  public Seller(int id, String name, String email, String companyName, double sellerRating) {
    super(id, name, email);
    this.companyName = companyName;
    this.sellerRating = sellerRating;
  }

  public String getCompanyName() {
    return companyName;
  }

  public double getSellerRating() {
    return sellerRating;
  }

  @Override
  public String toString() {
    return "Seller{id=" + getId() + ", name='" + getName() + "', email='" + getEmail() + "', companyName='"
        + companyName + "', sellerRating=" + sellerRating + "}";
  }
}

class Product {
  private int productId;
  private String productName;
  private String category;
  private double price;
  private double rating;
  private boolean inStock;
  private Seller seller;

  public Product(int productId, String productName, String category, double price, double rating, boolean inStock,
      Seller seller) {
    this.productId = productId;
    this.productName = productName;
    this.category = category;
    this.price = price;
    this.rating = rating;
    this.inStock = inStock;
    this.seller = seller;
  }

  public int getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public String getCategory() {
    return category;
  }

  public double getPrice() {
    return price;
  }

  public double getRating() {
    return rating;
  }

  public boolean isInStock() {
    return inStock;
  }

  public Seller getSeller() {
    return seller;
  }

  @Override
  public String toString() {
    return "Product{productId=" + productId + ", productName='" + productName + "', category='" + category + "', price="
        + price + ", rating=" + rating + ", inStock=" + inStock + ", seller='" + seller.getCompanyName() + "'}";
  }
}

public class OnlineShoppingSystem {
  public static void main(String[] args) {
    ArrayList<Customer> customers = new ArrayList<>();
    customers.add(new Customer(1, "Asha", "asha@mail.com", "Delhi", true));
    customers.add(new Customer(2, "Ben", "ben@mail.com", "Mumbai", false));
    customers.add(new Customer(3, "Chitra", "chitra@mail.com", "Chennai", true));
    customers.add(new Customer(4, "Dev", "dev@mail.com", "Delhi", false));

    ArrayList<Seller> sellers = new ArrayList<>();
    Seller s1 = new Seller(101, "Ravi", "ravi@seller.com", "Dell", 4.8);
    Seller s2 = new Seller(102, "Meera", "meera@seller.com", "Apple", 4.3);
    Seller s3 = new Seller(103, "Arun", "arun@seller.com", "Samsung", 4.6);
    sellers.add(s1);
    sellers.add(s2);
    sellers.add(s3);

    ArrayList<Product> products = new ArrayList<>();
    products.add(new Product(1, "Laptop", "Electronics", 75000, 4.7, true, s1));
    products.add(new Product(2, "Phone", "Electronics", 65000, 4.5, true, s2));
    products.add(new Product(3, "Headphones", "Accessories", 2500, 4.2, false, s3));
    products.add(new Product(4, "Keyboard", "Accessories", 1500, 4.1, true, s1));
    products.add(new Product(5, "Chair", "Furniture", 8500, 4.0, true, s2));
    products.add(new Product(6, "Table", "Furniture", 12500, 4.4, false, s3));
    products.add(new Product(7, "Monitor", "Electronics", 18000, 4.6, true, s1));
    products.add(new Product(8, "Mouse", "Accessories", 900, 4.3, true, s2));

    System.out
        .println("All product names: " + products.stream().map(Product::getProductName).collect(Collectors.toList()));
    System.out
        .println("In stock products: " + products.stream().filter(Product::isInStock).collect(Collectors.toList()));
    System.out.println("Products costing more than 100: "
        + products.stream().filter(p -> p.getPrice() > 100).collect(Collectors.toList()));
    System.out
        .println("Prime customers: " + customers.stream().filter(Customer::isPrimeMember).collect(Collectors.toList()));
    System.out.println("Sellers with rating above 4.5: "
        + sellers.stream().filter(s -> s.getSellerRating() > 4.5).collect(Collectors.toList()));
    System.out.println("Products sorted by price: "
        + products.stream().sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList()));
    System.out.println("Sellers sorted by rating descending: " + sellers.stream()
        .sorted(Comparator.comparingDouble(Seller::getSellerRating).reversed()).collect(Collectors.toList()));
    System.out.println("Unique product categories: "
        + products.stream().map(Product::getCategory).distinct().collect(Collectors.toList()));
    System.out.println("Count products in stock: " + products.stream().filter(Product::isInStock).count());
    System.out.println(
        "Costliest product: " + products.stream().max(Comparator.comparingDouble(Product::getPrice)).orElse(null));
    System.out.println(
        "Cheapest product: " + products.stream().min(Comparator.comparingDouble(Product::getPrice)).orElse(null));
    System.out
        .println("Average product price: " + products.stream().mapToDouble(Product::getPrice).average().orElse(0));
    System.out.println("Total value of products: " + products.stream().mapToDouble(Product::getPrice).sum());
    System.out.println("All products in stock? " + products.stream().allMatch(Product::isInStock));
    System.out.println("Any customer belongs to Dell? "
        + customers.stream().anyMatch(c -> c.getEmail().toLowerCase().contains("dell")));
    System.out.println(
        "First prime customer: " + customers.stream().filter(Customer::isPrimeMember).findFirst().orElse(null));
    System.out.println("Top 3 highest-rated products: " + products.stream()
        .sorted(Comparator.comparingDouble(Product::getRating).reversed()).limit(3).collect(Collectors.toList()));
    System.out.println(
        "Group products by category: " + products.stream().collect(Collectors.groupingBy(Product::getCategory)));
    System.out.println("Group products by seller: "
        + products.stream().collect(Collectors.groupingBy(p -> p.getSeller().getCompanyName())));
    System.out.println("Partition products into in stock and out of stock: "
        + products.stream().collect(Collectors.partitioningBy(Product::isInStock)));

    Map<Integer, Product> productMap = products.stream()
        .collect(Collectors.toMap(Product::getProductId, Function.identity(), (a, b) -> a, LinkedHashMap::new));
    System.out.println("Map<Integer, Product>: " + productMap);
    System.out.println("Customer names separated by commas: "
        + customers.stream().map(Customer::getName).collect(Collectors.joining(", ")));
  }
}
