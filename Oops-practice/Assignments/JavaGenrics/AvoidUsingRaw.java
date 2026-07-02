
import java.util.List;
import java.util.ArrayList;

public class AvoidUsingRaw {

  // Example: Use parameterized types instead of raw types
  public static void main(String[] args) {
    // GOOD: Using parameterized type List<String>
    List<String> stringList = new ArrayList<String>();
    stringList.add("Hello");
    stringList.add("World");

    for (String str : stringList) {
      System.out.println(str);
    }

    // GOOD: Using parameterized type List<Integer>
    List<Integer> integerList = new ArrayList<Integer>();
    integerList.add(10);
    integerList.add(20);

    for (Integer num : integerList) {
      System.out.println(num);
    }

    // BAD: Avoid raw type List without type parameter
    // List rawList = new ArrayList(); // Unchecked warning
    // rawList.add("String");
    // rawList.add(123);
  }
}
