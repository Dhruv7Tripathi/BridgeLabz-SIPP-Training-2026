import java.util.Arrays;
import java.util.List;

public class upperBounded {

  public static void printNumbers(List<? extends Number> numbers) {
    for (Number number : numbers) {
      System.out.println(number);
    }
    // numbers.add(10); // Not allowed: read-only with ? extends Number
  }

  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, 3, 4);
    List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);

    printNumbers(integers);
    printNumbers(doubles);
  }
}
