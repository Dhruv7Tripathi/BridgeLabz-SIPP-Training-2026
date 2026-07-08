import java.util.ArrayList;

abstract class Product {
  private int id;
  private String name;
  private double price;

  public Product(int id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
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

public class shop {
  public static void main(String[] args) {
    ArrayList<Product> products = new ArrayList<>();

  }
}
