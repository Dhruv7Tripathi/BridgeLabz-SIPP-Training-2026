import java.util.ArrayList;
import java.util.List;

public class lowerBoundedWildCards {

  // Lower bounded wildcard: allows writing Integer values
  public static void addNumbers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
    list.add(30);
  }

  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>();
    List<Object> objects = new ArrayList<>();

    addNumbers(numbers);
    addNumbers(objects);

    System.out.println("Number list: " + numbers);
    System.out.println("Object list: " + objects);
  }
}
