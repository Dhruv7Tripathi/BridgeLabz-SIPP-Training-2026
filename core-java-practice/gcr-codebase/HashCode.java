import java.util.Objects;

public class HashCode {
  private int id;
  private String name;
  private String city;

  public HashCode(int id, String name, String city) {
    this.id = id;
    this.name = name;
    this.city = city;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    HashCode other = (HashCode) obj;
    return id == other.id
        && Objects.equals(name, other.name)
        && Objects.equals(city, other.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, city);
  }

  public static void main(String[] args) {
    HashCode first = new HashCode(1, "Alice", "Seattle");
    HashCode second = new HashCode(1, "Alice", "Seattle");

    System.out.println(first == second);
    System.out.println(first.equals(second));
    System.out.println(first.hashCode() == second.hashCode());
  }
}